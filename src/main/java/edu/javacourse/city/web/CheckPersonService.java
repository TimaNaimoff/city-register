package edu.javacourse.city.web;

import edu.javacourse.city.domain.PersonResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/check")
public class CheckPersonService {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(@PathParam("id") int simpleId, @QueryParam("name") String simpleName){
        return new PersonResponse();
    }
}
