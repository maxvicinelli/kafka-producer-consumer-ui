package com.example.maxmessaging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private KafkaMessageQueueManager kafkaMessageQueueManager;


    @KafkaListener(id = "mms-consumer", topics = "#{'${kafka.topics}'.split(',')}")
    public void listenSendgridEvents(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // System.out.println("message from topic" + topic + " is: " + message);
        kafkaMessageQueueManager.queueMessage(message, topic);
    }
}
