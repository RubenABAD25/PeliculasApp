package modelos;

public class UsuarioTmp {
	private String email;
	private String clave;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	@Override
	public String toString() {
		return "UsuarioTmp [email=" + email + ", clave=" + clave + "]";
	}
	
	

}
