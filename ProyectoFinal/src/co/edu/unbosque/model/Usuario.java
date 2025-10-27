package co.edu.unbosque.model;	

import java.time.LocalDate;

public abstract class Usuario extends Persona {

	private boolean estaDisponible;
	private String alias;
	private String URLfoto;
	private boolean esIncognito;
	private int numLikes;

	
	public Usuario() {
	}


	public Usuario(boolean estaDisponible, String alias, String URLfoto, boolean esIncognito, int numLikes) {
		super();
		this.estaDisponible = estaDisponible;
		this.alias = alias;
		this.URLfoto = URLfoto;
		this.esIncognito = esIncognito;
		this.numLikes = numLikes;
	}








	public Usuario(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			boolean esAdministrador, boolean estaDisponible, String alias, String uRLfoto, boolean esIncognito,
			int numLikes) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
		this.estaDisponible = estaDisponible;
		this.alias = alias;
		URLfoto = uRLfoto;
		this.esIncognito = esIncognito;
		this.numLikes = numLikes;
	}

	
	
	

	public Usuario(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			boolean esAdministrador) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
		// TODO Auto-generated constructor stub
	}


	public Boolean isEstaDisponible() {
		return estaDisponible;
	}




	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}




	public String getAlias() {
		return alias;
	}




	public void setAlias(String alias) {
		this.alias = alias;
	}




	public String getURLfoto() {
		return URLfoto;
	}




	public void setURLfoto(String foto) {
		this.URLfoto = foto;
	}









	public boolean isEsIncognito() {
		return esIncognito;
	}


	public void setEsIncognito(boolean esIncognito) {
		this.esIncognito = esIncognito;
	}


	public int getNumLikes() {
		return numLikes;
	}




	public void setNumLikes(int numLikes) {
		this.numLikes = numLikes;
	}




	@Override
	public String toString() {
		return super.toString() + "\nEstá disponible?: " + estaDisponible +  "\nAlias: " + alias + "\nFoto: " + URLfoto + "\nModo incognito?: " + esIncognito + "\nNúmero de likes: " + numLikes;
	}
	
	
	
	
}
