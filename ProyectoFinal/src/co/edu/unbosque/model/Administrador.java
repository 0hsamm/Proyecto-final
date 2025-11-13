package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Representa un administrador dentro del sistema Bostinder.
 * Extiende la clase Persona y hereda sus atributos y comportamientos.
 * Implementa Serializable para permitir su almacenamiento y recuperación en archivos binarios.
 */
public class Administrador extends Persona implements Serializable {

	/*
	 * Identificador único de versión para la serialización de la clase.
	 */
	private static final long serialVersionUID = -8434305256640674877L;

	/*
	 * Constructor vacío que crea un objeto Administrador sin inicializar atributos.
	 */
	public Administrador() {
	}

	/*
	 * Constructor que crea un administrador inicializando todos los atributos heredados.
	 * 
	 * @param nombre nombre del administrador
	 * @param apellido apellido del administrador
	 * @param email correo electrónico del administrador
	 * @param contrasena contraseña de acceso del administrador
	 * @param fecha fecha de nacimiento
	 * @param genero género del administrador
	 * @param esAdministrador indica si el usuario es administrador (true)
	 */
	public Administrador(String nombre, String apellido, String email, String contrasena,
			LocalDate fecha, String genero, boolean esAdministrador) {
		super(nombre, apellido, email, contrasena, fecha, genero, esAdministrador);
	}

	/*
	 * Retorna una representación en texto del administrador,
	 * utilizando el método toString() de la clase Persona.
	 * 
	 * @return cadena con la información del administrador
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
