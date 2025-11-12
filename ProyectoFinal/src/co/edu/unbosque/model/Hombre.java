package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Hombre extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1834043748497202826L;
	private int promedioIngMensual;
	private double estatura;
	
	public Hombre() {
		
	}


	public Hombre(int promedioIngMensual, double estatura) {
		super();
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}




	

	public Hombre(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento, String genero,
			boolean esAdministrador, int promedioIngMensual, double estatura) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public Hombre(boolean estaDisponible, String alias, String URLfoto, boolean esIncognito, int numLikes,
			int promedioIngMensual, double estatura) {
		super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public Hombre(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento, String genero,
			boolean esAdministrador, boolean estaDisponible, String alias, String uRLfoto, boolean esIncognito,
			int numLikes, int promedioIngMensual, double estatura) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador, estaDisponible, alias, uRLfoto,
				esIncognito, numLikes);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public Hombre(boolean estaDisponible, String alias, String URLfoto, boolean esIncognito, int numLikes) {
		super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
		// TODO Auto-generated constructor stub
	}


	public Hombre(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento, String genero,
			boolean esAdministrador, boolean estaDisponible, String alias, String uRLfoto, boolean esIncognito,
			int numLikes) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador, estaDisponible, alias, uRLfoto, esIncognito,
				numLikes);
		// TODO Auto-generated constructor stub
	}


	public Hombre(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento, String genero,
			boolean esAdministrador) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
		// TODO Auto-generated constructor stub
	}

	
	

	public int getPromedioIngMensual() {
		return promedioIngMensual;
	}


	public void setPromedioIngMensual(int promedioIngMensual) {
		this.promedioIngMensual = promedioIngMensual;
	}


	public double getEstatura() {
		return estatura;
	}


	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}




	@Override
	public String toString() {
		return super.toString() + "\nPromedio de ingreso mensual: " + promedioIngMensual + "\nEstatura: " + estatura;
	}




	


	
	
}
