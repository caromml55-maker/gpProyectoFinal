package ec.edu.ups.ppw.gproyectoFinal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Horario {

	@Id
	@Column(name = "hor_id")
	private String id;

    @Column(name = "hor_fecha")
    private String fecha;

    @Column(name = "hor_inicio")
    private String inicio;

    @Column(name = "hor_fin")
    private String fin;

    @ManyToOne
    @JoinColumn(name = "hor_programador_id")
    private User programador;

    // GETTERS & SETTERS

    public String getId() { 
    	return id; 
    }
    
    public void setId(String id) { 
    	this.id = id; 
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

    public User getProgramador() { 
    	return programador; 
    }
    
    public void setProgramador(User programador) { 
    	this.programador = programador; 
    }
}
