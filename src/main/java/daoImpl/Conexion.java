package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String host = "jdbc:mysql://localhost:3306/";   //DONDE SE ENCUENTRA LA BASE
    private String user = "root";
    private String pass = "root";
    private String dbName = "segurosgroup";
    public static Conexion instancia;
    private Connection connection;
    private Conexion() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(host + dbName, user, pass);
            this.connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Conexion getConexion() {
    	
        if(instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public Connection getSQLConexion() {
        return this.connection;
    }

    public void cerrarConexion() {
        try {
                this.connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        instancia = null;
    }
}
