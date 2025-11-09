package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando el usuario ingresado no es válido.
 */
public class InvalidUserException extends Exception {

    /**
     * Constructor que muestra un mensaje indicando que se debe ingresar un usuario válido.
     */
    public InvalidUserException() {
        super("Ingrese un usuario válido");
    }
}
