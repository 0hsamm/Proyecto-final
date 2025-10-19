package co.edu.unbosque.model;

import java.time.LocalDate;

public class Hombre extends Persona{

	private int promedioIngMensual;
	private double estatura;
	private boolean esDivorciado;
	
	public Hombre() {
		
	}


	

	public Hombre(int promedioIngMensual, double estatura, boolean esDivorciado) {
		super();
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
		this.esDivorciado = esDivorciado;
	}




	public Hombre(String nombre, String alias, String email, LocalDate anio, String genero, int promedioIngMensual,
			double estatura, boolean esDivorciado) {
		super(nombre, alias, email, anio, genero);
		this.promedioIngMensual = promedioIngMensual;
		this.estatura = estatura;
		this.esDivorciado = esDivorciado;
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




	public boolean isEsDivorciado() {
		return esDivorciado;
	}




	public void setEsDivorciado(boolean esDivorciado) {
		this.esDivorciado = esDivorciado;
	}




	@Override
	public String toString() {
		return super.toString() + "\nPromedio de ingreso mensual: " + promedioIngMensual + "\nEstatura: " + estatura + "\nHa tenido algún divorcio?: " + esDivorciado;
	}
	

	
	
	
}
