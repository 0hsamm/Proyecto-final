package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

/*
 * Clase que funciona como fachada del modelo.
 * Centraliza el acceso a los DAOs de Hombre, Mujer y Administrador,
 * además de gestionar el usuario actualmente activo en el sistema.
 */
public class ModelFacade {

	private HombreDAO hombreDAO;
	private MujerDAO mujerDAO;
	private AdministradorDAO adminDAO;
	private Usuario usuarioActual;

	/*
	 * Constructor que inicializa todos los DAOs del modelo.
	 */
	public ModelFacade() {
		hombreDAO = new HombreDAO();
		mujerDAO = new MujerDAO();
		adminDAO = new AdministradorDAO(); 
	}

	/*
	 * Busca un usuario (hombre o mujer) por su alias.
	 *
	 * @param alias alias del usuario a buscar
	 * @return usuario encontrado o null si no existe
	 */
	public Usuario buscarUsuarioPorAlias(String alias) {
	    for (Hombre h : hombreDAO.getListaHombres()) {
	        if (h.getAlias().equalsIgnoreCase(alias)) return h;
	    }
	    for (Mujer m : mujerDAO.getListaMujeres()) {
	        if (m.getAlias().equalsIgnoreCase(alias)) return m;
	    }
	    return null;
	}

	/*
	 * Obtiene el DAO de hombres.
	 *
	 * @return instancia de HombreDAO
	 */
	public HombreDAO getHombreDAO() {
		return hombreDAO;
	}

	/*
	 * Establece el DAO de hombres.
	 *
	 * @param hombreDAO nuevo DAO de hombres
	 */
	public void setHombreDAO(HombreDAO hombreDAO) {
		this.hombreDAO = hombreDAO;
	}

	/*
	 * Obtiene el DAO de mujeres.
	 *
	 * @return instancia de MujerDAO
	 */
	public MujerDAO getMujerDAO() {
		return mujerDAO;
	}

	/*
	 * Establece el DAO de mujeres.
	 *
	 * @param mujerDAO nuevo DAO de mujeres
	 */
	public void setMujerDAO(MujerDAO mujerDAO) {
		this.mujerDAO = mujerDAO;
	}

	/*
	 * Obtiene el DAO de administradores.
	 *
	 * @return instancia de AdministradorDAO
	 */
	public AdministradorDAO getAdminDAO() {
		return adminDAO;
	}

	/*
	 * Establece el DAO de administradores.
	 *
	 * @param adminDAO nuevo DAO de administradores
	 */
	public void setAdminDAO(AdministradorDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	/*
	 * Obtiene el usuario actualmente activo en el sistema.
	 *
	 * @return usuario actual
	 */
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	/*
	 * Establece el usuario actualmente activo en el sistema.
	 *
	 * @param usuarioActual nuevo usuario activo
	 */
	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

}
