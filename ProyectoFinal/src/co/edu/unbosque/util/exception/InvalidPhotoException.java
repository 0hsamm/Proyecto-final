package co.edu.unbosque.util.exception;

/*
 * Excepción que se lanza cuando una foto ingresada no es válida.
 */
public class InvalidPhotoException extends Exception {

    /*
     * Constructor que crea la excepción con un mensaje vacío.
     */
    public InvalidPhotoException() {
        super("");
    }
}
