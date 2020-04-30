package Modelo;

public class Enfermero {
	
	int idEnfermero;
	String nombre;
	String apellido;
	int numeroColegiado;
	
	public Enfermero(int idEnfermero, String nombre, String apellido, int numeroColegiado) {
		super();
		this.idEnfermero = idEnfermero;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroColegiado = numeroColegiado;
	}

	public int getIdEnfermero() {
		return idEnfermero;
	}

	public void setIdEnfermero(int idEnfermero) {
		this.idEnfermero = idEnfermero;
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

	public int getNumeroColegiado() {
		return numeroColegiado;
	}

	public void setNumeroColegiado(int numeroColegiado) {
		this.numeroColegiado = numeroColegiado;
	}

	@Override
	public String toString() {
		return "Enfermero [idEnfermero=" + idEnfermero + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", numeroColegiado=" + numeroColegiado + "]";
	}
	
	
	
	

}
