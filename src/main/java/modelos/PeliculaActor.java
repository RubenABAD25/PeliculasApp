package modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PeliculaActor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JsonIgnore
	private Pelicula p;
	
	@ManyToOne
	@JsonIgnore
	private Actor act;
	@Transient
	private int temporal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pelicula getP() {
		return p;
	}
	public void setP(Pelicula p) {
		this.p = p;
	}
	public Actor getAct() {
		return act;
	}
	public void setAct(Actor act) {
		this.act = act;
	}
	public int getTemporal() {
		return temporal;
	}
	public void setTemporal(int temporal) {
		this.temporal = temporal;
	}
	@Override
	public String toString() {
		return "PeliculaActor [id=" + id + ", p=" + p + ", act=" + act + ", temporal=" + temporal + "]";
	}
}
