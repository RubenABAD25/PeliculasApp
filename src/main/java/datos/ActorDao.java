package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelos.Actor;



public class ActorDao 
{
	@Inject
	private EntityManager em;
	
	public void create(Actor a) {
		System.out.println("dao " + a);
		em.persist(a);
	}
	
	public Actor read(int id) {
		return em.find(Actor.class, id);
	}
	
	public void update(Actor a) {
		
		em.merge(a);
	}
	
	public void delete(int id) {
		Actor a = read(id);
		em.remove(a);
	}
	
	public List<Actor> getActores(){
		String jpql = "SELECT p FROM Actor p ";
		
		Query q = em.createQuery(jpql, Actor.class);
		
		List<Actor> actores = q.getResultList();
		return actores;
	}
	
	public List<Actor> getActoresPorFiltro(String filtroBusqued){
		String jpql = "SELECT p FROM Actor p "
					+ "	WHERE p.nombres LIKE :filtro ";
		
		Query q = em.createQuery(jpql, Actor.class);
		q.setParameter("filtro", "%"+filtroBusqued+"%");
		List<Actor> actores = q.getResultList();
		return actores;
	}
	public Actor buscarActor(int cod) {
		String jpql = "SELECT a FROM Actor a where a.id = :codigo";
		Query query= em.createQuery(jpql,Actor.class);
		query.setParameter("codigo", cod);
		Actor act =(Actor)query.getSingleResult();
		return act;
	}
	public Actor buscarAutor(String nombres) {
		String jpql = "SELECT a FROM Autor a JOIN FETCH a where a.nombres = :nombres";
		Query query = em.createQuery(jpql, Actor.class);
		query.setParameter("nombres", nombres);
		Actor actor = (Actor) query.getSingleResult();
		return actor;
	}
	public Actor actores(int id) {
		//JOIN FETCH la la.autor.id = :id
		String jqpl = "SELECT la.autor FROM LibroAutor la JOIN FECTH la where la.autor.id = 1 ";
		Query query = em.createQuery(jqpl, Actor.class);
		//query.setParameter("id", id);
		Actor actor = (Actor) query.getSingleResult();
		return actor;
	}



}
