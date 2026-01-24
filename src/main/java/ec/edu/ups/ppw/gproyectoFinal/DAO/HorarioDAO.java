package ec.edu.ups.ppw.gproyectoFinal.DAO;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.Model.Horario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class HorarioDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Horario horario) {
		em.persist(horario);
	}
	
	public void update(Horario horario) {
		em.merge(horario);
	}
	
	public Horario read(String pk) {
		return em.find(Horario.class, pk);
	}

	public void delete(String pk) {
		Horario horario = em.find(Horario.class, pk);
		em.remove(horario);
    }

    public List<Horario> getAll() {
        String jpql = "SELECT h FROM Horario h";
        TypedQuery<Horario> q = em.createQuery(jpql, Horario.class);
        return q.getResultList();
    }
}
