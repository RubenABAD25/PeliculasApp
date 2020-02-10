package servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import modelos.Pelicula;

import negocio.PeliculaON;

@Path("/pelicula")
public class PeliculaService {
	
	@Inject
	private PeliculaON pon;
	
	@GET
	@Path("/list")
	@Produces("application/json")
   public List<Pelicula> getPeliculas(){
	return pon.getPelicula();
	   
		
	}
	
	@GET
	@Path("/peliporcategoria")
	@Produces("application/json")
   public List<Pelicula> getPeliculaspoCategoria(@QueryParam("id")int id){
	return pon.getPeliculaporCategoria(id); 
	}
	
	@GET
	@Path("/peliNombre")
	@Produces("application/json")
	public List<Pelicula> getPelisNombre(@QueryParam("nombre")String name) {
		return pon.buscar(name);
	}
	@GET
	@Path("/peliEstreno")
	@Produces("application/json")
	public List<Pelicula>getEstrenos(@QueryParam("anio")int a){
		return pon.buscarAnios(a);
	}
	@GET
	@Path("/obtenerPelicula")
	@Produces("application/json")
	public Pelicula readPelicula(@QueryParam("id")int id) {
		return pon.buscar(id);
	}
}
