package ec.edu.ups.ppw.gproyectoFinal.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "uid")
    private User usuario;

    private String mensaje;
    private String fechaHora;
    private boolean leido;
    
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
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
}
