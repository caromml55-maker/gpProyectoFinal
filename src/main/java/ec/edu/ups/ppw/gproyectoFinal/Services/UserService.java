package ec.edu.ups.ppw.gproyectoFinal.Services;


import java.util.List;
import ec.edu.ups.ppw.gproyectoFinal.Model.*;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionUsers;
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


@Path("/users")
@Consumes("application/json")
@Produces("application/json")
public class UserService {
	
	@Inject
    private GestionUsers gestionUsers;
	 @GET
	    @Path("/programadores")
	    public List<User> getProgramadores() {
	        return gestionUsers.listarProgramadores();
	    }

	    @GET
	    @Path("/admins")
	    public List<User> getAdmins() {
	        return gestionUsers.listarAdmins();
	    }

	    @GET
	    @Path("/usuarios")
	    public List<User> getUsuarios() {
	        return gestionUsers.listarUsuarios();
	    }

	    @GET
	    @Path("/{uid}")
	    public User getUsuario(@PathParam("uid") String uid) {
	        return gestionUsers.obtenerUsuario(uid);
	    }

	    @POST
	    public Response crearUsuario(User u) {
	        gestionUsers.crearUsuario(u);
	        return Response.status(Response.Status.CREATED).build();
	    }

	    @PUT
	    @Path("/{uid}")
	    public Response actualizarUsuario(@PathParam("uid") String uid, User u) {
	        u.setUid(uid);
	        gestionUsers.actualizarUsuario(u);
	        return Response.ok().build();
	    }

	    @DELETE
	    @Path("/{uid}")
	    public Response eliminarUsuario(@PathParam("uid") String uid) {
	        gestionUsers.eliminarUsuario(uid);
	        return Response.noContent().build();
	    }
}
