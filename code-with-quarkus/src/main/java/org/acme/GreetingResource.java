package org.acme;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

//	@ConfigProperty(name="greeting.message",defaultValue = "hello..")
//	String message;

	@Inject
	GreetingService greetingService;

	@Inject
	Config config;

	@ConfigProperty(name = "training.date")
	LocalDate trainingDate;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
//		String message = config.getOptionalValue("greeting.message", String.class).orElse("hello");
//		return message + " " + trainingDate.toString();
		return greetingService.message();
	}

}