package ec.edu.ups.ppw.gproyectoFinal.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String tecnologias;
    private String tipo; // academico o laboral
    private String tipoParticipacion;
    private String enlaceDemo;
    private String urlRepositorio;

    @ManyToOne
    @JoinColumn(name = "portafolio")
    @JsonIgnore
    private Portafolio portafolio;

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoParticipacion() {
		return tipoParticipacion;
	}

	public void setTipoParticipacion(String tipoParticipacion) {
		this.tipoParticipacion = tipoParticipacion;
	}

	public String getEnlaceDemo() {
		return enlaceDemo;
	}

	public void setEnlaceDemo(String enlaceDemo) {
		this.enlaceDemo = enlaceDemo;
	}

	public String getUrlRepositorio() {
		return urlRepositorio;
	}

	public void setUrlRepositorio(String urlRepositorio) {
		this.urlRepositorio = urlRepositorio;
	}

	public Portafolio getPortafolio() {
		return portafolio;
	}

	public void setPortafolio(Portafolio portafolio) {
		this.portafolio = portafolio;
	}
}