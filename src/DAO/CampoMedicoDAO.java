package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.CampoMedico;

public class CampoMedicoDAO {
	
	public static void insertarCampo(CampoMedico campo) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert;
		
		if(campo.getId_campo()==0) {
			sqlInsert = "INSERT INTO Campos_Medicos (nombre_campo) VALUES ('"+campo.getNombre_campo()+"')";
		} else {
			sqlInsert = "INSERT INTO Campos_Medicos (id_campo, nombre_campo) VALUES ("+campo.getId_campo()+", '"+campo.getNombre_campo()+"')";
		}
		
		if (enlace.insertar(sqlInsert)) {
			System.out.println("Se ha insertado correctamente.");
		} else {
			System.out.println("Ha habido un error en la insercion.");
		}
	}
	
	public static void eliminarCampo(CampoMedico campo) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "DELETE FROM Campos_Medicos WHERE id_campo="+campo.getId_campo()+" OR nombre_campo='"+campo.getNombre_campo()+"'";
		
		if (enlace.insertar(sqlInsert)) {
			System.out.println("Se ha eliminado correctamente.");
		} else {
			System.out.println("Ha habido un error en el borrado.");
		}
	}
	
	public static List<CampoMedico> selectAllCampo() throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<CampoMedico> lista = new ArrayList<CampoMedico>();
		
		String sqlSelect = "SELECT * FROM Campos_Medicos";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new CampoMedico(rs.getInt(1), rs.getString(2)));
		}
		
		return lista;
	}
	
	public static List<CampoMedico> selectOneCampo(CampoMedico campo) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<CampoMedico> lista = new ArrayList<CampoMedico>();
		
		String sqlSelect = "SELECT * FROM Campos_Medicos WHERE id_campo="+campo.getId_campo()+" OR nombre_campo='"+campo.getNombre_campo()+"'";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new CampoMedico(rs.getInt(1), rs.getString(2)));
		}
		
		return lista;
	}

}