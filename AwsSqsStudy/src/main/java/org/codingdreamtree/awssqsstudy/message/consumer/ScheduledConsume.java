package org.codingdreamtree.awssqsstudy.message.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledConsume {
    private final SqsAsyncClient sqsAsyncClient;
    private static final String QUEUE_URL = "";


    @Scheduled(fixedDelay = 5000) // Poll every 20 seconds
    public void pollMessages() {
        log.debug("Polling for messages...");
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .maxNumberOfMessages(10)
                .waitTimeSeconds(20)
                .queueUrl(QUEUE_URL)
                .visibilityTimeout(60)
                .build();


        CompletableFuture<ReceiveMessageResponse> response = sqsAsyncClient.receiveMessage(receiveMessageRequest);

        response.whenComplete((messageResponse, throwable) -> {
            if (messageResponse.hasMessages()) {
                List<Message> messages = messageResponse.messages();
                for (Message message : messages) {
                    processMessage(message);
                    sqsAsyncClient.deleteMessage(DeleteMessageRequest.builder()
                            .queueUrl(QUEUE_URL)
                            .receiptHandle(message.receiptHandle())
                            .build());
                }
            }
        });

    }

    private void processMessage(Message message) {
        log.debug("Processing message: " + message.body());
    }
}
