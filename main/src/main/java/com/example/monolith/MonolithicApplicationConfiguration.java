package com.example.monolith;

import static java.util.Collections.singleton;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.eventbus.EventBus;
import org.requirementsascode.spring.eventbus.EventListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.monolith.consumer.behavior.ConsumerBehaviorModel;
import com.example.monolith.producer.behavior.ProducerBehaviorModel;

@Configuration
public class MonolithicApplicationConfiguration {
	@Bean
	BehaviorModel endpointBehaviorModel(EventBus eventBus) {
		ProducerBehaviorModel producerBehaviorModel = new ProducerBehaviorModel(eventBus);
		return producerBehaviorModel;
	}

	@Bean
	EventListeners eventListeners() {
		return EventListeners.of(singleton(new ConsumerBehaviorModel()));
	}
}
