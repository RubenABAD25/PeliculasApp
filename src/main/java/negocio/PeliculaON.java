package negocio;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.PeliculaDao;
import modelos.Pelicula;
/**
 * 
 * @author Ruben
 *
 */
@Stateless
public class PeliculaON {
	@Inject
	private PeliculaDao pdao;
	
	public void crearPelicula(Pelicula pelicula) {
		pdao.crearPelicula(pelicula);
	}

	/**
	 * 
	 * @param id
	 */
	public void borrar(int id) {
		pdao.eliminar(id);
	}
	/**
	 * 
	 * @param id
	 */
	public void actualizar(int id) {
		Pelicula p = pdao.buscarPelicula(id);
		pdao.modificar(p.getId());
	}
	/**
	 * 
	 * @return
	 */
	public List<Pelicula> getPelicula(){
		return pdao.getPeliculas();
	}
	
	
	public List<Pelicula> getPeliculaporCategoria(int id){
		return pdao.getPeliculasPorCategoria(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Pelicula buscar(int id) {
		return pdao.buscarPelicula(id);
	}
	public List<Pelicula>buscarAnios(int a){
		return pdao.getPeliculasEstreno(a);
	}
	public List<Pelicula> buscar(String name) {
		
		return pdao.getPeliculasNombre(name);
	}
}
