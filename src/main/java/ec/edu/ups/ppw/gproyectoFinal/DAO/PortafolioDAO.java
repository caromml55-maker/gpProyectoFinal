package ec.edu.ups.ppw.gproyectoFinal.DAO;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.Model.Portafolio;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class PortafolioDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Portafolio portafolio) {
		em.persist(portafolio);
	}

	public void update(Portafolio portafolio) {
		em.merge(portafolio);
	}

	public Portafolio read(String pk) {
		return em.find(Portafolio.class, pk);
	}

	public void delete(String pk) {
		Portafolio portafolio = em.find(Portafolio.class, pk);
		em.remove(portafolio);
	}

	public List<Portafolio> getAll(){
		String jpql = "SELECT p FROM Portafolio p";
		TypedQuery<Portafolio> q = em.createQuery(jpql, Portafolio.class);
		return q.getResultList();
	}
	
	public Portafolio findByUsuarioUid(String uid) {
	    try {
	        String jpql = "SELECT p FROM Portafolio p WHERE p.usuario = :uid";
	        return em.createQuery(jpql, Portafolio.class)
	                 .setParameter("uid", uid)
	                 .getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}
}
