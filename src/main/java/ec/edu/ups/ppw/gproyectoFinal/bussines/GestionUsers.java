package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.UserDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class GestionUsers {
	
	@Inject
	private UserDAO dao;

	public List<User> getAll() {
        return dao.findAll();
    }

    public User getByUid(String uid) {
        return dao.findByUid(uid);
    }

    public List<User> getAdmins() {
        return dao.findByRole("ADMIN");
    }

    public List<User> getProgramadores() {
        return dao.findByRole("USER");
    }

    public User create(User user) {
        dao.insert(user);
        return user;
    }

    public User update(User user) {
        return dao.update(user);
    }

    public void changeRole(String uid, String role) {
        User u = dao.findByUid(uid);
        if (u != null) {
            u.setRole(role);
            dao.update(u);
        }
    }

    public void delete(String uid) {
        dao.delete(uid);
    }

}
