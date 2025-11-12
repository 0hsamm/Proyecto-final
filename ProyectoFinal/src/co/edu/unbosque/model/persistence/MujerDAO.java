
package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

public class MujerDAO implements DAO<MujerDTO>{

	private ArrayList<Mujer> listaMujeres;
	private final String FILE_NAME = "Mujer.csv";
	private final String SERIAL_FILE_NAME = "Mujer.bin";
	
	public MujerDAO() {
	    listaMujeres = new ArrayList<>();
	    cargarDesdeArchivoSerializado();

	    boolean camposNulos = listaMujeres.stream()
	        .anyMatch(m -> m == null || m.getAlias() == null || m.getContrasena() == null);

	    if (listaMujeres.isEmpty() || camposNulos) {
	        System.out.println("[WARN] BIN inválido o con campos nulos. Cargando desde CSV...");
	        listaMujeres.clear();
	        leerDesdeArchivoDeTexto(FILE_NAME);
	        escribirEnArchivoSerializado();
	        System.out.println("[INFO] Rehidratación OK: " + listaMujeres.size() + " mujeres.");
	    }
	}
	
	@Override
	public void create(MujerDTO temp) {
		
		Mujer newData = DataMapper.convertirMujerDTOAMujer(temp);
		listaMujeres.add(newData);
		escribirEnArchivoDeTexto();
		escribirEnArchivoSerializado();
		
	}

