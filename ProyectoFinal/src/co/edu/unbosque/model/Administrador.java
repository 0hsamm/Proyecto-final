package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Administrador extends Persona implements Serializable{

	public Administrador() {

	}

	public Administrador(String nombre, String apellido, String email, LocalDate fecha, String genero,
			Boolean esAdministrador) {
		super(nombre, apellido, email, fecha, genero, esAdministrador);
	}



	
	
	

	

}
