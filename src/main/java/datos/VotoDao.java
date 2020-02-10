package datos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelos.Voto;

public class VotoDao {
	@Inject
	private EntityManager em;
	
	public void realizarVoto(Voto v) {
		em.persist(v);
		
	}


}
