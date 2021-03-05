package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher; // 

@Path("/hello")
public class PriceResource {

	@Inject
	@Channel("my-data-stream")
	Publisher<Double> prices;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello RESTEasy";
	}

	@GET
	@Path("/price-stream")
	@Produces(MediaType.SERVER_SENT_EVENTS)
	@SseElementType("text/plain")
	public Publisher<Double> stream() {
		return prices;
	}

}