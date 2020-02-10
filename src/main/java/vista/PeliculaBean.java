package vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

import modelos.Actor;
import modelos.Categoria;
import modelos.Pelicula;
import modelos.PeliculaActor;
import negocio.ActorON;
import negocio.CategoriaON;
import negocio.PeliculaON;

@ManagedBean
@ViewScoped
public class PeliculaBean {

	@Inject
	private PeliculaON peliculaOn;

	@Inject
	private CategoriaON categoriaOn;

	@Inject
	private ActorON actorOn;

	private Pelicula pelicula;

	private List<Pelicula> peliculas;

	private List<Categoria> categorias;
	private List<Actor> actores;
	private Categoria categoria;
	private List<Integer> idCategorias;
	private String nombreCat;
	private int idCategoria;
	private int idActor;
	private Part file;

	@PostConstruct
	public void init() {
		pelicula = new Pelicula();
		categoria = new Categoria();
		idCategorias = new ArrayList<Integer>();
		categorias = categoriaOn.getList();
		actores = actorOn.mostrarActores();
		getIds();
		listarPeliculas();
	}
	
	public void getIds() {
		for (int i = 0; i < categorias.size(); i++) {
			idCategorias.add(categorias.get(i).getId());
		}
	}
	
	public String buscarActor(PeliculaActor pa) {
		System.out.println("Correccion "+pa.toString());
		try {
			Actor a = actorOn.buscar(pa.getTemporal());
			pa.setAct(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String agregarActor() {
		pelicula.agregarActores(new PeliculaActor());
		return null;
	}
	
	public void selecionar() {
		try {
			categoria = categoriaOn.buscar(idCategoria);
			nombreCat = categoria.getNombre();
			pelicula.setCategoria(categoria);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String crearPelicula() {
		try {
			if(file != null) {
				int size = (int) file.getSize();
				byte[] foto;
				if(size > 0) {
					foto = new byte[size];
					file.getInputStream().read(foto);
					pelicula.setPortada(foto);
				}
			}
			peliculaOn.crearPelicula(pelicula);
			pelicula = null;
			listarPeliculas();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void listarPeliculas() {
		peliculas = peliculaOn.getPelicula();
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Integer> getIdCategorias() {
		return idCategorias;
	}

	public void setIdCategorias(List<Integer> idCategorias) {
		this.idCategorias = idCategorias;
	}

	public String getNombreCat() {
		return nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
}
