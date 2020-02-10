package modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voto implements Serializable{
	@Id
	private int id;
	@ManyToOne
	private Pelicula pel;
	@ManyToOne
	private Usuario user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pelicula getPel() {
		return pel;
	}
	public void setPel(Pelicula pel) {
		this.pel = pel;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Voto [id=" + id + ", pel=" + pel + ", user=" + user + "]";
	}
private static final long serialVersionUID = 1L;

}
