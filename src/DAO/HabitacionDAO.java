package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Habitacion;
import Modelo.Pasillo;

public class HabitacionDAO {
	
	public static void insertarHabitacion(Habitacion habitacion) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert;
		
		if (habitacion.getIdHabitacion()==0) {
			sqlInsert = "INSERT INTO Habitaciones (id_pasillo) VALUES ('"+habitacion.getPasillo().getIdPasillo()+"')";
		} else {
			sqlInsert = "INSERT INTO Habitaciones (id_habitacion, id_pasillo) VALUES ('"+habitacion.getIdHabitacion()+"', '"+habitacion.getPasillo().getIdPasillo()+"')";
		}
		
		if (enlace.insertar(sqlInsert)) {
			System.out.println("Se ha insertado correctamente.");
		} else {
			System.out.println("Ha habido un error en la insercion.");
		}
	}
	
	public static void eliminarHabitacion(Habitacion habitacion) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert = "DELETE FROM Habitaciones WHERE id_habitacion="+habitacion.getIdHabitacion()+"";
		
		if (enlace.insertar(sqlInsert) ) {
			System.out.println("Se ha eliminado correctamente.");
		} else {
			System.out.println("Ha habido un error en la insercion");
		}
	}
	
	public static List<Habitacion> selectAllHabitaciones() throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Habitacion> lista = new ArrayList<Habitacion>();
		
		String sqlSelect = "SELECT * FROM Habitaciones";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new Habitacion(rs.getInt(1), new Pasillo(rs.getInt(2))));
		}
		
		return lista;
	}
	
	public static List<Habitacion> selectAllHabitacionFromOnePasillo(Pasillo pasillo) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Habitacion> lista = new ArrayList<Habitacion>();
		
		String sqlSelect = "SELECT * FROM Habitaciones WHERE id_pasillo="+pasillo.getIdPasillo()+"";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new Habitacion(rs.getInt(1), new Pasillo(rs.getInt(2))));
		}
		
		return lista;
	}
	
	public static List<Habitacion> selectOneHabitacion(Habitacion habitacion) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Habitacion> lista = new ArrayList<Habitacion>();
		
		String sqlSelect = "SELECT * FROM Habitaciones WHERE id_habitacion="+habitacion.getIdHabitacion()+"";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new Habitacion(rs.getInt(1), new Pasillo(rs.getInt(2))));
		}
		
		return lista;
	}
	
	public static List<Habitacion> selectAllHabitacionesVacias() throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Habitacion> lista = new ArrayList<Habitacion>();
		
		String sqlSelect = "SELECT id_habitacion FROM Habitaciones WHERE id_habitacion NOT IN (SELECT id_habitacion FROM Pacientes) ";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			lista.add(new Habitacion(rs.getInt(1), new Pasillo(0)));
		}
		
		return lista;
	}

}
