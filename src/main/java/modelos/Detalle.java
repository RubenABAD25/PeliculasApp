package modelos;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
public class Detalle implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pel_id")
	private Pelicula pelicula;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", pelicula=" + pelicula + "]";
	}
	public Double calcularSubtotal() {
		return cantidad * pelicula.getPrecio();
	}
	private static final long serialVersionUID = 1L;

}


