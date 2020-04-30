package Modelo;

public class Paciente {
	
	int idPaciente;
	String nombre;
	String apellido;
	String dni;
	Habitacion habitacion;
	
	public Paciente(int idPaciente, String nombre, String apellido, String dni, Habitacion habitacion) {
		super();
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.habitacion = habitacion;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", habitacion=" + habitacion + "]";
	}

}
