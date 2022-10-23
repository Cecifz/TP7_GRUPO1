package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dao.SeguroDao;
import dao.TipoSeguroDao;
import entidad.Seguro;
import entidad.TipoSeguro;

import java.sql.Statement;


public class TipoSeguroDaoImpl implements TipoSeguroDao
{
	
	private static final String readall = "SELECT * FROM tiposeguros";
	private static final String readlast = "SELECT * FROM tiposeguros ORDER by idTipo DESC LIMIT 1";
		
	
		
	public List<TipoSeguro> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<entidad.TipoSeguro> tipoSeguros = new ArrayList<TipoSeguro>();
		Conexion conexion = Conexion.getConexion();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				tipoSeguros.add(getTipoSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			System.out.print("Error al Querer obtener todos los registros(SQL ERROR)");
		}
		return tipoSeguros;
	}
	
	public int readLast()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		TipoSeguro tipoSeguro = new TipoSeguro();
		Conexion conexion = Conexion.getConexion();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readlast);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				tipoSeguro = getTipoSeguro(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			System.out.print("Error al Querer   el registro(SQL ERROR)");
		}
		return tipoSeguro.getIdTipo();
	}
	
	
	private TipoSeguro getTipoSeguro(ResultSet resultSet) throws SQLException
	{

		int idTipo = resultSet.getInt("idTipo");
		String descripcion = resultSet.getString("descripcion");
		return new TipoSeguro(idTipo,descripcion);

	

}
}

