package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;


import co.edu.unbosque.model.Hombre;

public class HombreDAO implements DAO<Hombre>{
	
	private ArrayList<Hombre> listaHombres;
	private final String FILE_NAME = "Hombre.csv";
	private final String SERIAL_FILE_NAME = "Hombre.bin";
	
	public HombreDAO() {
		listaHombres = new ArrayList<Hombre>();
		leerDesdeArchivoDeTexto(FILE_NAME);
		cargarDesdeArchivoSerializado();
	}
	
	@Override
	public void create(Hombre newData) {
		listaHombres.add(newData);
		escribirEnArchivoDeTexto();
		cargarDesdeArchivoSerializado();
		
	}

	@Override
	public boolean delete(int index) {
		if(index < 0 || index >= listaHombres.size()) {
			return false;
		}else {
			listaHombres.remove(index);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean update(int index, Hombre newData) {
		if(index < 0 || index >= listaHombres.size()) {
			return false;
		}else {
			listaHombres.set(index, newData);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public String showAll() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < listaHombres.size(); i++) {
			sb.append(i + 1);
			sb.append(" - ");
			sb.append(listaHombres.get(i).toString());
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
		if(contenido == null || contenido.isBlank()) {
			return;
		}else {
			String[] filas = contenido.split("\n");
			for (int i = 0; i < filas.length; i++) {
				if(filas[i].trim().isEmpty()) continue;
				
				String[] columna = filas[i].split("\n");
				if(columna.length < 7) {
					System.out.println("Línea inválida en archivo de Hombres: " + filas[i]);
					continue;
				}
				Hombre temp = new Hombre();
				temp.setNombre(columna[0]);
				temp.setUsuario(columna[1]);
				temp.setEmail(columna[2]);
				temp.setAnio(LocalDate.parse(columna[3]));
				temp.setGenero(columna[4]);
				temp.setEstatura(Double.parseDouble(columna[5]));
				temp.setPromedioIngMensual(Integer.parseInt(columna[6]));
				
				listaHombres.add(temp);
			}
		}
		
	}

	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder sb = new StringBuilder();
		for (Hombre hombre : listaHombres) {
			sb.append(hombre.getNombre() + ";");
			sb.append(hombre.getUsuario() + ";");
			sb.append(hombre.getEmail() + ";");
			sb.append(hombre.getAnio() + ";");
			sb.append(hombre.getGenero() + ";");
			sb.append(hombre.getEstatura() + ";");
			sb.append(hombre.getPromedioIngMensual() + "\n");
			
		}
		FileHandler.escribirEnArchivoDeTexto(FILE_NAME, sb.toString());
		
	}

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

	public ArrayList<Hombre> getListaCompradores() {
		return listaHombres;
	}

	public void setListaCompradores(ArrayList<Hombre> listaCompradores) {
		this.listaHombres = listaCompradores;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}
	
}
