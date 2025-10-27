package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Mujer extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -442432088216894276L;
	private double estatura;
	private boolean esDivorciada;
	
	
	public Mujer() {
	
	}


	public Mujer(double estatura, boolean esDivorciada) {
		super();
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}


	public Mujer(Boolean estaDisponible, String alias, String URLfoto, Boolean esIncognito, int numLikes,
			double estatura, boolean esDivorciada) {
		super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}


	public Mujer(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			Boolean esAdministrador, Boolean estaDisponible, String alias, String uRLfoto, Boolean esIncognito,
			int numLikes, double estatura, boolean esDivorciada) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador, estaDisponible, alias, uRLfoto,
				esIncognito, numLikes);
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}


	public Mujer(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			Boolean esAdministrador, double estatura, boolean esDivorciada) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}


	public Mujer(Boolean estaDisponible, String alias, String URLfoto, Boolean esIncognito, int numLikes) {
		super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
		// TODO Auto-generated constructor stub
	}


	public Mujer(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			Boolean esAdministrador, Boolean estaDisponible, String alias, String uRLfoto, Boolean esIncognito,
			int numLikes) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador, estaDisponible, alias, uRLfoto, esIncognito,
				numLikes);
		// TODO Auto-generated constructor stub
	}


	public Mujer(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			Boolean esAdministrador) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
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
