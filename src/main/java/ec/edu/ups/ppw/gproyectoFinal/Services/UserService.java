package ec.edu.ups.ppw.gproyectoFinal.Services;

import java.net.URI;
import java.util.List;
import ec.edu.ups.ppw.gproyectoFinal.Model.*;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionUsers;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("user")
public class UserService {
	
	@Inject
	private GestionUsers gp;
	
	@GET
	@Produces("application/json")
	public Response getListaPersonas(){
	List<User> listado = gp.getPersona();
		return Response.ok(listado).build();  //status code 200
	}
	
	
	@GET
	@Path("/{uid}")
	@Produces("application/json")
	public Response getPersona(@PathParam("uid") String cedula) {
		User p;
		try {
			p = gp.getPersona(cedula);
		}
		catch(Exception e){
			e.printStackTrace();
			Error error = new Error(
					500,
					"Error interno",
					e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build()	;
			}
		
		if(p== null) {
			Error error = new Error(
					404,
					"No encontrado",
					"Usuario con ID "+cedula+" no encuentrado");
				
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
		
		return Response.ok(p).build();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createPersona(User persona, @Context UriInfo uriInfo) {	
		
		try {
			gp.crearPersona(persona);
		}
		catch(Exception e){
			e.printStackTrace();
			Error error = new Error(
					500,
					"Error interno",
					e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build()	;
			}
		
		URI location = uriInfo.getAbsolutePathBuilder()
				.path(persona.getUid())
				.build();
		return Response.created(location)
				.entity(persona)
				.build();
	}
	
	@PUT
	@Path("/{uid}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updatePersona(@PathParam("uid") String id, User persona, @Context UriInfo uriInfo) {
		try {
			 if(!id.equals(persona.getUid())) {
		            Error error = new Error(
		                    400,
		                    "Datos incorrectos",
		                    "La cédula no coincide con el parámetro");
		            return Response.status(Response.Status.BAD_REQUEST)
		                    .entity(error).build();
		        }
			 User p = gp.getPersona(id);

		        if(p == null) {
		            Error error = new Error(
		                    404,
		                    "No encontrado",
		                    "Persona con ID " + id + " no existe");
		            return Response.status(Response.Status.NOT_FOUND)
		                    .entity(error).build();
		        }

		        gp.actualizarPersona(persona);

		    } catch(Exception e) {
		        e.printStackTrace();	
		        Error error = new Error(
		                500,
		                "Error interno",
		                e.getMessage());
		        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
		                .entity(error).build();
		    }

		    return Response.ok(persona).build();
		
	}

}
