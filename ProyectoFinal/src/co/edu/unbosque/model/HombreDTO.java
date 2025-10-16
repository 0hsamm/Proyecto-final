package co.edu.unbosque.model;

import java.time.LocalDate;

public class HombreDTO extends Persona{

	private int promedioIngMensual;

	public HombreDTO() {
		
	}
	
	public HombreDTO(int promedioIngMensual) {
		super();
		this.promedioIngMensual = promedioIngMensual;
	}

	public HombreDTO(String nombre, String usuario, String email, LocalDate anio, String genero, double estatura,
			int promedioIngMensual) {
		super(nombre, usuario, email, anio, genero, estatura);
		this.promedioIngMensual = promedioIngMensual;
	}

	public HombreDTO(String nombre, String usuario, String email, LocalDate anio, String genero, double estatura) {
		super(nombre, usuario, email, anio, genero, estatura);
		// TODO Auto-generated constructor stub
	}

	public int getPromedioIngMensual() {
		return promedioIngMensual;
	}

	public void setPromedioIngMensual(int promedioIngMensual) {
		this.promedioIngMensual = promedioIngMensual;
	}

	@Override
	public String toString() {
		return super.toString() + "\nPromedio de los ingresos mensuales: " + promedioIngMensual;
	}
	
}
