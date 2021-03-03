package org.acme;

import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.web.Route;

@ApplicationScoped
public class GreetingReactiveRoutes {
	
	@Route(path = "/greeting")
	public String greeting() throws InterruptedException {
		System.out.println(Thread.currentThread());
		TimeUnit.SECONDS.sleep(5);
		return "greeting";
	}
	
}
