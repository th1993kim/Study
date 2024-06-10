package org.codingdreamtree.awssqsstudy.message.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement;
import lombok.extern.slf4j.Slf4j;
import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class SqsListenerConsumer {

//    @SqsListener(queueNames = {"test-queue"},  maxConcurrentMessages = "3", maxMessagesPerPoll = "3", factory = "simpleMessageListenerContainerFactory", messageVisibilitySeconds = "60")
    public void processMessage(List<Message<SimpleMessage>> simpleMessageList) {
        simpleMessageList.forEach(message -> {
            log.debug(">>>> 소비자 메시지 : {} ", message.getPayload());
        });

        Acknowledgement.acknowledgeAsync(simpleMessageList);
    }
}
