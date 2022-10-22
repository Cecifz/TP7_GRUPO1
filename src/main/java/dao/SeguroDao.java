package dao;

import java.util.List;

import entidad.Seguro;

public interface SeguroDao {
	public boolean insert(Seguro seguro_a_agregar);
	public boolean delete(Seguro seguro_a_eliminar);
	public boolean update(Seguro seguro_a_modificar);
	public List<Seguro> readAll();
}
