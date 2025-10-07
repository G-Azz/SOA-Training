package webservices;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Module;
import metiers.ModuleBusiness;
@Path("/mod")
public class ModuleResources {
    static ModuleBusiness helper = new ModuleBusiness();
    @POST
    @Path("/adding")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(Module md)
    {
        if(helper.addModule(md))
            return Response.status(201).entity("Added").build();
        else
            return Response.status(208).entity("Already Exist").build();

    }
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam(value = "type") Module.TypeModule type)
    {
        return Response.status(200).entity(helper.getModulesByType(type)).build();
    }
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list()
    {
        return Response.status(200).
                entity(helper.getAllModules()).build();
    }
    @DELETE
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@QueryParam(value = "matricule") String matricule )
    {
        if(helper.deleteModule(matricule))
            return Response.status(200).entity("Deleted").build();
        return Response.status(404).entity("Not found").build();
    }
}
