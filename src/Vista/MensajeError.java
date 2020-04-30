package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MensajeError {
	
	JFrame frameError;
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(frameError, mensaje, "Alerta", JOptionPane.WARNING_MESSAGE);
	}

}
