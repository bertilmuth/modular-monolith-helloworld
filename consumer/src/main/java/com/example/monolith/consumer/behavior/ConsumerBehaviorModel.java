package com.example.monolith.consumer.behavior;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.Model;

import com.example.monolith.producer.behavior.ProducerBehaviorModel.GreetingRequested;

public class ConsumerBehaviorModel implements BehaviorModel {
	@Override
	public Model model() {
		return Model.builder()
			.user(GreetingRequested.class).system(this::printGreeting)
			.build();
	}
	
	private void printGreeting(GreetingRequested greetingRequested) {
		System.out.println(greetingRequested.greetingText);
	}
}
