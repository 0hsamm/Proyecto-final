package co.edu.unbosque.model;

import java.awt.Image;
import java.time.LocalDate;

public class HombreDTO extends Usuario{

	private int promedioIngMensual;
	private double estatura;
	
	public HombreDTO () {
		
	}


	public HombreDTO (int promedioIngMensual, double estatura) {
		super();
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}



	public HombreDTO (String nombre, String apellido, String email, LocalDate fecha, String genero, Boolean esAdministrador,
			Boolean estaDisponible, String alias, Image foto, Boolean esIncognito, int numLikes, int promedioIngMensual,
			double estatura) {
		super(nombre, apellido, email, fecha, genero, esAdministrador, estaDisponible, alias, foto, esIncognito,
				numLikes);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}




	public HombreDTO (String nombre, String apellido, String email, LocalDate fecha, String genero, Boolean esAdministrador,
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
