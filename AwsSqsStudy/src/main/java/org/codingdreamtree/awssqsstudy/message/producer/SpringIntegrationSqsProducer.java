package org.codingdreamtree.awssqsstudy.message.producer;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsAsyncOperations;
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

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class SpringIntegrationSqsProducer {

    private final SqsAsyncOperations sqsAsyncOperations;

    public void sendMessage() {

        CompletableFuture<SendResult.Batch<SimpleMessage>> batchCompletableFuture = sqsAsyncOperations.sendManyAsync("test-queue", getSimpleMessageList());

        batchCompletableFuture.whenCompleteAsync(
                (result, ex) -> {
                    if (ex != null) {
                        result.failed()
                                .forEach(failedMessage -> {
                                    log.error("메시지 전송 메시지 내용: {}", failedMessage.message());
                                    log.error("메시지 전송 오류 : {}", ex.getMessage(), ex);
                                });
                    } else {
                        Collection<SendResult<SimpleMessage>> successful = result.successful();
                        log.debug(">>>>>> 메시지 전송 성공 전송량: {}", successful.size());
                    }
                });
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
