package com.example.maxmessaging.controllers;

import com.example.maxmessaging.KafkaMessageQueueManager;
import com.example.maxmessaging.KafkaProducer;
import com.example.maxmessaging.models.DisplayFrontendInput;
import com.example.maxmessaging.models.SubmitFrontendInput;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
public class RequestController {

    private KafkaProducer kafkaProducer;

    private KafkaMessageQueueManager kafkaMessageQueueManager;

    @Inject
    public RequestController(KafkaProducer kafkaProducer, KafkaMessageQueueManager kafkaMessageQueueManager) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageQueueManager = kafkaMessageQueueManager;
    }


    @PostMapping("/submit")
    public String getSubmits(@RequestBody SubmitFrontendInput submitFrontendInput) {
        if (kafkaMessageQueueManager.incomingTopicInService(submitFrontendInput.getTopic())) {
            kafkaProducer.send(submitFrontendInput.getInput(), submitFrontendInput.getTopic());
            return submitFrontendInput.getInput();
        }
        return "topic does not exist in service - please add to application.properties";
    }

    @PostMapping("/display")
    public String getDisplays(@RequestBody DisplayFrontendInput displayFrontendInput) {
        if (kafkaMessageQueueManager.incomingTopicInService(displayFrontendInput.getTopic())) {
            return kafkaMessageQueueManager.getNMessagesForTopic(displayFrontendInput.getOffset(), displayFrontendInput.getTopic());
        }
        return "topic does not exist in service - please add to application.properties";
    }
}
