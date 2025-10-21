package co.edu.unbosque.model;	

import java.awt.Image;
import java.time.LocalDate;

public abstract class Usuario extends Persona {

	private Boolean estaDisponible;
	private String alias;
	private Image foto;
	private Boolean esIncognito;
	private int numLikes;
	//codigo de validación (preguntazrle a dieguito)
	
	public Usuario() {
	}

	
	
	
	public Usuario(Boolean estaDisponible, String alias, Image foto, Boolean esIncognito, int numLikes) {
		super();
		this.estaDisponible = estaDisponible;
		this.alias = alias;
		this.foto = foto;
		this.esIncognito = esIncognito;
		this.numLikes = numLikes;
	}




	public Usuario(String nombre, String apellido, String email, LocalDate fecha, String genero,
			Boolean esAdministrador, Boolean estaDisponible, String alias, Image foto, Boolean esIncognito,
			int numLikes) {
		super(nombre, apellido, email, fecha, genero, esAdministrador);
		this.estaDisponible = estaDisponible;
		this.alias = alias;
		this.foto = foto;
		this.esIncognito = esIncognito;
		this.numLikes = numLikes;
	}




	public Usuario(String nombre, String apellido, String email, LocalDate fecha, String genero,
			Boolean esAdministrador) {
		super(nombre, apellido, email, fecha, genero, esAdministrador);
		// TODO Auto-generated constructor stub
	}




	public Boolean getEstaDisponible() {
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




	public Image getFoto() {
		return foto;
	}




	public void setFoto(Image foto) {
		this.foto = foto;
	}




	public Boolean getEsIncognito() {
		return esIncognito;
	}




	public void setEsIncognito(Boolean esIncognito) {
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
		return super.toString() + "\nEstá disponible?: " + estaDisponible +  "\nAlias: " + alias + "\nFoto: " + foto + "\nModo incognito?: " + esIncognito + "\nNúmero de likes: " + numLikes;
	}
	
	
	
	
}
