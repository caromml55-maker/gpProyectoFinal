package ec.edu.ups.ppw.gproyectoFinal.Firebase;

import com.google.firebase.auth.FirebaseToken;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
	
	@Inject
    private FirebaseAuthService firebaseAuthService;

    @POST
    @Path("/validate-token")
    public Response validateToken(TokenRequest request) {
        try {
            FirebaseToken decodedToken =
                    firebaseAuthService.validateToken(request.getToken());

            UserResponse user = new UserResponse(
                    decodedToken.getUid(),
                    decodedToken.getEmail(),
                    decodedToken.getName()
            );

            return Response.ok(user).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Token inválido o expirado")
                    .build();
        }
    }
}
