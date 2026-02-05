package ec.edu.ups.ppw.gproyectoFinal.Services;

import ec.edu.ups.ppw.gproyectoFinal.Model.Notification;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionNotification;
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
import java.util.*;
import java.net.URI;


@Path("notification")
public class NotificationService {

	@Inject
	private GestionNotification gn;

	@GET
	@Produces("application/json")
	public Response getListaNotifications(){
		List<Notification> listado = gn.getNotification();
		return Response.ok(listado).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getNotification(@PathParam("id") String id) {

		Notification n;
		try {
			n = gn.getNotification(id);
		} catch(Exception e) {
			Error error = new Error(500,"Error interno",e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}

		if(n == null) {
			Error error = new Error(404,"No encontrado",
					"Notificación con ID "+id+" no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error).build();
		}

		return Response.ok(n).build();
	}

	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateNotification(@PathParam("id") String id,
			Notification n) {

		try {

			if(!id.equals(n.getId())) {
				Error error = new Error(400,"Datos incorrectos",
						"El ID no coincide");
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(error).build();
			}

			Notification not = gn.getNotification(id);

			if(not == null) {
				Error error = new Error(404,"No encontrado",
						"Notificación con ID "+id+" no existe");
				return Response.status(Response.Status.NOT_FOUND)
						.entity(error).build();
			}

			gn.actualizarNotification(n);

		} catch(Exception e) {
			Error error = new Error(500,"Error interno",e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error).build();
		}

		return Response.ok(n).build();
	}
	@GET
    @Path("/usuario/{uid}")
    @Produces("application/json")
    public Response getNotificacionesPorUsuario(@PathParam("uid") String uid) {
        try {
            List<Notification> lista = gn.getNotificacionesPorUsuario(uid);
            
            return Response.ok(lista).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Error al obtener notificaciones").build();
        }
    }
    
    @PUT
    @Path("/{id}/leido")
    @Produces("application/json")
    public Response marcarComoLeida(@PathParam("id") Long id) {
        try {

             return Response.ok("{\"mensaje\":\"Actualizado\"}").build();
        } catch (Exception e) {
            return Response.status(500).entity("Error").build();
        }
    }

}
