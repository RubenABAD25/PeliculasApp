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

	
	public Respuesta login(String email, String clave) {
	     Respuesta r =new Respuesta();
	     Usuario u= null;
	     try {
	    	 u=dao.login(email, clave);
	    	 if(u!= null) {
		    	 r.setRespuesta("OK");
		     }else {
		    	 r.setRespuesta("fallido");
		     }
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
	    	
		return r;
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
