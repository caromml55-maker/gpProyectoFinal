package ec.edu.ups.ppw.gproyectoFinal.bussines;

import ec.edu.ups.ppw.gproyectoFinal.DAO.AsesoriaDAO;
import ec.edu.ups.ppw.gproyectoFinal.DAO.NotificationDAO;
import ec.edu.ups.ppw.gproyectoFinal.Model.Asesoria;
import ec.edu.ups.ppw.gproyectoFinal.Model.Notification;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class GestionAsesorias {
	
	@Inject
    private AsesoriaDAO daoAsesoria;
	
	@Inject
    private NotificationDAO daoNotificacion;

    public List<Asesoria> obtenerPendientes(String uidProgramador) {
        return daoAsesoria.getPendientesPorProgramador(uidProgramador);
    }

    public void responderAsesoria(Long idAsesoria, String nuevoEstado) throws Exception {
        Asesoria a = daoAsesoria.read(idAsesoria);
        
        if (a == null) throw new Exception("Asesoría no encontrada");

	        a.setEstado(nuevoEstado);
	        String mensajeRespuesta = nuevoEstado.equals("aceptada") 
	                ? "El programador ha aceptado tu asesoría" 
	                : "El programador ha rechazado tu asesoría";
	        a.setRespuesta(mensajeRespuesta);
	        daoAsesoria.update(a);

        Notification n = new Notification();
	        n.setUsuario(a.getUsuario()); 
	        n.setFechaHora(LocalDateTime.now().toString());
	        n.setLeido(false);
        

        String nombreProg = a.getProgramador().getDisplayName(); 
        String icono = nuevoEstado.equals("aceptada") ? "✔️" : "❌";
        n.setMensaje(icono + " Tu asesoría fue " + nuevoEstado + " por " + nombreProg);
        
        daoNotificacion.insert(n);
    }
	
    public void solicitarAsesoria(Asesoria a) throws Exception {
        
        boolean existe = daoAsesoria.existeAsesoriaPendiente(
            a.getUsuario().getUid(), 
            a.getProgramador().getUid(), 
            a.getFechaHora()
        );
        
        if (existe) {
            throw new Exception("DUPLICADO: Ya tienes una solicitud pendiente para esta fecha y hora.");
        }

        daoAsesoria.insert(a);

        Notification n = new Notification();
        n.setUsuario(a.getProgramador()); // El destinatario es el programador
        n.setFechaHora(LocalDateTime.now().toString());
        n.setLeido(false);
        n.setMensaje("📩 Nueva solicitud de asesoría de " + a.getUsuario().getDisplayName());
        
        daoNotificacion.insert(n);
    }
    

 public void cancelarAsesoria(Long idAsesoria) throws Exception {
     Asesoria a = daoAsesoria.read(idAsesoria);
     
     if (a == null) {
         throw new Exception("La asesoría no existe o ya fue eliminada");
     }
     Notification n = new Notification();
     n.setUsuario(a.getProgramador()); // Destinatario: Programador
     n.setFechaHora(LocalDateTime.now().toString());
     n.setLeido(false);
     
     String nombreUsuario = (a.getUsuario() != null) ? a.getUsuario().getDisplayName() : "Un usuario";
     n.setMensaje("⚠️ " + nombreUsuario + " ha cancelado la asesoría reservada para el " + a.getFechaHora());
     
     daoNotificacion.insert(n);
     daoAsesoria.delete(idAsesoria); 
 }
}
