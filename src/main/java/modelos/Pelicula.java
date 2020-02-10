package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Pelicula implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private  String sinopsis;
	private String nombre;
	@Lob
	private byte[] portada;
	@NotNull
	private int anio;
	
	@NotNull
	private String duracion;
	@NotNull
	private double precio;
	
	@OneToOne
	private Categoria categoria;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pelicula_id")
	private List<PeliculaActor>pelActores;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getPortada() {
		return portada;
	}
	public void setPortada(byte[] portada) {
		this.portada = portada;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public List<PeliculaActor> getPelActores() {
		return pelActores;
	}
	public void setPelActores(List<PeliculaActor> pelActores) {
		this.pelActores = pelActores;
	}
	public void agregarActores(PeliculaActor pa)
	{
		if(pelActores == null) {
			pelActores= new ArrayList<PeliculaActor>();
		}
		pelActores.add(pa);
		System.out.println(pelActores.size());
	}
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	//private static final long serialVersionUID = 1L;


}
