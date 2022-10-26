package com.example.maxmessaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class KafkaMessageQueueManager {

    private Map<String, KafkaMessageQueue> kafkaMessageQueueMap;

    private final Set<String> topicsSet;


    public KafkaMessageQueueManager(@Value("${kafka.topics}") String topics) {
        super();
        kafkaMessageQueueMap = new HashMap<>();
        topicsSet = Set.of(topics.split(","));
        topicsSet.forEach((topic) -> kafkaMessageQueueMap.put(topic, new KafkaMessageQueue(topic)));
    }

    public String getNMessagesForTopic(int n, String topic) {
        System.out.println("printing msg queue list");
        for (KafkaMessageQueue kafkaMessageQueue : kafkaMessageQueueMap.values()) {
            System.out.println(kafkaMessageQueue.getTopic());
        }
        System.out.println(topic);
        return kafkaMessageQueueMap.get(topic).retrieveNMessages(n);
    }

    public void queueMessage(String message, String topic) {
        KafkaMessageQueue kafkaMessageQueue = kafkaMessageQueueMap.get(topic);

        kafkaMessageQueue.queueMessage(message);

    }

    public boolean incomingTopicInService(String topic) {
        return topicsSet.contains(topic);
    }
}
