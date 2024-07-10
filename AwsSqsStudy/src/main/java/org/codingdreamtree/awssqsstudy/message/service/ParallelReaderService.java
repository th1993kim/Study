package org.codingdreamtree.awssqsstudy.message.service;

import lombok.RequiredArgsConstructor;
import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

//@Service
@RequiredArgsConstructor
public class ParallelReaderService implements MessageReaderService {

    private final ProcessMessageService processMessageService;

    @Override
    public List<Message<SimpleMessage>> readList(List<Message<SimpleMessage>> simpleMessageList) {
        return simpleMessageList.parallelStream()
                .map(processMessageService::completeMessage)
                .filter(Objects::nonNull)
                .toList();
    }
}
