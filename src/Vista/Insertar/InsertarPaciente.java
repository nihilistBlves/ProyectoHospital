package Vista.Insertar;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Control.Acciones;
import DAO.HabitacionDAO;
import Modelo.Habitacion;

public class InsertarPaciente {
	
	private JFrame insertarPacienteFrame;
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel dniLabel;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField dniTextField;
	private JLabel habitacionesLabel;
	private JComboBox<String> habitacionesComboBox;
	private JButton insertarPacienteButton;
	
	protected String[] rellenarComboBox() {
		String[] arrayRelleno = null;
		try {
			List<Habitacion> habitaciones = HabitacionDAO.selectAllHabitacionesVacias();
			int arrayLength = habitaciones.size();
			arrayRelleno = new String[arrayLength];
			for (int i=0; i<habitaciones.size(); i++) {
				arrayRelleno[i] = ""+habitaciones.get(i).getIdHabitacion()+"";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arrayRelleno;
	}
	
	public void mostrarInterfaz() {
		insertarPacienteFrame = new JFrame("Insertar paciente");
		insertarPacienteFrame.setSize(300, 400);;
		
		nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds(125, 20, 50, 20);
		nombreTextField = new JTextField();
		nombreTextField.setBounds(75, 40, 150, 30);
		
		apellidoLabel = new JLabel("Apellido");
		apellidoLabel.setBounds(125, 80, 80, 20);
		apellidoTextField = new JTextField();
		apellidoTextField.setBounds(75, 100, 150, 30);
		
		dniLabel = new JLabel("DNI");
		dniLabel.setBounds(135, 140, 100, 20);
		dniTextField = new JTextField();
		dniTextField.setBounds(75, 160, 150, 30);
		
		habitacionesLabel = new JLabel("Habitacion");
		habitacionesLabel.setBounds(115, 200, 100, 20);
		habitacionesComboBox = new JComboBox<String>(rellenarComboBox());
		habitacionesComboBox.setBounds(100, 220, 100, 30);
		
		insertarPacienteButton = new JButton("Insertar");
		insertarPacienteButton.setBounds(100, 280, 100, 80);
		insertarPacienteButton.addActionListener(Acciones.insertarPaciente(nombreTextField, apellidoTextField, dniTextField, habitacionesComboBox, insertarPacienteFrame));
		
		insertarPacienteFrame.add(nombreLabel);
		insertarPacienteFrame.add(nombreTextField);
		insertarPacienteFrame.add(apellidoLabel);
		insertarPacienteFrame.add(apellidoTextField);
		insertarPacienteFrame.add(dniLabel);
		insertarPacienteFrame.add(dniTextField);
		insertarPacienteFrame.add(habitacionesLabel);
		insertarPacienteFrame.add(habitacionesComboBox);
		insertarPacienteFrame.add(insertarPacienteButton);
		
		insertarPacienteFrame.setLocationRelativeTo(null);
		insertarPacienteFrame.setLayout(null);
		insertarPacienteFrame.setVisible(true);
	}

}
