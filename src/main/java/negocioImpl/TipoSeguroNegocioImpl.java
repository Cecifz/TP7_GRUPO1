package negocioImpl;

import java.util.List;

import dao.SeguroDao;
import dao.TipoSeguroDao;
import daoImpl.SeguroDaoImpl;
import daoImpl.TipoSeguroDaoImpl;
import entidad.Seguro;
import entidad.TipoSeguro;
import negocio.SeguroNegocio;
import negocio.TipoSeguroNegocio;


public class TipoSeguroNegocioImpl implements TipoSeguroNegocio{

	TipoSeguroDao pdao = new TipoSeguroDaoImpl();
	
	

	public List<TipoSeguro> readAll() {
		
		List<TipoSeguro> lSeguro;
		lSeguro = pdao.readAll();
		return lSeguro;
	}
	
	public int readLast() {
		System.out.print(pdao.readLast());
		return pdao.readLast();
	}
	

}

