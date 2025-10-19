package co.edu.unbosque.model;

import java.time.LocalDate;

public abstract class Persona {

	private String nombre;
	private String alias;
	private String email;
	private LocalDate anio;
	private String genero;

	
	
	public Persona() {
	
	}


	public Persona(String nombre, String alias, String email, LocalDate anio, String genero) {
		super();
		this.nombre = nombre;
		this.alias = alias;
		this.email = email;
		this.anio = anio;
		this.genero = genero;
	
	}
	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getAnio() {
		return anio;
	}


	public void setAnio(LocalDate anio) {
		this.anio = anio;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	


	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nAlias: " + alias + "\nEmail: " + email + "\nAño: " + anio
				+ "\nGenero: " + genero;
	}

	
	
}