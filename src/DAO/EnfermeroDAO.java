package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.CampoMedico;
import Modelo.Enfermero;
import Vista.MensajeError;
import Vista.MensajeSuccess;

public class EnfermeroDAO {
	
	public static boolean insertarEnfermero(Enfermero enfermero) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert;
		
		if(enfermero.getIdEnfermero()==0) {
			sqlInsert = "INSERT INTO Enfermeros (nombre, apellido, numero_colegiado) VALUES ('"+enfermero.getNombre()+"', '"+enfermero.getApellido()+"', '"+enfermero.getNumeroColegiado()+"')";
		} else {
			sqlInsert = "INSERT INTO Enfermeros (id_enfermero, nombre, apellido, numero_colegiado) VALUES ('"+enfermero.getIdEnfermero()+"', '"+enfermero.getNombre()+"', '"+enfermero.getApellido()+"', '"+enfermero.getNumeroColegiado()+"')";
		}
		
		return enlace.insertar(sqlInsert);
	}
	
	public static boolean eliminarEnfermero(Enfermero enfermero) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "DELETE FROM Enfermeros WHERE id_enfermero="+enfermero.getIdEnfermero()+" OR numero_colegiado="+enfermero.getNumeroColegiado()+"";
		
		return enlace.insertar(sqlInsert);
	}
	
	public static boolean editarEnfermero(Enfermero enfermero) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "UPDATE Enfermeros SET nombre='"+enfermero.getNombre()+"', apellido='"+enfermero.getApellido()+"', numero_colegiado="+enfermero.getNumeroColegiado()+" WHERE id_enfermero="+enfermero.getIdEnfermero()+"";
		
		return enlace.insertar(sqlInsert);
	}

	public static List<Enfermero> selectAllEnfermeros() throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Enfermero> lista = new ArrayList<Enfermero>();
		
		String sqlSelect = "SELECT * FROM Enfermeros";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new Enfermero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		return lista;
	}
	
	public static List<Enfermero> selectOneEnfermero(Enfermero enfermero) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Enfermero> lista = new ArrayList<Enfermero>();
		
		String sqlSelect = "SELECT * FROM Enfermeros WHERE id_enfermero="+enfermero.getIdEnfermero()+" OR numero_colegiado="+enfermero.getNumeroColegiado()+"";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new Enfermero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		return lista;
	}
	
	public static List<Enfermero> selectSearchingBy(Enfermero enfermero) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Enfermero> lista = new ArrayList<Enfermero>();
		
		String sqlSelect = "SELECT * FROM Enfermeros WHERE nombre LIKE '%"+enfermero.getNombre()+"%' OR apellido LIKE '%"+enfermero.getApellido()+"%' ";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			lista.add(new Enfermero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		
		return lista;
	}
}
