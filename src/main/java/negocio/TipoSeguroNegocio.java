package negocio;

import java.util.List;

import entidad.Seguro;
import entidad.TipoSeguro;

public interface TipoSeguroNegocio {
	public List<TipoSeguro> readAll();
	public int readLast();
}
