package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.AsesoriaDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Asesoria;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class AsesoriaDemo {

	@Inject
    private AsesoriaDAO dao;

    @PostConstruct
    public void init() {

    	Asesoria a1 = new Asesoria();
        a1.setId("A1");
        a1.setComentario("Necesito ayuda con Angular");
        a1.setEstado("aceptada");
        a1.setFechaHora("2025-12-17T10:30:00-05:00");
        a1.setProgramadorId("PROG123");
        a1.setRespuesta("Aceptada");
        a1.setUsuarioId("USER123");

        dao.insert(a1);

        System.out.println(" Asesoría insertada");
    }
    
}
