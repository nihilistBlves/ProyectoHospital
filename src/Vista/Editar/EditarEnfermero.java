package Vista.Editar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Control.Acciones;

public class EditarEnfermero {
	
	private JFrame editarEnfermeroFrame;
	private JLabel idLabel;
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	private JLabel apellidoLabel;
	private JTextField apellidoTextField;
	private JLabel numeroColegiadoLabel;
	private JTextField numeroColegiadoTextField;
	private JButton editarEnfermeroButton;
	
	public void editarEnfermeroMostrar(JTable tabla) {
		editarEnfermeroFrame = new JFrame("Editar enfermero");
		
		int id = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
		String nombre = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
		String apellido = tabla.getValueAt(tabla.getSelectedRow(), 2).toString();
		int nColegiado = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
		
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
		
		numeroColegiadoLabel = new JLabel("Nº de colegiado");
		numeroColegiadoLabel.setBounds(470, 55, 100, 20);
		numeroColegiadoTextField = new JTextField();
		numeroColegiadoTextField.setText(Integer.toString(nColegiado));
		numeroColegiadoTextField.setBounds(575, 50, 100, 30);
		
		editarEnfermeroButton = new JButton("Confirmar Edición");
		editarEnfermeroButton.setBounds(280, 110, 150, 40);
		editarEnfermeroButton.addActionListener(Acciones.editarEnfermero(id, nombreTextField, apellidoTextField, numeroColegiadoTextField, editarEnfermeroFrame));
		
		editarEnfermeroFrame.add(idLabel);
		editarEnfermeroFrame.add(nombreLabel);
		editarEnfermeroFrame.add(nombreTextField);
		editarEnfermeroFrame.add(apellidoLabel);
		editarEnfermeroFrame.add(apellidoTextField);
		editarEnfermeroFrame.add(numeroColegiadoLabel);
		editarEnfermeroFrame.add(numeroColegiadoTextField);
		editarEnfermeroFrame.add(editarEnfermeroButton);
		
		editarEnfermeroFrame.setBounds(400, 300, 750, 200);
		editarEnfermeroFrame.setLayout(null);
		editarEnfermeroFrame.setVisible(true);
		
	}

}
