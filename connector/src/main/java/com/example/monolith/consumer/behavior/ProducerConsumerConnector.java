package com.example.monolith.consumer.behavior;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.Model;
import org.requirementsascode.eventbus.EventBus;

import com.example.monolith.consumer.behavior.ConsumerBehaviorModel.GreetingRequested;

public class ProducerConsumerConnector implements BehaviorModel {
	private final EventBus eventBus;

	public ProducerConsumerConnector(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	@Override
	public Model model() {
		return Model.builder()
			.on(com.example.monolith.producer.behavior.ProducerBehaviorModel.GreetingRequested.class).systemPublish(this::greetingRequested).to(eventBus)
			.build();
	}
	
	private GreetingRequested greetingRequested(com.example.monolith.producer.behavior.ProducerBehaviorModel.GreetingRequested greetingRequested) {
		return new GreetingRequested(greetingRequested.greetingText);
	}
}
