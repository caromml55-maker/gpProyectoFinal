package ec.edu.ups.ppw.gproyectoFinal.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class User {

   
	 @Id
	    @Column(name = "uid")
	    private String uid;

	    private String displayName;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "especialidad")
	    private String especialidad;

	    @Column(name = "role")
	    private String role;

	    private String photoURL;

	    @Column(name = "descripcion")
	    private String descripcion;

	    @Column(name = "telefono")
	    private String telefono;

	    @Column(name = "github")
	    private String github;

	    @Column(name = "linkedin")
	    private String linkedin;

	    // RELACIONES
	    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<Portafolio> portafolios;

	    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<Asesoria> asesoriasSolicitadas;

	    @OneToMany(mappedBy = "programador", cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<Asesoria> asesoriasRecibidas;

	    @OneToMany(mappedBy = "programador", cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<Horario> horarios;

	    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<Notification> notifications;

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEspecialidad() {
			return especialidad;
		}

		public void setEspecialidad(String especialidad) {
			this.especialidad = especialidad;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getPhotoURL() {
			return photoURL;
		}

		public void setPhotoURL(String photoURL) {
			this.photoURL = photoURL;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getGithub() {
			return github;
		}

		public void setGithub(String github) {
			this.github = github;
		}

		public String getLinkedin() {
			return linkedin;
		}

		public void setLinkedin(String linkedin) {
			this.linkedin = linkedin;
		}

		public List<Portafolio> getPortafolios() {
			return portafolios;
		}

		public void setPortafolios(List<Portafolio> portafolios) {
			this.portafolios = portafolios;
		}

		public List<Asesoria> getAsesoriasSolicitadas() {
			return asesoriasSolicitadas;
		}

		public void setAsesoriasSolicitadas(List<Asesoria> asesoriasSolicitadas) {
			this.asesoriasSolicitadas = asesoriasSolicitadas;
		}

		public List<Asesoria> getAsesoriasRecibidas() {
			return asesoriasRecibidas;
		}

		public void setAsesoriasRecibidas(List<Asesoria> asesoriasRecibidas) {
			this.asesoriasRecibidas = asesoriasRecibidas;
		}

		public List<Horario> getHorarios() {
			return horarios;
		}

		public void setHorarios(List<Horario> horarios) {
			this.horarios = horarios;
		}

		public List<Notification> getNotifications() {
			return notifications;
		}

		public void setNotifications(List<Notification> notifications) {
			this.notifications = notifications;
		}
}
