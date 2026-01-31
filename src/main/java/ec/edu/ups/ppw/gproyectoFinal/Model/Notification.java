package ec.edu.ups.ppw.gproyectoFinal.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notification {

	@Id
    @Column(name = "not_id")
    private String id;

    @Column(name = "not_fecha_hora")
    private String fechaHora;

    @Column(name = "not_leido")
    private boolean leido;

    @Column(name = "not_mensaje")
    private String mensaje;


    @ManyToOne
    @JoinColumn(name = "not_usuario_id")
    @JsonIgnore
    private User usuario;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}


	public boolean isLeido() {
		return leido;
	}


	public void setLeido(boolean leido) {
		this.leido = leido;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public User getUsuario() {
		return usuario;
	}


	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
  
}
