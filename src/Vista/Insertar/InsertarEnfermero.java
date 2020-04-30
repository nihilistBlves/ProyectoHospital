package Vista.Insertar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Control.Acciones;

public class InsertarEnfermero {
	
	private JFrame insertarEnfermeroFrame;
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel numeroColegiadoLabel;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField numeroColegiadoTextField;
	private JButton insertarEnfermeroButton;
	
	public void mostrarInterfaz() {
		insertarEnfermeroFrame = new JFrame("Insertar enfermero");
		insertarEnfermeroFrame.setSize(300, 350);;
		
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
		
		insertarEnfermeroButton = new JButton("Insertar");
		insertarEnfermeroButton.setBounds(100, 220, 100, 80);
		insertarEnfermeroButton.addActionListener(Acciones.insertarEnfermero(nombreTextField, apellidoTextField, numeroColegiadoTextField, insertarEnfermeroFrame));
		
		insertarEnfermeroFrame.add(nombreLabel);
		insertarEnfermeroFrame.add(nombreTextField);
		insertarEnfermeroFrame.add(apellidoLabel);
		insertarEnfermeroFrame.add(apellidoTextField);
		insertarEnfermeroFrame.add(numeroColegiadoLabel);
		insertarEnfermeroFrame.add(numeroColegiadoTextField);
		insertarEnfermeroFrame.add(insertarEnfermeroButton);
		
		insertarEnfermeroFrame.setLocationRelativeTo(null);
		insertarEnfermeroFrame.setLayout(null);
		insertarEnfermeroFrame.setVisible(true);
	}
	
	

}
