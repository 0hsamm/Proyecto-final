package co.edu.unbosque.model;

import java.time.LocalDate;

public abstract class Persona {

	private String nombre;
	private String usuario;
	private String email;
	private LocalDate anio;
	private String genero;
	private double estatura;
	
	
	public Persona() {
	
	}


	public Persona(String nombre, String usuario, String email, LocalDate anio, String genero, double estatura) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.email = email;
		this.anio = anio;
		this.genero = genero;
		this.estatura = estatura;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
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


	public double getEstatura() {
		return estatura;
	}


	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}


	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nUsuario: " + usuario + "\nEmail: " + email + "\nAño: " + anio
				+ "\nGenero: " + genero + "\nEstatura: " + estatura;
	}

	
	
}