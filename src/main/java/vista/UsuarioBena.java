package vista;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelos.Usuario;
import negocio.UsuarioBusiness;
import servicios.Respuesta;
@ManagedBean
public class UsuarioBena {
	@Inject
	private UsuarioBusiness uB;
	private Usuario usuario;
	@PostConstruct
	public void init()
	{
		usuario = new Usuario();
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String autenTicarse() 
	{
		Respuesta aux = uB.login(usuario.getEmail(), usuario.getClave());
		if(aux!=null) {
			return "actores";
		}
		return "usuarios";
	}
	public String registrarUser(){
		uB.guardar(usuario);
		return "login";
	}
	
}
