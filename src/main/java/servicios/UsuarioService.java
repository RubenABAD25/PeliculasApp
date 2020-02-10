package servicios;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import modelos.Usuario;
import modelos.UsuarioTmp;
import negocio.UsuarioBusiness;

@Path("/serviciosUsuario")

public class UsuarioService {
	@Inject
	private UsuarioBusiness uB;
	
	@GET
	@Path("/recuperar")
	@Produces("application/json")
	public Usuario revisar(@QueryParam("id")int id) {
		return uB.recuperarEstado(id);
	}
	@POST
	@Path("/login")
	@Consumes("application/json")
	@Produces("application/json")
	public int login(UsuarioTmp utemp) {
		return uB.login(utemp.getEmail(), utemp.getClave());
	}
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	@Produces("application/json")
	public Respuesta registrar (Usuario u) {
		Respuesta r = new Respuesta();
		try {
			uB.guardar(u);
			r.setRespuesta("ok");
		} catch (Exception e) {
			r.setRespuesta("error: "+e.getMessage());
		}
		return r;
	}
	

}
