package Vista.Editar;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Control.Acciones;
import DAO.HabitacionDAO;
import Modelo.Habitacion;

public class EditarPaciente {

	private JFrame editarMedicoFrame;
	private JLabel idLabel;
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	private JLabel apellidoLabel;
	private JTextField apellidoTextField;
	private JLabel dniLabel;
	private JTextField dniTextField;
	private JLabel habitacionLabel;
	private JComboBox<String> habitacionComboBox;
	private JButton editarPacienteButton;
	
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
	
	public void editarMedicoMostrar(JTable tabla) {
		editarMedicoFrame = new JFrame("Editar médico");
		
		int id = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
		String nombre = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
		String apellido = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
		String dni = tabla.getValueAt(tabla.getSelectedRow(), 3).toString();
		int habitacion = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
		
		idLabel = new JLabel("ID "+id);
		idLabel.setBounds(50, 50, 50, 30);
		
		nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds(100, 55, 50, 20);
		nombreTextField = new JTextField();
		nombreTextField.setText(nombre);
		nombreTextField.setBounds(155, 50, 100, 30);
		
		apellidoLabel = new JLabel("Apellido");
		apellidoLabel.setBounds(280, 55, 80, 20);
		apellidoTextField = new JTextField();
		apellidoTextField.setText(apellido);
		apellidoTextField.setBounds(335, 50, 100, 30);
		
		dniLabel = new JLabel("DNI");
		dniLabel.setBounds(470, 55, 100, 20);
		dniTextField = new JTextField();
		dniTextField.setText(dni);
		dniTextField.setBounds(495, 50, 100, 30);
		
		habitacionLabel = new JLabel("Habitacion");
		habitacionLabel.setBounds(620, 55, 100, 20);
		habitacionComboBox = new JComboBox<String>(rellenarComboBox());
		habitacionComboBox.setSelectedItem(habitacion);
		habitacionComboBox.setBounds(690, 50, 100, 30);
		
		editarPacienteButton = new JButton("Confirmar Edición");
		editarPacienteButton.setBounds(340, 110, 150, 40);
		editarPacienteButton.addActionListener(Acciones.editarPaciente(id, nombreTextField, apellidoTextField, dniTextField, habitacionComboBox, editarMedicoFrame));
		
		editarMedicoFrame.add(idLabel);
		editarMedicoFrame.add(nombreLabel);
		editarMedicoFrame.add(nombreTextField);
		editarMedicoFrame.add(apellidoLabel);
		editarMedicoFrame.add(apellidoTextField);
		editarMedicoFrame.add(dniLabel);
		editarMedicoFrame.add(dniTextField);
		editarMedicoFrame.add(habitacionLabel);
		editarMedicoFrame.add(habitacionComboBox);
		editarMedicoFrame.add(editarPacienteButton);
		
		editarMedicoFrame.setBounds(300, 300, 850, 200);
		editarMedicoFrame.setLayout(null);
		editarMedicoFrame.setVisible(true);
		
	}

	
}
