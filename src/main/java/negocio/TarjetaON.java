package negocio;

import javax.inject.Inject;

import datos.TarjetaDao;
import modelos.Tarjeta;

public class TarjetaON {
	@Inject
	private TarjetaDao tdao;
	
	public void insertarTarjeta(Tarjeta t) {
		tdao.agregarTarjeta(t);
	}
	
	public Tarjeta buscarTarjeta(int cod) {
		return tdao.buscarTarjeta(cod);
	}
}
