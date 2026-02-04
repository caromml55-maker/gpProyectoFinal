package ec.edu.ups.ppw.gproyectoFinal.Services;

import java.util.List;
import java.util.Map;

import ec.edu.ups.ppw.gproyectoFinal.DAO.UserDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.*;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionAsesorias;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("asesoria")
public class AsesoriaService {
	
	@Inject
	private GestionAsesorias gp;
	
	@Inject
    private UserDAO userDAO;
	
	@GET
    @Path("/programador/{uid}/pendientes")
    @Produces("application/json")
    public Response getPendientes(@PathParam("uid") String uid) {
        try {
            List<Asesoria> lista = gp.obtenerPendientes(uid);
            return Response.ok(lista).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
		
	@PUT
    @Path("/{id}/responder")
    @Consumes("application/json") 
    public Response responder(@PathParam("id") Long id, Map<String, String> body) {
        try {
            String nuevoEstado = body.get("estado"); 
            if (nuevoEstado == null) return Response.status(400).entity("Estado requerido").build();

            gp.responderAsesoria(id, nuevoEstado);
            
            return Response.ok().entity("{\"mensaje\": \"Respuesta enviada y notificación creada\"}").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
	
	@POST
	@Consumes("application/json")
	public Response crearAsesoria(Map<String, String> data) {
	    try {
	        Asesoria a = new Asesoria();
	        a.setComentario(data.get("comentario"));
	        a.setFechaHora(data.get("fechaHora"));
	        a.setEstado("pendiente");
	        
	        User u = userDAO.buscarPorUid(data.get("usuarioUid"));
	        User p = userDAO.buscarPorUid(data.get("programadorUid"));
	        
	        if (u == null || p == null) return Response.status(404).entity("Usuario no encontrado").build();
	        
	        a.setUsuario(u);
	        a.setProgramador(p);
	        
	        gp.solicitarAsesoria(a);
	        
	        return Response.status(201).entity("Solicitud creada").build();
	        
	    } catch (Exception e) {
	        if (e.getMessage().startsWith("DUPLICADO")) {
	            return Response.status(409).entity(e.getMessage()).build(); // 409 Conflict
	        }
	        return Response.status(500).entity(e.getMessage()).build();
	    }
	}
	
	@DELETE
	@Path("/{id}")
	public Response cancelarAsesoria(@PathParam("id") Long id) {
	    try {
	        gp.cancelarAsesoria(id); // Implementado en el paso anterior
	        return Response.ok("{\"mensaje\": \"Asesoría cancelada\"}").build();
	    } catch (Exception e) {
	        return Response.status(500).build();
	    }
	}
}
