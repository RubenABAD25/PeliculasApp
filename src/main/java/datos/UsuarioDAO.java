package datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelos.Usuario;



@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager em;
	public Usuario login(String email, String clave) {
		String jpql = "SELECT u FROM Usuario u WHERE u.email LIKE :e AND  u.clave LIKE :p";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter("e", email);
		query.setParameter("p", clave);
		Usuario c = (Usuario) query.getSingleResult();
		return c;
	}

	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Usuario leer(int codigo) {
		return em.find(Usuario.class, codigo);
	}
	public void crear(Usuario usr) {
		em.persist(usr);
	}
	public Usuario recuperarF(int id) {
		String a="open";
		String jpql="SELECT u FROM Usuario u LEFT JOIN c.compras co WHERE u.id = :id AND co.estado like 'open'";
		Query q= em.createQuery(jpql,Usuario.class);
		q.setParameter("id", id);
		Usuario aux=(Usuario) q.getSingleResult();
		return aux;
		
	}
	
}
