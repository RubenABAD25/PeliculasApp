package modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Tarjeta implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	
	private String numero;
	
	private String fechaCaducidad;
	
	
	private int codigoSeguridad;
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * 
	 * @return
	 */
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * 
	 * @param fechaCaducidad
	 */
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * 
	 * @return
	 */
	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	/**
	 * 
	 * @param codigoSeguridad
	 */
	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	//Mostramos la informacion del objeto Tarjeta
	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", nombre=" + nombre + ", numero=" + numero + ", fechaCaducidad=" + fechaCaducidad
				+ ", codigoSeguridad=" + codigoSeguridad + "]";
	}
	private static final long serialVersionUID = 1L;

}
