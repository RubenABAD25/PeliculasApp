package datos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelos.Direccion;

public class DireccionDao {
	@Inject
	private EntityManager em;
	
	public void insertar(Direccion dir) {
		em.persist(dir);
	}
	public void actualizar(Direccion dir) {
		em.merge(dir);
	}
	public Direccion buscarDireccion(int id) {
		return em.find(Direccion.class, id);
	}

}
