package org.codingdreamtree.awssqsstudy.message.service;

import lombok.RequiredArgsConstructor;
import org.codingdreamtree.awssqsstudy.message.SimpleMessage;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

//@Service
@RequiredArgsConstructor
public class ThreadExecutorReaderService implements MessageReaderService {

    private final ProcessMessageService processMessageService;

    @Override
    public List<Message<SimpleMessage>> readList(List<Message<SimpleMessage>> simpleMessageList) {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        List<Callable<Message>> callableList = simpleMessageList.stream()
                .map(message -> (Callable<Message>) () -> processMessageService.completeMessage(message))
                .toList();

        try {
            List<Future<Message>> futures = executorService.invokeAll(callableList);
            return futures.stream()
                    .map(message -> {
                        try {
                            return (Message<SimpleMessage>) message.get();
                        } catch (InterruptedException e) {
                            return null;
                        } catch (ExecutionException e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .toList();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.close();
        }
    }
}
