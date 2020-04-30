package Vista;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

import Control.Acciones;
import DAO.CampoMedicoDAO;
import DAO.EnfermeroDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import Modelo.CampoMedico;
import Modelo.Enfermero;
import Modelo.Habitacion;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Pasillo;

public class MenuPrincipal {
	
	private JFrame mainMenuFrame;
	private JLabel buscarLabel;
	private JComboBox<String> buscarComboBox;
	private JTextField buscarTextField;
	private JButton buscarButton;
	private JPanel enfermeroPanel;
	private JTable enfermeroTabla;
	private JScrollPane enfermeroScrollPane;
	private JPanel medicoPanel;
	private JTable medicoTabla;
	private JScrollPane medicoScrollPane;
	private JPanel pacientePanel;
	private JTable pacienteTabla;
	private JScrollPane pacienteScrollPane;
	private JPopupMenu popUpMenuTablaEnfermero;
	private JMenuItem popUpVerPacienteEnfermero;
	private JMenuItem popUpDeleteEnfermero;
	private JMenuItem popUpEditEnfermero;
	private JPopupMenu popUpMenuTablaMedico;
	private JMenuItem popUpVerPacienteMedico;
	private JMenuItem popUpDeleteMedico;
	private JMenuItem popUpEditMedico;
	private JPopupMenu popUpMenuTablaPaciente;
	private JMenuItem popUpDeletePaciente;
	private JMenuItem popUpEditPaciente;
	
