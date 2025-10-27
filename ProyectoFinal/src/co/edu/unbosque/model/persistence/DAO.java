package co.edu.unbosque.model.persistence;

/**
 * Interfaz genérica para operaciones básicas de acceso a datos.
 * Permite crear, eliminar, actualizar, mostrar y contar registros,
 * así como leer y escribir en archivos de texto.
 *
 * @param <E> tipo de objeto que manejará la clase que implemente esta interfaz
 */
public interface DAO<E> {

    /**
     * Agrega un nuevo elemento.
     *
     * @param newData objeto de tipo E que se va a guardar
     */
    void create(E newData);

    /**
     * Elimina un elemento según su posición.
     *
     * @param index posición del elemento a eliminar
     * @return true si se eliminó, false si no
     */
    boolean delete(int index);

    /**
     * Actualiza un elemento en la lista según su posición.
     *
     * @param index   posición del elemento a actualizar
     * @param newData objeto con los nuevos datos
     * @return true si se actualizó, false si no
     */
    boolean update(int index, E newData);

    /**
     * Muestra todos los elementos en formato de texto.
     *
     * @return cadena con la información de todos los elementos
     */
    String showAll();

    /**
     * Devuelve la cantidad de elementos guardados.
     *
     * @return número de elementos
     */
    int count();

    /**
     * Lee los datos desde un archivo de texto.
     *
     * @param url nombre o ruta del archivo
     */
    void leerDesdeArchivoDeTexto(String url);

    /**
     * Escribe los datos en un archivo de texto.
     */
    void escribirEnArchivoDeTexto();
    
    
    void cargarDesdeArchivoSerializado();
    
    void escribirEnArchivoSerializado();
    
    }
