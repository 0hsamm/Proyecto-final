package co.edu.unbosque.view;

public class ViewFacade {

	private VentanaMenuPrincipal venMenu;
	private VentanaRegistroHombre venRegistroHombre;
	private VentanaRegistroMujer venRegistroMujer;
	private VentanaPrincipal venPrincipal;
	private VentanaCRUD venCRUD;
	private VentanaEscogerGenero venGenero;
	private VentanaRegistroAdministrador venRegistroAdmin;
	private VentanaInicioSesionAdmin venInicioSesionAdmin;
	private VentanaPerfil venPerfil;

	public ViewFacade() {

		venMenu = new VentanaMenuPrincipal();
		venRegistroHombre = new VentanaRegistroHombre();
		venRegistroMujer = new VentanaRegistroMujer();
		venPrincipal = new VentanaPrincipal();
		venCRUD = new VentanaCRUD();
		venGenero = new VentanaEscogerGenero();
		venRegistroAdmin = new VentanaRegistroAdministrador();
		venInicioSesionAdmin = new VentanaInicioSesionAdmin();
		venPerfil = new VentanaPerfil();

	}

	public VentanaMenuPrincipal getVenMenu() {
		return venMenu;
	}

	public void setVenMenu(VentanaMenuPrincipal venMenu) {
		this.venMenu = venMenu;
	}

	public VentanaRegistroHombre getVenRegistroHombre() {
		return venRegistroHombre;
	}

	public void setVenRegistroHombre(VentanaRegistroHombre venRegistroHombre) {
		this.venRegistroHombre = venRegistroHombre;
	}

	public VentanaRegistroMujer getVenRegistroMujer() {
		return venRegistroMujer;
	}

	public void setVenRegistroMujer(VentanaRegistroMujer venRegistroMujer) {
		this.venRegistroMujer = venRegistroMujer;
	}

	public VentanaPrincipal getVenPrincipal() {
		return venPrincipal;
	}

	public void setVenPrincipal(VentanaPrincipal venPrincipal) {
		this.venPrincipal = venPrincipal;
	}

	public VentanaCRUD getVenCRUD() {
		return venCRUD;
	}

	public void setVenCRUD(VentanaCRUD venCRUD) {
		this.venCRUD = venCRUD;
	}

	public VentanaEscogerGenero getVenGenero() {
		return venGenero;
	}

	public void setVenGenero(VentanaEscogerGenero venGenero) {
		this.venGenero = venGenero;
	}

	public VentanaRegistroAdministrador getVenRegistroAdmin() {
		return venRegistroAdmin;
	}

	public void setVenRegistroAdmin(VentanaRegistroAdministrador venRegistroAdmin) {
		this.venRegistroAdmin = venRegistroAdmin;
	}

	public VentanaInicioSesionAdmin getVenInicioSesionAdmin() {
		return venInicioSesionAdmin;
	}

	public void setVenInicioSesionAdmin(VentanaInicioSesionAdmin venInicioSesionAdmin) {
		this.venInicioSesionAdmin = venInicioSesionAdmin;
	}

	public VentanaPerfil getVenPerfil() {
		return venPerfil;
	}

	public void setVenPerfil(VentanaPerfil venPerfil) {
		this.venPerfil = venPerfil;
	}
	
	
}
