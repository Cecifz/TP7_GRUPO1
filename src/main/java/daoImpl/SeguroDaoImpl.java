package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private static final String readOne = "SELECT * FROM seguros Where idSeguro = ?";
		
	public boolean insert(Seguro seguro_a_agregar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
			e.printStackTrace();
			
		}
		
		return isInsertExitoso;
	}
	
	public boolean update(Seguro seguro_a_actualizar) {
		
		System.out.println(seguro_a_actualizar.toString());
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
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
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	@Override
	public List<Seguro> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public List<Seguro> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<entidad.Seguro> seguros = new ArrayList<Seguro>();
		Conexion conexion = Conexion.getConexion();
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
			e.printStackTrace();
		}
		return seguros;
	}
	
	private Seguro getSeguro(ResultSet resultSet) throws SQLException
	{
		String descripcion = resultSet.getString("descripcion");
		int idTipo = Integer.parseInt(resultSet.getString("idTipo"));
		Double costoContratacion = Double.valueOf(resultSet.getString("costoContratacion"));
		Double costoAsegurado = Double.valueOf(resultSet.getString("costoAsegurado"));
		return new Seguro(descripcion, idTipo,costoContratacion,costoAsegurado);
	}*/
	/*
	
	public Seguro readOne(int id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Seguro usuario = new Seguro();
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("Select * from usuario where Id = ?");
			miSentencia.setInt(1, id); //Cargo el ID recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
			usuario.setId(resultado.getInt(1));
		    usuario.setNombre(resultado.getString(2));
		    usuario.setApellido(resultado.getString(3));
		    
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
		return usuario;
	}
	
	
	 public void procedimientoInsertarUsuario(Usuario usuario)
	   {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   Connection conn = null;
	       try {
	    	    conn = DriverManager.getConnection(host + dbName, user, pass);
	            CallableStatement proc = conn.prepareCall(" CALL crearUsuario(?,?) ");
	            proc.setString("Unombre", usuario.getNombre());//Tipo String
	            proc.setString("Uapellido", usuario.getApellido());
	            proc.execute();            
	        } 
	       catch (Exception e) {                  
	            System.out.println(e);
	       }
	   }
	*/
	

}
