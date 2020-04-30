package Modelo;

public class Pasillo {

	int idPasillo;

	public Pasillo(int idPasillo) {
		super();
		this.idPasillo = idPasillo;
	}

	public int getIdPasillo() {
		return idPasillo;
	}

	public void setIdPasillo(int idPasillo) {
		this.idPasillo = idPasillo;
	}

	@Override
	public String toString() {
		return "Pasillo [idPasillo=" + idPasillo + "]";
	}
	
}
