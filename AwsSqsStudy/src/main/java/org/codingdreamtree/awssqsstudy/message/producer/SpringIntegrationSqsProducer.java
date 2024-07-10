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
        return List.of(
                MessageBuilder.withPayload(getSimpleMessage(1, "test1", 15, 1300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(2, "test2", 20,2300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(3, "test3", 25, 1300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(4, "test4", 20, 1300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(5, "test5", 15, 2300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(6, "test6", 30, 3300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(7, "test7", 16, 4300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(8, "test8", 39, 5300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(9, "test9", 42, 6300)).build(),
                MessageBuilder.withPayload(getSimpleMessage(10, "test10", 100, 7300)).build()
        );
    }

    private SimpleMessage getSimpleMessage(int pk, String name, int age, int salary) {
        return new SimpleMessage(pk, name, age, salary);
    }
}
