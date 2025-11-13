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
		 if (entity == null) return null;
	        HombreDTO dto = new HombreDTO();
	        dto.setNombre(entity.getNombre());
	        dto.setApellido(entity.getApellido());
	        dto.setEmail(entity.getEmail());
	        dto.setContrasena(entity.getContrasena());
	        dto.setFechaNacimiento(entity.getFechaNacimiento());
	        dto.setGenero(entity.getGenero());
	        dto.setEsAdministrador(entity.isEsAdministrador());
	        dto.setEstaDisponible(entity.isEstaDisponible());
	        dto.setAlias(entity.getAlias());
	        dto.setURLFoto(entity.getURLfoto());
	        dto.setEsIncognito(entity.isEsIncognito());
	        dto.setNumLikes(entity.getNumLikes());
	        dto.setEstatura(entity.getEstatura());
	        dto.setPromedioIngMensual(entity.getPromedioIngMensual());
	        return dto;
		
	}
	
	public static Hombre convertirHombreDTOAHombre(HombreDTO dto) {
		if (dto == null) return null;
        Hombre entity = new Hombre();
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        entity.setContrasena(dto.getContrasena());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setGenero(dto.getGenero());
        entity.setEsAdministrador(dto.isEsAdministrador());
        entity.setEstaDisponible(dto.isEstaDisponible());
        entity.setAlias(dto.getAlias());
        entity.setURLFoto(dto.getURLfoto());
        entity.setEsIncognito(dto.isEsIncognito());
        entity.setNumLikes(dto.getNumLikes());
        entity.setPromedioIngMensual(dto.getPromedioIngMensual());
        entity.setEstatura(dto.getEstatura());
        return entity;
	}
	
	public static MujerDTO convertirMujerAMujerDTO(Mujer entity) {
		 if (entity == null) return null;
	        MujerDTO dto = new MujerDTO();
	        dto.setNombre(entity.getNombre());
	        dto.setApellido(entity.getApellido());
	        dto.setEmail(entity.getEmail());
	        dto.setContrasena(entity.getContrasena());
	        dto.setFechaNacimiento(entity.getFechaNacimiento());
	        dto.setGenero(entity.getGenero());
	        dto.setEsAdministrador(entity.isEsAdministrador());
	        dto.setEstaDisponible(entity.isEstaDisponible());
	        dto.setAlias(entity.getAlias());
	        dto.setURLFoto(entity.getURLfoto());
	        dto.setEsIncognito(entity.isEsIncognito());
	        dto.setNumLikes(entity.getNumLikes());
	        dto.setEstatura(entity.getEstatura());
	        dto.setEsDivorciada(entity.isEsDivorciada());
	        return dto;
	}
	
	
	public static Mujer convertirMujerDTOAMujer(MujerDTO dto) {
		if (dto == null) return null;
        Mujer entity = new Mujer();
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        entity.setContrasena(dto.getContrasena());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setGenero(dto.getGenero());
        entity.setEsAdministrador(dto.isEsAdministrador());
        entity.setEstaDisponible(dto.isEstaDisponible());
        entity.setAlias(dto.getAlias());
        entity.setURLFoto(dto.getURLfoto());
        entity.setEsIncognito(dto.isEsIncognito());
        entity.setNumLikes(dto.getNumLikes());
        entity.setEstatura(dto.getEstatura());
        entity.setEsDivorciada(dto.isEsDivorciada());
        return entity;
	}
	
	public static AdministradorDTO convertirAdministradorAAdministradorDTO(Administrador entity) {
		if (entity == null) return null;
		AdministradorDTO dto = new AdministradorDTO();
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setEmail(entity.getEmail());
		dto.setContrasena(entity.getContrasena());
		dto.setFechaNacimiento(entity.getFechaNacimiento());
		dto.setGenero(entity.getGenero());
		dto.setEsAdministrador(entity.isEsAdministrador());
		return dto;
	}
	
	
	public static Administrador convertirAdministradorDTOAAdministrador(AdministradorDTO dto) {
		if (dto == null) return null;
		Administrador entity = new Administrador();
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setEmail(dto.getEmail());
		entity.setContrasena(dto.getContrasena());
		entity.setFechaNacimiento(dto.getFechaNacimiento());
		entity.setGenero(dto.getGenero());
		entity.setEsAdministrador(dto.isEsAdministrador());
		return entity;
	}
	
	public static ArrayList<HombreDTO> listaHombres(ArrayList<Hombre> entityList){
		ArrayList<HombreDTO> dtoList = new ArrayList<>();
		for(Hombre r : entityList) {
			dtoList.add(new HombreDTO(r.getNombre(),r.getApellido(),r.getEmail(),r.getContrasena(),r.getFechaNacimiento(),r.getGenero(),r.isEsAdministrador(),r.isEstaDisponible(),r.getAlias(),r.getURLfoto(),r.isEsIncognito(),r.getNumLikes(),r.getPromedioIngMensual(),r.getEstatura()));
		}
		return dtoList;
	}
	
	public static ArrayList<Hombre>listaHombreDTOAListaHombre(ArrayList<HombreDTO> dtoList){
		ArrayList<Hombre> entityList = new ArrayList<>();
		for(HombreDTO d : dtoList) {
			entityList.add(new Hombre(d.getNombre(),d.getApellido(),d.getEmail(),d.getContrasena(),d.getFechaNacimiento(),d.getGenero(),d.isEsAdministrador()));
		}
		return entityList;
	}
	
	public static ArrayList<MujerDTO> listaMujeres(ArrayList<Mujer> entityList){
		ArrayList<MujerDTO> dtoList = new ArrayList<>();
		for(Mujer r : entityList) {
			dtoList.add(new MujerDTO(r.getNombre(),r.getApellido(),r.getEmail(),r.getContrasena(),r.getFechaNacimiento(),r.getGenero(),r.isEsAdministrador(),r.isEstaDisponible(),r.getAlias(),r.getURLfoto(),r.isEsIncognito(),r.getNumLikes(),r.getEstatura(),r.isEsDivorciada()));
		}
		return dtoList;
	}
	
	public static ArrayList<Mujer>listaMujerDTOAListaMujer(ArrayList<MujerDTO> dtoList){
		ArrayList<Mujer> entityList = new ArrayList<>();
		for(MujerDTO r : dtoList) {
			entityList.add(new Mujer(r.getNombre(),r.getApellido(),r.getEmail(),r.getContrasena(),r.getFechaNacimiento(),r.getGenero(),r.isEsAdministrador(),r.isEstaDisponible(),r.getAlias(),r.getURLfoto(),r.isEsIncognito(),r.getNumLikes(),r.getEstatura(),r.isEsDivorciada()));
		}
		return entityList;
	}
	
	public static ArrayList<AdministradorDTO> listaAdministradores(ArrayList<Administrador> entityList){
		ArrayList<AdministradorDTO> dtoList = new ArrayList<>();
		for(Administrador g : entityList) {
			dtoList.add(new AdministradorDTO(g.getNombre(),g.getApellido(),g.getEmail(),g.getContrasena(),g.getFechaNacimiento(),g.getGenero(),g.isEsAdministrador()));
		}
		return dtoList;
	}
	
	public static ArrayList<Administrador>listaAdministradorDTOAListaAdministrador(ArrayList<AdministradorDTO> dtoList){
		ArrayList<Administrador> entityList = new ArrayList<>();
		for(AdministradorDTO d : dtoList) {
			entityList.add(new Administrador(d.getNombre(),d.getApellido(),d.getEmail(),d.getContrasena(),d.getFechaNacimiento(),d.getGenero(),d.isEsAdministrador()));
		}
		return entityList;
	}
	
	
	
	
		

}
