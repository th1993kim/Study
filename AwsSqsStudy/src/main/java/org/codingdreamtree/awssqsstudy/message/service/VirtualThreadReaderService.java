package org.codingdreamtree.awssqsstudy.message.service;

import lombok.RequiredArgsConstructor;
import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
@RequiredArgsConstructor
public class VirtualThreadReaderService implements MessageReaderService{

    private final ProcessMessageService processMessageService;

    @Override
    public List<Message<SimpleMessage>> readList(List<Message<SimpleMessage>> simpleMessageList) {

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        List<Callable<Message<SimpleMessage>>> callableList = simpleMessageList.stream()
                .map(message -> (Callable<Message<SimpleMessage>>) () -> processMessageService.completeMessage(message))
                .toList();

        try {
            List<Future<Message<SimpleMessage>>> futureList = executorService.invokeAll(callableList);
            return futureList.stream()
                    .map(messageFuture -> {
                        try {
                            return messageFuture.get();
                        } catch (InterruptedException | ExecutionException e) {
                            Thread.currentThread().interrupt();
                            return null;
                        }
                    })
                    .toList();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Virtual Thread Read Fail");
        } finally {
            executorService.close();
        }
    }
}
