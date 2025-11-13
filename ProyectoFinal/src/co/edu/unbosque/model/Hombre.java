package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Representa un usuario de tipo Hombre dentro de la aplicación.
 * Extiende la clase Usuario e incluye atributos específicos como
 * el promedio de ingreso mensual y la estatura.
 * Implementa Serializable para permitir su almacenamiento.
 */
public class Hombre extends Usuario implements Serializable {

    /*
     * Identificador único de versión para la serialización de la clase.
     */
    private static final long serialVersionUID = -1834043748497202826L;

    private int promedioIngMensual;
    private double estatura;

    /*
     * Constructor vacío que crea un objeto Hombre sin inicializar atributos.
     */
    public Hombre() { }

    /*
     * Constructor que inicializa los atributos específicos del hombre.
     * 
     * @param promedioIngMensual ingreso mensual promedio
     * @param estatura estatura en metros
     */
    public Hombre(int promedioIngMensual, double estatura) {
        super();
        this.promedioIngMensual = promedioIngMensual;
        this.estatura = estatura;
    }

    /*
     * Constructor que inicializa los atributos heredados y propios.
     * 
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param email correo electrónico
     * @param contrasena contraseña
     * @param fechaNacimiento fecha de nacimiento
     * @param genero género del usuario
     * @param esAdministrador indica si es administrador
     * @param promedioIngMensual ingreso mensual promedio
     * @param estatura estatura en metros
     */
    public Hombre(String nombre, String apellido, String email, String contrasena,
                  LocalDate fechaNacimiento, String genero, boolean esAdministrador,
                  int promedioIngMensual, double estatura) {
        super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
        this.promedioIngMensual = promedioIngMensual;
        this.estatura = estatura;
    }

    /*
     * Constructor que inicializa atributos heredados del usuario visible/invisible
     * y los valores específicos del hombre.
     * 
     * @param estaDisponible disponibilidad del perfil
     * @param alias alias del usuario
     * @param URLfoto ruta de la foto de perfil
     * @param esIncognito estado de privacidad
     * @param numLikes número de likes
     * @param promedioIngMensual ingreso mensual promedio
     * @param estatura estatura en metros
     */
    public Hombre(boolean estaDisponible, String alias, String URLfoto,
                  boolean esIncognito, int numLikes,
                  int promedioIngMensual, double estatura) {
        super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
        this.promedioIngMensual = promedioIngMensual;
        this.estatura = estatura;
    }

    /*
     * Constructor que inicializa todos los campos heredados y propios.
     */
    public Hombre(String nombre, String apellido, String email, String contrasena,
                  LocalDate fechaNacimiento, String genero, boolean esAdministrador,
                  boolean estaDisponible, String alias, String uRLfoto,
                  boolean esIncognito, int numLikes, int promedioIngMensual, double estatura) {
        super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador,
              estaDisponible, alias, uRLfoto, esIncognito, numLikes);
        this.promedioIngMensual = promedioIngMensual;
        this.estatura = estatura;
    }

    /*
     * Constructor alterno basado solo en atributos de Usuario.
     */
    public Hombre(boolean estaDisponible, String alias, String URLfoto,
                  boolean esIncognito, int numLikes) {
        super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
    }

    /*
     * Constructor alterno que inicializa únicamente atributos heredados.
     */
    public Hombre(String nombre, String apellido, String email, String contrasena,
                  LocalDate fechaNacimiento, String genero, boolean esAdministrador) {
        super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
    }

    /*
     * Retorna el ingreso mensual promedio del hombre.
     * 
     * @return ingreso mensual promedio
     */
    public int getPromedioIngMensual() {
        return promedioIngMensual;
    }

    /*
     * Asigna el ingreso mensual promedio del hombre.
     * 
     * @param promedioIngMensual nuevo ingreso mensual promedio
     */
    public void setPromedioIngMensual(int promedioIngMensual) {
        this.promedioIngMensual = promedioIngMensual;
    }

    /*
     * Retorna la estatura del hombre.
     * 
     * @return estatura en metros
     */
    public double getEstatura() {
        return estatura;
    }

    /*
     * Asigna la estatura del hombre.
     * 
     * @param estatura nueva estatura en metros
     */
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    /*
     * Devuelve una representación en texto de este Hombre,
     * incluyendo los atributos heredados y los propios.
     * 
     * @return cadena con la información del hombre
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nPromedio de ingreso mensual: " + promedioIngMensual
                + "\nEstatura: " + estatura;
    }

}
