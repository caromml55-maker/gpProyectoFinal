package ec.edu.ups.ppw.gproyectoFinal.DAO;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.Model.Horario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Stateless
public class HorarioDAO {

    @PersistenceContext
    private EntityManager em;

    public Horario findById(Long id) {
        return em.find(Horario.class, id);
    }

    public List<Horario> findAll() {
        return em.createQuery("SELECT h FROM Horario h", Horario.class).getResultList();
    }

    @Transactional
    public void create(Horario horario) {
        em.persist(horario);
    }

    @Transactional
    public void update(Horario horario) {
        em.merge(horario);
    }

    @Transactional
    public void delete(Long id) {
        String jpql = "DELETE FROM Horario h WHERE h.id = :id";
        int eliminados = em.createQuery(jpql)
                           .setParameter("id", id)
                           .executeUpdate();
    }

    public List<Horario> findByProgramadorUid(String uid) {
        return em.createQuery("SELECT h FROM Horario h WHERE h.programador.uid = :uid", Horario.class)
                 .setParameter("uid", uid)
                 .getResultList();
    }
}
