package ec.edu.ups.ppw.gproyectoFinal.DAO;

import java.util.List;
import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class UserDAO {
	
	@PersistenceContext
    private EntityManager em;

    public void insert(User user) {
        em.persist(user);
    }

    public User update(User user) {
        return em.merge(user);
    }

    public User findByUid(String uid) {
        return em.find(User.class, uid);
    }

    public void delete(String uid) {
        User u = findByUid(uid);
        if (u != null) {
            em.remove(u);
        }
    }

    public List<User> findAll() {
        return em.createQuery(
                "SELECT u FROM User u", User.class
        ).getResultList();
    }

    public List<User> findByRole(String role) {
        TypedQuery<User> q = em.createQuery(
                "SELECT u FROM User u WHERE u.role = :role", User.class);
        q.setParameter("role", role);
        return q.getResultList();
    }

    public User findByEmail(String email) {
        TypedQuery<User> q = em.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
        q.setParameter("email", email);
        List<User> res = q.getResultList();
        return res.isEmpty() ? null : res.get(0);
    }

}
