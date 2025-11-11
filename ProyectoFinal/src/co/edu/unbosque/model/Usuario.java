package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario extends Persona {

	private boolean estaDisponible;
	private String alias;
	private String UrlFoto;
	private boolean esIncognito;
	private int numLikes;

	private ArrayList<Usuario> likesDados;
	private ArrayList<Usuario> likesRecibidos;
	
	
	public Usuario() {
	}

	public Usuario(boolean estaDisponible, String alias, String URLfoto, boolean esIncognito, int numLikes) {
		super();
		this.estaDisponible = estaDisponible;
		this.alias = alias;
		this.UrlFoto = URLfoto;
		this.esIncognito = esIncognito;
		this.numLikes = numLikes;
	}

	public Usuario(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento,
			String genero, boolean esAdministrador, boolean estaDisponible, String alias, String uRLfoto,
			boolean esIncognito, int numLikes) {
		super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
		this.estaDisponible = estaDisponible;
		this.alias = alias;
		UrlFoto = uRLfoto;
		this.esIncognito = esIncognito;
		this.numLikes = numLikes;
	}

	public Usuario(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
			boolean esAdministrador) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
		// TODO Auto-generated constructor stub
	}

	public void darLike(Usuario receptor) {
	    if (receptor == null || receptor == this) return; 
	    if (likesDados == null) likesDados = new ArrayList<>();
	    if (likesRecibidos == null) likesRecibidos = new ArrayList<>();
	    if (receptor.likesRecibidos == null) receptor.likesRecibidos = new ArrayList<>();
	    if (receptor.likesDados == null) receptor.likesDados = new ArrayList<>();

	    // Evita duplicados
	    if (!likesDados.contains(receptor)) {
	        likesDados.add(receptor);
	        receptor.likesRecibidos.add(this);

	        
	        receptor.setNumLikes(receptor.getNumLikes() + 1);
	    }
	}

	public boolean haDadoLikeA(Usuario u) {
	    return likesDados != null && likesDados.contains(u);
	}

	
	
	
	public boolean isEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		if (alias == null || alias.isBlank()) {
			throw new IllegalArgumentException("El alias no puede estar vacío.");
		}
		this.alias = alias.trim();
	}

	public String getURLfoto() {
		return UrlFoto;
	}

	public void setURLFoto(String urlFoto) {
		if (urlFoto == null || !urlFoto.toLowerCase().endsWith(".jpg")) {
			throw new IllegalArgumentException("La foto debe ser un archivo con formato .jpg");
		}
		this.UrlFoto = urlFoto.trim();
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
	

	public ArrayList<Usuario> getLikesDados() {
		return likesDados;
	}

	public void setLikesDados(ArrayList<Usuario> likesDados) {
		this.likesDados = likesDados;
	}

	public ArrayList<Usuario> getLikesRecibidos() {
		return likesRecibidos;
	}

	public void setLikesRecibidos(ArrayList<Usuario> likesRecibidos) {
		this.likesRecibidos = likesRecibidos;
	}

	@Override
	public String toString() {
		return super.toString() + "\nEstá disponible?: " + estaDisponible + "\nAlias: " + alias + "\nFoto: " + UrlFoto
				+ "\nModo incognito?: " + esIncognito + "\nNúmero de likes: " + numLikes;
	}
	

}
