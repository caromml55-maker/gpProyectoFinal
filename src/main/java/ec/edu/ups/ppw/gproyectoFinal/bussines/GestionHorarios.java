package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.HorarioDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Horario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class GestionHorarios {

	@Inject
    private HorarioDAO horarioDAO;

    public Horario getById(Long id) {
        return horarioDAO.findById(id);
    }

    public List<Horario> getAll() {
        return horarioDAO.findAll();
    }

    public List<Horario> getByProgramador(String uid) {
        return horarioDAO.findByProgramadorUid(uid);
    }

    public void create(Horario horario) {
        horarioDAO.create(horario);
    }

    public void update(Horario horario) {
        horarioDAO.update(horario);
    }

    public void delete(Horario horario) {
        horarioDAO.delete(horario);
    }
	
}
