package co.edu.unbosque.util.exception;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que valida diferentes tipos de datos de entrada
 * y lanza excepciones personalizadas cuando no cumplen con el formato requerido.
 */
public class LanzadorDeExcepcion {

    /**
     * Verifica si un correo electrónico es válido.
     *
     * @param email correo a validar
     * @throws InvalidEmailException si el correo no cumple con el formato
     */
    public static void verificarEmail(String email) throws InvalidEmailException {
       /* Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mat = patron.matcher(email);

        if (!mat.find()) {
            throw new InvalidEmailException();
        }*/
    }



    /**
     * Verifica si una contraseña cumple con el tamaño mínimo.
     *
     * @param contrasena contraseña a validar
     * @throws InvalidPasswordException si la contraseña es demasiado corta
     */
    public static void verificarTamanoContrasena(String contrasena) throws InvalidPasswordException {
    	if (contrasena.length() < 8) {
            throw new InvalidPasswordException();
        }
    }

   
    

    public static void verificarNombre(String nombre) throws InvalidNameException {
    	 if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
    	        throw new InvalidNameException();
    	    }
    }
    
    public static void verificarApellido(String apellido) throws InvalidSurNameException {
    	if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
	        throw new InvalidSurNameException();
	    }
    }
    
   
    
    public static void verificarAltura(double altura) throws InvalidHeightException {
    	if(altura < 0) {
    		throw new InvalidHeightException();
    	}
    	
    }
    
    public static void verificarDouble(double valor) throws InvalidDoubleException {
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new InvalidDoubleException();
        }
    }

    public static void verificarEdad(LocalDate edad) throws InvalidDateException {

    	    LocalDate hoy = LocalDate.now();
    	    Period anio = Period.between(edad, hoy);

    	    if (anio.getYears() < 18) {
    	        throw new InvalidDateException();
    	    }
    
    }
    
    public static void verificarFoto(String url) throws InvalidPhotoException {
    	
    	/*if(url == null || url.trim().isEmpty()) {
    		throw new InvalidPhotoException();
    	}*/
    }
    
    
}
