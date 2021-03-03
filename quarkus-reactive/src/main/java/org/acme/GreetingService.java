package org.acme;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class GreetingService {
	
	@ConsumeEvent("hello.addr")
	public String getHelloMessage(String message) {
		return "Hello";
	}

}
