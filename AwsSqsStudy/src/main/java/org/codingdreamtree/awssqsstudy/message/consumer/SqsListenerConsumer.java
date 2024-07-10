package org.codingdreamtree.awssqsstudy.message.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.codingdreamtree.awssqsstudy.message.service.MessageReaderService;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
@Slf4j
@RequiredArgsConstructor
public class SqsListenerConsumer {

    private final MessageReaderService messageReaderService;

    @SqsListener(
            queueNames = {"test-queue"},
            maxConcurrentMessages = "10",
            maxMessagesPerPoll = "10",
            factory = "simpleMessageListenerContainerFactory",
            pollTimeoutSeconds = "10",
            messageVisibilitySeconds = "60"
    )
    public void processMessage(List<Message<SimpleMessage>> simpleMessageList) {

        log.debug(">>>>>>> 소비 10개의 메시지 큐 시작 시작시간 : {}", LocalDateTime.now());
        List<Message<SimpleMessage>> completedMessageList = messageReaderService.readList(simpleMessageList);
//        for (MessageReaderService messageReaderService : messageReaderServiceList) {
//            log.debug("========>>> service : {} , startTime: {}", messageReaderService.getClass(), LocalDateTime.now());
//            messageReaderService.readList(simpleMessageList);
//            log.debug("========>>> service : {} , startTime: {}", messageReaderService.getClass(), LocalDateTime.now());
//        }

        log.debug(">>>>>>> 소비 10개의 메시지 큐 시작 종료시간 : {}", LocalDateTime.now());
        Acknowledgement.acknowledgeAsync(completedMessageList);
    }
}
