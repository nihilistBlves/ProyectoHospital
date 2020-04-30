package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private Connection jdbcConnection;
	private String jdbcUser;
	private String jdbcPass;
	private String jdbcURL;
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	// Constructor de la conexion
	public Conexion(String jdbcURL, String jdbcUser, String jdbcPass) {
		this.jdbcURL = jdbcURL;
		this.jdbcUser = jdbcUser;
		this.jdbcPass = jdbcPass;
	}

	// Metodo para conectar
	public void conectar() throws SQLException {

		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
		}

	}

	// Metodo para desconectar
	public void desconectar() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	// Metodo para obtener la conexion
	public Connection getJdbcConnection() {
		return jdbcConnection;
	}

}
