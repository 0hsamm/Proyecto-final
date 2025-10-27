package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Hombre;

public class AdministradorDAO implements DAO<Administrador>{

	private ArrayList<Administrador> listaAdministradores;
	private final String FILE_NAME = "Hombre.csv";
	private final String SERIAL_FILE_NAME = "Hombre.bin";
	
	public AdministradorDAO() {
		listaAdministradores = new ArrayList<Administrador>();
		leerDesdeArchivoDeTexto(FILE_NAME);
		cargarDesdeArchivoSerializado();
	}

	
	
	@Override
	public void create(Administrador newData) {
		listaAdministradores.add(newData);
		escribirEnArchivoDeTexto();
		cargarDesdeArchivoSerializado();
		
	}

	@Override
	public boolean delete(int index) {
		if(index < 0 || index >= listaAdministradores.size()) {
			return false;
		}else {
			listaAdministradores.remove(index);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean update(int index, Administrador newData) {
		if(index < 0 || index >= listaAdministradores.size()) {
			return false;
		}else {
			listaAdministradores.set(index, newData);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public String showAll() {
StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < listaAdministradores.size(); i++) {
			sb.append(i + 1);
			sb.append(" - ");
			sb.append(listaAdministradores.get(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public int count() {
		return listaAdministradores.size();
	}

	@Override
	public void leerDesdeArchivoDeTexto(String url) {
		String contenido = FileHandler.leerDesdeArchivoDeTexto(url);
		if(contenido == null || contenido.isBlank()) {
			return;
		}else {
			String[] filas = contenido.split("\n");
			for (int i = 0; i < filas.length; i++) {
				if(filas[i].trim().isEmpty()) continue;
				
				String[] columna = filas[i].split("\n");
				if(columna.length < 6) {
					System.out.println("Línea inválida en archivo de Hombres: " + filas[i]);
					continue;
				}
				Administrador temp = new Administrador();
				temp.setNombre(columna[0]);
				temp.setApellido(columna[1]);;
				temp.setEmail(columna[2]);
				temp.setContrasena(columna[3]);
				temp.setFecha(LocalDate.parse(columna[4]));
				temp.setGenero(columna[5]);
				temp.setEsAdministrador(Boolean.parseBoolean(columna[6]));
			
				
				listaAdministradores.add(temp);
			}
		}
		
	}

	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder sb = new StringBuilder();
		for (Administrador administrador : listaAdministradores) {
			sb.append(administrador.getNombre() + ";");
			sb.append(administrador.getApellido() + ";");
			sb.append(administrador.getEmail() + ";");
			sb.append(administrador.getContrasena() + ";");
			sb.append(administrador.getFecha() + ";");
			sb.append(administrador.getGenero() + ";");
			sb.append(administrador.isEsAdministrador() + ";");
		
		}
		FileHandler.escribirEnArchivoDeTexto(FILE_NAME, sb.toString());
		
	}

	@Override
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaAdministradores = (ArrayList<Administrador>) contenido;
		} else {
			listaAdministradores = new ArrayList<>();
		}		
	}

	@Override
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaAdministradores);
		
	}

}
