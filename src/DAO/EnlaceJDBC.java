package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnlaceJDBC {

	// Variables de la clase
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:8889/ProyectoIndividual";
	private static final String USUARIO = "root";
	private static final String CLAVE = "root";

	private Conexion objetoConexion;
	private Connection connection;

	//Metodo que genera el enlace
	public EnlaceJDBC() throws SQLException {
		objetoConexion = new Conexion(URL, USUARIO, CLAVE);
	}

	//Metodo para insertar en MySql
	public boolean insertar(String sqlInsert) throws SQLException {

		objetoConexion.conectar();
		connection = objetoConexion.getJdbcConnection();
		Statement statement = connection.createStatement();

		// Ejecutamos la sentencia
		boolean rowInserted = statement.executeUpdate(sqlInsert) > 0;
		statement.close();
		objetoConexion.desconectar();
		return rowInserted;
	}

	//Metodo para SELECT
	public ResultSet seleccionRegistros(String consultaSQL) {
		Statement sentencia = null;
		ResultSet filas = null;

		try {
			objetoConexion.conectar();
			connection = objetoConexion.getJdbcConnection();
			sentencia = connection.createStatement();
			filas = sentencia.executeQuery(consultaSQL);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;

	}
}
