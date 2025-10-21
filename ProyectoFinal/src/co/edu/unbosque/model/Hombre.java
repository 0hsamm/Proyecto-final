package co.edu.unbosque.model;

import java.awt.Image;
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



	public Hombre(String nombre, String apellido, String email, LocalDate fecha, String genero, Boolean esAdministrador,
			Boolean estaDisponible, String alias, Image foto, Boolean esIncognito, int numLikes, int promedioIngMensual,
			double estatura) {
		super(nombre, apellido, email, fecha, genero, esAdministrador, estaDisponible, alias, foto, esIncognito,
				numLikes);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}




	public Hombre(String nombre, String apellido, String email, LocalDate fecha, String genero, Boolean esAdministrador,
			Boolean estaDisponible, String alias, Image foto, Boolean esIncognito, int numLikes) {
		super(nombre, apellido, email, fecha, genero, esAdministrador, estaDisponible, alias, foto, esIncognito, numLikes);
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
