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
import DAO.CampoMedicoDAO;
import Modelo.CampoMedico;

public class EditarMedico {
	
	private JFrame editarMedicoFrame;
	private JLabel idLabel;
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	private JLabel apellidoLabel;
	private JTextField apellidoTextField;
	private JLabel numeroColegiadoLabel;
	private JTextField numeroColegiadoTextField;
	private JLabel campoLabel;
	private JComboBox<String> campoComboBox;
	private JButton editarMedicoButton;
	
	private String[] rellenarComboBox() {
		String[] arrayRelleno = null;
		try {
			List<CampoMedico> campos = CampoMedicoDAO.selectAllCampo();
			int arrayLength = campos.size();
			arrayRelleno = new String[arrayLength];
			for (int i=0; i<campos.size(); i++) {
				arrayRelleno[i] = campos.get(i).getNombre_campo();
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
		int nColegiado = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
		String campo = tabla.getValueAt(tabla.getSelectedRow(), 4).toString();
		
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
		
		campoLabel = new JLabel("Campo");
		campoLabel.setBounds(700, 55, 50, 20);
		campoComboBox = new JComboBox<String>(rellenarComboBox());
		campoComboBox.setSelectedItem(campo);
		campoComboBox.setBounds(750, 50, 100, 30);
		
		editarMedicoButton = new JButton("Confirmar Edición");
		editarMedicoButton.setBounds(340, 110, 150, 40);
		editarMedicoButton.addActionListener(Acciones.editarMedico(id, nombreTextField, apellidoTextField, numeroColegiadoTextField, campoComboBox, editarMedicoFrame));
		
		editarMedicoFrame.add(idLabel);
		editarMedicoFrame.add(nombreLabel);
		editarMedicoFrame.add(nombreTextField);
		editarMedicoFrame.add(apellidoLabel);
		editarMedicoFrame.add(apellidoTextField);
		editarMedicoFrame.add(numeroColegiadoLabel);
		editarMedicoFrame.add(numeroColegiadoTextField);
		editarMedicoFrame.add(campoLabel);
		editarMedicoFrame.add(campoComboBox);
		editarMedicoFrame.add(editarMedicoButton);
		
		editarMedicoFrame.setBounds(300, 300, 900, 200);
		editarMedicoFrame.setLayout(null);
		editarMedicoFrame.setVisible(true);
		
	}

}
