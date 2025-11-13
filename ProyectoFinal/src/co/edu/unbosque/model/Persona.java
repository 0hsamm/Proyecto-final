package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/*
 * Clase abstracta que representa una persona en el sistema.
 * Maneja información básica de identificación, credenciales y rol de administrador.
 */
public abstract class Persona {

	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private LocalDate fechaNacimiento;
	private String genero;

	private boolean esAdministrador;

	/*
	 * Constructor por defecto de la clase Persona.
	 */
	public Persona() {

	}

	/*
	 * Constructor que inicializa algunos datos básicos de la persona.
	 *
	 * @param nombre nombre de la persona
	 * @param apellido apellido de la persona
	 * @param email correo electrónico de la persona
	 * @param fecha fecha de nacimiento de la persona
	 * @param genero género de la persona
	 * @param esAdministrador indica si la persona es administrador
	 */
	public Persona(String nombre, String apellido, String email, LocalDate fecha, String genero,
			Boolean esAdministrador) {

	}

	/*
	 * Constructor que inicializa todos los datos de la persona.
	 *
	 * @param nombre nombre de la persona
	 * @param apellido apellido de la persona
	 * @param email correo electrónico de la persona
	 * @param contrasena contraseña de la persona
	 * @param fechaNacimineto fecha de nacimiento de la persona
	 * @param genero género de la persona
	 * @param esAdministrador indica si la persona es administrador
	 */
	public Persona(String nombre, String apellido, String email, String contrasena, LocalDate fechaNacimineto, String genero,
			boolean esAdministrador) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		this.fechaNacimiento = fechaNacimineto;
		this.genero = genero;
		this.esAdministrador = esAdministrador;
	}

	/*
	 * Obtiene el nombre de la persona.
	 *
	 * @return nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/*
	 * Establece el nombre de la persona.
	 *
	 * @param nombre nuevo nombre de la persona
	 */
	public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

	/*
	 * Obtiene el apellido de la persona.
	 *
	 * @return apellido de la persona
	 */
	public String getApellido() {
		return apellido;
	}

	/*
	 * Establece el apellido de la persona.
	 *
	 * @param apellido nuevo apellido de la persona
	 */
	public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido.trim();
    }

	/*
	 * Obtiene el correo electrónico de la persona.
	 *
	 * @return correo electrónico de la persona
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * Establece el correo electrónico de la persona.
	 *
	 * @param email nuevo correo electrónico de la persona
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Obtiene la contraseña de la persona.
	 *
	 * @return contraseña de la persona
	 */
	public String getContrasena() {
		return contrasena;
	}

	/*
	 * Establece la contraseña de la persona.
	 *
	 * @param contrasena nueva contraseña de la persona
	 */
	public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
        }
        this.contrasena = contrasena;
    }

	/*
	 * Obtiene la fecha de nacimiento de la persona.
	 *
	 * @return fecha de nacimiento de la persona
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/*
	 * Establece la fecha de nacimiento de la persona.
	 *
	 * @param fechaNacimiento nueva fecha de nacimiento de la persona
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
        if (fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

	/*
	 * Obtiene el género de la persona.
	 *
	 * @return género de la persona
	 */
	public String getGenero() {
		return genero;
	}

	/*
	 * Establece el género de la persona.
	 *
	 * @param genero nuevo género de la persona
	 */
	public void setGenero(String genero) {
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("El género no puede estar vacío.");
        }
        this.genero = genero.trim();
    }

	/*
	 * Indica si la persona es administrador.
	 *
	 * @return true si la persona es administrador, false en caso contrario
	 */
	public boolean isEsAdministrador() {
		return esAdministrador;
	}

	/*
	 * Establece si la persona es administrador.
	 *
	 * @param esAdministrador valor que indica si la persona es administrador
	 */
	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}
	
	/*
	 * Calcula la edad de la persona en años a partir de la fecha de nacimiento.
	 *
	 * @return edad de la persona en años, o 0 si la fecha de nacimiento es nula
	 */
	public int calcularEdad() {
        if (fechaNacimiento == null) return 0;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

	/*
	 * Convierte una fecha en formato texto a un objeto LocalDate con el patrón dd/MM/yyyy.
	 *
	 * @param fechaTexto fecha en formato texto con el patrón dd/MM/yyyy
	 * @return fecha de nacimiento como objeto LocalDate
	 */
    public static LocalDate parseFecha(String fechaTexto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaTexto, formatter);
    }

	/*
	 * Genera una representación en texto de la persona con sus datos principales.
	 *
	 * @return cadena con la información de la persona
	 */
	@Override
	public String toString() {
		return "Nombre: " + nombre +
			       "\nApellido: " + apellido +
			       "\nEmail: " + email +
			       "\nContraseña: " + contrasena +
			       "\nFecha de nacimiento: " + fechaNacimiento +
			       "\nGénero: " + genero +
			       "\n¿Es administrador?: " + esAdministrador;
	}

}
