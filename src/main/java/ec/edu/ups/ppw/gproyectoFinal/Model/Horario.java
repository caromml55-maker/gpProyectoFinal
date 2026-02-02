package ec.edu.ups.ppw.gproyectoFinal.Model;

import java.time.LocalDate;
import java.time.LocalTime;

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
	@JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "programador")
    @JsonIgnore
    private User programador;

    @Transient
    private String programadorUid;
    private LocalDate fecha;
    private LocalTime inicio;
    private LocalTime fin;
    
    
    
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}
	public LocalTime getFin() {
		return fin;
	}
	public void setFin(LocalTime fin) {
		this.fin = fin;
	}
}
