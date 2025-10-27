package co.edu.unbosque.model;

import java.time.LocalDate;

public abstract class Persona {

	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private LocalDate fecha;
	private String genero;
	private boolean esAdministrador;
	
	
	public Persona() {
	
	}


	public Persona(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			boolean esAdministrador) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		this.fecha = fecha;
		this.genero = genero;
		this.esAdministrador = esAdministrador;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public String getApellido() {
		return apellido;
	}






	public void setApellido(String apellido) {
		this.apellido = apellido;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}



	public String getContrasena() {
		return contrasena;
	}






	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}






	public LocalDate getFecha() {
		return fecha;
	}






	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}






	public String getGenero() {
		return genero;
	}






	public void setGenero(String genero) {
		this.genero = genero;
	}





	public boolean isEsAdministrador() {
		return esAdministrador;
	}






	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}






	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nApellido: " + apellido + "\nEmail: " + email + "\nEmail: " + "\nContrasena" + contrasena +  "\nFecha: " + fecha
				+ "\nGenero: " + genero + "\nEs administrador?: " + esAdministrador;
	}




	
	
}