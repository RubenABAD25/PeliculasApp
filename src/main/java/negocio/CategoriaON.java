package negocio;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CategoriaDao;
import modelos.Categoria;
/**
 * 
 * @author Diego Parra
 *
 */
@Stateless
public class CategoriaON {
	
	@Inject
	private CategoriaDao cdao;
	
	
	public void guardar(Categoria categoria) {
		cdao.create(categoria);
	}

	
	/**
	 * 
	 * @return
	 */
	public List<Categoria>getList(){
		return cdao.getCategorias();
		} 
	
	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void borar(int id) throws Exception {
		cdao.delete(id);
	}
	
	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void actualizar(int id)throws Exception{
		Categoria aux = cdao.buscarCategorias(id);
		cdao.update(aux);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Categoria buscar (int id) {
		
		Categoria aux= cdao.buscarCategorias(id);
		return aux;
	}
	
}
