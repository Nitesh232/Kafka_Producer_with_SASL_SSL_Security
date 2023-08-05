package com.nitesh.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nitesh.springboot.model.SampleMessage;

@Service
public class KafkaService {

	
	@Autowired
	private KafkaTemplate<String, SampleMessage> template;
	
	@Value("${app.kafka.producer.topic}")
	private String TOPIC;
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	
	public String addMessage(SampleMessage message) {
		
		template.send(TOPIC, message);
		
		logger.info("Message Recieved {}", message.toString());
		
		return "Message added successfully!!";
		
	}
	
}
