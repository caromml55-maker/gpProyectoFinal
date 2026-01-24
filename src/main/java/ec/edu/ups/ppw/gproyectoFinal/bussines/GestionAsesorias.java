package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.AsesoriaDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Asesoria;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class GestionAsesorias {

	@Inject
	private AsesoriaDAO dao;
	
	public List<Asesoria> getAsesorias(){
		return dao.getAll();
	}
	
	public Asesoria getAsesoria(String id) throws Exception {
		if(id == null || id.isEmpty())
			throw new Exception("ID inválido");
		
		Asesoria a = dao.read(id);
		return a;
	}
	
	public void crearAsesoria(Asesoria asesoria) throws Exception {
		if(asesoria.getId() == null || asesoria.getId().isEmpty())
			throw new Exception("ID inválido");
		
		dao.insert(asesoria);
	}
	
	public void actualizarAsesoria(Asesoria asesoria) throws Exception {
		if(asesoria.getId() == null || asesoria.getId() .isEmpty())
			throw new Exception("ID inválido");
		
		dao.update(asesoria);
	}
	
}
