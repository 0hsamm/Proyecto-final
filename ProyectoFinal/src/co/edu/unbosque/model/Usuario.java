package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/*
 * Clase abstracta que representa un usuario del sistema.
 * Extiende Persona y añade información relacionada con su alias,
 * foto de perfil, disponibilidad, modo incógnito y gestión de likes.
 */
public abstract class Usuario extends Persona {

    private boolean estaDisponible;
    private String alias;
    private String UrlFoto;
    private boolean esIncognito;
    private int numLikes;

    private ArrayList<Usuario> likesDados;
    private ArrayList<Usuario> likesRecibidos;

    /*
     * Constructor por defecto de Usuario.
     */
    public Usuario() { }

    /*
     * Constructor que inicializa datos básicos del usuario.
     *
     * @param estaDisponible indica si el usuario está disponible
     * @param alias alias del usuario
     * @param URLfoto ruta de la foto del usuario
     * @param esIncognito indica si el usuario está en modo incógnito
     * @param numLikes número de likes recibidos
     */
    public Usuario(boolean estaDisponible, String alias, String URLfoto, boolean esIncognito, int numLikes) {
        super();
        this.estaDisponible = estaDisponible;
        this.alias = alias;
        this.UrlFoto = URLfoto;
        this.esIncognito = esIncognito;
       	this.numLikes = numLikes;
    }

    /*
     * Constructor que inicializa todos los datos de un usuario.
     *
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param email correo del usuario
     * @param contrasena contraseña del usuario
     * @param fechaNacimiento fecha de nacimiento
     * @param genero género del usuario
     * @param esAdministrador indica si es administrador
     * @param estaDisponible indica disponibilidad del usuario
     * @param alias alias del usuario
     * @param uRLfoto ruta de la foto del usuario
     * @param esIncognito indica si está en modo incógnito
     * @param numLikes número de likes recibidos
     */
    public Usuario(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimiento,
                   String genero, boolean esAdministrador, boolean estaDisponible, String alias, String uRLfoto,
                   boolean esIncognito, int numLikes) {
        super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
        this.estaDisponible = estaDisponible;
        this.alias = alias;
        this.UrlFoto = uRLfoto;
        this.esIncognito = esIncognito;
        this.numLikes = numLikes;
    }

    /*
     * Constructor que inicializa datos heredados de Persona.
     *
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param email correo del usuario
     * @param contrasena contraseña del usuario
     * @param fecha fecha de nacimiento
     * @param genero género del usuario
     * @param esAdministrador indica si es administrador
     */
    public Usuario(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String genero,
                   boolean esAdministrador) {
        super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
    }

    /*
     * Garantiza que las listas de likes estén inicializadas antes de usarse.
     */
    private void ensureCollections() {
        if (likesDados == null) likesDados = new ArrayList<>();
        if (likesRecibidos == null) likesRecibidos = new ArrayList<>();
    }

    /*
     * Limpia y normaliza el alias de un usuario.
     *
     * @param u usuario del cual se obtiene el alias
     * @return alias seguro en minúsculas o null
     */
    private static String safeAlias(Usuario u) {
        return (u == null || u.getAlias() == null) ? null : u.getAlias().trim().toLowerCase();
    }

    /*
     * Permite que un usuario le dé like a otro.
     *
     * @param receptor usuario que recibe el like
     * @return true si el like fue dado exitosamente, false si no
     */
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

    /*
     * Verifica si este usuario ha dado like a otro.
     *
     * @param u usuario a verificar
     * @return true si ya le ha dado like, false en caso contrario
     */
    public boolean haDadoLikeA(Usuario u) {
        this.ensureCollections();
        return likesDados.contains(u);
    }

    /*
     * Indica si el usuario está disponible.
     *
     * @return true si está disponible, false si no
     */
    public boolean isEstaDisponible() { return estaDisponible; }

