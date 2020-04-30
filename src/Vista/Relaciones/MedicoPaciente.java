package Vista.Relaciones;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.Acciones;
import DAO.EnfermeroPacienteDAO;
import DAO.MedicoPacienteDAO;
import Modelo.CampoMedico;
import Modelo.Enfermero;
import Modelo.Medico;
import Modelo.Paciente;

public class MedicoPaciente {

	private JFrame medicoPacienteFrame;
	private JLabel pacientesAsignadosLabel;
	private JTable pacientesAsignadosTable;
	private JScrollPane pacientesAsignadosScroll;
	private JLabel pacientesLibresLabel;
	private JButton desasignarButton;
	private JTable pacientesLibresTable;
	private JScrollPane pacientesLibresScroll;
	private JButton asignarButton;

	public void abrirEnfermeroPaciente(JTable medicoTabla) {
		int idMedico = Integer.parseInt(medicoTabla.getValueAt(medicoTabla.getSelectedRow(), 0).toString());

		medicoPacienteFrame = new JFrame(
				"Pacientes asignados a " + medicoTabla.getValueAt(medicoTabla.getSelectedRow(), 1) + " "
						+ medicoTabla.getValueAt(medicoTabla.getSelectedRow(), 2));

		pacientesAsignadosLabel = new JLabel("Pacientes asignados");
		pacientesAsignadosLabel.setBounds(50, 30, 150, 20);
		pacientesLibresLabel = new JLabel("Pacientes sin asignar");
		pacientesLibresLabel.setBounds(400, 30, 150, 20);

		pacientesAsignadosTable = new JTable();
		pacientesAsignadosTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		cargarPacientesAsignados(idMedico);
		pacientesAsignadosScroll = new JScrollPane(pacientesAsignadosTable);
		pacientesAsignadosScroll.setBounds(50, 60, 250, 250);
		desasignarButton = new JButton("Desasignar");
		desasignarButton.setBounds(110, 315, 100, 60);
		desasignarButton.addActionListener(Acciones.desasignarPacienteMedico(pacientesAsignadosTable, idMedico));

		pacientesLibresTable = new JTable();
		pacientesLibresTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		cargarPacientesLibres(idMedico);
		pacientesLibresScroll = new JScrollPane(pacientesLibresTable);
		pacientesLibresScroll.setBounds(400, 60, 250, 250);
		asignarButton = new JButton("Asignar");
		asignarButton.setBounds(475, 315, 100, 60);
		asignarButton.addActionListener(Acciones.asignarPacienteMedico(pacientesLibresTable, idMedico));

		ImageIcon refreshIcon = new ImageIcon("Ficheros/refresh_icon.png");
		refreshIcon = resizeIcon(refreshIcon, 30, 30);
		JButton refresh = new JButton(refreshIcon);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable(idMedico);
			}
		});
		refresh.setBounds(335, 60, 30, 30);

		medicoPacienteFrame.add(pacientesAsignadosLabel);
		medicoPacienteFrame.add(pacientesLibresLabel);
		medicoPacienteFrame.add(pacientesAsignadosScroll);
		medicoPacienteFrame.add(pacientesLibresScroll);
		medicoPacienteFrame.add(desasignarButton);
		medicoPacienteFrame.add(asignarButton);
		medicoPacienteFrame.add(refresh);

		medicoPacienteFrame.setLayout(null);
		medicoPacienteFrame.setBounds(350, 200, 700, 410);
		medicoPacienteFrame.setVisible(true);
	}

	private void cargarPacientesAsignados(int idMedico) {
		DefaultTableModel tableModel = new DefaultTableModel();

		List<Paciente> pacientes = null;

		String[] columnas = { "ID", "Nombre", "Apellido", "DNI", "Habitacion" };

		try {
			pacientes = MedicoPacienteDAO.pacientesAsignadosMedico(new Medico(idMedico, "", "", 0, new CampoMedico(0, "")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String datos[][] = new String[pacientes.size()][5];
		for (int i = 0; i < pacientes.size(); i++) {
			datos[i][0] = Integer.toString(pacientes.get(i).getIdPaciente());
			datos[i][1] = pacientes.get(i).getNombre();
			datos[i][2] = pacientes.get(i).getApellido();
			datos[i][3] = pacientes.get(i).getDni();
			datos[i][4] = Integer.toString(pacientes.get(i).getHabitacion().getIdHabitacion());
		}

		tableModel.setDataVector(datos, columnas);

		pacientesAsignadosTable.setModel(tableModel);
	}

	private void cargarPacientesLibres(int idMedico) {
		DefaultTableModel tableModel = new DefaultTableModel();

		List<Paciente> pacientes = null;

		String[] columnas = { "ID", "Nombre", "Apellido", "DNI", "Habitacion" };

		try {
			pacientes = MedicoPacienteDAO.pacientesSinAsignarMedico(new Medico(idMedico, "", "", 0, new CampoMedico(0, "")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String datos[][] = new String[pacientes.size()][5];
		for (int i = 0; i < pacientes.size(); i++) {
			datos[i][0] = Integer.toString(pacientes.get(i).getIdPaciente());
			datos[i][1] = pacientes.get(i).getNombre();
			datos[i][2] = pacientes.get(i).getApellido();
			datos[i][3] = pacientes.get(i).getDni();
			datos[i][4] = Integer.toString(pacientes.get(i).getHabitacion().getIdHabitacion());
		}

		tableModel.setDataVector(datos, columnas);

		pacientesLibresTable.setModel(tableModel);
	}

	private void refreshTable(int idMedico) {
		cargarPacientesAsignados(idMedico);
		cargarPacientesLibres(idMedico);
	}

	private ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

}
