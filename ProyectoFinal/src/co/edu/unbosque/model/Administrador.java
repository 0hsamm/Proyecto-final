package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Administrador extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8434305256640674877L;

	
	
	
	public Administrador() {

	}

	public Administrador(String nombre, String apellido, String email, String contrasena, LocalDate fecha,
			String genero, boolean esAdministrador) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
	}


	
	

	

}
