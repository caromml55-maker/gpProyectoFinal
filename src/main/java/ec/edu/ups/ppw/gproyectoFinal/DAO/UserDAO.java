package ec.edu.ups.ppw.gproyectoFinal.DAO;

import java.util.List;
import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(User persona) {
		em.persist(persona);
	}
	
	public void update(User persona) {
		em.merge(persona);
	}
	
	public User read(String pk) {
		return em.find(User.class, pk);
	}
	
	public void delete(String pk) {
		User persona = em.find(User.class, pk);
		em.remove(persona);
	}
	
	public List<User> getAll(){
		String jpql = "SELECT u FROM User u";
		TypedQuery<User> q = em.createQuery(jpql,User.class);
		return q.getResultList();
	}

}
