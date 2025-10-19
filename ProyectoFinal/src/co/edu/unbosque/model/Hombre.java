package co.edu.unbosque.model;

import java.time.LocalDate;

public class Hombre extends Persona{

	private int promedioIngMensual;
	private double estatura;
	
	
	public Hombre() {
		
	}


	public Hombre(int promedioIngMensual, double estatura) {
		super();
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public Hombre(String nombre, String alias, String email, LocalDate anio, String genero, int promedioIngMensual,
			double estatura) {
		super(nombre, alias, email, anio, genero);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
	}


	public Hombre(String nombre, String alias, String email, LocalDate anio, String genero) {
		super(nombre, alias, email, anio, genero);
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
