package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ActorDao;
import modelos.Actor;

@Stateless
public class ActorON 
{
	@Inject
	private ActorDao gestion;
	
	public void crearAutor(Actor ac) {
		this.gestion.create(ac);
	}
	
	public Actor buscar(int id) {
		return gestion.buscarActor(id);
	}
	
	public Actor buscarActor(String nombres) {
		return this.gestion.buscarAutor(nombres);
	}
	
	public List<Actor>mostrarActores() {
		return this.gestion.getActores();
	}
	public Actor libroautor(int id) {
		return gestion.actores(id);
	}
}
