package ec.edu.ups.ppw.gproyectoFinal.DAO;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.Model.Asesoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class AsesoriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Asesoria a) {
        em.persist(a);
    }

    public void update(Asesoria a) {
        em.merge(a);
    }

    public Asesoria read(String pk) {
        return em.find(Asesoria.class, pk);
    }

    public void delete(String pk) {
        Asesoria a = em.find(Asesoria.class, pk);
        em.remove(a);
    }

    public List<Asesoria> getAll() {
        String jpql = "SELECT a FROM Asesoria a";
        TypedQuery<Asesoria> q = em.createQuery(jpql, Asesoria.class);
        return q.getResultList();
    }

}
