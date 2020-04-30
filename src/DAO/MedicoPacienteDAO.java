package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Habitacion;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Pasillo;

public class MedicoPacienteDAO {

	public static boolean insertarMedicoPaciente(Medico medico, Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "INSERT INTO Medico_Paciente (id_medico, id_paciente) VALUES ("+medico.getIdMedico()+", "+paciente.getIdPaciente()+")";
		
		return enlace.insertar(sqlInsert);
	}
	
	public static boolean eliminarMedicoPaciente(Medico medico, Paciente paciente) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		
		String sqlInsert = "DELETE FROM Medico_Paciente WHERE id_enfermero="+medico.getIdMedico()+" AND id_paciente="+paciente.getIdPaciente()+")";
		
		return enlace.insertar(sqlInsert);
	}
	
	public static List<Paciente> pacientesSinAsignarMedico(Medico medico) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Paciente> pacientesLibres = new ArrayList<Paciente>();
		
		String sqlSelect = "SELECT * FROM Pacientes WHERE Pacientes.id_paciente NOT IN (SELECT Medico_Paciente.id_paciente FROM Medico_Paciente WHERE id_medico="+medico.getIdMedico()+")";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			pacientesLibres.add(new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Habitacion(rs.getInt(5), new Pasillo(0))));
		}
		
		return pacientesLibres;
	}
	
	public static List<Paciente> pacientesAsignadosMedico(Medico medico) throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();
		List<Paciente> pacientesLibres = new ArrayList<Paciente>();
		
		String sqlSelect = "SELECT * FROM Pacientes WHERE Pacientes.id_paciente IN (SELECT Medico_Paciente.id_paciente FROM Medico_Paciente WHERE id_medico="+medico.getIdMedico()+")";
		
		ResultSet rs = enlace.seleccionRegistros(sqlSelect);
		
		while(rs.next()) {
			pacientesLibres.add(new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Habitacion(rs.getInt(5), new Pasillo(0))));
		}
		
		return pacientesLibres;
	}
	
}
