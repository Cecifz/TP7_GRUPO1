package negocio;

import java.util.List;

import entidad.Seguro;

public interface SeguroNegocio {
	public boolean insert(Seguro seguro);
	public boolean delete(Seguro seguro_a_eliminar);
	public boolean update(Seguro seguro_a_modificar);
	public List<Seguro> readAll();
	public int readLast();
	public boolean isNumber(String cadena);
}
