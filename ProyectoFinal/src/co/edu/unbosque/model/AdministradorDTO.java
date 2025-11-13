package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Representa un objeto de transferencia de datos (DTO) para un administrador.
 * Extiende la clase Persona y hereda todos sus atributos.
 * Implementa Serializable para permitir su almacenamiento en archivos binarios.
 */
public class AdministradorDTO extends Persona implements Serializable {

    /*
     * Identificador único de versión para la serialización de la clase.
     */
    private static final long serialVersionUID = -8434305256640674877L;

    /*
     * Constructor vacío que crea un objeto AdministradorDTO sin inicializar atributos.
     */
    public AdministradorDTO() {
    }

    /*
     * Constructor que crea un AdministradorDTO inicializando todos los atributos heredados.
     * 
     * @param nombre nombre del administrador
     * @param apellido apellido del administrador
     * @param email correo electrónico del administrador
     * @param contrasena contraseña del administrador
     * @param fecha fecha de nacimiento
     * @param genero género del administrador
     * @param esAdministrador indica si el usuario es administrador
     */
    public AdministradorDTO(String nombre, String apellido, String email, String contrasena,
            LocalDate fecha, String genero, boolean esAdministrador) {
        super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
    }

    /*
     * Devuelve una representación en texto de este AdministradorDTO,
     * utilizando el método toString() de la clase Persona.
     * 
     * @return cadena con la información del administrador
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
