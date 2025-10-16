package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller {
	
	private ViewFacade vf;
	private ModelFacade mf;
	
	public Controller() {
		vf = new ViewFacade();
		mf= new ModelFacade();
	}

	public void runGUI() {
		vf.getVenMenu().setVisible(true);
	}
	
	public void asignarListeners() {
		
		
	}
}
