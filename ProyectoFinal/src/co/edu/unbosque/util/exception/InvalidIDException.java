package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando el ID ingresado no es válido.
 */
public class InvalidIDException extends Exception {

    /**
     * Constructor que muestra un mensaje indicando que se debe ingresar un ID válido.
     */
    public InvalidIDException() {
        super("Ingrese un ID válido");
    }
}
