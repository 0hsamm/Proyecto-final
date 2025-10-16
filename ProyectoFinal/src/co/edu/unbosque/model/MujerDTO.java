package co.edu.unbosque.model;

import java.time.LocalDate;

public class MujerDTO extends Persona{

	private boolean esDivorciada;
	
	public MujerDTO() {
	
	}

	public MujerDTO(boolean esDivorciada) {
		super();
		this.esDivorciada = esDivorciada;
	}

	public MujerDTO(String nombre, String usuario, String email, LocalDate anio, String genero, double estatura,
			boolean esDivorciada) {
		super(nombre, usuario, email, anio, genero, estatura);
		this.esDivorciada = esDivorciada;
	}

	public MujerDTO(String nombre, String usuario, String email, LocalDate anio, String genero, double estatura) {
		super(nombre, usuario, email, anio, genero, estatura);
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
