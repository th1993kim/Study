package org.codingdreamtree.awssqsstudy.message.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.config.SqsListenerConfigurer;
import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import io.awspring.cloud.sqs.listener.ListenerMode;
import io.awspring.cloud.sqs.listener.MessageListener;
import io.awspring.cloud.sqs.listener.QueueNotFoundStrategy;
import io.awspring.cloud.sqs.listener.acknowledgement.handler.AcknowledgementMode;
import io.awspring.cloud.sqs.listener.interceptor.AsyncMessageInterceptor;
import io.awspring.cloud.sqs.operations.SqsAsyncOperations;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.awspring.cloud.sqs.operations.TemplateAcknowledgementMode;
import io.awspring.cloud.sqs.support.converter.SqsMessagingMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.BackOffPolicyBuilder;
import software.amazon.awssdk.auth.credentials.SystemPropertyCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

@Configuration
public class SqsMessageConfig {

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(SystemPropertyCredentialsProvider.create())
                .build();
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
                .configure(options -> {
                    options.messageConverter(sqsMessagingMessageConverter())
                            .pollTimeout(Duration.ofSeconds(5L))
                            .maxDelayBetweenPolls(Duration.ofSeconds(3L))
                            .acknowledgementMode(AcknowledgementMode.MANUAL)
                            .queueNotFoundStrategy(QueueNotFoundStrategy.FAIL);
                })
                .build();
    }

    @Bean
    public SqsListenerConfigurer sqsListenerConfigurer(ObjectMapper objectMapper) {
        return registrar -> registrar.setObjectMapper(objectMapper);
    }

}
