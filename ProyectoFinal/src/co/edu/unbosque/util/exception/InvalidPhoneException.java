package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando el número de teléfono ingresado no es válido.
 */
public class InvalidPhoneException extends Exception {

    /**
     * Constructor que muestra un mensaje indicando que se debe ingresar un teléfono válido.
     */
    public InvalidPhoneException() {
        super("Ingrese un teléfono válido");
    }
}

