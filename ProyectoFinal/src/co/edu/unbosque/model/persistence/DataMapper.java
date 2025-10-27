package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;


public class DataMapper {

	public static HombreDTO convertirHombreAHombreDTO(Hombre entity) {
		HombreDTO dto = new HombreDTO();
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setEmail(entity.getEmail());
		dto.setContrasena(entity.getContrasena());
		dto.setFecha(entity.getFecha());
		dto.setGenero(entity.getGenero());
		dto.setEsAdministrador(entity.isEsAdministrador());
		dto.setEstaDisponible(entity.isEstaDisponible());
		dto.setAlias(entity.getAlias());
		dto.setURLfoto(entity.getURLfoto());
		dto.setEsIncognito(entity.isEsIncognito());
		dto.setNumLikes(entity.getNumLikes());
		dto.setEstatura(entity.getEstatura());
		dto.setPromedioIngMensual(entity.getPromedioIngMensual());
		dto.setEstatura(entity.getEstatura());
		return dto;
		
	}
	
	public static Hombre convertirHombreDTOAHombre(HombreDTO dto) {
		Hombre entity = new Hombre();
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setEmail(dto.getEmail());
		entity.setContrasena(dto.getContrasena());
		entity.setFecha(dto.getFecha());
		entity.setGenero(dto.getGenero());
		entity.setEsAdministrador(dto.isEsAdministrador());
		entity.setEstaDisponible(dto.isEstaDisponible());
		entity.setAlias(dto.getAlias());
		entity.setURLfoto(dto.getURLfoto());
		entity.setEsIncognito(dto.isEsIncognito());
		entity.setNumLikes(entity.getNumLikes());
		entity.setPromedioIngMensual(dto.getPromedioIngMensual());
		entity.setEstatura(dto.getEstatura());
		return entity;
	}
	
	public static MujerDTO convertirMujerAMujerDTO(Mujer entity) {
		MujerDTO dto = new MujerDTO();
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setEmail(entity.getEmail());
		dto.setContrasena(entity.getContrasena());
		dto.setFecha(entity.getFecha());
		dto.setGenero(entity.getGenero());
		dto.setEsAdministrador(entity.isEsAdministrador());
		dto.setEstaDisponible(entity.isEstaDisponible());
		dto.setAlias(entity.getAlias());
		dto.setURLfoto(entity.getURLfoto());
		dto.setEsIncognito(entity.isEsIncognito());
		dto.setNumLikes(entity.getNumLikes());
		dto.setEstatura(entity.getEstatura());
		dto.setEsDivorciada(entity.isEsDivorciada());
		return dto;
	}
	
	
	public static Mujer convertirMujerDTOAMujer(MujerDTO dto) {
		Mujer entity = new Mujer();
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setEmail(dto.getEmail());
		entity.setContrasena(dto.getContrasena());
		entity.setFecha(dto.getFecha());
		entity.setGenero(dto.getGenero());
		entity.setEsAdministrador(dto.isEsAdministrador());
		entity.setEstaDisponible(dto.isEstaDisponible());
		entity.setAlias(dto.getAlias());
		entity.setURLfoto(dto.getURLfoto());
		entity.setEsIncognito(dto.isEsIncognito());
		entity.setNumLikes(entity.getNumLikes());
		entity.setEstatura(dto.getEstatura());
		entity.setEsDivorciada(dto.isEsDivorciada());
		return entity;
	}
	
	public static AdministradorDTO convertirMujerAMujerDTO(Administrador entity) {
		AdministradorDTO dto = new AdministradorDTO();
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setEmail(entity.getEmail());
		dto.setContrasena(entity.getContrasena());
		dto.setFecha(entity.getFecha());
		dto.setGenero(entity.getGenero());
		dto.setEsAdministrador(entity.isEsAdministrador());
		return dto;
	}
	
	public static Administrador convertirAdministradorDTOAAdministrador(AdministradorDTO dto) {
		Administrador entity = new Administrador();
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setEmail(dto.getEmail());
		entity.setContrasena(dto.getContrasena());
		entity.setFecha(dto.getFecha());
		entity.setGenero(dto.getGenero());
		entity.setEsAdministrador(dto.isEsAdministrador());
		return entity;
	}
	
	public static ArrayList<HombreDTO> listaHombres(ArrayList<Hombre> entityList){
		ArrayList<HombreDTO> dtoList = new ArrayList<>();
		for(Hombre r : entityList) {
			dtoList.add(new HombreDTO(r.getNombre(),r.getApellido(),r.getEmail(),r.getContrasena(),r.getFecha(),r.getGenero(),r.isEsAdministrador(),r.isEstaDisponible(),r.getAlias(),r.getURLfoto(),r.isEsIncognito(),r.getNumLikes(),r.getPromedioIngMensual(),r.getEstatura()));
		}
		return dtoList;
	}
	
	public static ArrayList<Hombre>listaHombreDTOAListaHombre(ArrayList<HombreDTO> dtoList){
		ArrayList<Hombre> entityList = new ArrayList<>();
		for(HombreDTO d : dtoList) {
			entityList.add(new Hombre(d.getNombre(),d.getApellido(),d.getEmail(),d.getContrasena(),d.getFecha(),d.getGenero(),d.isEsAdministrador()));
		}
		return entityList;
	}
	
	public static ArrayList<MujerDTO> listaMujeres(ArrayList<Mujer> entityList){
		ArrayList<MujerDTO> dtoList = new ArrayList<>();
		for(Mujer r : entityList) {
			dtoList.add(new MujerDTO(r.getNombre(),r.getApellido(),r.getEmail(),r.getContrasena(),r.getFecha(),r.getGenero(),r.isEsAdministrador(),r.isEstaDisponible(),r.getAlias(),r.getURLfoto(),r.isEsIncognito(),r.getNumLikes(),r.getEstatura(),r.isEsDivorciada()));
		}
		return dtoList;
	}
	
	public static ArrayList<Mujer>listaMujerDTOAListaMujer(ArrayList<MujerDTO> dtoList){
		ArrayList<Mujer> entityList = new ArrayList<>();
		for(MujerDTO r : dtoList) {
			entityList.add(new Mujer(r.getNombre(),r.getApellido(),r.getEmail(),r.getContrasena(),r.getFecha(),r.getGenero(),r.isEsAdministrador(),r.isEstaDisponible(),r.getAlias(),r.getURLfoto(),r.isEsIncognito(),r.getNumLikes(),r.getEstatura(),r.isEsDivorciada()));
		}
		return entityList;
	}
	
	public static ArrayList<AdministradorDTO> listaAdministradores(ArrayList<Administrador> entityList){
		ArrayList<AdministradorDTO> dtoList = new ArrayList<>();
		for(Administrador g : entityList) {
			dtoList.add(new AdministradorDTO(g.getNombre(),g.getApellido(),g.getEmail(),g.getContrasena(),g.getFecha(),g.getGenero(),g.isEsAdministrador()));
		}
		return dtoList;
	}
	
	public static ArrayList<Administrador>listaAdministradorDTOAListaAdministrador(ArrayList<AdministradorDTO> dtoList){
		ArrayList<Administrador> entityList = new ArrayList<>();
		for(AdministradorDTO d : dtoList) {
			entityList.add(new Administrador(d.getNombre(),d.getApellido(),d.getEmail(),d.getContrasena(),d.getFecha(),d.getGenero(),d.isEsAdministrador()));
		}
		return entityList;
	}
	
	
		

}
