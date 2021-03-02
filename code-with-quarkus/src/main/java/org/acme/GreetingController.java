package org.acme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	GreetingService greetingService;

	@GetMapping("/spring-hello")
	public String hello() {
		return greetingService.getMessage();
	}

}
