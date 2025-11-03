package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class MujerDTO extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -442432088216894276L;
	private double estatura;
	private boolean esDivorciada;
	
	
	public MujerDTO() {
	
	}


	public MujerDTO(double estatura, boolean esDivorciada) {
		super();
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}


	public MujerDTO(boolean estaDisponible, String alias, String URLfoto, boolean esIncognito, int numLikes,
			double estatura, boolean esDivorciada) {
		super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}


	public MujerDTO(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento, String genero,
			boolean esAdministrador, boolean estaDisponible, String alias, String uRLfoto, boolean esIncognito,
			int numLikes, double estatura, boolean esDivorciada) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador, estaDisponible, alias, uRLfoto,
				esIncognito, numLikes);
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}


	public MujerDTO(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento, String genero,
			boolean esAdministrador, double estatura, boolean esDivorciada) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
		this.estatura = estatura;
		this.esDivorciada = esDivorciada;
	}


	public MujerDTO(boolean estaDisponible, String alias, String URLfoto, boolean esIncognito, int numLikes) {
		super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
		// TODO Auto-generated constructor stub
	}


	public MujerDTO(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento, String genero,
			boolean esAdministrador, boolean estaDisponible, String alias, String uRLfoto, boolean esIncognito,
			int numLikes) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador, estaDisponible, alias, uRLfoto, esIncognito,
				numLikes);
		// TODO Auto-generated constructor stub
	}


	public MujerDTO(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento, String genero,
			boolean esAdministrador) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
		// TODO Auto-generated constructor stub
	}


	public double getEstatura() {
		return estatura;
	}



	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}



	public boolean isEsDivorciada() {
		return esDivorciada;
	}



	public void setEsDivorciada(boolean esDivorciada) {
		this.esDivorciada = esDivorciada;
	}



	@Override
	public String toString() {
		return super.toString() +  "\nEstatura: " + estatura + "\nHa tenido algún divorcio?: " + esDivorciada;
	}



	
	
}
