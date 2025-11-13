package co.edu.unbosque.util.exception;

/*
 * Excepción que se lanza cuando un nombre ingresado no es válido.
 */
public class InvalidNameException extends Exception {

    /*
     * Constructor que crea la excepción con un mensaje vacío.
     */
    public InvalidNameException() {
        super("");
    }
}
