package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;

public class HombreDAO implements DAO<HombreDTO> {

	private ArrayList<Hombre> listaHombres;
	private final String FILE_NAME = "Hombre.csv";
	private final String SERIAL_FILE_NAME = "Hombre.bin";

	public HombreDAO() {
		listaHombres = new ArrayList<>();
		cargarDesdeArchivoSerializado();

		// Fallback si vinieron nulos desde el .bin
		boolean camposNulos = listaHombres.stream()
				.anyMatch(h -> h == null || h.getAlias() == null || h.getContrasena() == null);

		if (listaHombres.isEmpty() || camposNulos) {
			System.out.println("[WARN] BIN inválido o con campos nulos. Cargando desde CSV...");
			listaHombres.clear();
			leerDesdeArchivoDeTexto(FILE_NAME); // <-- tu método existente
			escribirEnArchivoSerializado(); // <-- re-serializa con el modelo actual
			System.out.println("[INFO] Rehidratación OK: " + listaHombres.size() + " hombres.");
		}
	}

	@Override
	public void create(HombreDTO temp) {

		Hombre newData = DataMapper.convertirHombreDTOAHombre(temp);
		listaHombres.add(newData);
		escribirEnArchivoDeTexto();
		escribirEnArchivoSerializado();

	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listaHombres.size()) {
			return false;
		} else {
			listaHombres.remove(index);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean update(int index, HombreDTO temp) {
		if (index < 0 || index >= listaHombres.size()) {
			return false;
		} else {
			Hombre newData = DataMapper.convertirHombreDTOAHombre(temp);
			listaHombres.set(index, newData);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public String showAll() {
		StringBuilder sb = new StringBuilder();
		ArrayList<HombreDTO> listaTemp = DataMapper.listaHombres(listaHombres);

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
		return listaHombres.size();
	}

	@Override
	public void leerDesdeArchivoDeTexto(String url) {
		String contenido = FileHandler.leerDesdeArchivoDeTexto(url);

		if (contenido == null || contenido.isBlank()) {
			System.out.println("[INFO] Archivo de Hombres vacío o inexistente.");
			return;
		}

		String[] filas = contenido.split("\n");
		int linea = 0;

		for (String fila : filas) {
			linea++;
			if (fila.trim().isEmpty())
				continue; // Salta líneas vacías

			try {
				// Mantiene campos vacíos con split -1
				String[] columna = fila.split(";", -1);
				if (columna.length < 14) {
					System.err.println("[WARN] Línea " + linea + " inválida (faltan columnas): " + fila);
					continue;
				}

				// Validar campos básicos
				String nombre = columna[0].trim();
				String apellido = columna[1].trim();
				String email = columna[2].trim();
				String contrasena = columna[3] == null ? "" : columna[3].trim();

				// Si la contraseña no cumple, salta la fila
				if (contrasena.isEmpty() || contrasena.length() < 6) {
					System.err.println("[WARN] Línea " + linea + " omitida (contraseña inválida): " + contrasena);
					continue;
				}

				Hombre temp = new Hombre();
				temp.setNombre(nombre);
				temp.setApellido(apellido);
				temp.setEmail(email);
				temp.setContrasena(contrasena);

				try {
					temp.setFechaNacimiento(LocalDate.parse(columna[4].trim()));
				} catch (Exception e) {
					System.err.println("[WARN] Línea " + linea + " - Fecha inválida, usando fecha actual.");
					temp.setFechaNacimiento(LocalDate.now());
				}

				temp.setGenero(columna[5].trim());
				temp.setEsAdministrador(Boolean.parseBoolean(columna[6].trim()));
				temp.setEstaDisponible(Boolean.parseBoolean(columna[7].trim()));
				temp.setAlias(columna[8].trim());

				try {
					temp.setURLFoto(columna[9].trim());
				} catch (Exception e) {
					System.err.println("[WARN] Línea " + linea + " - URL foto inválida, se deja vacía.");
					temp.setURLFoto("default.jpg");
				}

				temp.setEsIncognito(Boolean.parseBoolean(columna[10].trim()));

				try {
					temp.setNumLikes(Integer.parseInt(columna[11].trim()));
				} catch (Exception e) {
					temp.setNumLikes(0);
				}

				try {
					temp.setPromedioIngMensual(Integer.parseInt(columna[12].trim()));
				} catch (Exception e) {
					temp.setPromedioIngMensual(0);
				}

				try {
					temp.setEstatura(Double.parseDouble(columna[13].trim()));
				} catch (Exception e) {
					temp.setEstatura(0);
				}

				listaHombres.add(temp);

			} catch (Exception e) {
				System.err.println("[WARN] Error al procesar línea " + linea + ": " + e.getMessage());
				// No lanzamos excepción, solo saltamos la línea
			}
		}

		System.out.println("[INFO] Archivo de Hombres cargado correctamente. Total: " + listaHombres.size());
	}

	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder sb = new StringBuilder();

		for (Hombre h : listaHombres) {
			String pass = (h.getContrasena() == null) ? "" : h.getContrasena();
			String fecha = (h.getFechaNacimiento() == null) ? "" : h.getFechaNacimiento().toString();

			String nombre = (h.getNombre() == null) ? "" : h.getNombre();
			String apellido = (h.getApellido() == null) ? "" : h.getApellido();
			String email = (h.getEmail() == null) ? "" : h.getEmail();
			String genero = (h.getGenero() == null) ? "" : h.getGenero();
			String alias = (h.getAlias() == null) ? "" : h.getAlias();
			String urlFoto = (h.getURLfoto() == null) ? "" : h.getURLfoto();

			sb.append(nombre).append(';');
			sb.append(apellido).append(';');
			sb.append(email).append(';');
			sb.append(pass).append(';');
			sb.append(fecha).append(';');
			sb.append(genero).append(';');
			sb.append(h.isEsAdministrador()).append(';');
			sb.append(h.isEstaDisponible()).append(';');
			sb.append(alias).append(';');
			sb.append(urlFoto).append(';');
			sb.append(h.isEsIncognito()).append(';');
			sb.append(h.getNumLikes()).append(';');
			sb.append(h.getPromedioIngMensual()).append(';');
			sb.append(h.getEstatura()).append('\n');
		}

		FileHandler.escribirEnArchivoDeTexto(FILE_NAME, sb.toString());
	}

	@SuppressWarnings("unchecked")
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaHombres = (ArrayList<Hombre>) contenido;
		} else {
			listaHombres = new ArrayList<>();
		}
	}

	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaHombres);
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public ArrayList<Hombre> getListaHombres() {
		return listaHombres;
	}

	public void setListaHombres(ArrayList<Hombre> listaHombres) {
		this.listaHombres = listaHombres;
	}
	
	public void selectionSortMenorAMayor(Hombre[] listaHombres) {

		int n = listaHombres.length;
		for (int i = 0; i < n; i++) {
			int min_idx = i;

			for (int j = i + 1; j < n; j++) {

				int ingreso1 = listaHombres[j].getPromedioIngMensual();
				int ingreso2 = listaHombres[min_idx].getPromedioIngMensual();
				if (ingreso1 == 0)
					continue;
				if (ingreso2 == 0) {
					min_idx = j; 
					continue;
				}

				if (ingreso1 < ingreso2) {
					min_idx = j;
				}
			}

			if (min_idx != i) {
				Hombre temp = listaHombres[i];
				listaHombres[i] = listaHombres[min_idx];
				listaHombres[min_idx] = temp;
			}
		}

	}

	public void mostrarIngresosMenorAMayor() {
		
		Hombre[] temp = new Hombre[listaHombres.size()];
		
		for (int i = 0; i < temp.length; i++) {
			
			temp[i] = listaHombres.get(i);
			
		}
		
		selectionSortMenorAMayor(temp);
		
		for (int i = 0; i < listaHombres.size(); i++) {
			
			listaHombres.set(i, temp[i]);
			
		}
	}
	
	public void selectionSortMayorAMenor(Hombre[] listaHombres) {

		int n = listaHombres.length;
		for (int i = 0; i < n; i++) {
			int min_idx = i;

			for (int j = i + 1; j < n; j++) {

				int ingreso2 = listaHombres[j].getPromedioIngMensual();
				int ingreso1 = listaHombres[min_idx].getPromedioIngMensual();
				if (ingreso1 == 0)
					continue;
				if (ingreso2 == 0) {
					min_idx = j; 
					continue;
				}

				if (ingreso1 < ingreso2) {
					min_idx = j;
				}
			}

			if (min_idx != i) {
				Hombre temp = listaHombres[i];
				listaHombres[i] = listaHombres[min_idx];
				listaHombres[min_idx] = temp;
			}
		}

	}

	public void mostrarIngresosMayorAMenor() {
		
		Hombre[] temp = new Hombre[listaHombres.size()];
		
		for (int i = 0; i < temp.length; i++) {
			
			temp[i] = listaHombres.get(i);
			
		}
		
		selectionSortMayorAMenor(temp);
		
		for (int i = 0; i < listaHombres.size(); i++) {
			
			listaHombres.set(i, temp[i]);
			
		}
	}
	
	
}
