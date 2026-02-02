package ec.edu.ups.ppw.gproyectoFinal.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "portafolio")
public class Portafolio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "usuario", unique = true)
    private String usuario;

	@OneToMany(mappedBy = "portafolio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Proyecto> proyectos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
}
	    
