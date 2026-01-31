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


@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class UserService {
	
	@Inject
    private GestionUsers service;

    // ---------- USERS ----------
    @GET
    @Path("users")
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @GET
    @Path("users/{uid}")
    public User getUser(@PathParam("uid") String uid) {
        return service.getByUid(uid);
    }

    @POST
    @Path("users")
    public Response createUser(User user) {
        service.create(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    @Path("users/{uid}")
    public User updateUser(@PathParam("uid") String uid, User user) {
        user.setUid(uid);
        return service.update(user);
    }

    @DELETE
    @Path("users/{uid}")
    public Response deleteUser(@PathParam("uid") String uid) {
        service.delete(uid);
        return Response.noContent().build();
    }

    // ---------- ROLES ----------
    @PUT
    @Path("users/{uid}/role")
    public Response changeRole(@PathParam("uid") String uid, RoleDTO dto) {
        service.changeRole(uid, dto.role());
        return Response.ok().build();
    }

    // ---------- FILTERS ----------
    @GET
    @Path("admins")
    public List<User> getAdmins() {
        return service.getAdmins();
    }

    @GET
    @Path("programadores")
    public List<User> getProgramadores() {
        return service.getProgramadores();
    }

    public record RoleDTO(String role) {}

}
