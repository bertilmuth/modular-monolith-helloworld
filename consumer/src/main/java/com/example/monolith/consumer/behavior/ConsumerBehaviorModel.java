package com.example.monolith.consumer.behavior;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.Model;

public class ConsumerBehaviorModel implements BehaviorModel {
	@Override
	public Model model() {
		return Model.builder()
			.on(GreetingRequested.class).system(this::printGreeting)
			.build();
	}
	
	public static class GreetingRequested{
		public final String greetingText;
		GreetingRequested(String greetingText) {
			this.greetingText = greetingText;
		}
	}
	
	private void printGreeting(GreetingRequested greetingRequested) {
		System.out.println(greetingRequested.greetingText);
	}
}
