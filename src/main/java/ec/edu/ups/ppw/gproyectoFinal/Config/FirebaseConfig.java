package ec.edu.ups.ppw.gproyectoFinal.Config;

import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
public class FirebaseConfig {

	@PostConstruct
    public void init() {
        try {
            InputStream serviceAccount =
                getClass().getClassLoader()
                    .getResourceAsStream("firebase/proyectoppw67mm-firebase-adminsdk-fbsvc-6cb95185ae.json");

            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println(" Firebase inicializado correctamente");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
