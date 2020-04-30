package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.CampoMedico;
import Modelo.Habitacion;
import Modelo.Medico;
import Modelo.Paciente;

public class PacienteDAO {
	
	public static boolean insertarPaciente(Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		String sqlInsert = null;
		
		if (paciente.getIdPaciente()==0) {
			sqlInsert = "INSERT INTO Pacientes (nombre, apellido, dni, id_habitacion) VALUES ('"+paciente.getNombre()+"', '"+paciente.getApellido()+"', '"+paciente.getDni()+"', "+paciente.getHabitacion().getIdHabitacion()+")";
		} else {
			sqlInsert = "INSERT INTO Pacientes (id_paciente, nombre, apellido, dni, id_habitacion) VALUES ("+paciente.getIdPaciente()+", '"+paciente.getNombre()+"', '"+paciente.getApellido()+"', '"+paciente.getDni()+"', "+paciente.getHabitacion().getIdHabitacion()+")";
		}
		
		return enlace.insertar(sqlInsert);
	}
	
	public static boolean eliminarPaciente(Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "DELETE FROM Pacientes WHERE id_paciente="+paciente.getIdPaciente()+" OR dni="+paciente.getDni()+"";
		
		return enlace.insertar(sqlInsert);
	}
	
	public static boolean editarPaciente(Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "UPDATE Pacientes SET nombre='"+paciente.getNombre()+"', apellido='"+paciente.getApellido()+"', dni='"+paciente.getDni()+"', id_habitacion="+paciente.getHabitacion().getIdHabitacion()+" WHERE id_paciente="+paciente.getIdPaciente()+"";
	
		return enlace.insertar(sqlInsert);
	}
	
	public static List<Paciente> selectAllPacientes() throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Paciente> lista = new ArrayList<Paciente>();
		
		String sqlSelect = "SELECT * FROM Pacientes";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			lista.add(new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Habitacion(rs.getInt(5), PasilloDAO.selectPasilloDeOneHabitacion(rs.getInt(5)).get(0))));
		}
		
		return lista;
	}
	
	public static List<Paciente> selectOnePaciente(Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Paciente> lista = new ArrayList<Paciente>();
		
		String sqlSelect = "SELECT * FROM Pacientes WHERE id_paciente="+paciente.getIdPaciente()+" OR dni="+paciente.getDni()+" OR id_habitacion="+paciente.getHabitacion().getIdHabitacion()+"";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			lista.add(new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Habitacion(rs.getInt(5), PasilloDAO.selectPasilloDeOneHabitacion(rs.getInt(5)).get(0))));
		}
		
		return lista;
	}
	
	public static List<Paciente> selectSearchingBy(Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Paciente> lista = new ArrayList<Paciente>();
		
		String sqlSelect = "SELECT * FROM Pacientes WHERE nombre LIKE '%"+paciente.getNombre()+"%' OR apellido LIKE '%"+paciente.getApellido()+"%' ";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			lista.add(new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Habitacion(rs.getInt(5), PasilloDAO.selectPasilloDeOneHabitacion(rs.getInt(5)).get(0))));
		}
		
		return lista;
	}

}
