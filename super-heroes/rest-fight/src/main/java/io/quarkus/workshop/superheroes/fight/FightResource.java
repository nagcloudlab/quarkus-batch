// tag::adocResource[]
package io.quarkus.workshop.superheroes.fight;

// end::adocResource[]
import org.eclipse.microprofile.config.inject.ConfigProperty;
// tag::adocResource[]
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/fights")
@Produces(APPLICATION_JSON)
public class FightResource {

	private static final Logger LOGGER = Logger.getLogger(FightResource.class);

	@Inject
	FightService service;


	@GET
	@Path("/randomfighters")
	public Response getRandomFighters() throws InterruptedException {
		Fighters fighters = service.findRandomFighters();
		LOGGER.debug("Get random fighters " + fighters);
		return Response.ok(fighters).build();
	}
	// end::adocFaultTolerance[]

	@GET
	public Response getAllFights() {
		List<Fight> fights = service.findAllFights();
		LOGGER.debug("Total number of fights " + fights);
		return Response.ok(fights).build();
	}

	@GET
	@Path("/{id}")
	public Response getFight(@PathParam("id") Long id) {
		Fight fight = service.findFightById(id);
		if (fight != null) {
			LOGGER.debug("Found fight " + fight);
			return Response.ok(fight).build();
		} else {
			LOGGER.debug("No fight found with id " + id);
			return Response.noContent().build();
		}
	}

	@POST
	public Fight fight(@Valid Fighters fighters, @Context UriInfo uriInfo) {
		return service.persistFight(fighters);
	}

	@GET
	@Produces(TEXT_PLAIN)
	@Path("/hello")
	public String hello() {
		return "hello";
	}
}
// end::adocResource[]
