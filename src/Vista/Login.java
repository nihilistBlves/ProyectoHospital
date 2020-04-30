package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.Acciones;

public class Login {

	private JFrame loginFrame;
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	private JButton loginButton;
	
	public void mostrarLogin() {
		loginFrame = new JFrame("Login");
		loginFrame.setSize(300, 350);
		loginFrame.setLocation(500, 200);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setSize(200, 40);
		usernameLabel.setLocation(120, 50);
		
		usernameTextField = new JTextField();
		usernameTextField.setSize(200, 40);
		usernameTextField.setLocation(50, 80);
				
		passwordLabel = new JLabel("Password");
		passwordLabel.setSize(200, 40);
		passwordLabel.setLocation(120, 120);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setSize(200, 40);
		passwordTextField.setLocation(50, 150);
		
		loginButton = new JButton("Login");
		loginButton.setSize(100, 50);
		loginButton.setLocation(100, 220);
		
		loginFrame.add(usernameLabel);
		loginFrame.add(usernameTextField);
		loginFrame.add(passwordLabel);
		loginFrame.add(passwordTextField);
		loginFrame.add(loginButton);
		
		loginButton.addActionListener(Acciones.logear(usernameTextField, passwordTextField, loginFrame));
		
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
	}
	
}
