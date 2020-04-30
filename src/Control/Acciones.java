package Control;

import java.awt.Point;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import DAO.CampoMedicoDAO;
import DAO.EnfermeroDAO;
import DAO.EnfermeroPacienteDAO;
import DAO.HabitacionDAO;
import DAO.MedicoDAO;
import DAO.MedicoPacienteDAO;
import DAO.PacienteDAO;
import Modelo.CampoMedico;
import Modelo.Enfermero;
import Modelo.Habitacion;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Pasillo;
import Vista.Login;
import Vista.MensajeError;
import Vista.MensajeSuccess;
import Vista.MenuPrincipal;
import Vista.Editar.EditarEnfermero;
import Vista.Editar.EditarMedico;
import Vista.Editar.EditarPaciente;
import Vista.Insertar.InsertarEnfermero;
import Vista.Insertar.InsertarMedico;
import Vista.Insertar.InsertarPaciente;
import Vista.Relaciones.EnfermeroPaciente;
import Vista.Relaciones.MedicoPaciente;

public class Acciones {

	// LOGEAR
	public static ActionListener logear(JTextField username, JTextField pass, JFrame frame) {
		ActionListener logear = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				MensajeError m = new MensajeError();
				if (username.getText().isEmpty() && pass.getText().isEmpty()) {
					m.mostrarMensajeError("Usuario o contraseña vacíos.");
				} else if (username.getText().contentEquals("root") && pass.getText().contentEquals("root")){
					MenuPrincipal menu = new MenuPrincipal();
					menu.mostrarMenu();
					frame.setVisible(false);
				} else {
					m.mostrarMensajeError("Usuario o contraseña incorrectos.");
				}
			}
		};

		return logear;
	}

	// ABRIR INSERTAR ENFERMERO
	public static ActionListener abrirInsertarEnfermero() {
		ActionListener abrirInsertar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarEnfermero i = new InsertarEnfermero();
				i.mostrarInterfaz();
			}
		};
		return abrirInsertar;
	}

	// INSERTAR ENFERMERO
	public static ActionListener insertarEnfermero(JTextField nombre, JTextField apellido, JTextField nColegiado,
			JFrame frame) {
		ActionListener insertar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeError m = new MensajeError();
				MensajeSuccess m2 = new MensajeSuccess();
				if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || nColegiado.getText().isEmpty()) {
					m.mostrarMensajeError("Rellene todos los campos");
				} else {
					Enfermero enfermero = new Enfermero(0, nombre.getText(), apellido.getText(),
							Integer.parseInt(nColegiado.getText()));
					try {
						if (EnfermeroDAO.insertarEnfermero(enfermero)) {
							m2.mostrarMensajeSuccess("Insertado correctamente.");
							frame.setVisible(false);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
						m.mostrarMensajeError("Ha ocurrido un error en la insercion.");
					}
				}
			}
		};
		return insertar;
	}

	// ABRIR INSERTAR MEDICO
	public static ActionListener abrirInsertarMedico() {
		ActionListener abrirInsertar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarMedico i = new InsertarMedico();
				i.mostrarInterfaz();
			}
		};
		return abrirInsertar;
	}

	// INSERTAR MEDICO
	public static ActionListener insertarMedico(JTextField nombre, JTextField apellido, JTextField nColegiado,
			JComboBox<String> campo, JFrame frame) {
		ActionListener insertar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeError m1 = new MensajeError();
				MensajeSuccess m2 = new MensajeSuccess();
				if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || nColegiado.getText().isEmpty()
						|| campo.getItemAt(campo.getSelectedIndex()).isEmpty()) {
					m1.mostrarMensajeError("Rellene y seleccione todos los campos.");
				} else {
					List<CampoMedico> result = null;
					try {
						result = CampoMedicoDAO
								.selectOneCampo(new CampoMedico(0, campo.getItemAt(campo.getSelectedIndex())));
						if (MedicoDAO.insertarMedico(new Medico(0, nombre.getText(), apellido.getText(),
								Integer.parseInt(nColegiado.getText()), result.get(0)))) {
							m2.mostrarMensajeSuccess("Insertado correctamente.");
							frame.setVisible(false);
						} else {
							m1.mostrarMensajeError("Ha ocurrido un error en la insercion.");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		};

		return insertar;
	}

	// ABRIR INSERTAR PACIENTE
	public static ActionListener abrirInsertarPaciente() {
		ActionListener abrir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarPaciente i = new InsertarPaciente();
				i.mostrarInterfaz();
			}
		};
		return abrir;
	}

	// INSERTAR PACIENTE
	public static ActionListener insertarPaciente(JTextField nombre, JTextField apellido, JTextField dni,
			JComboBox<String> habitacion, JFrame frame) {
		ActionListener insertar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeError m1 = new MensajeError();
				MensajeSuccess m2 = new MensajeSuccess();
				if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || dni.getText().isEmpty()
						|| habitacion.getItemAt(habitacion.getSelectedIndex()).isEmpty()) {
					m1.mostrarMensajeError("Rellene y seleccione todos los campos.");
				} else {
					try {
						if (PacienteDAO
								.insertarPaciente(new Paciente(0, nombre.getText(), apellido.getText(), dni.getText(),
										new Habitacion(
												Integer.parseInt(habitacion.getItemAt(habitacion.getSelectedIndex())),
												new Pasillo(0))))) {
							m2.mostrarMensajeSuccess("Insertado correctamente.");
							frame.setVisible(false);
						} else {
							m1.mostrarMensajeError("Ha ocurrido un error en la insercion.");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}

			}
		};

		return insertar;

	}

	// ABRIR PACIENTES DE ENFERMERO
	public static ActionListener abrirEnfermeroPaciente(JTable tablaEnfermero) {
		ActionListener abrir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnfermeroPaciente m = new EnfermeroPaciente();
				m.abrirEnfermeroPaciente(tablaEnfermero);
			}
		};
		return abrir;
	}

	// DESASIGNAR PACIENTE DE ENFERMERO
	public static ActionListener desasignarPacienteEnfermero(JTable tablaAsignados, int idEnfermero) {
		ActionListener desasignar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				Paciente paciente = new Paciente(
						Integer.parseInt(tablaAsignados.getValueAt(tablaAsignados.getSelectedRow(), 0).toString()), "",
						"", "", new Habitacion(0, new Pasillo(0)));
				Enfermero enfermero = new Enfermero(idEnfermero, "", "", 0);
				try {
					if (EnfermeroPacienteDAO.eliminarEnfermermoPaciente(enfermero, paciente)) {
						m1.mostrarMensajeSuccess("Desasignado correctamente.");
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la desasignación.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};

		return desasignar;
	}

	// ASIGNAR PACIENTE A ENFERMERO
	public static ActionListener asignarPacienteEnfermero(JTable tablaNoAsignados, int idEnfermero) {
		ActionListener asignar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				Paciente paciente = new Paciente(
						Integer.parseInt(tablaNoAsignados.getValueAt(tablaNoAsignados.getSelectedRow(), 0).toString()),
						"", "", "", new Habitacion(0, new Pasillo(0)));
				Enfermero enfermero = new Enfermero(idEnfermero, "", "", 0);
				try {
					if (EnfermeroPacienteDAO.insertarEnfermeroPaciente(enfermero, paciente)) {
						m1.mostrarMensajeSuccess("Asignado correctamente.");
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la asignación.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};

		return asignar;
	}

	// ELIMINAR ENFERMERO
	public static ActionListener eliminarEnfermero(JTable tablaEnfermero) {
		ActionListener eliminar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				int row = tablaEnfermero.getSelectedRow();
				int column = 0;
				String value = tablaEnfermero.getModel().getValueAt(row, column).toString();
				try {
					if (EnfermeroDAO.eliminarEnfermero(new Enfermero(Integer.parseInt(value), "", "", 0))) {
						m1.mostrarMensajeSuccess("Eliminado correctamente.");
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la eliminación.");
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};

		return eliminar;
	}

	// ABRIR EDITAR ENFERMERO
	public static ActionListener abrirEditarEnfermero(JTable tabla) {
		ActionListener editar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarEnfermero m = new EditarEnfermero();
				m.editarEnfermeroMostrar(tabla);
			}
		};
		return editar;
	}

	// EDITAR ENFERMERO
	public static ActionListener editarEnfermero(int id, JTextField nombre, JTextField apellido, JTextField nColegiado,
			JFrame frame) {
		ActionListener editar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				try {
					if (EnfermeroDAO.editarEnfermero(new Enfermero(id, nombre.getText(), apellido.getText(),
							Integer.parseInt(nColegiado.getText())))) {
						m1.mostrarMensajeSuccess("Editado correctamente.");
						frame.setVisible(false);
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la edición.");
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};
		return editar;
	}

	// ABRIR PACIENTES DE MEDICO
	public static ActionListener abrirMedicoPaciente(JTable tablaMedico) {
		ActionListener abrir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoPaciente m = new MedicoPaciente();
				m.abrirEnfermeroPaciente(tablaMedico);
			}
		};
		return abrir;
	}

	// DESASIGNAR PACIENTE DE MEDICO
	public static ActionListener desasignarPacienteMedico(JTable tablaAsignados, int idMedico) {
		ActionListener desasignar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				Paciente paciente = new Paciente(
						Integer.parseInt(tablaAsignados.getValueAt(tablaAsignados.getSelectedRow(), 0).toString()), "",
						"", "", new Habitacion(0, new Pasillo(0)));
				Medico medico = new Medico(idMedico, "", "", 0, new CampoMedico(0, ""));
				try {
					if (MedicoPacienteDAO.eliminarMedicoPaciente(medico, paciente)) {
						m1.mostrarMensajeSuccess("Desasignado correctamente.");
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la desasignación.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};

		return desasignar;
	}

	// ASIGNAR PACIENTE A MEDICO
	public static ActionListener asignarPacienteMedico(JTable tablaNoAsignados, int idMedico) {
		ActionListener asignar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				Paciente paciente = new Paciente(
						Integer.parseInt(tablaNoAsignados.getValueAt(tablaNoAsignados.getSelectedRow(), 0).toString()),
						"", "", "", new Habitacion(0, new Pasillo(0)));
				Medico medico = new Medico(idMedico, "", "", 0, new CampoMedico(0, ""));
				try {
					if (MedicoPacienteDAO.insertarMedicoPaciente(medico, paciente)) {
						m1.mostrarMensajeSuccess("Asignado correctamente.");
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la asignación.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};

		return asignar;
	}

	// ELIMINAR MEDICO
	public static ActionListener eliminarMedico(JTable tablaMedico) {
		ActionListener eliminar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				int row = tablaMedico.getSelectedRow();
				int column = 0;
				String value = tablaMedico.getModel().getValueAt(row, column).toString();
				try {
					if (MedicoDAO
							.eliminarMedico(new Medico(Integer.parseInt(value), "", "", 0, new CampoMedico(0, "")))) {
						m1.mostrarMensajeSuccess("Eliminado correctamente.");
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la eliminación.");
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};
		return eliminar;
	}

	// ABRIR EDITAR MEDICO
	public static ActionListener abrirEditarMedico(JTable tablaMedico) {
		ActionListener abrir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarMedico m = new EditarMedico();
				m.editarMedicoMostrar(tablaMedico);
			}
		};
		return abrir;
	}

	// EDITAR MEDICO
	public static ActionListener editarMedico(int id, JTextField nombre, JTextField apellido, JTextField nColegiado,
			JComboBox<String> campo, JFrame frame) {
		ActionListener editar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				List<CampoMedico> result = null;
				try {
					result = CampoMedicoDAO
							.selectOneCampo(new CampoMedico(0, campo.getItemAt(campo.getSelectedIndex())));
					Medico medico = new Medico(id, nombre.getText(), apellido.getText(),
							Integer.parseInt(nColegiado.getText()), new CampoMedico(result.get(0).getId_campo(), ""));

					if (MedicoDAO.editarMedico(medico)) {
						m1.mostrarMensajeSuccess("Editado correctamente.");
						frame.setVisible(false);
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la edición.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		};
		return editar;
	}

	// ELIMINAR PACIENTE
	public static ActionListener eliminarPaciente(JTable tablaPaciente) {
		ActionListener eliminar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				int row = tablaPaciente.getSelectedRow();
				int column = 0;
				String value = tablaPaciente.getModel().getValueAt(row, column).toString();
				Paciente paciente = new Paciente(Integer.parseInt(value), "", "", "",
						new Habitacion(0, new Pasillo(0)));
				try {
					if (PacienteDAO.eliminarPaciente(paciente)) {
						m1.mostrarMensajeSuccess("Eliminado correctamente.");
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la eliminación.");
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};
		return eliminar;
	}

	// ABRIR EDITAR PACIENTE
	public static ActionListener abrirEditarPaciente(JTable tabla) {
		ActionListener abrir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarPaciente m = new EditarPaciente();
				m.editarMedicoMostrar(tabla);
			}
		};
		return abrir;
	}

	// EDITAR PACIENTE
	public static ActionListener editarPaciente(int id, JTextField nombre, JTextField apellido, JTextField dni,
			JComboBox<String> habitacion, JFrame frame) {
		ActionListener editar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MensajeSuccess m1 = new MensajeSuccess();
				MensajeError m2 = new MensajeError();
				List<Habitacion> result = null;
				try {
					result = HabitacionDAO.selectOneHabitacion(new Habitacion(
							Integer.parseInt(habitacion.getItemAt(habitacion.getSelectedIndex())), new Pasillo(0)));
					Paciente paciente = new Paciente(id, nombre.getText(), apellido.getText(), dni.getText(),
							new Habitacion(Integer.parseInt(habitacion.getItemAt(habitacion.getSelectedIndex())),
									new Pasillo(0)));
					if (PacienteDAO.editarPaciente(paciente)) {
						m1.mostrarMensajeSuccess("Editado correctamente.");
						frame.setVisible(false);
					} else {
						m2.mostrarMensajeError("Ha ocurrido un error en la edición.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};
		return editar;
	}

	// SELECCIONAR CON CLICK DERECHO
	public static PopupMenuListener seleccionarClickDerecho(JTable tabla, JPopupMenu popUpMenuTabla) {
		PopupMenuListener seleccionar = new PopupMenuListener() {

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						int rowAtPoint = tabla
								.rowAtPoint(SwingUtilities.convertPoint(popUpMenuTabla, new Point(0, 0), tabla));
						if (rowAtPoint > -1) {
							tabla.setRowSelectionInterval(rowAtPoint, rowAtPoint);
						}
					}
				});
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub

			}
		};

		return seleccionar;
	}

}
