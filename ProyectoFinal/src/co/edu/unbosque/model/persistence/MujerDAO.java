package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.Mujer;

public class MujerDAO implements DAO<Mujer>{

	private ArrayList<Mujer> listaMujeres;
	private final String FILE_NAME = "Mujer.csv";
	private final String SERIAL_FILE_NAME = "Mujer.bin";
	
	public MujerDAO() {
		listaMujeres = new ArrayList<Mujer>();
		leerDesdeArchivoDeTexto(FILE_NAME);
		cargarDesdeArchivoSerializado();
	}
	
	@Override
	public void create(Mujer newData) {
		listaMujeres.add(newData);
		escribirEnArchivoDeTexto();
		cargarDesdeArchivoSerializado();
		
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
	public boolean update(int index, Mujer newData) {
		if(index < 0 || index >= listaMujeres.size()) {
			return false;
		}else {
			listaMujeres.set(index, newData);
			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public String showAll() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < listaMujeres.size(); i++) {
			sb.append(i + 1);
			sb.append(" - ");
			sb.append(listaMujeres.get(i).toString());
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
				Mujer temp = new Mujer();
				temp.setNombre(columna[0]);
				temp.setAlias(columna[1]);
				temp.setEmail(columna[2]);
				temp.setAnio(LocalDate.parse(columna[3]));
				temp.setGenero(columna[4]);
				temp.setPromedioIngMensual(Integer.parseInt(columna[5]));
				temp.setEstatura(Double.parseDouble(columna[6]));
				temp.setEsDivorciada(Boolean.parseBoolean(columna[7]));;
				
				listaMujeres.add(temp);
			}
		}
		
	}

	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder sb = new StringBuilder();
		for (Mujer mujer : listaMujeres) {
			sb.append(mujer.getNombre() + ";");
			sb.append(mujer.getAlias() + ";");
			sb.append(mujer.getEmail() + ";");
			sb.append(mujer.getAnio() + ";");
			sb.append(mujer.getGenero() + ";");
			sb.append(mujer.getPromedioIngMensual() + ";");
			sb.append(mujer.getEstatura() + ";");
			sb.append(mujer.isEsDivorciada() + "\n");
			
			
		}
		FileHandler.escribirEnArchivoDeTexto(FILE_NAME, sb.toString());
		
	}

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

	public ArrayList<Mujer> getListaCompradores() {
		return listaMujeres;
	}

	public void setListaCompradores(ArrayList<Mujer> listaCompradores) {
		this.listaMujeres = listaCompradores;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	

}
