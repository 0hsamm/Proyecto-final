package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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
                return "";
            }

            StringBuilder contenido = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    // 🔹 Limpieza de caracteres invisibles y BOM
                    linea = linea.replace("\uFEFF", "").replace("\r", "").trim();
                    if (!linea.isEmpty()) {
                        contenido.append(linea).append("\n");
                    }
                }
            }

            return contenido.toString();
        } catch (IOException e) {
            System.out.println("No se pudo leer bien el archivo de texto");
            System.out.println(e.getMessage());
            return "";
        }
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
    public static Object leerDesdeArchivoSerializado(String fileName) {
        ObjectInputStream ois = null;
        try {
            File file = new File(fileName);
            if (!file.exists() || file.length() == 0) {
                System.out.println("Archivo binario vacío o no existente: " + fileName);
                return null;
            }

            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            return obj;

        } catch (EOFException e) {
            System.out.println("Archivo binario vacío: " + fileName);
            return null;

        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo binario");
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
