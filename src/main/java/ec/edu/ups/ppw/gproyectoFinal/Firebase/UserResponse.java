package ec.edu.ups.ppw.gproyectoFinal.Firebase;

public class UserResponse {

	 private String uid;
	    private String email;
	    private String name;

	    public UserResponse(String uid, String email, String name) {
	        this.uid = uid;
	        this.email = email;
	        this.name = name;
	    }

	    public String getUid() {
	        return uid;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getName() {
	        return name;
	    }
}
