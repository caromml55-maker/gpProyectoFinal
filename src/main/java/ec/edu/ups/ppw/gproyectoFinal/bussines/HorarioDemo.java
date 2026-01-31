package ec.edu.ups.ppw.gproyectoFinal.bussines;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.DAO.HorarioDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Horario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class HorarioDemo {

	@Inject
	private HorarioDAO dao;
	
	@PostConstruct
	public void init() {

		/*Horario h1 = new Horario();
		h1.setId("H001");
		h1.setFecha("2026-01-15");
		h1.setInicio("08:00");
		h1.setFin("10:00");

		Horario h2 = new Horario();
		h2.setId("H002");
		h2.setFecha("2026-01-16");
		h2.setInicio("10:00");
		h2.setFin("12:00");

		Horario h3 = new Horario();
		h3.setId("H003");
		h3.setFecha("2026-01-17");
		h3.setInicio("14:00");
		h3.setFin("16:00");

		dao.insert(h1);
		dao.insert(h2);
		dao.insert(h3);

		listarHorarios();*/
	}

	public void listarHorarios() {
		List<Horario> lista = dao.getAll();
		for(Horario h : lista) {
			System.out.println("ID: " + h.getId());
			System.out.println("Fecha: " + h.getFecha());
			System.out.println("Inicio: " + h.getInicio());
			System.out.println("Fin: " + h.getFin());
			System.out.println("---------------------");
		}
	}
}
