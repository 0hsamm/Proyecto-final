package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

public class ModelFacade {

	private HombreDAO hombreDao;
	private MujerDAO mujerDao;
	private AdministradorDAO adminDao;
	
	
	public ModelFacade() {
		hombreDao = new HombreDAO();
		mujerDao = new MujerDAO();
		adminDao = new AdministradorDAO();
	}

	public HombreDAO getHombreDao() {
		return hombreDao;
	}

	public void setHombreDao(HombreDAO hombreDao) {
		this.hombreDao = hombreDao;
	}

	public MujerDAO getMujerDao() {
		return mujerDao;
	}

	public void setMujerDao(MujerDAO mujerDao) {
		this.mujerDao = mujerDao;
	}

	public AdministradorDAO getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdministradorDAO adminDao) {
		this.adminDao = adminDao;
	}
	
	
	
}
