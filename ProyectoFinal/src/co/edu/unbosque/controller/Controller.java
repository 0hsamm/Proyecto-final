package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	
	private ViewFacade vf;
	private ModelFacade mf;
	
	public Controller() {
		vf = new ViewFacade();
		mf= new ModelFacade();
	}

	public void runGUI() {
		vf.getVenMenu().setVisible(true);
		asignarListeners();
	}
	
	public void asignarListeners() {
		
		vf.getVenMenu().getBtnConfirmar().addActionListener(this);
		vf.getVenMenu().getBtnConfirmar().setActionCommand("INICIAR_SESION");
		
		vf.getVenMenu().getBtnRegistro().addActionListener(this);
		vf.getVenMenu().getBtnRegistro().setActionCommand("REGISTRATE_AQUI");
		
		vf.getVenMenu().getBtnSalir().addActionListener(this);
		vf.getVenMenu().getBtnSalir().setActionCommand("SALIR_MENU");
		
		
	}
	
	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		switch (e.getActionCommand()) {
		
		/*case "INICIAR_SESION": {
			vf.getVenMenu().setVisible(false);
			break;
		*/
		case "REGISTRATE_AQUI": { 
			vf.getVenMenu().setVisible(false);
			vf.getVenRegistro().setVisible(true);
			break;
		}
		case "SALIR_MENU": {
			vf.getVenMenu().dispose();
			break;
		}
		}
	}
}
