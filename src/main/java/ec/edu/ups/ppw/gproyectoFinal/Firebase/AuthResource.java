package ec.edu.ups.ppw.gproyectoFinal.Firebase;

import com.google.firebase.auth.FirebaseToken;

import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import ec.edu.ups.ppw.gproyectoFinal.Services.FirebaseAuthService;
import ec.edu.ups.ppw.gproyectoFinal.bussines.GestionUsers;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Consumes("application/json")
@Produces("application/json")
public class AuthResource {
	
	@Inject
    private FirebaseAuthService firebaseAuthService;
	
	 @Inject
	   private GestionUsers gestionUsers;

	 @POST
	    @Path("/validate-token")
	    public Response validateToken(TokenRequest request) {
	        try {
	            // 1. Validar token con Firebase
	            FirebaseToken decodedToken = firebaseAuthService.validateToken(request.getToken());
	            System.out.println("Token validado para usuario: " + decodedToken.getUid());
	            
	            // 2. Buscar usuario en la base de datos
	            User dbUser = gestionUsers.getByUid(decodedToken.getUid());
	            
	            User finalUser;
	            
	            if (dbUser == null) {
	                // 3. Si no existe, crear nuevo usuario con rol "user"
	                System.out.println("Usuario no encontrado en BD, creando nuevo usuario: " + decodedToken.getUid());
	                
	                User newUser = new User();
	                newUser.setUid(decodedToken.getUid());
	                newUser.setDisplayName(decodedToken.getName());
	                newUser.setEmail(decodedToken.getEmail());
	                newUser.setPhotoURL(decodedToken.getPicture() != null ? decodedToken.getPicture() : "");
	                newUser.setRole("user"); // Rol por defecto para nuevos usuarios
	                newUser.setCreatedAt(java.time.LocalDate.now().toString());
	                
	                gestionUsers.create(newUser);
	                finalUser = newUser;
	                System.out.println("Usuario creado exitosamente con rol: user");
	            } else {
	              
	                finalUser = dbUser;
	                System.out.println("Usuario encontrado en BD con rol: " + dbUser.getRole());
	            }

	            UserResponse userResponse = new UserResponse(
	                finalUser.getUid(),
	                finalUser.getEmail(),
	                finalUser.getDisplayName(),
	                finalUser.getPhotoURL(),
	                finalUser.getRole()
	            );

	            System.out.println("Enviando respuesta con rol: " + finalUser.getRole());
	            return Response.ok(userResponse).build();

	        } catch (Exception e) {
	            e.printStackTrace();
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity("Token inválido o error interno: " + e.getMessage())
	                    .build();
	        }
	    }
}
