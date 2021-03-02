package org.acme;

// cdi
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

	public String message() {
		return "good morning";
	}

}
