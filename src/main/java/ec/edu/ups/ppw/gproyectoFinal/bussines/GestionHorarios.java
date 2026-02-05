package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.AsesoriaDAO;
import ec.edu.ups.ppw.gproyectoFinal.DAO.HorarioDAO;
import ec.edu.ups.ppw.gproyectoFinal.DAO.NotificationDAO;
import ec.edu.ups.ppw.gproyectoFinal.DAO.UserDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Asesoria;
import ec.edu.ups.ppw.gproyectoFinal.Model.Horario;
import ec.edu.ups.ppw.gproyectoFinal.Model.HorarioDTO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Notification;
import ec.edu.ups.ppw.gproyectoFinal.Model.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GestionHorarios {

	@Inject
    private HorarioDAO horarioDAO;
	
	@Inject
    private UserDAO userDAO;
	
	@Inject
	private AsesoriaDAO asesoriaDAO;
	
	@Inject
	private NotificationDAO notificationDAO;

    public Horario getById(Long id) {
        return horarioDAO.findById(id);
    }

    public List<Horario> getAll() {
        return horarioDAO.findAll();
    }

    public List<Horario> getByProgramador(String uid) {
        return horarioDAO.findByProgramadorUid(uid);
    }

    public void create(Horario horario) throws Exception {
        if(horario.getProgramadorUid() == null) {
            throw new Exception("El UID del programador es obligatorio");
        }
        if(horario.getFecha() == null || horario.getInicio() == null) {
            throw new Exception("Fecha y Hora son obligatorios");
       }

        User p = userDAO.buscarPorUid(horario.getProgramadorUid()); 

        if(p == null) {
            throw new Exception("Programador no encontrado");
        }

        horario.setProgramador(p);

        horarioDAO.create(horario);
    }
    public void update(Horario horario) {
        horarioDAO.update(horario);
    }

    public void delete(Long id) {
        horarioDAO.delete(id);
    }
    
    public List<Horario> getHorariosDisponibles(String uidProgramador) {
        List<Horario> todos = horarioDAO.findByProgramadorUid(uidProgramador);
        List<Asesoria> ocupadas = asesoriaDAO.getAsesoriasActivas(uidProgramador);
        todos.removeIf(h -> {
            String fechaHorario = h.getFecha() + "T" + h.getInicio();
            
            return ocupadas.stream().anyMatch(a -> {
                return a.getFechaHora() != null && a.getFechaHora().startsWith(fechaHorario);
            });
        });
        
        return todos;
    }
    
    public List<HorarioDTO> getHorariosConEstado(String uidProgramador, String uidUsuarioVisualizador) {
        List<Horario> horarios = horarioDAO.findByProgramadorUid(uidProgramador);
        List<HorarioDTO> resultado = new ArrayList<>();

        List<Asesoria> citas = asesoriaDAO.getAsesoriasActivas(uidProgramador);

        for (Horario h : horarios) {
            String uidDelDueño = h.getProgramador() != null ? h.getProgramador().getUid() : uidProgramador;

            // Pasamos el UID al constructor
            HorarioDTO dto = new HorarioDTO(
                h.getId(), 
                uidDelDueño, // <--- AQUÍ LO PASAMOS
                h.getFecha(), 
                h.getInicio(), 
                h.getFin(), 
                h.getModalidad()
            );

            String fechaHorario = h.getFecha() + "T" + h.getInicio();
            Asesoria coincidencia = citas.stream()
                .filter(a -> a.getFechaHora() != null && a.getFechaHora().startsWith(fechaHorario))
                .findFirst()
                .orElse(null);

            if (coincidencia != null) {
                dto.setIdAsesoria(coincidencia.getId());
                if (coincidencia.getUsuario().getUid().equals(uidUsuarioVisualizador)) {
                    dto.setEstado("MIO");
                } else {
                    dto.setEstado("OCUPADO");
                }
            }
            resultado.add(dto);
        }
        return resultado;
    }
    
    public void cancelarAsesoria(Long idAsesoria) throws Exception {
        Asesoria a = asesoriaDAO.read(idAsesoria);
        if (a != null) {
            Notification n = new Notification();
            n.setUsuario(a.getProgramador());
            n.setFechaHora(LocalDateTime.now().toString());
            n.setLeido(false);
            n.setMensaje("⚠️ El usuario " + a.getUsuario().getDisplayName() + " ha cancelado la asesoría del " + a.getFechaHora());
            notificationDAO.insert(n);

            asesoriaDAO.delete(idAsesoria); 
        }
    
    }
}
