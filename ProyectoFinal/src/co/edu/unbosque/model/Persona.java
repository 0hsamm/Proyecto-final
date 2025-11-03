package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Persona {

	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private LocalDate fechaNacimiento;
	private String genero;

	private boolean esAdministrador;

	public Persona() {

	}

	public Persona(String nombre, String apellido, String email, LocalDate fecha, String genero,
			Boolean esAdministrador) {

	}

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido.trim();
    }
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
        }
        this.contrasena = contrasena;
    }

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
        if (fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

	public String getGenero() {
		return genero;
	}

	 public void setGenero(String genero) {
	        if (genero == null || genero.isBlank()) {
	            throw new IllegalArgumentException("El género no puede estar vacío.");
	        }
	        this.genero = genero.trim();
	    }

	public boolean isEsAdministrador() {
		return esAdministrador;
	}

	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}
	
	//Metodos de utilidad
	public int calcularEdad() {
        if (fechaNacimiento == null) return 0;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public static LocalDate parseFecha(String fechaTexto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaTexto, formatter);
    }

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