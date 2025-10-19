package co.edu.unbosque.model;

import java.time.LocalDate;

public class Mujer extends Persona{

	private boolean esDivorciada;
	
	public Mujer() {
	
	}

	public Mujer(boolean esDivorciada) {
		super();
		this.esDivorciada = esDivorciada;
	}

	public Mujer(String nombre, String usuario, String email, LocalDate anio, String genero, 
			boolean esDivorciada) {
		super(nombre, usuario, email, anio, genero);
		this.esDivorciada = esDivorciada;
	}

	public Mujer(String nombre, String usuario, String email, LocalDate anio, String genero) {
		super(nombre, usuario, email, anio, genero);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsDivorciada() {
		return esDivorciada;
	}

	public void setEsDivorciada(boolean esDivorciada) {
		this.esDivorciada = esDivorciada;
	}

	@Override
	public String toString() {
		return super.toString() + "\nHa tenido algún divorcio?: " + esDivorciada;
	}
	
	
	
}
