package org.codingdreamtree.awssqsstudy.message.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequestEntry;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnergySqsProducer {

    public void sendMessage() {


        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl("http://localhost:4566/000000000000/test-queue")
                .messageBody("test")
                .delaySeconds(10)
                .build();

        SqsClient sqs = SqsClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();

        SqsAsyncClient sqsAsyncClient = SqsAsyncClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();


        sqs.sendMessage(sendMessageRequest);

        SendMessageBatchRequest batchRequest = SendMessageBatchRequest.builder()
                .queueUrl("http://localhost:4566/000000000000/test-queue")
                .entries(SendMessageBatchRequestEntry.builder()
                        .id("msg_1")
                        .messageBody("batch message")
                        .delaySeconds(10)
                        .build()
                )
                .build();

        CompletableFuture<SendMessageBatchResponse> response = sqsAsyncClient.sendMessageBatch(batchRequest);

        log.debug("response = {}", response);
    }

    private List<Message<SimpleMessage>> getSimpleMessageList() {
        SimpleMessage test1 = new SimpleMessage(1, "test1", 15, 300);
        SimpleMessage test2 = new SimpleMessage(2, "test2", 25, 500);
        SimpleMessage test3 = new SimpleMessage(3, "test3", 35, 700);
        return List.of(
                MessageBuilder.withPayload(test1).build(),
                MessageBuilder.withPayload(test2).build(),
                MessageBuilder.withPayload(test3).build()
        );
    }
}
