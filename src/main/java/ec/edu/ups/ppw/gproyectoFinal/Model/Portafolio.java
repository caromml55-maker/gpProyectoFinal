package ec.edu.ups.ppw.gproyectoFinal.Model;

import jakarta.persistence.*;

@Entity
public class Portafolio {

	 @Id
	    @Column(name = "por_id")
	    private String id;

	    @Column(name = "por_nombre")
	    private String nombre;

	    @Column(name = "por_descripcion")
	    private String descripcion;

	    @Column(name = "por_tecnologias")
	    private String tecnologias;

	    @Column(name = "por_tipo")
	    private String tipo; // academico / laboral

	    @Column(name = "por_tipo_participacion")
	    private String tipoParticipacion;

	    @Column(name = "por_url_repo")
	    private String urlRepositorio;

	    @Column(name = "por_enlace_demo")
	    private String enlaceDemo;

	    @Column(name = "por_expandido")
	    private boolean expandido;


	    @ManyToOne
	    @JoinColumn(name = "por_programador_id")
	    private User programador;
	    

		public String getId() {
			return id;
		}

		public void setId(String id) {
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

		public String getUrlRepositorio() {
			return urlRepositorio;
		}

		public void setUrlRepositorio(String urlRepositorio) {
			this.urlRepositorio = urlRepositorio;
		}

		public String getEnlaceDemo() {
			return enlaceDemo;
		}

		public void setEnlaceDemo(String enlaceDemo) {
			this.enlaceDemo = enlaceDemo;
		}

		public boolean isExpandido() {
			return expandido;
		}

		public void setExpandido(boolean expandido) {
			this.expandido = expandido;
		}

		public User getProgramador() {
			return programador;
		}

		public void setProgramador(User programador) {
			this.programador = programador;
		}

	    
	    
}
	    
