package com.nitesh.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.springboot.model.SampleMessage;
import com.nitesh.springboot.service.KafkaService;

@RestController
public class ProducerController {

	@Autowired
	private KafkaService service;
	
	@PostMapping("produce")
	public String produce(@RequestBody SampleMessage message) {
		return service.addMessage(message);
	}
	
}
