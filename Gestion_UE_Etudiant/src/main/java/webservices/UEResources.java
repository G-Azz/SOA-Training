package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UEResources {

    static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response adding(UniteEnseignement ue) {
        if(helper.addUniteEnseignement(ue))
        return Response.status(201).entity("added").build();
        else
            return Response.status(208).entity("already exists").build();
    }
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listing()
    {
        return Response.status(200).entity(helper.getListeUE()).build();
    }
    @DELETE
    @Path("/delete/{code}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUE5(@PathParam(value ="code") int code ){
        if(helper.deleteUniteEnseignement(code))
            return Response.status(200).entity("Deleted").build();
        return Response.status(404).entity("Not found").build();

    }
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam(value="s") int sem)
    {
        return Response.status(200).entity(helper.getUEBySemestre(sem)).build();
    }
}