    /*
     * Establece si el usuario está disponible.
     *
     * @param estaDisponible nuevo estado de disponibilidad
     */
    public void setEstaDisponible(Boolean estaDisponible) { this.estaDisponible = estaDisponible; }

    /*
     * Obtiene el alias del usuario.
     *
     * @return alias del usuario
     */
    public String getAlias() { return alias; }

    /*
     * Establece el alias del usuario.
     *
     * @param alias nuevo alias del usuario
     */
    public void setAlias(String alias) {
        if (alias == null || alias.isBlank()) throw new IllegalArgumentException("El alias no puede estar vacío.");
        this.alias = alias.trim();
    }

    /*
     * Obtiene la URL de la foto del usuario.
     *
     * @return ruta de la foto del usuario
     */
    public String getURLfoto() { return UrlFoto; }

    /*
     * Establece la URL de la foto del usuario.
     *
     * @param urlFoto nueva ruta de la foto
     */
    public void setURLFoto(String urlFoto) {
        if (urlFoto == null || urlFoto.trim().isEmpty()) throw new IllegalArgumentException("Debe seleccionar una foto");
        if (!(urlFoto.toLowerCase().endsWith(".jpg") || urlFoto.toLowerCase().endsWith(".jpeg") || urlFoto.toLowerCase().endsWith(".png")))
            throw new IllegalArgumentException("La foto debe ser un archivo con formato .jpg, .jpeg o .png");
        this.UrlFoto = urlFoto.trim();
    }

    /*
     * Indica si el usuario está en modo incógnito.
     *
     * @return true si está en modo incógnito, false si no
     */
    public boolean isEsIncognito() { return esIncognito; }

    /*
     * Establece si el usuario está en modo incógnito.
     *
     * @param esIncognito nuevo estado de incógnito
     */
    public void setEsIncognito(boolean esIncognito) { this.esIncognito = esIncognito; }

    /*
     * Obtiene el número de likes del usuario.
     *
     * @return número de likes
     */
    public int getNumLikes() { return numLikes; }

    /*
     * Establece el número de likes del usuario.
     *
     * @param numLikes nuevo número de likes
     */
    public void setNumLikes(int numLikes) { this.numLikes = numLikes; }

    /*
     * Obtiene la lista de likes dados por el usuario.
     *
     * @return lista de usuarios que recibieron like
     */
    public ArrayList<Usuario> getLikesDados() {
        this.ensureCollections();
        return likesDados;
    }

    /*
     * Establece la lista de likes dados.
     *
     * @param likesDados nueva lista de likes dados
     */
    public void setLikesDados(ArrayList<Usuario> likesDados) { this.likesDados = likesDados; }

    /*
     * Obtiene la lista de likes recibidos por el usuario.
     *
     * @return lista de usuarios que dieron like
     */
    public ArrayList<Usuario> getLikesRecibidos() {
        this.ensureCollections();
        return likesRecibidos;
    }

    /*
     * Establece la lista de likes recibidos.
     *
     * @param likesRecibidos nueva lista de likes recibidos
     */
    public void setLikesRecibidos(ArrayList<Usuario> likesRecibidos) { this.likesRecibidos = likesRecibidos; }

    /*
     * Compara usuarios por su alias normalizado.
     *
     * @param o objeto a comparar
     * @return true si los alias son iguales, false si no
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario that = (Usuario) o;
        return Objects.equals(safeAlias(this), safeAlias(that));
    }

    /*
     * Genera un hash basado en el alias del usuario.
     *
     * @return valor hash del alias
     */
    @Override
    public int hashCode() { return Objects.hash(safeAlias(this)); }

    /*
     * Genera una representación en texto del usuario.
     *
     * @return cadena con la información del usuario
     */
    @Override
    public String toString() {
        return super.toString() + "\nEstá disponible?: " + estaDisponible + "\nAlias: " + alias + "\nFoto: " + UrlFoto
                + "\nModo incognito?: " + esIncognito + "\nNúmero de likes: " + numLikes;
    }
}
