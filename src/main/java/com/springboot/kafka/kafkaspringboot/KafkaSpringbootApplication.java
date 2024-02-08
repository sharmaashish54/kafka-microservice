package com.springboot.kafka.kafkaspringboot;

import java.util.UUID;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

import com.springboot.kafka.kafkaspringboot.producer.MyProducer;

@EnableKafka
@SpringBootApplication
public class KafkaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringbootApplication.class, args);
		
	}
		@Bean
		public NewTopic topic(){
			return TopicBuilder.name("spring-topic")
			.partitions(3)
			.replicas(1)
			.build();
		}

		@Bean
		public ApplicationRunner runner(MyProducer producer){
			return args -> {
				while(true){
					producer.sendMessage("spring-topic","Hello from producer"+UUID.randomUUID());

					Thread.sleep(1000L);
				}

			};
		}
	}

