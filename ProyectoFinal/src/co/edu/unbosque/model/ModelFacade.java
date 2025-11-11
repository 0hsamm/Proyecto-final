package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

public class ModelFacade {

	private HombreDAO hombreDAO;
	private MujerDAO mujerDAO;
	private AdministradorDAO adminDAO;
	private Usuario usuarioActual;
	
	public ModelFacade() {
		hombreDAO = new HombreDAO();
		mujerDAO = new MujerDAO();
		adminDAO = new AdministradorDAO(); 
	}


	
	public Usuario buscarUsuarioPorAlias(String alias) {
	    for (Hombre h : hombreDAO.getListaHombres()) {
	        if (h.getAlias().equalsIgnoreCase(alias)) return h;
	    }
	    for (Mujer m : mujerDAO.getListaMujeres()) {
	        if (m.getAlias().equalsIgnoreCase(alias)) return m;
	    }
	    return null;
	}

	
	
	
	public HombreDAO getHombreDAO() {
		return hombreDAO;
	}


	public void setHombreDAO(HombreDAO hombreDAO) {
		this.hombreDAO = hombreDAO;
	}


	public MujerDAO getMujerDAO() {
		return mujerDAO;
	}


	public void setMujerDAO(MujerDAO mujerDAO) {
		this.mujerDAO = mujerDAO;
	}


	public AdministradorDAO getAdminDAO() {
		return adminDAO;
	}


	public void setAdminDAO(AdministradorDAO adminDAO) {
		this.adminDAO = adminDAO;
	}


	public Usuario getUsuarioActual() {
		return usuarioActual;
	}


	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	
	
	
	
	
}
