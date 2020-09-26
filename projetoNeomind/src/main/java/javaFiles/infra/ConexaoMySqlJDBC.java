package javaFiles.infra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import java.util.logging.Logger;

public class ConexaoMySqlJDBC implements ConexaoJDBC{

	
	private static String rota = "jdbc:mysql://localhost:3306/bd_empresa?useTimezone=true&serverTimezone=UTC";
	private Connection connection = null;
	
	public ConexaoMySqlJDBC() throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Properties properties = new Properties();
		properties.put("user", "root");
		properties.put("password", "root");
		
		this.connection = DriverManager.getConnection(rota, properties.getProperty("user"), properties.getProperty("password"));
		this.connection.setAutoCommit(false);
		
		//System.out.println("Banco Conectado");
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	public void close() {

		if(this.connection != null) {
			
			try {
				this.connection.close();
			} catch(SQLException ex) {
				Logger.getLogger(ConexaoMySqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
	}
	public void commit() throws SQLException {
		
		this.connection.commit();
		this.close();
		
	}
	public void rollback() {

		if(this.connection != null) {
			
			try {
				this.connection.rollback();
			} catch(SQLException ex) {
				Logger.getLogger(ConexaoMySqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				this.close();
			}
		}
		
		
		
	}
	
	
	
	
	
}
