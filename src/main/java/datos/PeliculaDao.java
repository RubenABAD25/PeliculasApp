package datos;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.Part;

import modelos.Actor;
import modelos.Pelicula;
import modelos.PeliculaActor;

public class PeliculaDao {

	
	@Inject
	private EntityManager em;
	
	
	
	
	
	public void crearPelicula(Pelicula p) {
		em.persist(p);
	}
	public Pelicula read(int id) {
		return em.find(Pelicula.class, id);
	}
	public void modificar(int id) {
		em.merge(read(id));
	}
	public void eliminar(int id) {
		em.remove(read(id));
	}
	public List<Pelicula> getPeliculasNombre(String nom){
		String jpql = "SELECT p FROM Pelicula p JOIN FETCH p.pelActores WHERE p.nombre like :nom ";
		Query q = em.createQuery(jpql, Pelicula.class);
		q.setParameter("nom","%"+nom+"%");
		List<Pelicula> peliculas = q.getResultList();
		for (Pelicula pelicula : peliculas) {
			pelicula.getPelActores().size();
		}
		//Pelicula pelicula = (Pelicula) q.getSingleResult();
//		int i = 0;
//		List<Pelicula> peliculas = q.getResultList();
//		for (Pelicula p : peliculas) {
//			System.out.println(p.getPelActores().size());
//			System.out.println(p.toString());
//		}
//		
//		return pelicula;
		return peliculas;
	}
	public List<Pelicula> getPeliculas(){
		String jpql = "SELECT p FROM Pelicula p ";
		
		Query q = em.createQuery(jpql, Pelicula.class);
		
		List<Pelicula> peliculas = q.getResultList();
		for (Pelicula p : peliculas) {
			p.getPelActores().size();
			p.getCategoria();
			}
		

		return peliculas;
	}
	
	public List<Pelicula> getPeliculasPorCategoria(int id){
		System.out.println(id);
		String jpql = "SELECT p FROM Pelicula p WHERE p.categoria.id = :id";
		Query q = em.createQuery(jpql, Pelicula.class);
		q.setParameter("id",id);
		List<Pelicula> peliculas = q.getResultList();
		System.out.println("heyy  "+ id);
		int i = 0;
		for (Pelicula p : peliculas) {
			System.out.println(p.toString());
			p.getPelActores().size();
			
			}
		return peliculas;
	}
	public List<Pelicula> getPeliculasEstreno(int a){
		String jpql = "SELECT p FROM Pelicula p WHERE p.anio=?1";
		
		Query q = em.createQuery(jpql, Pelicula.class);
		q.setParameter(1,a);
		List<Pelicula> peliculas = q.getResultList();
		int i =0;
		for (Pelicula p : peliculas) {
			p.getPelActores().size();
			}
		return peliculas;
	}
	public Pelicula buscarPelicula(int cod) {
		String jpql = "SELECT p FROM Pelicula p JOIN FETCH p.pelActores where p.id = :codigo";
		Query query= em.createQuery(jpql,Pelicula.class);
		query.setParameter("codigo", cod);
		Pelicula act =(Pelicula)query.getSingleResult();
		for (PeliculaActor ac : act.getPelActores()) {
			ac.getAct();
			}
		return act;
	}
	
	
	
  

}
