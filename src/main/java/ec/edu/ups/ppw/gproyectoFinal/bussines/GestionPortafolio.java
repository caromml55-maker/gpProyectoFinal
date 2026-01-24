package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.PortafolioDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Portafolio;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.*;

@Stateless
public class GestionPortafolio {
	
	@Inject
	private PortafolioDAO daoPortafolio;

	public List<Portafolio> getPortafolio(){
		return daoPortafolio.getAll();
	}
	
	public Portafolio getPortafolio(String id) throws Exception {
		if(id == null || id.isEmpty())
			throw new Exception("Parámetro incorrecto");
		
		Portafolio p = daoPortafolio.read(id);
		return p;
	}
	
	public void crearPortafolio(Portafolio portafolio) throws Exception {
		if(portafolio.getId() == null || portafolio.getId().isEmpty())
			throw new Exception("ID inválido");
		
		daoPortafolio.insert(portafolio);
	}
	
	public void actualizarPortafolio(Portafolio portafolio) throws Exception {
	    if(portafolio.getId() == null || portafolio.getId().isEmpty())
	        throw new Exception("ID inválido");

	    daoPortafolio.update(portafolio);
	}

}
