package Modelo;

public class CampoMedico {

	int idCampo;
	String nombreCampo;
	
	public CampoMedico(int idCampo, String nombreCampo) {
		super();
		this.idCampo = idCampo;
		this.nombreCampo = nombreCampo;
	}

	public int getId_campo() {
		return idCampo;
	}

	public void setId_campo(int id_campo) {
		this.idCampo = id_campo;
	}

	public String getNombre_campo() {
		return nombreCampo;
	}

	public void setNombre_campo(String nombre_campo) {
		this.nombreCampo = nombre_campo;
	}

	@Override
	public String toString() {
		return "CampoMedico [id_campo=" + idCampo + ", nombre_campo=" + nombreCampo + "]";
	}
	
	
	
}
