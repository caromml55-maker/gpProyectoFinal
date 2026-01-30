package ec.edu.ups.ppw.gproyectoFinal.Firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FirebaseAuthService {
	
	public FirebaseToken validateToken(String idToken) throws Exception {
        return FirebaseAuth.getInstance().verifyIdToken(idToken);
    }

}
