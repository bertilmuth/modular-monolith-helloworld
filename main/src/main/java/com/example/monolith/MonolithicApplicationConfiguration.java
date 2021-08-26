package com.example.monolith;

import java.util.Arrays;
import java.util.List;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.eventbus.EventBus;
import org.requirementsascode.spring.eventbus.EventListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.monolith.consumer.behavior.ConsumerBehaviorModel;
import com.example.monolith.consumer.behavior.ProducerConsumerConnector;
import com.example.monolith.producer.behavior.ProducerBehaviorModel;

@Configuration
public class MonolithicApplicationConfiguration {
	private final EventBus eventBus;

	MonolithicApplicationConfiguration(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	@Bean
	BehaviorModel endpointBehaviorModel() {
		ProducerBehaviorModel producerBehaviorModel = new ProducerBehaviorModel(eventBus);
		return producerBehaviorModel;
	}

	@Bean
	EventListeners eventListeners() {
		List<BehaviorModel> listeners = Arrays.asList(new ProducerConsumerConnector(eventBus), new ConsumerBehaviorModel());
		return EventListeners.of(listeners);
	}
}
