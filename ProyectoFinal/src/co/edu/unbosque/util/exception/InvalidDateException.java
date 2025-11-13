package co.edu.unbosque.util.exception;

/*
 * Excepción que se lanza cuando una fecha ingresada no es válida.
 */
public class InvalidDateException extends Exception {

    /*
     * Constructor que crea la excepción con un mensaje vacío.
     */
    public InvalidDateException() {
        super("");
    }
}
