package ec.edu.ups.ppw.gproyectoFinal.bussines;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.DAO.UserDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class UserDemo {
	
	@Inject
	private UserDAO dao;
	
	@PostConstruct
	public void init() {

		/* User u1 = new User();
			u1.setUid("U001");
			u1.setDisplayName("Juan Perez");
			u1.setEmail("juan@ups.edu.ec");
			u1.setPhotoURL("juan.png");
			u1.setRole("ADMIN");
			u1.setCreatedAt("2026-01-10");
			
			User u2 = new User();
			u2.setUid("U002");
			u2.setDisplayName("Maria Lopez");
			u2.setEmail("maria@ups.edu.ec");
			u2.setPhotoURL("maria.png");
			u2.setRole("USER");
			u2.setCreatedAt("2026-01-11");
			
			User u3 = new User();
			u3.setUid("U003");
			u3.setDisplayName("Carlos Diaz");
			u3.setEmail("carlos@ups.edu.ec");
			u3.setPhotoURL("carlos.png");
			u3.setRole("USER");
			u3.setCreatedAt("2026-01-12");
			
			User u4 = new User();
			u4.setUid("3dF8MYcjMBU0nRgx4CK7324oyl62");
			u4.setDisplayName("Michelle Merchan");
			u4.setEmail("caromml55@gmail.com");
			u4.setPhotoURL("\"https://lh3.googleusercontent.com/a/ACg8ocKvAtUKuLnm7jYhWXhvykPRpv_IZG_nZjaPJ3g4TQij-GSQSHO8=s96-c\"");
			u4.setRole("admin");
			u4.setCreatedAt("2026-01-17");
			
	        dao.insert(u1);
	        dao.insert(u2);
	        dao.insert(u3);
	        dao.insert(u4);

	        listarUsuarios();
	    }

	    public void listarUsuarios() {
	        List<User> lista = dao.getAll();
	        for(User u : lista) {
				System.out.println("UID: " + u.getUid());
				System.out.println("Nombre: " + u.getDisplayName());
				System.out.println("Email: " + u.getEmail());
				System.out.println("Rol: " + u.getRole());
				System.out.println("---------------------");
			}*/
	    }

}
