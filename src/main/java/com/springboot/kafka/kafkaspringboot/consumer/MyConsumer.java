package com.springboot.kafka.kafkaspringboot.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {
    
    @KafkaListener(id="kafka-consumer", topics = "spring-topic")
    public void listen(@Payload String payload){
     System.out.println("recieved new event :"+payload);
    }
}
