package ec.edu.ups.ppw.gproyectoFinal.bussines;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.DAO.NotificationDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Notification;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class NotificationDemo {

	@Inject
	private NotificationDAO dao;
	
	@PostConstruct
	public void init() {

		Notification n1 = new Notification();
		n1.setId("N001");
		n1.setFechaHora("2026-01-10T10:00");
		n1.setMensaje("Tu asesoría fue aceptada");
		n1.setLeido(false);

		Notification n2 = new Notification();
		n2.setId("N002");
		n2.setFechaHora("2026-01-11T11:00");
		n2.setMensaje("Tu asesoría fue rechazada");
		n2.setLeido(false);

		Notification n3 = new Notification();
		n3.setId("N003");
		n3.setFechaHora("2026-01-12T12:00");
		n3.setMensaje("Nuevo mensaje del programador");
		n3.setLeido(true);

		dao.insert(n1);
		dao.insert(n2);
		dao.insert(n3);

		listarNotifications();
	}

	public void listarNotifications() {
		List<Notification> lista = dao.getAll();
		for(Notification n : lista) {
			System.out.println("ID: " + n.getId());
			System.out.println("FechaHora: " + n.getFechaHora());
			System.out.println("Mensaje: " + n.getMensaje());
			System.out.println("Leído: " + n.isLeido());
			System.out.println("---------------------");
		}
	}
}
