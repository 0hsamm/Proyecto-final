package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

/**
 * Clase para manejar archivos de varias formas.
 * Permite leer y escribir texto en archivos, guardar y cargar objetos serializados,
 * y cargar archivos de propiedades para configuraciones.
 * Todos los métodos son estáticos, no requiere instanciación.
 */
public class FileHandler {

    public static Scanner sc;
    public static File archivo;
    public static PrintWriter escritor;
    public static Scanner lector;
    public static FileInputStream fis;
    public static ObjectInputStream ois;
    public static FileOutputStream fos;
    public static ObjectOutputStream oos;
    public static Properties prop;

    /**
     * Escribe texto en un archivo. Reemplaza el contenido si existe.
     * Crea el archivo si no existe.
     *
     * @param url ruta del archivo
     * @param contenido texto a escribir
     */
    public static void escribirEnArchivoDeTexto(String url, String contenido) {
        try {
            archivo = new File(url);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            escritor = new PrintWriter(archivo);
            escritor.println(contenido);
            escritor.close();
        } catch (IOException e) {
            System.out.println("Algo salió mal al escribir el archivo");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lee todo el contenido de un archivo de texto.
     * Crea el archivo vacío si no existe.
     *
     * @param url ruta del archivo
     * @return contenido del archivo o null si ocurre un error
     */
    public static String leerDesdeArchivoDeTexto(String url) {
        try {
            archivo = new File(url);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            sc = new Scanner(archivo);
            String contenido = "";
            while (sc.hasNext()) {
                contenido += sc.nextLine() + "\n";
            }
            sc.close();
            return contenido;
        } catch (IOException e) {
            System.out.println("No se pudo leer bien el archivo de texto");
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Guarda un objeto en un archivo binario (serializado).
     * Crea el archivo si no existe y reemplaza el contenido previo.
     *
     * @param url ruta del archivo
     * @param contenido objeto a guardar
     */
    public static void escribirEnArchivoSerializado(String url, Object contenido) {
        try {
            archivo = new File(url);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(contenido);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo binario");
            e.printStackTrace();
        }
    }

    /**
     * Lee un objeto guardado en un archivo binario.
     * Crea el archivo vacío si no existe.
     *
     * @param url ruta del archivo
     * @return objeto leído o null si ocurre un error
     */
    public static Object leerDesdeArchivoSerializado(String url) {
        archivo = new File(url);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            Object contenido = ois.readObject();
            ois.close();
            fis.close();
            return contenido;
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo binario");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("El objeto guardado no se pudo convertir");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Carga un archivo de propiedades (.properties).
     * Crea el archivo vacío si no existe.
     *
     * @param url ruta del archivo
     * @return objeto Properties con los datos o null si falla
     */
    public static Properties cargarArchivoDePropiedades(String url) {
        archivo = new File(url);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            prop = new Properties();
            prop.load(new FileInputStream(archivo));
            return prop;
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de propiedades");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
