package com.example.maxmessaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class KafkaProducer {

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    @Inject
    public KafkaProducer(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String msg, String topic) {
        kafkaTemplate.send(topic, msg);
    }
}
