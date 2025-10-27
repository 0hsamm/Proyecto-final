package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Administrador extends Usuario implements Serializable{

	public Administrador() {

	}

	public Administrador(String nombre, String apellido, String email, LocalDate fecha, String genero,
			Boolean esAdministrador, Boolean estaDisponible, String alias, String foto, Boolean esIncognito,
			int numLikes) {
		super(nombre, apellido, email, fecha, genero, esAdministrador, estaDisponible, alias, foto, esIncognito,
				numLikes);
	}

	public Administrador(String nombre, String apellido, String email, LocalDate fecha, String genero,
			Boolean esAdministrador) {
		super(nombre, apellido, email, fecha, genero, esAdministrador);
		// TODO Auto-generated constructor stub
	}
	
	public Administrador(Boolean estaDisponible, String alias, String foto, Boolean esIncognito, int numLikes) {
		super(estaDisponible, alias, foto, esIncognito, numLikes);
		// TODO Auto-generated constructor stub
	}

	
	
	

	

}
