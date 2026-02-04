package ec.edu.ups.ppw.gproyectoFinal.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "horario")
public class Horario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "programador")
    @JsonIgnore
    private User programador;

    @Transient
    private String programadorUid;
    
    private String fecha;   
    private String inicio;  
    private String fin;     
    private String modalidad;
    
    
	public String getProgramadorUid() {
		return programadorUid;
	}
	public void setProgramadorUid(String programadorUid) {
		this.programadorUid = programadorUid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getProgramador() {
		return programador;
	}
	public void setProgramador(User programador) {
		this.programador = programador;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
}
