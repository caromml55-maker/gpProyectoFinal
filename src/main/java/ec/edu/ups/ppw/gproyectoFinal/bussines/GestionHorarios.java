package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.HorarioDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Horario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class GestionHorarios {

	@Inject
	private HorarioDAO daoHorario;
	
	public List<Horario> getHorarios(){
		return daoHorario.getAll();
	}
	
	public Horario getHorario(String id) throws Exception {
		if(id == null || id.isEmpty())
			throw new Exception("Parámetro incorrecto");
		
		Horario h = daoHorario.read(id);
		return h;
	}
	
	public void crearHorario(Horario horario) throws Exception {
		if(horario.getId() == null || horario.getId().isEmpty())
			throw new Exception("ID inválido");
		
		daoHorario.insert(horario);
	}
	
	public void actualizarHorario(Horario horario) throws Exception {
	    if(horario.getId() == null || horario.getId().isEmpty())
	        throw new Exception("ID inválido");

	    daoHorario.update(horario);
	}
	
}
