package co.edu.unbosque.view;

public class ViewFacade {
	
	private VentanaMenuPrincipal venMenu;
	private VentanaRegistro venRegistro;
	private VentanaPrincipal venPrincipal;
	private VentanaCRUD venCRUD;
	
	public ViewFacade() {
		
		venMenu = new VentanaMenuPrincipal();
		venRegistro = new VentanaRegistro();
		venPrincipal = new VentanaPrincipal();
		venCRUD = new VentanaCRUD();
		
	}

	public VentanaMenuPrincipal getVenMenu() {
		return venMenu;
	}

	public void setVenMenu(VentanaMenuPrincipal venMenu) {
		this.venMenu = venMenu;
	}

	public VentanaRegistro getVenRegistro() {
		return venRegistro;
	}

	public void setVenRegistro(VentanaRegistro venRegistro) {
		this.venRegistro = venRegistro;
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
	
	

}
