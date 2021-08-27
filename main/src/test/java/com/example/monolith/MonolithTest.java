package com.example.monolith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.requirementsascode.spring.behavior.test.MockBehaviorEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.monolith.producer.behavior.ProducerBehaviorModel.GreetingRequested;
import com.example.monolith.producer.behavior.ProducerBehaviorModel.RequestGreeting;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MonolithTest {
	@Autowired
	private MockBehaviorEndpoint endpoint;

	@Test
	void rightGreetingIsCreated() throws Exception {
		RequestGreeting request = new RequestGreeting("Joe");
		GreetingRequested greetingRequested = endpoint.post(request, GreetingRequested.class);
		assertEquals("Hello, Joe.", greetingRequested.greetingText);
	}

}
