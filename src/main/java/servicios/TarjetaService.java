package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import modelos.Tarjeta;
import negocio.TarjetaON;

@Path("/tarjeta")
public class TarjetaService {
	@Inject
	private TarjetaON ton;
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public Tarjeta getTarjeta(@QueryParam("id")int id){
		return ton.buscarTarjeta(id); 
	}
	
	@POST
	@Path("/registrarTarjeta")
	@Consumes("application/json")
	@Produces("application/json")
	public Respuesta registrar (Tarjeta t) {
		Respuesta r = new Respuesta();
		try {
			ton.insertarTarjeta(t);
			r.setRespuesta("ok");
		} catch (Exception e) {
			r.setRespuesta("error: "+e.getMessage());
		}
		return r;
	}


}
