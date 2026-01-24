package ec.edu.ups.ppw.gproyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "asesoria")
public class Asesoria {

	  @Id
	    @Column(name = "ase_id")
	    private String id;   
	  
	    @Column(name = "ase_comentario")
	    private String comentario;

	    private String estado;

	    @Column(name = "ase_fecha_hora")
	    private String fechaHora;

	    @Column(name = "ase_programador_id")
	    private String programadorId;

	    @Column(name = "ase_respuesta")
	    private String respuesta;

	    @Column(name = "ase_usuario_id")
	    private String usuarioId;

	    // GETTERS & SETTERS

	    public String getId() {
	        return id;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getComentario() {
	        return comentario;
	    }
	    public void setComentario(String comentario) {
	        this.comentario = comentario;
	    }

	    public String getEstado() {
	        return estado;
	    }
	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

	    public String getFechaHora() {
	        return fechaHora;
	    }
	    public void setFechaHora(String fechaHora) {
	        this.fechaHora = fechaHora;
	    }

	    public String getProgramadorId() {
	        return programadorId;
	    }
	    public void setProgramadorId(String programadorId) {
	        this.programadorId = programadorId;
	    }

	    public String getRespuesta() {
	        return respuesta;
	    }
	    public void setRespuesta(String respuesta) {
	        this.respuesta = respuesta;
	    }

	    public String getUsuarioId() {
	        return usuarioId;
	    }
	    public void setUsuarioId(String usuarioId) {
	        this.usuarioId = usuarioId;
	    }
}
