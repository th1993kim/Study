package org.codingdreamtree.awssqsstudy.message.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.config.SqsListenerConfigurer;
import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import io.awspring.cloud.sqs.listener.QueueNotFoundStrategy;
import io.awspring.cloud.sqs.listener.acknowledgement.handler.AcknowledgementMode;
import io.awspring.cloud.sqs.operations.SqsAsyncOperations;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.awspring.cloud.sqs.operations.TemplateAcknowledgementMode;
import io.awspring.cloud.sqs.support.converter.SqsMessagingMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;
import java.time.Duration;
import java.util.Objects;

@Configuration
public class SqsMessageConfig {

    @Value("${localstack.endPoint}")
    private String localstackEndPoint;
    @Value("${localstack.region}")
    private String localstackRegion;

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .region(getRegion())
                .endpointOverride(getEndPoint())
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(System.getProperty("aws.accessKeyId"), System.getProperty("aws.secretAccessKey"))))
                .build();
    }

    private Region getRegion() {
        if (Objects.isNull(localstackRegion)) {
            return Region.AP_NORTHEAST_2;
        }
        return Region.of(localstackRegion);
    }

    private URI getEndPoint() {
        if (Objects.isNull(localstackEndPoint)) {
            return null;
        }
        return URI.create(localstackEndPoint);
    }

    @Bean
    public SqsAsyncOperations sqsAsyncOperations(SqsAsyncClient sqsAsyncClient) {
        return SqsTemplate.builder()
                .sqsAsyncClient(sqsAsyncClient)
                .configure(options -> {
                    options.queueNotFoundStrategy(QueueNotFoundStrategy.FAIL)
                            .defaultMaxNumberOfMessages(2)
                            .acknowledgementMode(TemplateAcknowledgementMode.MANUAL);
                })
                .build();
    }

    public SqsMessagingMessageConverter sqsMessagingMessageConverter() {
        SqsMessagingMessageConverter sqsMessagingMessageConverter = new SqsMessagingMessageConverter();
        sqsMessagingMessageConverter.setPayloadMessageConverter(mappingJackson2MessageConverter());
        return sqsMessagingMessageConverter;
    }

    public MessageConverter mappingJackson2MessageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setPrettyPrint(true);
        mappingJackson2MessageConverter.setStrictContentTypeMatch(false);
        return mappingJackson2MessageConverter;
    }

    @Bean
    public SqsMessageListenerContainerFactory<Object> simpleMessageListenerContainerFactory(SqsAsyncClient sqsAsyncClient) {
        return SqsMessageListenerContainerFactory.builder()
                .sqsAsyncClient(sqsAsyncClient)
                .configure(options -> options.messageConverter(sqsMessagingMessageConverter())
                        .pollTimeout(Duration.ofSeconds(10L))
                        .maxDelayBetweenPolls(Duration.ofSeconds(10L))
                        .acknowledgementMode(AcknowledgementMode.MANUAL)
                        .queueNotFoundStrategy(QueueNotFoundStrategy.FAIL))
                .build();
    }

    @Bean
    public SqsListenerConfigurer sqsListenerConfigurer(ObjectMapper objectMapper) {
        return registrar -> registrar.setObjectMapper(objectMapper);
    }

}
