package co.edu.unbosque.util.exception;

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
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mat = patron.matcher(email);

        if (!mat.find()) {
            throw new InvalidEmailException();
        }
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

    /**
     * Verifica si un número de teléfono es válido.
     *
     * @param telefono número de teléfono a validar
     * @throws InvalidPhoneException si el teléfono no cumple con el formato
     */
    public static void verificarTelefono(String telefono) throws InvalidPhoneException {
        String telTrim = telefono.trim();

        if ((telefono.length() < 10) && !telefono.matches("^[0-9]")) {
            throw new InvalidPhoneException();
        }
    }
    
    
    public static void verificarPalabra(String palabra) throws InvalidWordException {
    	 if (!palabra.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
    	        throw new InvalidWordException();
    	    }
    }
    
}
