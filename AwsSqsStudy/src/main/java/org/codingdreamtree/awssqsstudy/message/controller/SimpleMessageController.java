package org.codingdreamtree.awssqsstudy.message.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codingdreamtree.awssqsstudy.message.producer.SpringIntegrationSqsProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@Slf4j
public class SimpleMessageController {

    private final SpringIntegrationSqsProducer producer;

    @PostMapping("/test")
    public void sendMessage() {
        producer.sendMessage();
        log.debug(">>>>>> 컨트롤러 메시지 전송 완료");
    }
}
