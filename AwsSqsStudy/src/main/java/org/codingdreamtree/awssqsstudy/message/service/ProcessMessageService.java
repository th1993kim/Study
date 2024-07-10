package org.codingdreamtree.awssqsstudy.message.service;

import lombok.extern.slf4j.Slf4j;
import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProcessMessageService {

    public Message<SimpleMessage> completeMessage(Message<SimpleMessage> message) {
        try {
            Thread.sleep(2000);
//            log.debug(">>>> 소비자 메시지 : {} ", message.getPayload());
            return message;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
