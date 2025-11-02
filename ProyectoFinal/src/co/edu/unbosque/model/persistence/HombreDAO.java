package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;


import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;

public class HombreDAO implements DAO<HombreDTO>{
	
	private ArrayList<Hombre> listaHombres;
	private final String FILE_NAME = "Hombre.csv";
	private final String SERIAL_FILE_NAME = "Hombre.bin";
	
	public HombreDAO() {
		listaHombres = new ArrayList<Hombre>();
		leerDesdeArchivoDeTexto(FILE_NAME);
		cargarDesdeArchivoSerializado();
	}
	
	@Override
	public void create(HombreDTO temp) {
		
		Hombre newData = DataMapper.convertirHombreDTOAHombre(temp);
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
	public boolean update(int index, HombreDTO temp) {
		if(index < 0 || index >= listaHombres.size()) {
			return false;
		}else {
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
		if(contenido == null || contenido.isBlank()) {
			return;
		}else {
			String[] filas = contenido.split("\n");
			for (int i = 0; i < filas.length; i++) {
				if(filas[i].trim().isEmpty()) continue;
				
				String[] columna = filas[i].split("\n");
				if(columna.length < 13) {
					System.out.println("Línea inválida en archivo de Hombres: " + filas[i]);
					continue;
				}
				Hombre temp = new Hombre();
				temp.setNombre(columna[0]);
				temp.setApellido(columna[1]);;
				temp.setEmail(columna[2]);
				temp.setContrasena(columna[3]);
				temp.setFecha(LocalDate.parse(columna[4]));
				temp.setGenero(columna[5]);
				temp.setEsAdministrador(Boolean.parseBoolean(columna[6]));
				temp.setEstaDisponible(Boolean.parseBoolean(columna[7]));
				temp.setAlias(columna[8]);
				temp.setURLfoto(columna[9]);
				temp.setEsIncognito(Boolean.parseBoolean(columna[10]));
				temp.setNumLikes(Integer.parseInt(columna[11]));
				temp.setPromedioIngMensual(Integer.parseInt(columna[12]));
				temp.setEstatura(Double.parseDouble(columna[13]));
				
				listaHombres.add(temp);
			}
		}
		
	}

	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder sb = new StringBuilder();
		for (Hombre hombre : listaHombres) {
			sb.append(hombre.getNombre() + ";");
			sb.append(hombre.getApellido() + ";");
			sb.append(hombre.getEmail() + ";");
			sb.append(hombre.getContrasena() + ";");
			sb.append(hombre.getFecha() + ";");
			sb.append(hombre.getGenero() + ";");
			sb.append(hombre.isEsAdministrador() + ";");
			sb.append(hombre.isEstaDisponible() + ";");
			sb.append(hombre.getAlias() + ";");
			sb.append(hombre.getURLfoto() + ";");
			sb.append(hombre.isEsIncognito() + ";");
			sb.append(hombre.getNumLikes() + ";");
			sb.append(hombre.getPromedioIngMensual() + ";");
			sb.append(hombre.getEstatura() + "\n");
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

	public ArrayList<Hombre> getListaHombres() {
		return listaHombres;
	}

	public void setListaHombres(ArrayList<Hombre> listaHombres) {
		this.listaHombres = listaHombres;
	}
	
	
	
}
