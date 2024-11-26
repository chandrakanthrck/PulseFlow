package com.dataeng.ingestion.controller;

import com.dataeng.ingestion.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping
    public String sendMessage(@RequestParam("message") String message) {
        kafkaProducerService.sendMessage(message);
        return "Message sent to Kafka topic: " + message;
    }
}
