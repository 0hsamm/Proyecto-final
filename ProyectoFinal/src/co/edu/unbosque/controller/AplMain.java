package co.edu.unbosque.controller;

/*
 * Clase principal de la aplicación.
 * Inicia la ejecución creando el controlador y mostrando la interfaz gráfica.
 */
public class AplMain {

	/*
	 * Método principal que inicia la aplicación.
	 *
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		Controller c = new Controller();
		c.runGUI();
	}

}
