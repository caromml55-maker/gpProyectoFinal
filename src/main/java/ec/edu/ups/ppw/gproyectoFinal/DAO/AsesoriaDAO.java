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

    public Asesoria read(Long pk) {
        return em.find(Asesoria.class, pk);
    }

    public void delete(Long pk) {
        Asesoria a = em.find(Asesoria.class, pk);
        em.remove(a);
    }

    public List<Asesoria> getAll() {
        String jpql = "SELECT a FROM Asesoria a";
        TypedQuery<Asesoria> q = em.createQuery(jpql, Asesoria.class);
        return q.getResultList();
    }
    
    public List<Asesoria> getPendientesPorProgramador(String uid) {
        String jpql = "SELECT a FROM Asesoria a WHERE a.programador.uid = :uid AND a.estado = 'pendiente'";
        return em.createQuery(jpql, Asesoria.class)
                 .setParameter("uid", uid)
                 .getResultList();
    }
    
    public boolean existeAsesoriaPendiente(String uidUsuario, String uidProgramador, String fechaHora) {
        String jpql = "SELECT COUNT(a) FROM Asesoria a WHERE " +
                      "a.usuario.uid = :uidUser AND " +
                      "a.programador.uid = :uidProg AND " +
                      "a.fechaHora = :fecha AND " +
                      "a.estado = 'pendiente'";
                      
        Long count = em.createQuery(jpql, Long.class)
                       .setParameter("uidUser", uidUsuario)
                       .setParameter("uidProg", uidProgramador)
                       .setParameter("fecha", fechaHora)
                       .getSingleResult();
                       
        return count > 0;
    }
    
    public List<Asesoria> getAsesoriasActivas(String uidProgramador) {
        String jpql = "SELECT a FROM Asesoria a WHERE a.programador.uid = :uid AND a.estado IN ('pendiente', 'aceptada')";
        return em.createQuery(jpql, Asesoria.class)
                 .setParameter("uid", uidProgramador)
                 .getResultList();
    }
    
    
    

}
