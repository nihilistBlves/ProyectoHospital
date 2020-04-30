package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CampoMedicoDAO;
import Modelo.CampoMedico;
import Vista.Login;

public class Main {
	
	public static List<CampoMedico> leerCsvEinsertarEnList(String rutaFicheroLeer) {
		List<CampoMedico> listaCampos = new ArrayList<CampoMedico>();
		BufferedReader br = null;
		final String splitBy = ";";

		try {
			br = new BufferedReader(new FileReader(rutaFicheroLeer));
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] separados = line.split(splitBy);
				for (int i=0; i<separados.length; i++) {
					listaCampos.add(new CampoMedico(i+1, separados[i]));
				}
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}

		return listaCampos;
	}
	
	public static void insertarListaCamposEnBDD() {
		List<CampoMedico> campos = leerCsvEinsertarEnList("Ficheros/camposMedicos.csv");
		
		for (int i=0; i<campos.size(); i++) {
			CampoMedico campo = campos.get(i);
			try {
				CampoMedicoDAO.insertarCampo(campo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Login log = new Login();
		log.mostrarLogin();
		
	}

}
