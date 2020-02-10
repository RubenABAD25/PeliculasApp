package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelos.Categoria;
import negocio.CategoriaON;

@ManagedBean
public class CategoriaBean {

	@Inject
	private CategoriaON catOn;

	private Categoria categoria;

	private List<Categoria> categorias;

	@PostConstruct
	public void init() {
		categoria = new Categoria();
		listarCategorias();
	}
	
	public String crearCategoria() {
		catOn.guardar(categoria);
		listarCategorias();
		categoria = null;
		return null;
	}
	
	public void listarCategorias() {
		categorias = catOn.getList();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
