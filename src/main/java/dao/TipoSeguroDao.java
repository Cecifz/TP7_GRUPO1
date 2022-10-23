package dao;

import java.util.List;

import entidad.Seguro;
import entidad.TipoSeguro;

public interface TipoSeguroDao {
	public List<TipoSeguro> readAll();
	public int readLast();
}
