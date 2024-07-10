package org.codingdreamtree.awssqsstudy.message.service;

import lombok.RequiredArgsConstructor;
import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
@RequiredArgsConstructor
public class SingleThreadReaderService implements MessageReaderService {
    private final ProcessMessageService processMessageService;

    @Override
    public List<Message<SimpleMessage>> readList(List<Message<SimpleMessage>> simpleMessageList) {
        simpleMessageList.forEach(processMessageService::completeMessage);
        return simpleMessageList;
    }
}
