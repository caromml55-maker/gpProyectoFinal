package ec.edu.ups.ppw.gproyectoFinal.Model;

public class HorarioDTO {
    private Long idHorario;
    private Long idAsesoria; // Necesario para saber qué borrar si cancelo
    private String programadorUid;
    private String fecha;
    private String inicio;
    private String fin;
    private String modalidad;
    private String estado; // Valores: "LIBRE", "MIO", "OCUPADO"

    // Constructor completo
    public HorarioDTO(Long idHorario, String programadorUid, String fecha, String inicio, String fin, String modalidad) {
        this.idHorario = idHorario;
        this.programadorUid = programadorUid;
        this.fecha = fecha;
        this.inicio = inicio;
        this.fin = fin;
        this.modalidad = modalidad;
        this.estado = "LIBRE"; // Por defecto
    }

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public Long getIdAsesoria() {
		return idAsesoria;
	}

	public void setIdAsesoria(Long idAsesoria) {
		this.idAsesoria = idAsesoria;
	}

	public String getProgramadorUid() {
		return programadorUid;
	}

	public void setProgramadorUid(String programadorUid) {
		this.programadorUid = programadorUid;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    
}
