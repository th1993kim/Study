package org.codingdreamtree.awssqsstudy.message.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledConsume {
    private final SqsAsyncClient sqsAsyncClient;
    private static final String QUEUE_URL = "";


//    @Scheduled(fixedDelay = 5000) // Poll every 20 seconds
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
                List<Message> successMessages = new ArrayList<>();
                for (Message message : messages) {
                    successMessages.add(processMessage(message));
                }

                sqsAsyncClient.deleteMessageBatch(DeleteMessageBatchRequest.builder()
                        .queueUrl(QUEUE_URL)
                        .entries(successMessages.stream()
                                .filter(Objects::nonNull)
                                .map(message -> DeleteMessageBatchRequestEntry.builder()
                                        .id(message.messageId())
                                        .build())
                                .toList())
                        .build());
            }
        });

    }

    private Message processMessage(Message message) {
        log.debug("Processing message: " + message.body());
        if (Math.random() < 0.5) {
            return message;
        }
        return null;
    }
}
