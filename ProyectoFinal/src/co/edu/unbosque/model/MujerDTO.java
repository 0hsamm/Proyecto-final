package co.edu.unbosque.model;

import java.awt.Image;
import java.time.LocalDate;

public class MujerDTO extends Usuario{

	private double estatura;
	private boolean esDivorciada;
	
	
	public MujerDTO() {
	
	}

	

	public MujerDTO(double estatura, boolean esDivorciada) {
		super();
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}







	public MujerDTO(String nombre, String apellido, String email, LocalDate fecha, String genero, Boolean esAdministrador,
			Boolean estaDisponible, String alias, Image foto, Boolean esIncognito, int numLikes, double estatura,
			boolean esDivorciada) {
		super(nombre, apellido, email, fecha, genero, esAdministrador, estaDisponible, alias, foto, esIncognito,
				numLikes);
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}



	public MujerDTO(String nombre, String apellido, String email, LocalDate fecha, String genero, Boolean esAdministrador,
			Boolean estaDisponible, String alias, Image foto, Boolean esIncognito, int numLikes) {
		super(nombre, apellido, email, fecha, genero, esAdministrador, estaDisponible, alias, foto, esIncognito, numLikes);
		// TODO Auto-generated constructor stub
	}



	public double getEstatura() {
		return estatura;
	}



	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}



	public boolean isEsDivorciada() {
		return esDivorciada;
	}



	public void setEsDivorciada(boolean esDivorciada) {
		this.esDivorciada = esDivorciada;
	}



	@Override
	public String toString() {
		return super.toString() +  "\nEstatura: " + estatura + "\nHa tenido algún divorcio?: " + esDivorciada;
	}



	
	
}
