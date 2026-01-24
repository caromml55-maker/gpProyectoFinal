package ec.edu.ups.ppw.gproyectoFinal.DAO;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.Model.Notification;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class NotificationDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Notification notification) {
		em.persist(notification);
	}

	public void update(Notification notification) {
		em.merge(notification);
	}

	public Notification read(String pk) {
		return em.find(Notification.class, pk);
	}

	public void delete(String pk) {
		Notification notification = em.find(Notification.class, pk);
		em.remove(notification);
	}

	public List<Notification> getAll(){
		String jpql = "SELECT n FROM Notification n";
		TypedQuery<Notification> q = em.createQuery(jpql, Notification.class);
		return q.getResultList();
	}
}
