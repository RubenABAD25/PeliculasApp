package negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CompraDao;
import modelos.Compra;
@Stateless
public class ComprarON {
	@Inject
	private CompraDao dao;
	public void nuevaCompra(Compra compra) {
	dao.nuevaCompra(compra);
	}

}
