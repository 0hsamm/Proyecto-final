package co.edu.unbosque.model;

import java.time.LocalDate;

public class HombreDTO extends Persona{

	private int promedioIngMensual;
	private double estatura;
	
	
	public HombreDTO() {
		
	}


	public HombreDTO(int promedioIngMensual, double estatura) {
		super();
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public HombreDTO(String nombre, String usuario, String email, LocalDate anio, String genero, int promedioIngMensual,
			double estatura) {
		super(nombre, usuario, email, anio, genero);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public HombreDTO(String nombre, String usuario, String email, LocalDate anio, String genero) {
		super(nombre, usuario, email, anio, genero);
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
		return "\nPromedio de ingreso mensual: " + promedioIngMensual + "\nEstatura: " + estatura;
	}
	

	
	
	
}