	public void mostrarMenu() {
		mainMenuFrame = new JFrame();
		
		//MENU PARA INSERTAR
		JMenu insertarMenu = new JMenu("Insertar");
		JMenuItem insertarEnfermero = new JMenuItem("Enfermero");
		JMenuItem insertarMedico = new JMenuItem("Medico");
		JMenuItem insertarPaciente = new JMenuItem("Paciente");
		JMenuBar menuBar = new JMenuBar();
		
		insertarEnfermero.addActionListener(Acciones.abrirInsertarEnfermero());
		insertarMedico.addActionListener(Acciones.abrirInsertarMedico());
		insertarPaciente.addActionListener(Acciones.abrirInsertarPaciente());
		
		insertarMenu.add(insertarEnfermero);
		insertarMenu.add(insertarMedico);
		insertarMenu.add(insertarPaciente);
				
		menuBar.add(insertarMenu);
		
		mainMenuFrame.setJMenuBar(menuBar);
		
		//BUSCAR POR NOMBRE, APELLIDO...
		buscarLabel = new JLabel("Buscar");
		buscarLabel.setBounds(50, 50, 50, 20);
		String buscarOpciones[] = {"Enfermero","Medico","Paciente"};
		buscarComboBox = new JComboBox<String>(buscarOpciones);
		buscarComboBox.setBounds(45, 70, 150, 30);
		buscarTextField = new JTextField();
		buscarTextField.setBounds(47, 110, 150, 30);
		buscarButton = new JButton("Buscar");
		buscarButton.setBounds(50, 150, 100, 50);
		
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarRellenar(buscarComboBox, buscarTextField);
			}
		});
		
		mainMenuFrame.add(buscarLabel);
		mainMenuFrame.add(buscarComboBox);
		mainMenuFrame.add(buscarTextField);
		mainMenuFrame.add(buscarButton);
		
		//MENU SELECCIONAR
		JTabbedPane menuSelect = new JTabbedPane();
		menuSelect.setBounds(250, 20, 400, 300);
		
		//PANEL TABLA ENFERMERO
		enfermeroPanel = new JPanel();
		enfermeroTabla = new JTable();
		popUpMenuTablaEnfermero = new JPopupMenu();
		popUpMenuTablaEnfermero.addPopupMenuListener(Acciones.seleccionarClickDerecho(enfermeroTabla, popUpMenuTablaEnfermero));
		popUpVerPacienteEnfermero = new JMenuItem("Ver pacientes asignados");
		popUpEditEnfermero = new JMenuItem("Editar");
		popUpDeleteEnfermero = new JMenuItem("Eliminar");
		
		popUpVerPacienteEnfermero.addActionListener(Acciones.abrirEnfermeroPaciente(enfermeroTabla));
		popUpDeleteEnfermero.addActionListener(Acciones.eliminarEnfermero(enfermeroTabla));
		popUpEditEnfermero.addActionListener(Acciones.abrirEditarEnfermero(enfermeroTabla));
		
		popUpMenuTablaEnfermero.add(popUpVerPacienteEnfermero);
		popUpMenuTablaEnfermero.add(popUpEditEnfermero);
		popUpMenuTablaEnfermero.add(popUpDeleteEnfermero);
		enfermeroTabla.setComponentPopupMenu(popUpMenuTablaEnfermero);
		
		cargarTableModelEnfermero();
		enfermeroScrollPane = new JScrollPane(enfermeroTabla);
		enfermeroScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		enfermeroScrollPane.setBounds(0, 0, 378, 255);
		enfermeroPanel.add(enfermeroScrollPane);
		enfermeroPanel.setLayout(null);
		
		//PANEL TABLA MEDICO
		medicoPanel = new JPanel();
		medicoTabla = new JTable();
		medicoTabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		popUpMenuTablaMedico = new JPopupMenu();
		popUpMenuTablaMedico.addPopupMenuListener(Acciones.seleccionarClickDerecho(medicoTabla, popUpMenuTablaMedico));
		popUpVerPacienteMedico = new JMenuItem("Ver pacientes asignados");
		popUpEditMedico = new JMenuItem("Editar");
		popUpDeleteMedico = new JMenuItem("Eliminar");
		
		popUpVerPacienteMedico.addActionListener(Acciones.abrirMedicoPaciente(medicoTabla));
		popUpDeleteMedico.addActionListener(Acciones.eliminarMedico(medicoTabla));
		popUpEditMedico.addActionListener(Acciones.abrirEditarMedico(medicoTabla));
		
		popUpMenuTablaMedico.add(popUpVerPacienteMedico);
		popUpMenuTablaMedico.add(popUpEditMedico);
		popUpMenuTablaMedico.add(popUpDeleteMedico);
		medicoTabla.setComponentPopupMenu(popUpMenuTablaMedico);
		
		cargarTableModelMedico();
		medicoScrollPane = new JScrollPane(medicoTabla);
		medicoScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		medicoScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		medicoScrollPane.setBounds(0, 0, 378, 255);
		medicoPanel.add(medicoScrollPane);
		medicoPanel.setLayout(null);
		
		//PANEL TABLA PACIENTE
		pacientePanel = new JPanel();
		pacienteTabla = new JTable();
		pacienteTabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		popUpMenuTablaPaciente = new JPopupMenu();
		popUpMenuTablaPaciente.addPopupMenuListener(Acciones.seleccionarClickDerecho(pacienteTabla, popUpMenuTablaPaciente));
		popUpEditPaciente = new JMenuItem("Editar");
		popUpDeletePaciente = new JMenuItem("Eliminar");
		
		popUpDeletePaciente.addActionListener(Acciones.eliminarPaciente(pacienteTabla));
		popUpEditPaciente.addActionListener(Acciones.abrirEditarPaciente(pacienteTabla));
		
		popUpMenuTablaPaciente.add(popUpEditPaciente);
		popUpMenuTablaPaciente.add(popUpDeletePaciente);
		pacienteTabla.setComponentPopupMenu(popUpMenuTablaPaciente);
		
		cargarTableModelPaciente();
		pacienteScrollPane = new JScrollPane(pacienteTabla);
		pacienteScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pacienteScrollPane.setBounds(0, 0, 378, 255);
		pacientePanel.add(pacienteScrollPane);
		pacientePanel.setLayout(null);
		
		menuSelect.add("Enfermeros", enfermeroPanel);
		menuSelect.add("Medicos", medicoPanel);
		menuSelect.add("Pacientes", pacientePanel);
		
		mainMenuFrame.add(menuSelect);

		//Boton para actualizar tablas
		ImageIcon refreshIcon = new ImageIcon("Ficheros/refresh_icon.png");
		refreshIcon = resizeIcon(refreshIcon, 30, 30);
		JButton refresh = new JButton(refreshIcon);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		refresh.setBounds(650, 40, 30, 30);
		mainMenuFrame.add(refresh);
		
		mainMenuFrame.setSize(700,400); 
		mainMenuFrame.setLocationRelativeTo(null);
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenuFrame.setLayout(null);
		mainMenuFrame.setVisible(true);  
	}
	
	private void cargarTableModelEnfermero() {
		DefaultTableModel tableModel = new DefaultTableModel();
				
		List<Enfermero> enfermeros = null; 
		
		String[] columnas = {"ID","Nombre","Apellido","Nº Colegiado"};

		try {
			enfermeros = EnfermeroDAO.selectAllEnfermeros();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String datos[][] = new String[enfermeros.size()][4];
		for (int i=0; i<enfermeros.size(); i++) {
			datos[i][0] = Integer.toString(enfermeros.get(i).getIdEnfermero());
			datos[i][1] = enfermeros.get(i).getNombre();
			datos[i][2] = enfermeros.get(i).getApellido();
			datos[i][3] = Integer.toString(enfermeros.get(i).getNumeroColegiado());
		}
		
		tableModel.setDataVector(datos, columnas);			
		
		enfermeroTabla.setModel(tableModel);
	}
	
	private void cargarTableModelMedico() {
		DefaultTableModel tableModel = new DefaultTableModel();
				
		List<Medico> medicos = null; 
		
		String[] columnas = {"ID","Nombre","Apellido","Nº Colegiado","Campo"};

		try {
			medicos = MedicoDAO.selectAllMedicos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String datos[][] = new String[medicos.size()][5];
		for (int i=0; i<medicos.size(); i++) {
			datos[i][0] = Integer.toString(medicos.get(i).getIdMedico());
			datos[i][1] = medicos.get(i).getNombre();
			datos[i][2] = medicos.get(i).getApellido();
			datos[i][3] = Integer.toString(medicos.get(i).getNumeroColegiado());
			List<CampoMedico> campo = null;
			try {
				campo = CampoMedicoDAO.selectOneCampo(new CampoMedico(medicos.get(i).getCampo().getId_campo(), ""));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			datos[i][4] = campo.get(0).getNombre_campo();
		}
		
		tableModel.setDataVector(datos, columnas);			
		
		medicoTabla.setModel(tableModel);
	}
	
	private void cargarTableModelPaciente() {
		DefaultTableModel tableModel = new DefaultTableModel();
				
		List<Paciente> pacientes = null; 
		
		String[] columnas = {"ID","Nombre","Apellido","DNI","Habitacion"};

		try {
			pacientes = PacienteDAO.selectAllPacientes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String datos[][] = new String[pacientes.size()][5];
		for (int i=0; i<pacientes.size(); i++) {
			datos[i][0] = Integer.toString(pacientes.get(i).getIdPaciente());
			datos[i][1] = pacientes.get(i).getNombre();
			datos[i][2] = pacientes.get(i).getApellido();
			datos[i][3] = pacientes.get(i).getDni();
			datos[i][4] = Integer.toString(pacientes.get(i).getHabitacion().getIdHabitacion());
		}
		
		tableModel.setDataVector(datos, columnas);	
		
		pacienteTabla.setModel(tableModel);
	}
	
	private void refreshTable() {
		cargarTableModelEnfermero();
		cargarTableModelMedico();
		cargarTableModelPaciente();
	}
	
	private void buscarRellenar(JComboBox<String> opcion, JTextField text) {
		switch (opcion.getItemAt(opcion.getSelectedIndex()).toString()) {
		case "Enfermero":
			DefaultTableModel tableModel = new DefaultTableModel();
			
			List<Enfermero> enfermeros = null; 
			
			String[] columnas = {"ID","Nombre","Apellido","Nº Colegiado"};

			try {
				enfermeros = EnfermeroDAO.selectSearchingBy(new Enfermero(0, text.getText(), text.getText(), 0));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String datos[][] = new String[enfermeros.size()][4];
			for (int i=0; i<enfermeros.size(); i++) {
				datos[i][0] = Integer.toString(enfermeros.get(i).getIdEnfermero());
				datos[i][1] = enfermeros.get(i).getNombre();
				datos[i][2] = enfermeros.get(i).getApellido();
				datos[i][3] = Integer.toString(enfermeros.get(i).getNumeroColegiado());
			}
			
			tableModel.setDataVector(datos, columnas);			
			
			enfermeroTabla.setModel(tableModel);
			
			break;
		case "Medico":
			DefaultTableModel tableModel2 = new DefaultTableModel();
			
			List<Medico> medicos = null; 
			
			String[] columnas2 = {"ID","Nombre","Apellido","Nº Colegiado","Campo"};

			try {
				medicos = MedicoDAO.selectSearchingBy(new Medico(0, text.getText(), text.getText(), 0, new CampoMedico(0, "")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String datos2[][] = new String[medicos.size()][5];
			for (int i=0; i<medicos.size(); i++) {
				datos2[i][0] = Integer.toString(medicos.get(i).getIdMedico());
				datos2[i][1] = medicos.get(i).getNombre();
				datos2[i][2] = medicos.get(i).getApellido();
				datos2[i][3] = Integer.toString(medicos.get(i).getNumeroColegiado());
				List<CampoMedico> campo = null;
				try {
					campo = CampoMedicoDAO.selectOneCampo(new CampoMedico(medicos.get(i).getCampo().getId_campo(), ""));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				datos2[i][4] = campo.get(0).getNombre_campo();
			}
			
			tableModel2.setDataVector(datos2, columnas2);			
			
			medicoTabla.setModel(tableModel2);
			
			break;
		case "Paciente":
			DefaultTableModel tableModel3 = new DefaultTableModel();
			
			List<Paciente> pacientes = null; 
			
			String[] columnas3 = {"ID","Nombre","Apellido","DNI","Habitacion"};

			try {
				pacientes = PacienteDAO.selectSearchingBy(new Paciente(0, text.getText(), text.getText(), "", new Habitacion(0, new Pasillo(0))));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String datos3[][] = new String[pacientes.size()][5];
			for (int i=0; i<pacientes.size(); i++) {
				datos3[i][0] = Integer.toString(pacientes.get(i).getIdPaciente());
				datos3[i][1] = pacientes.get(i).getNombre();
				datos3[i][2] = pacientes.get(i).getApellido();
				datos3[i][3] = pacientes.get(i).getDni();
				datos3[i][4] = Integer.toString(pacientes.get(i).getHabitacion().getIdHabitacion());
			}
			
			tableModel3.setDataVector(datos3, columnas3);	
			
			pacienteTabla.setModel(tableModel3);
			
			break;
		}
	}
	
	private static ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}

}
