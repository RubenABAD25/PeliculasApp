package modelos;

import java.io.Serializable;
import java.util.Date;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
public class Compra implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fecha;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Usuario usuario; // muchas Facturas o Compras un solo cliente

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "detalle_id")
	private List<Detalle> detalles; // una Factura o Compra muchos detalles

	private String descripcion;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Direccion direccion;
	private String estado;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Tarjeta tarjeta;

	public Double calcularTotal() {
		Double total = 0.0;
		for (int i = 0; i < detalles.size(); i++) {
			total += detalles.get(i).calcularSubtotal();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", fecha=" + fecha + ", usuario=" + usuario + ", detalles=" + detalles
				+ ", descripcion=" + descripcion + "]";
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}


	private static final long serialVersionUID = 1L;

}
