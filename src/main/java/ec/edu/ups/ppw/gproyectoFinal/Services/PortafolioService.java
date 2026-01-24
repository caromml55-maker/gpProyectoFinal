package ec.edu.ups.ppw.gproyectoFinal.Services;

import java.net.URI;
import java.util.List;
import ec.edu.ups.ppw.gproyectoFinal.Model.Portafolio;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionPortafolio;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("portafolio")
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
	@Path("/{id}")
	@Produces("application/json")
	public Response getPortafolio(@PathParam("id") String id) {

		Portafolio p;
		try {
			p = gp.getPortafolio(id);
		} catch(Exception e) {
			Error error = new Error(500,"Error interno",e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}

		if(p == null) {
			Error error = new Error(404,"No encontrado",
					"Portafolio con ID "+id+" no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error).build();
		}

		return Response.ok(p).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createPortafolio(Portafolio p,
			@Context UriInfo uriInfo) {

		try {
			gp.crearPortafolio(p);
		} catch(Exception e) {
			Error error = new Error(500,"Error interno",e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}

		URI location = uriInfo.getAbsolutePathBuilder()
				.path(p.getId()).build();

		return Response.created(location)
				.entity(p).build();
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
}
