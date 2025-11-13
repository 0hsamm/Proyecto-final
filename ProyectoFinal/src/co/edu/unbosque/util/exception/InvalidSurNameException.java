package co.edu.unbosque.util.exception;

/*
 * Excepción que se lanza cuando un apellido ingresado no es válido.
 */
public class InvalidSurNameException extends Exception {

    /*
     * Constructor que crea la excepción con un mensaje vacío.
     */
    public InvalidSurNameException() {
        super("");
    }
}
