package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Habitacion;
import Modelo.Pasillo;

public class PasilloDAO {
	
	public static void insertarPasillo(Pasillo pasillo) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert;
		
		if (pasillo.getIdPasillo()==0) {
			sqlInsert = "INSERT INTO Pasillos (id_pasillo) VALUES (null)";
		} else {
			sqlInsert = "INSERT INTO Pasillos (id_pasillo) VALUES ("+pasillo.getIdPasillo()+")";
		}
		
		if (enlace.insertar(sqlInsert)) {
			System.out.println("Se ha insertado correctamente.");
		} else {
			System.out.println("Ha habido un error en la insercion.");
		}
	}
	
	public static void eliminarPasillo(Pasillo pasillo) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert = "DELETE FROM Pasillos WHERE id_pasillo="+pasillo.getIdPasillo()+"";
		
		if (enlace.insertar(sqlInsert) ) {
			System.out.println("Se ha eliminado correctamente.");
		} else {
			System.out.println("Ha habido un error en la insercion");
		}
	}
	
	public static List<Pasillo> selectAllPasillos() throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Pasillo> lista = new ArrayList<Pasillo>();
	
		String sqlSelect = "SELECT * FROM Pasillos";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new Pasillo(rs.getInt(1)));
		}
		
		return lista;
	}
	
	public static List<Pasillo> selectPasilloDeOneHabitacion(int idHabitacion) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Pasillo> lista = new ArrayList<Pasillo>();
		
		String sqlSelect = "SELECT Habitaciones.id_pasillo FROM Habitaciones WHERE Habitaciones.id_habitacion="+idHabitacion+"";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			lista.add(new Pasillo(rs.getInt(1)));
		}
		
		return lista;
	}

}
