package co.edu.unbosque.model.persistence;

import javax.xml.stream.events.EndDocument;

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
		dto.setEstaDisponible(entity.getEstaDisponible());
		dto.setEsAdministrador(entity.getEsAdministrador());
		dto.setAlias(entity.getAlias());
		dto.setURLfoto(entity.getURLfoto());
		dto.setEsIncognito(entity.getEsIncognito());
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
		entity.setEstaDisponible(dto.getEstaDisponible());
		entity.setEsAdministrador(dto.getEsAdministrador());
		entity.setAlias(dto.getAlias());
		entity.setURLfoto(dto.getURLfoto());
		entity.setEsIncognito(dto.getEsIncognito());
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
		dto.setEstaDisponible(entity.getEstaDisponible());
		dto.setEsAdministrador(entity.getEsAdministrador());
		dto.setAlias(entity.getAlias());
		dto.setURLfoto(entity.getURLfoto());
		dto.setEsIncognito(entity.getEsIncognito());
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
		entity.setEstaDisponible(dto.getEstaDisponible());
		entity.setEsAdministrador(dto.getEsAdministrador());
		entity.setAlias(dto.getAlias());
		entity.setURLfoto(dto.getURLfoto());
		entity.setEsIncognito(dto.getEsIncognito());
		entity.setNumLikes(entity.getNumLikes());
		entity.setEstatura(dto.getEstatura());
		entity.setEsDivorciada(dto.isEsDivorciada());
		return entity;
	}
	
	
	
}