	@Override
	public boolean delete(int index) {
		if(index < 0 || index >= listaMujeres.size()) {
			return false;
		}else {
			listaMujeres.remove(index);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean update(int index, MujerDTO temp) {
		if(index < 0 || index >= listaMujeres.size()) {
			return false;
		}else {
			Mujer newData = DataMapper.convertirMujerDTOAMujer(temp);
			listaMujeres.set(index, newData);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public String showAll() {
		StringBuilder sb = new StringBuilder();
		ArrayList<MujerDTO> listaTemp = DataMapper.listaMujeres(listaMujeres);
		
		for (int i = 0; i < listaTemp.size(); i++) {
			sb.append(i + 1);
			sb.append(" - ");
			sb.append(listaTemp.get(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public int count() {
		return listaMujeres.size();
	}

	@Override
	public void leerDesdeArchivoDeTexto(String url) {
	    String contenido = FileHandler.leerDesdeArchivoDeTexto(url);
	    if (contenido == null || contenido.isBlank()) {
	        System.out.println("[INFO] Archivo de Mujeres vacío o inexistente.");
	        return;
	    }

	    String[] filas = contenido.split("\n");
	    int linea = 0;

	    for (String fila : filas) {
	        linea++;
	        if (fila.trim().isEmpty()) continue;

	        try {
	            // Usa -1 para conservar campos vacíos al final
	            String[] c = fila.split(";", -1);
	            if (c.length < 14) {
	                System.err.println("[WARN] Línea " + linea + " inválida (faltan columnas): " + fila);
	                continue;
	            }

	            // Orden de columnas según tu código actual:
	            // 0 nombre, 1 apellido, 2 email, 3 contrasena, 4 fechaNac, 5 genero,
	            // 6 estaDisponible, 7 esAdministrador, 8 alias, 9 urlFoto,
	            // 10 esIncognito, 11 numLikes, 12 estatura, 13 esDivorciada

	            String nombre       = c[0].trim();
	            String apellido     = c[1].trim();
	            String email        = c[2].trim();
	            String contrasena   = c[3] == null ? "" : c[3].trim();

	            // Validación dura de contraseña
	            if (contrasena.isEmpty() || contrasena.length() < 6) {
	                System.err.println("[WARN] Línea " + linea + " omitida (contraseña inválida).");
	                continue;
	            }

	            Mujer temp = new Mujer();
	            temp.setNombre(nombre);
	            temp.setApellido(apellido);
	            temp.setEmail(email);
	            temp.setContrasena(contrasena);

	            // Fecha de nacimiento
	            try {
	                temp.setFechaNacimiento(LocalDate.parse(c[4].trim())); // formato ISO yyyy-MM-dd
	            } catch (Exception e) {
	                System.err.println("[WARN] Línea " + linea + " - Fecha inválida, usando fecha actual.");
	                temp.setFechaNacimiento(LocalDate.now());
	            }

	            temp.setGenero(c[5].trim());

	            // Booleans con fallback
	            try { temp.setEstaDisponible(Boolean.parseBoolean(c[6].trim())); }
	            catch (Exception e) { temp.setEstaDisponible(false); }

	            try { temp.setEsAdministrador(Boolean.parseBoolean(c[7].trim())); }
	            catch (Exception e) { temp.setEsAdministrador(false); }

	            temp.setAlias(c[8].trim());

	            // URL foto (si no cumple tu validación, deja un placeholder)
	            try {
	                String urlFoto = c[9].trim();
	                temp.setURLFoto(urlFoto.isEmpty() ? "default.jpg" : urlFoto);
	            } catch (Exception e) {
	                System.err.println("[WARN] Línea " + linea + " - URL foto inválida, se asigna default.");
	                temp.setURLFoto("default.jpg");
	            }

	            try { temp.setEsIncognito(Boolean.parseBoolean(c[10].trim())); }
	            catch (Exception e) { temp.setEsIncognito(false); }

	            // Números con fallback
	            try { temp.setNumLikes(Integer.parseInt(c[11].trim())); }
	            catch (Exception e) { temp.setNumLikes(0); }

	            try { temp.setEstatura(Double.parseDouble(c[12].trim())); }
	            catch (Exception e) { temp.setEstatura(0.0); }

	            try { temp.setEsDivorciada(Boolean.parseBoolean(c[13].trim())); }
	            catch (Exception e) { temp.setEsDivorciada(false); }

	            listaMujeres.add(temp);

	        } catch (Exception e) {
	            System.err.println("[WARN] Error al procesar línea " + linea + ": " + e.getMessage());
	            // sigue con la siguiente
	        }
	    }

	    System.out.println("[INFO] Archivo de Mujeres cargado. Total: " + listaMujeres.size());
	}

	@Override
	public void escribirEnArchivoDeTexto() {
	    StringBuilder sb = new StringBuilder();

	    for (Mujer m : listaMujeres) {
	        String pass = (m.getContrasena() == null) ? "" : m.getContrasena();
	        String fecha = (m.getFechaNacimiento() == null) ? "" : m.getFechaNacimiento().toString();

	        String nombre   = (m.getNombre() == null) ? "" : m.getNombre();
	        String apellido = (m.getApellido() == null) ? "" : m.getApellido();
	        String email    = (m.getEmail() == null) ? "" : m.getEmail();
	        String genero   = (m.getGenero() == null) ? "" : m.getGenero();
	        String alias    = (m.getAlias() == null) ? "" : m.getAlias();
	        String urlFoto  = (m.getURLfoto() == null) ? "" : m.getURLfoto();

	        sb.append(nombre).append(';');
	        sb.append(apellido).append(';');
	        sb.append(email).append(';');
	        sb.append(pass).append(';');
	        sb.append(fecha).append(';');
	        sb.append(genero).append(';');
	        sb.append(m.isEstaDisponible()).append(';');
	        sb.append(m.isEsAdministrador()).append(';');
	        sb.append(alias).append(';');
	        sb.append(urlFoto).append(';');
	        sb.append(m.isEsIncognito()).append(';');
	        sb.append(m.getNumLikes()).append(';');
	        sb.append(m.getEstatura()).append(';');
	        sb.append(m.isEsDivorciada()).append('\n');
	    }

	    FileHandler.escribirEnArchivoDeTexto(FILE_NAME, sb.toString());
	}

	 @SuppressWarnings("unchecked")
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaMujeres = (ArrayList<Mujer>) contenido;
		} else {
			listaMujeres = new ArrayList<>();
		}
	}

	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaMujeres);
	}

	public ArrayList<Mujer> getListaMujeres() {
		return listaMujeres;
	}

	public void setListaMujeres(ArrayList<Mujer> listaMujeres) {
		this.listaMujeres = listaMujeres;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

}
