package ec.edu.ups.ppw.gproyectoFinal.Services;

import ec.edu.ups.ppw.gproyectoFinal.Model.Horario;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionHorarios;
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
import java.util.List;
import java.net.URI;


@Path("horario")
public class HorarioService {

	@Inject
	private GestionHorarios gh;
	
	@GET
	@Produces("application/json")
	public Response getListaHorarios(){
		List<Horario> listado = gh.getHorarios();
		return Response.ok(listado).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getHorario(@PathParam("id") String id) {

		Horario h;
		try {
			h = gh.getHorario(id);
		} catch(Exception e) {
			Error error = new Error(500,"Error interno",e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}

		if(h == null) {
			Error error = new Error(404,"No encontrado",
					"Horario con ID "+id+" no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error).build();
		}

		return Response.ok(h).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createHorario(Horario horario,
			@Context UriInfo uriInfo) {

		try {
			gh.crearHorario(horario);
		} catch(Exception e) {
			Error error = new Error(500,"Error interno",e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}

		URI location = uriInfo.getAbsolutePathBuilder()
				.path(horario.getId()).build();

		return Response.created(location)
				.entity(horario).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateHorario(@PathParam("id") String id,Horario horario) {

		try {

			if(!id.equals(horario.getId())) {
				Error error = new Error(400,"Datos incorrectos",
						"El ID no coincide");
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(error).build();
			}

			Horario h = gh.getHorario(id);

			if(h == null) {
				Error error = new Error(404,"No encontrado",
						"Horario con ID "+id+" no existe");
				return Response.status(Response.Status.NOT_FOUND)
						.entity(error).build();
			}

			gh.actualizarHorario(horario);

		} catch(Exception e) {
			Error error = new Error(500,"Error interno",e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}

		return Response.ok(horario).build();
	}
}
