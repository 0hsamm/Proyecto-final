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
		dto.setAlias(entity.getAlias());
		dto.setEmail(entity.getEmail());
		dto.setAnio(entity.getAnio());
		dto.setGenero(entity.getGenero());
		dto.setPromedioIngMensual(entity.getPromedioIngMensual());
		dto.setEstatura(entity.getEstatura());
		dto.setEsDivorciado(entity.isEsDivorciado());
		return dto;
		
	}
	
	public static Hombre convertirHombreDTOAHombre(HombreDTO dto) {
		Hombre entity = new Hombre();
		entity.setNombre(dto.getNombre());
		entity.setAlias(dto.getAlias());
		entity.setEmail(dto.getEmail());
		entity.setAnio(dto.getAnio());
		entity.setGenero(dto.getGenero());
		entity.setPromedioIngMensual(dto.getPromedioIngMensual());
		entity.setEstatura(dto.getEstatura());
		entity.setEsDivorciado(dto.isEsDivorciado());
		return entity;
	}
	
	public static MujerDTO convertirMujerAMujerDTO(Mujer entity) {
		MujerDTO dto = new MujerDTO();
		dto.setNombre(entity.getNombre());
		dto.setAlias(entity.getAlias());
		dto.setEmail(entity.getEmail());
		dto.setAnio(entity.getAnio());
		dto.setGenero(entity.getGenero());
		dto.setPromedioIngMensual(entity.getPromedioIngMensual());
		dto.setEstatura(entity.getEstatura());
		dto.setEsDivorciada(entity.isEsDivorciada());
		return dto;
	}
	
	
	public static Mujer convertirMujerDTOAMujer(MujerDTO dto) {
		Mujer entity = new Mujer();
		entity.setNombre(dto.getNombre());
		entity.setAlias(dto.getAlias());
		entity.setEmail(dto.getEmail());
		entity.setAnio(dto.getAnio());
		entity.setGenero(dto.getGenero());
		entity.setPromedioIngMensual(dto.getPromedioIngMensual());
		entity.setEstatura(dto.getEstatura());
		entity.setEsDivorciada(dto.isEsDivorciada());
		return entity;
	}
	
	
	
}
