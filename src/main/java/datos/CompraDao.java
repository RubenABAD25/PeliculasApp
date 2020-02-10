package datos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelos.Compra;

public class CompraDao {
	@Inject
	private EntityManager em;
	
	public void nuevaCompra(Compra compra) {
		em.persist(compra);
	}

}
