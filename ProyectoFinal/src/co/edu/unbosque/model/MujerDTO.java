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

	public MujerDTO(String nombre, String alias, String email, LocalDate anio, String genero, 
			boolean esDivorciada) {
		super(nombre, alias, email, anio, genero);
		this.esDivorciada = esDivorciada;
	}

	public MujerDTO(String nombre, String alias, String email, LocalDate anio, String genero  ) {
		super(nombre, alias, email, anio, genero);
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
