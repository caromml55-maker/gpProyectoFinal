package ec.edu.ups.ppw.gproyectoFinal.DAO;

import java.util.List;
import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class UserDAO {
	
	@PersistenceContext
    private EntityManager em;

	public void crear(User u) {
        em.persist(u);
    }

    public void actualizar(User u) {
        em.merge(u);
    }

    public void eliminar(String uid) {
        User u = em.find(User.class, uid);
        if (u != null) em.remove(u);
    }

    public User buscarPorUid(String uid) {
        return em.find(User.class, uid);
    }

    public List<User> getTodos() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public List<User> getPorRole(String role) {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class);
        q.setParameter("role", role);
        return q.getResultList();
    }
    
    public User buscarPorEmail(String email) {
        try {
            TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            q.setParameter("email", email);
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
