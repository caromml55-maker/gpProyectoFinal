package ec.edu.ups.ppw.gproyectoFinal.Services;

import java.net.URI;
import java.util.List;
import ec.edu.ups.ppw.gproyectoFinal.Model.Portafolio;
import ec.edu.ups.ppw.gproyectoFinal.Model.Proyecto;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionPortafolio;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("users/portafolio")
public class PortafolioService {

	@Inject
	private GestionPortafolio gp;

	@GET
	@Produces("application/json")
	public Response getListaPortafolios(){
		List<Portafolio> listado = gp.getPortafolio();
		return Response.ok(listado).build();
	}

	@GET
	@Path("/{uid}")
	@Produces("application/json")
	public Response getPortafolioByUid(@PathParam("uid") String uid) {
	    Portafolio p = gp.getPortafolioByUid(uid); // Llama al nuevo método del DAO
	    if (p == null) return Response.status(Response.Status.NOT_FOUND).build();
	    return Response.ok(p).build();
	}

	@POST
	@Path("/{uid}/proyecto")
	@Consumes("application/json")
	public Response addProyecto(@PathParam("uid") String uid, Proyecto proyecto) {
	    try {
	        gp.agregarProyecto(uid, proyecto);
	        return Response.status(Response.Status.CREATED).build();
	    } catch (Exception e) {
	        return Response.status(500).entity(e.getMessage()).build();
	    }
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updatePortafolio(@PathParam("id") String id,
			Portafolio p) {

		try {

			if(!id.equals(p.getId())) {
				Error error = new Error(400,"Datos incorrectos",
						"El ID no coincide");
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(error).build();
			}

			Portafolio por = gp.getPortafolio(id);

			if(por == null) {
				Error error = new Error(404,"No encontrado",
						"Portafolio con ID "+id+" no existe");
				return Response.status(Response.Status.NOT_FOUND)
						.entity(error).build();
			}

			gp.actualizarPortafolio(p);

		} catch(Exception e) {
			Error error = new Error(500,"Error interno",e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}

		return Response.ok(p).build();
	}
	
	@DELETE
	@Path("/proyecto/{id}")
	public Response eliminarProyecto(@PathParam("id") Long id) {
	    try {
	        gp.eliminarProyecto(id);
	        return Response.ok().build();
	    } catch (Exception e) {
	        return Response.status(500).entity(e.getMessage()).build();
	    }
	}
}
