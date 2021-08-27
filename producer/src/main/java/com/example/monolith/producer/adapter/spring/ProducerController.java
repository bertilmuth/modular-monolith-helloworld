package com.example.monolith.producer.adapter.spring;

import org.requirementsascode.Behavior;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.monolith.producer.behavior.ProducerBehaviorModel.RequestGreeting;

@RestController
public class ProducerController {
	/**
	 * This behavior is configured by a single bean of type BehaviorModel, the ProducerBehaviorModel
	 * @see https://github.com/bertilmuth/modular-monolith-helloworld/blob/main/main/src/main/java/com/example/monolith/MonolithicApplicationConfiguration.java
	 */
	private final Behavior behavior;

	ProducerController(Behavior behavior) {
		this.behavior = behavior;
	}

	@PostMapping("/producer")
	public Object listTasks(@RequestBody RequestGreeting request) {
		Object response = behavior.reactTo(request).orElse("");
		return response;
	}
}
