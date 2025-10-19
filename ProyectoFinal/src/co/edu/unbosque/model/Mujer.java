package co.edu.unbosque.model;

import java.time.LocalDate;

public class Mujer extends Persona{

	private int promedioIngMensual;
	private double estatura;
	private boolean esDivorciada;
	
	public Mujer() {
	
	}

	

	public Mujer(int promedioIngMensual, double estatura, boolean esDivorciada) {
		super();
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}



	public Mujer(String nombre, String alias, String email, LocalDate anio, String genero, int promedioIngMensual,
			double estatura, boolean esDivorciada) {
		super(nombre, alias, email, anio, genero);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}



	public Mujer(String nombre, String alias, String email, LocalDate anio, String genero) {
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



	public boolean isEsDivorciada() {
		return esDivorciada;
	}

	public void setEsDivorciada(boolean esDivorciada) {
		this.esDivorciada = esDivorciada;
	}

	@Override
	public String toString() {
		return super.toString() + "\nPromedio de ingreso mensual: " + promedioIngMensual + "\nEstatura: " + estatura + "\nHa tenido algún divorcio?: " + esDivorciada;
	}
	
	
	
}
