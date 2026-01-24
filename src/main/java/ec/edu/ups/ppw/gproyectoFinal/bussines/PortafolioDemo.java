package ec.edu.ups.ppw.gproyectoFinal.bussines;

import java.util.List;

import ec.edu.ups.ppw.gproyectoFinal.DAO.PortafolioDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Portafolio;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.*;
import jakarta.inject.Inject;


@Singleton
@Startup
public class PortafolioDemo {

    @Inject
    private PortafolioDAO dao;

    @PostConstruct
    public void init() {

    	Portafolio p1 = new Portafolio();
		p1.setId("P001");
		p1.setNombre("Sistema de ventas");
		p1.setDescripcion("Proyecto académico");
		p1.setTecnologias("Java, MySQL");
		p1.setTipo("academico");
		p1.setTipoParticipacion("Backend");
		p1.setUrlRepositorio("https://github.com/demo1");
		p1.setEnlaceDemo("");
		p1.setExpandido(false);

		Portafolio p2 = new Portafolio();
		p2.setId("P002");
		p2.setNombre("App móvil");
		p2.setDescripcion("Proyecto laboral");
		p2.setTecnologias("Flutter");
		p2.setTipo("laboral");
		p2.setTipoParticipacion("Frontend");
		p2.setUrlRepositorio("https://github.com/demo2");
		p2.setEnlaceDemo("");
		p2.setExpandido(false);

		Portafolio p3 = new Portafolio();
		p3.setId("P003");
		p3.setNombre("Sistema contable");
		p3.setDescripcion("Proyecto laboral");
		p3.setTecnologias("Angular, Spring");
		p3.setTipo("laboral");
		p3.setTipoParticipacion("FullStack");
		p3.setUrlRepositorio("https://github.com/demo3");
		p3.setEnlaceDemo("");
		p3.setExpandido(true);

		dao.insert(p1);
		dao.insert(p2);
		dao.insert(p3);

		listarPortafolios();
	}

	public void listarPortafolios() {
		List<Portafolio> lista = dao.getAll();
		for(Portafolio p : lista) {
			System.out.println("ID: " + p.getId());
			System.out.println("Nombre: " + p.getNombre());
			System.out.println("Tipo: " + p.getTipo());
			System.out.println("Tecnologías: " + p.getTecnologias());
			System.out.println("Participación: " + p.getTipoParticipacion());
			System.out.println("Repositorio: " + p.getUrlRepositorio());
			System.out.println("---------------------");
		}
	}

}
