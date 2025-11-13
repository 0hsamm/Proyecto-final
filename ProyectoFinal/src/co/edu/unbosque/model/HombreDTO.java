package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Representa un objeto de transferencia de datos (DTO) para un usuario de tipo Hombre.
 * Extiende la clase Usuario e incluye atributos específicos como
 * el promedio de ingreso mensual y la estatura.
 * Implementa Serializable para permitir su almacenamiento en archivos binarios.
 */
public class HombreDTO extends Usuario implements Serializable {

    /*
     * Identificador único de versión para la serialización de la clase.
     */
    private static final long serialVersionUID = -1834043748497202826L;

    private int promedioIngMensual;
    private double estatura;

    /*
     * Constructor vacío que crea un objeto HombreDTO sin inicializar atributos.
     */
    public HombreDTO() {
    }

    /*
     * Constructor que inicializa los atributos específicos del hombre.
     * 
     * @param promedioIngMensual ingreso mensual promedio
     * @param estatura estatura en metros
     */
    public HombreDTO(int promedioIngMensual, double estatura) {
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
    public HombreDTO(String nombre, String apellido, String email, String contrasena,
                     LocalDate fechaNacimiento, String genero, boolean esAdministrador,
                     int promedioIngMensual, double estatura) {
        super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
        this.promedioIngMensual = promedioIngMensual;
        this.estatura = estatura;
    }

    /*
     * Constructor que inicializa atributos heredados y específicos del DTO.
     * 
     * @param estaDisponible disponibilidad del perfil
     * @param alias alias del usuario
     * @param URLfoto ruta de la foto de perfil
     * @param esIncognito estado de privacidad
     * @param numLikes cantidad de likes
     * @param promedioIngMensual ingreso mensual promedio
     * @param estatura estatura en metros
     */
    public HombreDTO(boolean estaDisponible, String alias, String URLfoto,
                     boolean esIncognito, int numLikes,
                     int promedioIngMensual, double estatura) {
        super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
        this.promedioIngMensual = promedioIngMensual;
        this.estatura = estatura;
    }

    /*
     * Constructor que inicializa todos los atributos heredados y específicos.
     */
    public HombreDTO(String nombre, String apellido, String email, String contrasena,
                     LocalDate fechaNacimiento, String genero, boolean esAdministrador,
                     boolean estaDisponible, String alias, String uRLfoto, boolean esIncognito,
                     int numLikes, int promedioIngMensual, double estatura) {
        super(nombre, apellido, email, contrasena, fechaNacimiento, genero,
              esAdministrador, estaDisponible, alias, uRLfoto, esIncognito, numLikes);
        this.promedioIngMensual = promedioIngMensual;
        this.estatura = estatura;
    }

    /*
     * Constructor alterno basado únicamente en atributos de Usuario.
     */
    public HombreDTO(boolean estaDisponible, String alias, String URLfoto,
                     boolean esIncognito, int numLikes) {
        super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
    }

    /*
     * Constructor alterno que inicializa atributos heredados sin valores propios.
     */
    public HombreDTO(String nombre, String apellido, String email, String contrasena,
                     LocalDate fechaNacimiento, String genero, boolean esAdministrador,
                     boolean estaDisponible, String alias, String uRLfoto, boolean esIncognito,
                     int numLikes) {
        super(nombre, apellido, email, contrasena, fechaNacimiento, genero,
              esAdministrador, estaDisponible, alias, uRLfoto, esIncognito, numLikes);
    }

    /*
     * Constructor alterno basado únicamente en información de Persona.
     */
    public HombreDTO(String nombre, String apellido, String email, String contrasena,
                     LocalDate fecha, String genero, boolean esAdministrador) {
        super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
    }

    /*
     * Retorna el ingreso mensual promedio.
     * 
     * @return ingreso mensual promedio
     */
    public int getPromedioIngMensual() {
        return promedioIngMensual;
    }

    /*
     * Asigna el ingreso mensual promedio.
     * 
     * @param promedioIngMensual nuevo ingreso mensual promedio
     */
    public void setPromedioIngMensual(int promedioIngMensual) {
        this.promedioIngMensual = promedioIngMensual;
    }

    /*
     * Retorna la estatura del usuario.
     * 
     * @return estatura en metros
     */
    public double getEstatura() {
        return estatura;
    }

    /*
     * Asigna la estatura del usuario.
     * 
     * @param estatura nueva estatura en metros
     */
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    /*
     * Devuelve una representación en texto del HombreDTO,
     * incluyendo atributos heredados y los propios.
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
