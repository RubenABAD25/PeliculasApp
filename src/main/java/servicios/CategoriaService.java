package servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import modelos.Categoria;
import negocio.CategoriaON;

@Path("/categoria")
public class CategoriaService {
	
	@Inject
	private CategoriaON cON;
	
	@GET
	@Path("/list")
	@Produces("application/json")
   public List<Categoria> getCategorias(){
	return cON.getList();
	   
   }
	
	@POST
	@Path("/insert")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertCategoria(Categoria categoria) {
		
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		
		try {
			cON.guardar(categoria);
			data.put("code", "1");
			data.put("message", "OK");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		
		return builder.build();
		
		
	}
	
	
}
