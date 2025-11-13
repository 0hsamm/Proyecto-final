package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Usuario extends Persona {

    private boolean estaDisponible;
    private String alias;
    private String UrlFoto;
    private boolean esIncognito;
    private int numLikes;

    private ArrayList<Usuario> likesDados;
    private ArrayList<Usuario> likesRecibidos;

    public Usuario() { }

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
    }

    private void ensureCollections() {
        if (likesDados == null) likesDados = new ArrayList<>();
        if (likesRecibidos == null) likesRecibidos = new ArrayList<>();
    }

    private static String safeAlias(Usuario u) {
        return (u == null || u.getAlias() == null) ? null : u.getAlias().trim().toLowerCase();
    }

    public synchronized boolean darLike(Usuario receptor) {
        if (receptor == null || receptor == this) return false;
        this.ensureCollections();
        receptor.ensureCollections();
        if (likesDados.contains(receptor)) return false;
        likesDados.add(receptor);
        receptor.likesRecibidos.add(this);
        receptor.setNumLikes(receptor.getNumLikes() + 1);
        return true;
    }

    public boolean haDadoLikeA(Usuario u) {
        this.ensureCollections();
        return likesDados.contains(u);
    }

    public boolean isEstaDisponible() { return estaDisponible; }
    public void setEstaDisponible(Boolean estaDisponible) { this.estaDisponible = estaDisponible; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) {
        if (alias == null || alias.isBlank()) throw new IllegalArgumentException("El alias no puede estar vacío.");
        this.alias = alias.trim();
    }

    public String getURLfoto() { return UrlFoto; }
    public void setURLFoto(String urlFoto) {
        if (urlFoto == null || urlFoto.trim().isEmpty()) throw new IllegalArgumentException("Debe seleccionar una foto");
        if (!(urlFoto.toLowerCase().endsWith(".jpg") || urlFoto.toLowerCase().endsWith(".jpeg") || urlFoto.toLowerCase().endsWith(".png")))
            throw new IllegalArgumentException("La foto debe ser un archivo con formato .jpg, .jpeg o .png");
        this.UrlFoto = urlFoto.trim();
    }

    public boolean isEsIncognito() { return esIncognito; }
    public void setEsIncognito(boolean esIncognito) { this.esIncognito = esIncognito; }

    public int getNumLikes() { return numLikes; }
    public void setNumLikes(int numLikes) { this.numLikes = numLikes; }

    public ArrayList<Usuario> getLikesDados() {
        this.ensureCollections();
        return likesDados;
    }
    public void setLikesDados(ArrayList<Usuario> likesDados) { this.likesDados = likesDados; }

    public ArrayList<Usuario> getLikesRecibidos() {
        this.ensureCollections();
        return likesRecibidos;
    }
    public void setLikesRecibidos(ArrayList<Usuario> likesRecibidos) { this.likesRecibidos = likesRecibidos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario that = (Usuario) o;
        return Objects.equals(safeAlias(this), safeAlias(that));
    }

    @Override
    public int hashCode() { return Objects.hash(safeAlias(this)); }

    @Override
    public String toString() {
        return super.toString() + "\nEstá disponible?: " + estaDisponible + "\nAlias: " + alias + "\nFoto: " + UrlFoto
                + "\nModo incognito?: " + esIncognito + "\nNúmero de likes: " + numLikes;
    }
}
