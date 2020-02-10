package negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.UsuarioDAO;
import modelos.Usuario;
import servicios.Respuesta;

@Stateless
public class UsuarioBusiness {

	@Inject
	private UsuarioDAO dao;

	
	public int login(String email, String clave) {
	     int val = 0;
	     Usuario u= null;
	     try {
	    	 u=dao.login(email, clave);
	    	 if(u!= null) {
		    	 val=u.getId();
		     }else {
		    	 val=0;
		     }
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
	    	
		return val;
	}

	/**
	 * Retorna un Usuario segun su codigo
	 * 
	 * @param codigo
	 * @return
	 */
	public Usuario leer(int codigo) {
		return dao.leer(codigo);
	}
	
	public void guardar(Usuario usr){
		dao.crear(usr);
	}
	public Usuario recuperarEstado(int c) {
		return dao.recuperarF(c);
	}
}
