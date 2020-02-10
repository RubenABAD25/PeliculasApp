package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelos.Actor;
import negocio.ActorON;
@ManagedBean
public class ActorBean {
	@Inject
	private ActorON aon;

	private Actor ac;
	
	private List<Actor> actores;

	@PostConstruct
	public void init() {
		ac = new Actor();
		listarActores();
		
	}

	public String ingresar() {
		aon.crearAutor(ac);
		listarActores();
		ac = null;
		return null;
	}

	public void listarActores() {
		actores = aon.mostrarActores();
	}
	
	public Actor getAc() {
		return ac;
	}

	public void setAc(Actor ac) {
		this.ac = ac;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}
	
	
	
}
