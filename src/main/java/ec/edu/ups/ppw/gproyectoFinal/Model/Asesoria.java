package ec.edu.ups.ppw.gproyectoFinal.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	    
	    @Column(name = "ase_respuesta")
	    private String respuesta;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "ase_programador_id")
	    @JsonIgnore
	    private User programador;

	    @ManyToOne
	    @JoinColumn(name = "ase_usuario_id")
	    @JsonIgnore
	    private User usuario;
	    
	    

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

		public String getRespuesta() {
			return respuesta;
		}

		public void setRespuesta(String respuesta) {
			this.respuesta = respuesta;
		}

		public User getProgramador() {
			return programador;
		}

		public void setProgramador(User programador) {
			this.programador = programador;
		}

		public User getUsuario() {
			return usuario;
		}

		public void setUsuario(User usuario) {
			this.usuario = usuario;
		}

}    

	    
	    
