package datos;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.Part;

import modelos.Categoria;



@Stateless
public class CategoriaDao {
 
	 private Part file;
	
	@Inject
	private EntityManager cm;
	
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
	
	

	public void create(Categoria c) {
		cm.persist(c);
	}
	
	public Categoria read(int id) {
		return cm.find(Categoria.class, id);
	}
	
	public void update(Categoria c) {
		
		cm.merge(c);
	}
	
	public void delete(int id) {
		Categoria c = read(id);
		cm.remove(c);
	}
	public Categoria buscarCategorias(int id) {
		String jpql = "SELECT ca FROM Categoria ca where ca.id =:codigo";
		Query query= cm.createQuery(jpql,Categoria.class);
		query.setParameter("codigo", id);
		Categoria cate =(Categoria)query.getSingleResult();
		
		return cate;
	}
		
	public List<Categoria> getCategoriasParam(String filtroBusqued){
		String jpql = "SELECT p FROM Categoria p "
					+ "	WHERE p.nombre LIKE :filtro ";
		
		Query q = cm.createQuery(jpql, Categoria.class);
		q.setParameter("filtro", "%"+filtroBusqued+"%");
		
		List<Categoria> categoria = q.getResultList();
		return categoria;
	}
	
	public List<Categoria> getCategorias(){
		String jpgl = "select c from Categoria c";
		Query query = cm.createQuery(jpgl,Categoria.class);
		List<Categoria> cate = query.getResultList();
		for (Categoria categoria : cate) {
			//categoria.getPeliculas().size();
		}
		return cate;
	}
	
	
    	
	
	

}
