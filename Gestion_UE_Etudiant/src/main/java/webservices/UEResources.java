package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UEResources {

    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response adding(UniteEnseignement ue) {G
        if(helper.addUniteEnseignement(ue))
        return Response.status(201).entity("added").build();
        else
            return Response.status(409).entity("already exists").build();
    }
}
