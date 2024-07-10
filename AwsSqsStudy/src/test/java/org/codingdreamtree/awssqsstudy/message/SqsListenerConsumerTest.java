package org.codingdreamtree.awssqsstudy.message;

import org.codingdreamtree.awssqsstudy.message.producer.SpringIntegrationSqsProducer;
import org.codingdreamtree.awssqsstudy.message.service.MessageReaderService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.testcontainers.containers.localstack.LocalStackContainer.Service.SQS;

@SpringBootTest
@Testcontainers
class SqsListenerConsumerTest {

    @Container
    static LocalStackContainer localStack = new LocalStackContainer(DockerImageName.parse("localstack/localstack:latest"))
            .withEnv("LOCALSTACK_HOST", "localhost.localstack.cloud")
            .withEnv("SQS_ENDPOINT_STRATEGY", "dynamic");

    static final String QUEUE_NAME = "test-queue";

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        System.setProperty("aws.accessKeyId", localStack.getAccessKey());
        System.setProperty("aws.secretAccessKey", localStack.getSecretKey());

        registry.add("aws.sqs.queue.name", () -> QUEUE_NAME);
        registry.add(
                "spring.cloud.aws.region.static",
                () -> localStack.getRegion()
        );
        registry.add(
                "localstack.region",
                () -> localStack.getRegion()
        );
        registry.add(
                "spring.cloud.aws.credentials.access-key",
                () -> localStack.getAccessKey()
        );
        registry.add(
                "aws.accessKeyId",
                () -> localStack.getAccessKey()
        );
        registry.add(
                "aws.secretAccessKey",
                () -> localStack.getSecretKey()
        );
        registry.add(
                "spring.cloud.aws.credentials.secret-key",
                () -> localStack.getSecretKey()
        );
        registry.add(
                "localstack.endPoint",
                () -> localStack.getEndpointOverride(SQS).toString()
        );
        registry.add(
                "spring.cloud.aws.sqs.endpoint",
                () -> localStack.getEndpointOverride(SQS).toString()
        );
    }

    @BeforeAll
    static void beforeAll() throws IOException, InterruptedException {
        localStack.execInContainer(
                "awslocal",
                "sqs",
                "create-queue",
                "--queue-name",
                QUEUE_NAME
        );
    }


    @Autowired
    SpringIntegrationSqsProducer springIntegrationSqsProducer;
    @MockBean
    MessageReaderService messageReaderService;

    @Test
    @DisplayName("Sqs Listener 테스트 코드")
    void sqsListenerTest() {
        springIntegrationSqsProducer.sendMessage();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        verify(messageReaderService, atLeastOnce()).readList(any());
    }
}
