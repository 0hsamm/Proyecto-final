package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	
	private ViewFacade vf;
	private ModelFacade mf;
	private Properties prop;
	
	public Controller() {
		vf = new ViewFacade();
		mf= new ModelFacade();
		prop = new Properties();
	}

	public void runGUI() {
        mainloop:
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    null,
                    "Seleccione el idioma a ejecutar:\n1. Español\n2. English\n3. Português\n4. Latinus",
                    "Seleccionar idioma",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (opcion == null) {
                break mainloop;
            }

            switch (opcion) {
                case "1": // Español
                    prop = FileHandler.cargarArchivoDePropiedades("espa.properties");
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                    continue mainloop;
            }

            vf.getVenMenu().setProp(prop);
            vf.getVenRegistro().setProp(prop);
            vf.getVenPrincipal().setProp(prop);
            vf.getVenMenu().setVisible(true);
            asignarListeners();
            break mainloop;
        }
    }

	
	public void asignarListeners() {
		
		vf.getVenMenu().getBtnConfirmar().addActionListener(this);
		vf.getVenMenu().getBtnConfirmar().setActionCommand("INICIAR_SESION");
		
		vf.getVenMenu().getBtnRegistro().addActionListener(this);
		vf.getVenMenu().getBtnRegistro().setActionCommand("REGISTRATE_AQUI");
		
		vf.getVenMenu().getBtnSalir().addActionListener(this);
		vf.getVenMenu().getBtnSalir().setActionCommand("SALIR_MENU");
		
		vf.getVenRegistro().getBtnCrearCuenta().addActionListener(this);
		vf.getVenRegistro().getBtnCrearCuenta().setActionCommand("CREAR_CUENTA");;
		
		vf.getVenRegistro().getBtnVolver().addActionListener(this);
		vf.getVenRegistro().getBtnVolver().setActionCommand("VOLVER_DESDE_REGISTRO");
	}
	
	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		switch (e.getActionCommand()) {
		
		case "INICIAR_SESION": {
			vf.getVenMenu().setVisible(false);
			vf.getVenPrincipal().setVisible(true);
			break;
		}
		case "REGISTRATE_AQUI": { 
			vf.getVenMenu().setVisible(false);
			vf.getVenRegistro().setVisible(true);
			break;
		}
		case "SALIR_MENU": {
			vf.getVenMenu().dispose();
			break;
		}
		case "VOLVER_DESDE_REGISTRO":{
			vf.getVenRegistro().setVisible(false);
			vf.getVenMenu().setVisible(true);
		}
		}
	}
}
