package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.NotificationDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Notification;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class GestionNotification {
	
	@Inject
	private NotificationDAO daoNotification;

	public List<Notification> getNotification(){
		return daoNotification.getAll();
	}
	
	public Notification getNotification(String id) throws Exception {
		if(id == null || id.isEmpty())
			throw new Exception("Parámetro incorrecto");
		
		Notification n = daoNotification.read(id);
		return n;
	}
	
	public void crearNotification(Notification notification) throws Exception {
		if(notification.getId() == null || notification.getId().isEmpty())
			throw new Exception("ID inválido");
		
		daoNotification.insert(notification);
	}
	
	public void actualizarNotification(Notification notification) throws Exception {
	    if(notification.getId() == null || notification.getId().isEmpty())
	        throw new Exception("ID inválido");

	    daoNotification.update(notification);
	}

}
