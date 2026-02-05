package ec.edu.ups.ppw.gproyectoFinal.DAO;

import ec.edu.ups.ppw.gproyectoFinal.Model.Proyecto;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateful
public class ProyectoDAO {

	@PersistenceContext
    private EntityManager em;

    public void delete(Long id) {
        Proyecto p = em.find(Proyecto.class, id);
        if (p != null) {
            em.remove(p);
        }
    }
}
