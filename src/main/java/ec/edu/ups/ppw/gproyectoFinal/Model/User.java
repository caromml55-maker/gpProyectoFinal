package ec.edu.ups.ppw.gproyectoFinal.Model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class User {
	 @Id
	    @Column(name = "usr_uid")
	    private String uid;

	    @Column(name = "usr_display_name")
	    private String displayName;

	    @Column(name = "usr_email")
	    private String email;

	    @Column(name = "usr_photo_url")
	    private String photoURL;

	    @Column(name = "usr_role")
	    private String role;

	    @Column(name = "usr_created_at")
	    private String createdAt;
	    
	    @OneToMany(mappedBy = "usuario")
	    private List<Notification> notifications;

	    @OneToMany(mappedBy = "programador")
	    private List<Portafolio> portafolios;
	    

	    // GETTERS & SETTERS

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

	    public String getPhotoURL() {
	        return photoURL;
	    }
	    public void setPhotoURL(String photoURL) {
	        this.photoURL = photoURL;
	    }

	    public String getRole() {
	        return role;
	    }
	    public void setRole(String role) {
	        this.role = role;
	    }

	    public String getCreatedAt() {
	        return createdAt;
	    }
	    public void setCreatedAt(String createdAt) {
	        this.createdAt = createdAt;
	    }
}
