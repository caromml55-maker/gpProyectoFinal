package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.PortafolioDAO;
import ec.edu.ups.ppw.gproyectoFinal.DAO.ProyectoDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Portafolio;
import ec.edu.ups.ppw.gproyectoFinal.Model.Proyecto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.*;

@Stateless
public class GestionPortafolio {
	
	@Inject
	private PortafolioDAO daoPortafolio;
	
	@Inject
	private ProyectoDAO daoProyecto;

	public void eliminarProyecto(Long id) throws Exception {
	    daoProyecto.delete(id);
	}

	public List<Portafolio> getPortafolio(){
		return daoPortafolio.getAll();
	}
	
	public Portafolio getPortafolioByUid(String uid) {
        return daoPortafolio.findByUsuarioUid(uid);
    }
	
	public Portafolio getPortafolio(String id) throws Exception {
		if(id == null || id.isEmpty())
			throw new Exception("Parámetro incorrecto");
		
		Portafolio p = daoPortafolio.read(id);
		return p;
	}
	
	public void crearPortafolio(Portafolio portafolio) throws Exception {
		if(portafolio.getId() == null )
			throw new Exception("ID inválido");
		
		daoPortafolio.insert(portafolio);
	}
	
	public void actualizarPortafolio(Portafolio portafolio) throws Exception {
	    if(portafolio.getId() == null )
	        throw new Exception("ID inválido");

	    daoPortafolio.update(portafolio);
	}
	
	public void agregarProyecto(String uid, Proyecto nuevoProyecto) throws Exception {
	    Portafolio p = daoPortafolio.findByUsuarioUid(uid);
	    
	    if (p == null) {
	        p = new Portafolio();
	        p.setUsuario(uid);
	        p.setProyectos(new ArrayList<>());
	        daoPortafolio.insert(p);
	    }
	    
	    // Vinculamos el proyecto con el portafolio
	    nuevoProyecto.setPortafolio(p);
	    p.getProyectos().add(nuevoProyecto);
	    
	    daoPortafolio.update(p);
	}

}
