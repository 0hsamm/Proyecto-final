package co.edu.unbosque.view;

public class ViewFacade {
	
	private VentanaMenuPrincipal venMenu;
	
	public ViewFacade() {
		
		venMenu = new VentanaMenuPrincipal();
		
	}

	public VentanaMenuPrincipal getVenMenu() {
		return venMenu;
	}

	public void setVenMenu(VentanaMenuPrincipal venMenu) {
		this.venMenu = venMenu;
	}
}
