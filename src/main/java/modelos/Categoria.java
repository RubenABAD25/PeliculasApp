package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
public class Categoria {
	
	@Id
	@GeneratedValue
	private Integer id;

	private String nombre;
	
	

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

	
	@Override
	public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
	}
	@Override
	public boolean equals(Object object) {
        // TODO Auto-generated method stub
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id!= null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
