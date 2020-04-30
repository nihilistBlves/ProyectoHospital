package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.CampoMedico;
import Modelo.Enfermero;
import Modelo.Medico;

public class MedicoDAO {
	
	public static boolean insertarMedico(Medico medico) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert;
		
		if (medico.getIdMedico()==0) {
			sqlInsert = "INSERT INTO Medicos (nombre, apellido, numero_colegiado, id_campo) VALUES ('"+medico.getNombre()+"', '"+medico.getApellido()+"', "+medico.getNumeroColegiado()+", "+medico.getCampo().getId_campo()+")";
		} else {
			sqlInsert = "INSERT INTO Medicos (id_campo, nombre, apellido, numero_colegiado, id_campo) VALUES ("+medico.getIdMedico()+", '"+medico.getNombre()+"', '"+medico.getApellido()+"', "+medico.getNumeroColegiado()+", "+medico.getCampo().getId_campo()+")";
		}
		
		return enlace.insertar(sqlInsert);
	}
	
	public static boolean eliminarMedico(Medico medico) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert = "DELETE FROM Medicos WHERE id_medico="+medico.getIdMedico()+" OR numero_colegiado="+medico.getNumeroColegiado()+"";
	
		return enlace.insertar(sqlInsert);
	}
	
	public static boolean editarMedico(Medico medico) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "UPDATE Medicos SET nombre='"+medico.getNombre()+"' , apellido='"+medico.getApellido()+"' , numero_colegiado="+medico.getNumeroColegiado()+" , id_campo="+medico.getCampo().getId_campo()+"  WHERE id_medico="+medico.getIdMedico()+"";
		
		return enlace.insertar(sqlInsert);
	}
	
	public static List<Medico> selectAllMedicos() throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Medico> lista = new ArrayList<Medico>();
		
		String sqlSelect = "SELECT * FROM Medicos";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), new CampoMedico(rs.getInt(5), null)));
		}
		
		return lista;
	}
	
	public static List<Medico> selectOneMedicos(Medico medico) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Medico> lista = new ArrayList<Medico>();
		
		String sqlSelect = "SELECT * FROM Medicos WHERE id_medico="+medico.getIdMedico()+"";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while (rs.next()) {
			lista.add(new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), new CampoMedico(rs.getInt(5), null)));
		}
		
		return lista;
	}
	
	public static List<Medico> selectSearchingBy(Medico medico) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Medico> lista = new ArrayList<Medico>();
		
		String sqlSelect = "SELECT * FROM Medicos WHERE nombre LIKE '%"+medico.getNombre()+"%' OR apellido LIKE '%"+medico.getApellido()+"%' ";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			lista.add(new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), new CampoMedico(rs.getInt(5), null)));
		}
		
		return lista;
	}


}
