package org.acme;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;
import io.vertx.mutiny.ext.web.client.WebClient;

@Path("/hello")
public class GreetingResource {

	@Inject
	Vertx vertx;
	
//	@Inject
//	GreetingService greetingService;
	
	@Inject
	EventBus eventBus;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Uni<String> hello() {
		
//		return "hello";
//		return greetingService.getHelloMessage();
		
		return eventBus
		.<String>request("hello.addr", "")
		.onItem()
		.transform(Message::body);
	}
	
	
	
	
	
	
	
	
	@Path("/async")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Uni<String> helloAsync() {
		
//		 return Uni.createFrom()
//	                .item(() -> "Hello!")
//	                .onItem().delayIt().by(Duration.ofMillis(10));
		
		return 
		vertx
		.fileSystem()
		.readFile("/META-INF/hello.txt")
		.onItem()
		.transform(buffer->{
			return buffer.toString();
		});
		
	}
	


    private WebClient client;
    
    @PostConstruct
    public void init() {
    	this.client = WebClient.create(vertx,
                new WebClientOptions()
                    .setDefaultHost("fruityvice.com")
                    .setDefaultPort(443)
                    .setSsl(true)
                    .setTrustAll(true));
	}
	
	@GET
	@Path("/fruit/{name}")
	public Uni<JsonObject> getFruitDetails(@PathParam("name")String fruitName) {
		System.out.println("req-handler-threader : "+Thread.currentThread());
		return client
		.get("/api/fruit/" + fruitName)
		.send()
		.onItem()
		.transform(resp->{
			System.out.println("io-handler-threader : "+Thread.currentThread());
			 if (resp.statusCode() == 200) {
                 return resp.bodyAsJsonObject();
             }else {
            	 return new JsonObject()
                         .put("code", resp.statusCode())
                         .put("message", resp.bodyAsString());
             }
		});
	}
	
	
	@GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @Path("/{name}")
    public Multi<String> greeting(@PathParam("name") String name) {
        
		return vertx
        		.periodicStream(2000)
        		.toMulti()
                .map(l -> String.format("Hello %s! (%s)%n", name, new Date()));
    }
	
	
	
}