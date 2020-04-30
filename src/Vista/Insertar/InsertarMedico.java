package Vista.Insertar;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Control.Acciones;
import DAO.CampoMedicoDAO;
import Modelo.CampoMedico;

public class InsertarMedico {
	
	private JFrame insertarMedicoFrame;
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel numeroColegiadoLabel;
	private JLabel camposLabel;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField numeroColegiadoTextField;
	private JComboBox<String> camposComboBox;
	private JButton insertarMedicoButton;
	
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
	
	public void mostrarInterfaz() {
		insertarMedicoFrame = new JFrame("Insertar medico");
		insertarMedicoFrame.setSize(300, 450);;
		
		nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds(125, 20, 50, 20);
		nombreTextField = new JTextField();
		nombreTextField.setBounds(75, 40, 150, 30);
		
		apellidoLabel = new JLabel("Apellido");
		apellidoLabel.setBounds(125, 80, 80, 20);
		apellidoTextField = new JTextField();
		apellidoTextField.setBounds(75, 100, 150, 30);
		
		numeroColegiadoLabel = new JLabel("Nº de colegiado");
		numeroColegiadoLabel.setBounds(100, 150, 100, 20);
		numeroColegiadoTextField = new JTextField();
		numeroColegiadoTextField.setBounds(75, 170, 150, 30);
		
		camposLabel = new JLabel("Campo medico");
		camposLabel.setBounds(105, 220, 150, 20);
		camposComboBox = new JComboBox<String>(rellenarComboBox());
		camposComboBox.setBounds(75, 240, 155, 30);
		
		insertarMedicoButton = new JButton("Insertar");
		insertarMedicoButton.setBounds(100, 300, 100, 80);
		insertarMedicoButton.addActionListener(Acciones.insertarMedico(nombreTextField, apellidoTextField, numeroColegiadoTextField, camposComboBox, insertarMedicoFrame));
		
		insertarMedicoFrame.add(nombreLabel);
		insertarMedicoFrame.add(nombreTextField);
		insertarMedicoFrame.add(apellidoLabel);
		insertarMedicoFrame.add(apellidoTextField);
		insertarMedicoFrame.add(numeroColegiadoLabel);
		insertarMedicoFrame.add(numeroColegiadoTextField);
		insertarMedicoFrame.add(insertarMedicoButton);
		insertarMedicoFrame.add(camposLabel);
		insertarMedicoFrame.add(camposComboBox);
		
		insertarMedicoFrame.setLocationRelativeTo(null);
		insertarMedicoFrame.setLayout(null);
		insertarMedicoFrame.setVisible(true);
	}

}
