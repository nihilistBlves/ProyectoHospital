package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Enfermero;
import Modelo.Habitacion;
import Modelo.Paciente;
import Modelo.Pasillo;

public class EnfermeroPacienteDAO {
	
	public static boolean insertarEnfermeroPaciente(Enfermero enfermero, Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "INSERT INTO Enfermero_Paciente (id_enfermero, id_paciente) VALUES ("+enfermero.getIdEnfermero()+", "+paciente.getIdPaciente()+")";
		
		return enlace.insertar(sqlInsert);
	}
	
	public static boolean eliminarEnfermermoPaciente(Enfermero enfermero, Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "DELETE FROM Enfermero_Paciente WHERE id_enfermero="+enfermero.getIdEnfermero()+" AND id_paciente="+paciente.getIdPaciente()+")";
		
		return enlace.insertar(sqlInsert);
	}
	
	public static List<Paciente> pacientesSinAsignarEnfermero(Enfermero enfermero) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Paciente> pacientesLibres = new ArrayList<Paciente>();
		
		String sqlSelect = "SELECT * FROM Pacientes WHERE Pacientes.id_paciente NOT IN (SELECT Enfermero_Paciente.id_paciente FROM Enfermero_Paciente WHERE id_enfermero="+enfermero.getIdEnfermero()+")";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			pacientesLibres.add(new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Habitacion(rs.getInt(5), new Pasillo(0))));
		}
		
		return pacientesLibres;
	}
	
	public static List<Paciente> pacientesAsignadosEnfermero(Enfermero enfermero) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Paciente> pacientesLibres = new ArrayList<Paciente>();
		
		String sqlSelect = "SELECT * FROM Pacientes WHERE Pacientes.id_paciente IN (SELECT Enfermero_Paciente.id_paciente FROM Enfermero_Paciente WHERE id_enfermero="+enfermero.getIdEnfermero()+")";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			pacientesLibres.add(new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Habitacion(rs.getInt(5), new Pasillo(0))));
		}
		
		return pacientesLibres;
	}

}
