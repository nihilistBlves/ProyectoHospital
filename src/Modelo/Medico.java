package Modelo;

public class Medico {
	
	int idMedico;
	String nombre;
	String apellido;
	int numeroColegiado;
	CampoMedico campo;
	
	public Medico(int idMedico, String nombre, String apellido, int numeroColegiado, CampoMedico campo) {
		super();
		this.idMedico = idMedico;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroColegiado = numeroColegiado;
		this.campo = campo;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
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

	public CampoMedico getCampo() {
		return campo;
	}

	public void setCampo(CampoMedico campo) {
		this.campo = campo;
	}

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nombre=" + nombre + ", apellido=" + apellido + ", numeroColegiado="
				+ numeroColegiado + ", campo=" + campo + "]";
	}
	
	

}
