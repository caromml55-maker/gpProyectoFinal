package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.UserDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class GestionUsers {
	
	@Inject
	private UserDAO daoUser;

	public List<User> getPersona(){
		return daoUser.getAll();
	}
	
	public User getPersona(String id) throws Exception {
		if(id == null || id.isEmpty())
			throw new Exception("Parámetro incorrecto");
		
		User u = daoUser.read(id);
		return u;
	}
	
	public void crearPersona(User user) throws Exception {
		if(user.getUid() == null || user.getUid().isEmpty())
			throw new Exception("UID inválido");
		
		daoUser.insert(user);
	}
	
	public void actualizarPersona(User user) throws Exception {
	    if(user.getUid() == null || user.getUid().isEmpty())
	        throw new Exception("UID inválido");

	    daoUser.update(user);
	}

}
