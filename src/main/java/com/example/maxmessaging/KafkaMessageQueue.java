package com.example.maxmessaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.*;


public class KafkaMessageQueue {

    private final Queue<String> messageQueue = new ArrayDeque<>();

    private final String topic;

    public KafkaMessageQueue(String topic) {
        this.topic = topic;
    }

    public void queueMessage(String message) {
        messageQueue.add(message);
    }

    public String getTopic() {
        return topic;
    }

    public String retrieveNMessages(int offset) {
        int loopLength = offset;
        if (offset > messageQueue.size()) {
            loopLength = messageQueue.size();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < loopLength; i++) {
            result.append(String.format(messageQueue.remove() + "<br>"));
        }
        return result.toString();
    }
}
