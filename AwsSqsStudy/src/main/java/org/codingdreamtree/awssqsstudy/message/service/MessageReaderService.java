package org.codingdreamtree.awssqsstudy.message.service;

import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.springframework.messaging.Message;

import java.util.List;

public interface MessageReaderService {

    List<Message<SimpleMessage>> readList(List<Message<SimpleMessage>> simpleMessageList);
}
