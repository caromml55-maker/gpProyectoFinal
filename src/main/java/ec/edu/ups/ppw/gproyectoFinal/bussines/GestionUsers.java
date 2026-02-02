package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.UserDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class GestionUsers {
	
	 @Inject
	    private UserDAO userDAO;

	    public List<User> listarProgramadores() {
	        return userDAO.getPorRole("programador");
	    }

	    public List<User> listarAdmins() {
	        return userDAO.getPorRole("admin");
	    }

	    public List<User> listarUsuarios() {
	        return userDAO.getPorRole("user");
	    }

	    public void crearUsuario(User u) {
	        if(u.getUid() == null || u.getUid().isEmpty()) {
	            throw new IllegalArgumentException("El UID es obligatorio");
	        }
	        userDAO.crear(u);
	    }

	    public void actualizarUsuario(User u) {
	        if(userDAO.buscarPorUid(u.getUid()) == null) {
	            throw new IllegalArgumentException("Usuario no encontrado");
	        }
	        userDAO.actualizar(u);
	    }

	    public void eliminarUsuario(String uid) {
	        userDAO.eliminar(uid);
	    }

	    public User obtenerUsuario(String uid) {
	        return userDAO.buscarPorUid(uid);
	    }
}
