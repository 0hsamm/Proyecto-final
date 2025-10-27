package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class HombreDTO extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1834043748497202826L;
	private int promedioIngMensual;
	private double estatura;
	
	public HombreDTO() {
		
	}


	public HombreDTO(int promedioIngMensual, double estatura) {
		super();
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}




	

	public HombreDTO(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			Boolean esAdministrador, int promedioIngMensual, double estatura) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public HombreDTO(Boolean estaDisponible, String alias, String URLfoto, Boolean esIncognito, int numLikes,
			int promedioIngMensual, double estatura) {
		super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public HombreDTO(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			Boolean esAdministrador, Boolean estaDisponible, String alias, String uRLfoto, Boolean esIncognito,
			int numLikes, int promedioIngMensual, double estatura) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador, estaDisponible, alias, uRLfoto,
				esIncognito, numLikes);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public HombreDTO(Boolean estaDisponible, String alias, String URLfoto, Boolean esIncognito, int numLikes) {
		super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
		// TODO Auto-generated constructor stub
	}


	public HombreDTO(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			Boolean esAdministrador, Boolean estaDisponible, String alias, String uRLfoto, Boolean esIncognito,
			int numLikes) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador, estaDisponible, alias, uRLfoto, esIncognito,
				numLikes);
		// TODO Auto-generated constructor stub
	}


	public HombreDTO(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			Boolean esAdministrador) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
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
