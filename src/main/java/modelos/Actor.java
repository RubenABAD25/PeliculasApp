package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Actor implements Serializable
{
	@Id
	@GeneratedValue
	private int id;
	private String nombres;
	private String apellidos;
	private String nacionalidad;
	private String fechaN;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PeliculaActor>pelActores;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFechaN() {
		return fechaN;
	}

	public void setFechaN(String fechaN) {
		this.fechaN = fechaN;
	}

	public List<PeliculaActor> getPelActores() {
		return pelActores;
	}

	public void setPelActores(List<PeliculaActor> pelActores) {
		this.pelActores = pelActores;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", nacionalidad="
				+ nacionalidad + ", fechaN=" + fechaN + "]";
	}
	
	
	//private static final long serialVersionUID = 1L;

}
