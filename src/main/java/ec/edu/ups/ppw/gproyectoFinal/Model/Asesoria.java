package ec.edu.ups.ppw.gproyectoFinal.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "asesoria")
public class Asesoria {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", referencedColumnName = "uid")
    private User usuario;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "programador_uid", referencedColumnName = "uid")
	@JsonIgnore
    private User programador;

    private String fechaHora;
    private String comentario;
    private String estado;
    private String respuesta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	public User getProgramador() {
		return programador;
	}
	public void setProgramador(User programador) {
		this.programador = programador;
	}
	
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
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
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}    

	    
	    
