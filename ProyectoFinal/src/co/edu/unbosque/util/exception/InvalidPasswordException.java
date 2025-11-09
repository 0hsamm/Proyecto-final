package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando la contraseña ingresada no es válida.
 */
public class InvalidPasswordException extends Exception {

    /**
     * Constructor que muestra un mensaje indicando que la contraseña no es válida.
     */
    public InvalidPasswordException() {
        super("");
    }
}
