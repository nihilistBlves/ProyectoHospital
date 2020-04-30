package Modelo;

public class Habitacion {
	
	int idHabitacion;
	Pasillo pasillo;
	
	public Habitacion(int idHabitacion, Pasillo pasillo) {
		super();
		this.idHabitacion = idHabitacion;
		this.pasillo = pasillo;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public Pasillo getPasillo() {
		return pasillo;
	}

	public void setPasillo(Pasillo pasillo) {
		this.pasillo = pasillo;
	}

	@Override
	public String toString() {
		return "Habitacion [idHabitacion=" + idHabitacion + "], Pasillo [idPasillo=" + pasillo.getIdPasillo() + "]";
	}
	
	

}
