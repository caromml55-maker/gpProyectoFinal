package ec.edu.ups.ppw.gproyectoFinal.Services;

import java.net.URI;
import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.Model.*;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionAsesorias;
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

@Path("asesoria")
public class AsesoriaService {
	
	@Inject
	private GestionAsesorias gp;
	
	@GET
	@Produces("application/json")
	public Response getListaAsesorias(){
		List<Asesoria> listado = gp.getAsesorias();
		return Response.ok(listado).build();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getAsesoria(@PathParam("id") String id) {
		Asesoria a;
		try {
			a = gp.getAsesoria(id);
		}
		catch(Exception e){
			e.printStackTrace();
			Error error = new Error(
					500,
					"Error interno",
					e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}
		
		if(a == null) {
			Error error = new Error(
					404,
					"No encontrado",
					"Asesoria con ID "+id+" no encontrada");
				
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error).build();
		}
		
		return Response.ok(a).build();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createAsesoria(Asesoria asesoria, @Context UriInfo uriInfo) {	
		
		try {
			gp.crearAsesoria(asesoria);
		}
		catch(Exception e){
			e.printStackTrace();
			Error error = new Error(
					500,
					"Error interno",
					e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}
		
		URI location = uriInfo.getAbsolutePathBuilder()
				.path(asesoria.getId())
				.build();
		
		return Response.created(location)
				.entity(asesoria)
				.build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateAsesoria(@PathParam("id") String id, Asesoria asesoria) {
		try {
			 if(!id.equals(asesoria.getId())) {
		            Error error = new Error(
		                    400,
		                    "Datos incorrectos",
		                    "El ID no coincide con el parámetro");
		            return Response.status(Response.Status.BAD_REQUEST)
		                    .entity(error).build();
		        }
			 
			 Asesoria a = gp.getAsesoria(id);

		        if(a == null) {
		            Error error = new Error(
		                    404,
		                    "No encontrado",
		                    "Asesoria con ID " + id + " no existe");
		            return Response.status(Response.Status.NOT_FOUND)
		                    .entity(error).build();
		        }

		        gp.actualizarAsesoria(asesoria);

		    } catch(Exception e) {
		        e.printStackTrace();	
		        Error error = new Error(
		                500,
		                "Error interno",
		                e.getMessage());
		        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
		                .entity(error).build();
		    }

		    return Response.ok(asesoria).build();
	}
}
