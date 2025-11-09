package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando el correo ingresado no es válido.
 */
public class InvalidEmailException extends Exception {

    /**
     * Constructor que muestra un mensaje indicando que se debe ingresar un correo válido.
     */
    public InvalidEmailException() {
        super("Ingrese un correo válido");
    }
}
