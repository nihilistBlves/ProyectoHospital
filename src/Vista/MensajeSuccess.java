package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MensajeSuccess {
	
	JFrame frameSuccess;
	
	public void mostrarMensajeSuccess(String mensaje) {
		JOptionPane.showMessageDialog(frameSuccess, mensaje, "Alerta", JOptionPane.INFORMATION_MESSAGE);
	}

}
