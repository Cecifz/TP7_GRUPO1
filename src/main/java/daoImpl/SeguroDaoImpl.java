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
import entidad.Seguro;
import java.sql.Statement;


public class SeguroDaoImpl implements SeguroDao
{
	private static final String insert = "INSERT INTO seguros(idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM seguros WHERE idSeguro = ?";
	private static final String readall = "SELECT * FROM seguros";
	private static final String update = "UPDATE seguros set descripcion = ?, idTipo = ?, costoContratacion = ?, costoAsegurado = ? Where idSeguro = ?";
	private static final String readlast = "SELECT * FROM seguros ORDER by idSeguro DESC LIMIT 1";
		
	public boolean insert(Seguro seguro_a_agregar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1,seguro_a_agregar.getIdSeguro());
			statement.setString(2, seguro_a_agregar.getDescripcion());
			statement.setInt(3, seguro_a_agregar.getIdTipo());
			statement.setDouble(4,seguro_a_agregar.getCostoContratacion());
			statement.setDouble(5,seguro_a_agregar.getCostoAsegurado());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		}
		catch (SQLException e) 
		{
			
			System.out.println("Error al intentar ingresar un registro");
		}
		
		return isInsertExitoso;
	}
	
	public boolean update(Seguro seguro_a_actualizar) {
		
		System.out.println(seguro_a_actualizar.toString());
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
				statement = conexion.prepareStatement(update);
				statement.setString(1, seguro_a_actualizar.getDescripcion());
				statement.setInt(2, seguro_a_actualizar.getIdTipo());
				statement.setDouble(3, seguro_a_actualizar.getCostoContratacion());
				statement.setDouble(4, seguro_a_actualizar.getCostoAsegurado());
				statement.setInt(5,seguro_a_actualizar.getIdSeguro());

				
			if(statement.executeUpdate() > 0){
				conexion.commit();
				isUpdateExitoso  = true;
				}
			} 
		catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		
		return isUpdateExitoso;
		}
		
	
	
	public boolean delete(Seguro seguro_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1,seguro_a_eliminar.getIdSeguro());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			System.out.print("Error al Querer Borrar el registro(SQL ERROR)");
		}
		return isdeleteExitoso;
	}

		
	public List<Seguro> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<entidad.Seguro> seguros = new ArrayList<Seguro>();
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
				seguros.add(getSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			System.out.print("Error al Querer obtener todos los registros(SQL ERROR)");
		}
		return seguros;
	}
	
	public int readLast()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Seguro seguro = new Seguro();
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
				seguro = getSeguro(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			System.out.print("Error al Querer   el registro(SQL ERROR)");
		}
		return seguro.getIdSeguro();
	}
	
	
	private Seguro getSeguro(ResultSet resultSet) throws SQLException
	{

		int idSeguro = resultSet.getInt("idSeguro");
		String descripcion = resultSet.getString("descripcion");
		int idTipo = Integer.parseInt(resultSet.getString("idTipo"));
		Double costoContratacion = Double.valueOf(resultSet.getString("costoContratacion"));
		Double costoAsegurado = Double.valueOf(resultSet.getString("costoAsegurado"));
		return new Seguro(idSeguro,descripcion, idTipo,costoContratacion,costoAsegurado);

	

}
}

