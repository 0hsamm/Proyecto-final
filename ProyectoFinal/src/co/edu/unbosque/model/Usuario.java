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
    private ArrayList<Usuario> matches; 

   

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
    }

    
    // Helpers internos
   

    private void ensureCollections() {
        if (likesDados == null) likesDados = new ArrayList<>();
        if (likesRecibidos == null) likesRecibidos = new ArrayList<>();
        if (matches == null) matches = new ArrayList<>();
    }

    private static String safeAlias(Usuario u) {
        return (u == null || u.getAlias() == null) ? null : u.getAlias().trim().toLowerCase();
    }

 
    // Lógica social: Like / Dislike / Match
  

    /** 
     * Da like a 'receptor'. 
     * @return true si se genera MATCH mutuo 
     */
    public synchronized boolean darLike(Usuario receptor) {
        if (receptor == null || receptor == this) return false;

        this.ensureCollections();
        receptor.ensureCollections();

        // Evitar duplicado
        if (!likesDados.contains(receptor)) {
            likesDados.add(receptor);
            receptor.likesRecibidos.add(this);
            receptor.setNumLikes(receptor.getNumLikes() + 1);
        }

        // ¿Mutuo?
        boolean receptorMeDioLike = receptor.likesDados.contains(this);
        if (receptorMeDioLike) {
            if (!this.matches.contains(receptor)) this.matches.add(receptor);
            if (!receptor.matches.contains(this)) receptor.matches.add(this);
            return true; // MATCH
        }
        return false; // Like unilateral
    }

    /** 
     * Marca dislike sobre 'receptor'. 
     * Elimina like previo y rompe match si existía. 
     */
    public synchronized void darDislike(Usuario receptor) {
        if (receptor == null || receptor == this) return;

        this.ensureCollections();
        receptor.ensureCollections();

        // Si yo le había dado like, retirarlo y ajustar contador
        if (likesDados.remove(receptor)) {
            receptor.likesRecibidos.remove(this);
            receptor.setNumLikes(Math.max(0, receptor.getNumLikes() - 1));
        }

        // Si había match, romperlo en ambos lados
        if (this.matches.remove(receptor)) {
            receptor.matches.remove(this);
        }

        // (Opcional futuro) Si deseas registrar dislikes explícitos, crea ArrayList<Usuario> dislikesDados.
    }

    /** 
     * Verifica si hay match mutuo con otro usuario 
     */
    public boolean tieneMatchCon(Usuario otro) {
        this.ensureCollections();
        return matches.contains(otro);
    }

    public boolean haDadoLikeA(Usuario u) {
        this.ensureCollections();
        return likesDados.contains(u);
    }


    // Getters / Setters


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
        if (urlFoto == null || urlFoto.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar una foto");
        }

       
        if (!(urlFoto.toLowerCase().endsWith(".jpg")
                || urlFoto.toLowerCase().endsWith(".jpeg")
                || urlFoto.toLowerCase().endsWith(".png"))) {
            throw new IllegalArgumentException("La foto debe ser un archivo con formato .jpg, .jpeg o .png");
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
        this.ensureCollections();
        return likesDados;
    }

    public void setLikesDados(ArrayList<Usuario> likesDados) {
        this.likesDados = likesDados;
    }

    public ArrayList<Usuario> getLikesRecibidos() {
        this.ensureCollections();
        return likesRecibidos;
    }

    public void setLikesRecibidos(ArrayList<Usuario> likesRecibidos) {
        this.likesRecibidos = likesRecibidos;
    }

    public ArrayList<Usuario> getMatches() {
        this.ensureCollections();
        return matches;
    }

    public void setMatches(ArrayList<Usuario> matches) {
        this.matches = matches;
    }


    // Igualdad por alias (clave para contains/remove)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario that = (Usuario) o;
        return Objects.equals(safeAlias(this), safeAlias(that));
    }

    @Override
    public int hashCode() {
        return Objects.hash(safeAlias(this));
    }


    @Override
    public String toString() {
        return super.toString() + "\nEstá disponible?: " + estaDisponible + "\nAlias: " + alias + "\nFoto: " + UrlFoto
                + "\nModo incognito?: " + esIncognito + "\nNúmero de likes: " + numLikes;
    }
}
