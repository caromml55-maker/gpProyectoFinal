package ec.edu.ups.ppw.gproyectoFinal.Services;

import ec.edu.ups.ppw.gproyectoFinal.Model.Horario;
import ec.edu.ups.ppw.gproyectoFinal.Model.HorarioDTO;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionHorarios;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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
    private GestionHorarios gestionHorario;

    @GET
    public List<Horario> getAllHorarios() {
        return gestionHorario.getAll();
    }

    @GET
    @Path("/{id}")
    public Horario getHorario(@PathParam("id") Long id) {
        return gestionHorario.getById(id);
    }

    @GET
    @Path("/programador/{uid}")
    @Produces("application/json")
    public List<Horario> getHorariosByProgramador(@PathParam("uid") String uid) {
    	return gestionHorario.getHorariosDisponibles(uid);
    }
    
    @GET
    @Path("/programador/{uidProg}/visto-por/{uidUser}")
    @Produces("application/json")
    public List<HorarioDTO> getHorariosVistosPorUsuario(@PathParam("uidProg") String uidProg, @PathParam("uidUser") String uidUser) {
        return gestionHorario.getHorariosConEstado(uidProg, uidUser);
    }

    @POST
    public Response createHorario(Horario horario) throws Exception {
        gestionHorario.create(horario);
        return Response.status(Response.Status.CREATED).entity(horario).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateHorario(@PathParam("id") Long id, Horario horario) {
        Horario existing = gestionHorario.getById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        horario.setId(id);
        gestionHorario.update(horario);
        return Response.ok(horario).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteHorario(@PathParam("id") Long id) {
    	try {
            gestionHorario.delete(id);
            
            return Response.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Error al eliminar: " + e.getMessage()).build();
        }
    }
}
