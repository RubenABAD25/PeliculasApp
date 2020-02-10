package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String clave;
	@OneToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL, mappedBy = "usuario")
	//@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<Direccion> direcciones;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Tarjeta> tarjetas;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Compra> compras;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Voto> votos;

	public void agregarVoto(Voto voto) {
		if (votos == null) {
			votos = new ArrayList<Voto>();
		}
		votos.add(voto);
	}

	public void nuevaCompra(Compra compra) {
		if (compras == null) {
			compras = new ArrayList<Compra>();
		}
		compras.add(compra);
	}

	public Usuario() {
		super();
	}

	public void agregarDireccion(Direccion direccion) {
		if (direcciones == null) {
			direcciones = new ArrayList<Direccion>();
		}
		this.direcciones.add(direccion);
	}

	public void agregarTarjeta(Tarjeta tarjeta) {
		if (tarjetas == null) {
			tarjetas = new ArrayList<>();
		}
		tarjetas.add(tarjeta);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", clave=" + clave + ", direcciones=" + direcciones
				+ ", tarjetas=" + tarjetas + ", compras=" + compras + ", votos=" + votos + "]";
	}
	private static final long serialVersionUID = 1L;

}
