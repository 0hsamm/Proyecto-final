package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Representa un objeto de transferencia de datos (DTO) para una usuaria de tipo Mujer.
 * Extiende la clase Usuario e incluye atributos específicos como estatura y estado de divorcio.
 * Implementa Serializable para permitir su almacenamiento en archivos binarios.
 */
public class MujerDTO extends Usuario implements Serializable {

    /*
     * Identificador único de versión para la serialización.
     */
    private static final long serialVersionUID = -442432088216894276L;

    private double estatura;
    private boolean esDivorciada;

    /*
     * Constructor vacío que crea un objeto MujerDTO sin inicializar atributos.
     */
    public MujerDTO() {
    }

    /*
     * Constructor que inicializa los atributos propios del DTO.
     *
     * @param estatura estatura de la usuaria en metros
     * @param esDivorciada indica si ha tenido un divorcio
     */
    public MujerDTO(double estatura, boolean esDivorciada) {
        super();
        this.estatura = estatura;
        this.esDivorciada = esDivorciada;
    }

    /*
     * Constructor que inicializa atributos heredados y específicos.
     */
    public MujerDTO(boolean estaDisponible, String alias, String URLfoto, boolean esIncognito,
                    int numLikes, double estatura, boolean esDivorciada) {
        super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
        this.estatura = estatura;
        this.esDivorciada = esDivorciada;
    }

    /*
     * Constructor que inicializa todos los atributos heredados y propios.
     */
    public MujerDTO(String nombre, String apellido, String email, String contrasena,
                    LocalDate fechaNacimiento, String genero, boolean esAdministrador,
                    boolean estaDisponible, String alias, String uRLfoto, boolean esIncognito,
                    int numLikes, double estatura, boolean esDivorciada) {

        super(nombre, apellido, email, contrasena, fechaNacimiento, genero,
              esAdministrador, estaDisponible, alias, uRLfoto, esIncognito, numLikes);

        this.estatura = estatura;
        this.esDivorciada = esDivorciada;
    }

    /*
     * Constructor basado en información personal y atributos propios.
     */
    public MujerDTO(String nombre, String apellido, String email, String contrasena,
                    LocalDate fechaNacimiento, String genero, boolean esAdministrador,
                    double estatura, boolean esDivorciada) {

        super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
        this.estatura = estatura;
        this.esDivorciada = esDivorciada;
    }

    /*
     * Constructor basado únicamente en atributos heredados.
     */
    public MujerDTO(boolean estaDisponible, String alias, String URLfoto,
                    boolean esIncognito, int numLikes) {

        super(estaDisponible, alias, URLfoto, esIncognito, numLikes);
    }

    /*
     * Constructor basado en atributos heredados desde Persona y Usuario.
     */
    public MujerDTO(String nombre, String apellido, String email, String contrasena,
                    LocalDate fechaNacimiento, String genero, boolean esAdministrador,
                    boolean estaDisponible, String alias, String uRLfoto,
                    boolean esIncognito, int numLikes) {

        super(nombre, apellido, email, contrasena, fechaNacimiento, genero,
              esAdministrador, estaDisponible, alias, uRLfoto, esIncognito, numLikes);
    }

    /*
     * Constructor basado en información básica de Persona.
     */
    public MujerDTO(String nombre, String apellido, String email, String contrasena,
                    LocalDate fechaNacimiento, String genero, boolean esAdministrador) {

        super(nombre, apellido, email, contrasena, fechaNacimiento, genero, esAdministrador);
    }

    /*
     * Retorna la estatura de la usuaria.
     *
     * @return estatura en metros
     */
    public double getEstatura() {
        return estatura;
    }

    /*
     * Asigna la estatura de la usuaria.
     *
     * @param estatura nueva estatura en metros
     */
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    /*
     * Indica si la usuaria ha tenido un divorcio.
     *
     * @return true si ha tenido un divorcio, false si no
     */
    public boolean isEsDivorciada() {
        return esDivorciada;
    }

    /*
     * Asigna el estado de divorcio de la usuaria.
     *
     * @param esDivorciada nuevo estado de divorcio
     */
    public void setEsDivorciada(boolean esDivorciada) {
        this.esDivorciada = esDivorciada;
    }

    /*
     * Devuelve una representación en texto del objeto MujerDTO,
     * incluyendo información heredada y atributos propios.
     */
    @Override
    public String toString() {
        return super.toString()
                + "\nEstatura: " + estatura
                + "\nHa tenido algún divorcio?: " + esDivorciada;
    }

}
