package com.example.monolith.producer.behavior;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.Model;
import org.requirementsascode.eventbus.EventBus;

public class ProducerBehaviorModel implements BehaviorModel {
	private final EventBus eventBus;

	public ProducerBehaviorModel(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	@Override
	public Model model() {
		return Model.builder()
			.user(RequestGreeting.class).systemPublish(this::greetingRequested).to(eventBus)
			.build();
	}
	
	public static class RequestGreeting {
		public final String userName;
		public RequestGreeting(String userName) {
			this.userName = userName;
		}
	};
	
	public static class GreetingRequested{
		public final String greetingText;
		GreetingRequested(String greetingText) {
			this.greetingText = greetingText;
		}
	}
	
	private GreetingRequested greetingRequested(RequestGreeting requestGreeting) {
		return new GreetingRequested("Hello, " + requestGreeting.userName + ".");
	}
}
