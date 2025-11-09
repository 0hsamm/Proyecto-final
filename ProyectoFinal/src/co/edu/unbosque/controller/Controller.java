package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.view.ViewFacade;
import jakarta.mail.search.IntegerComparisonTerm;

public class Controller implements ActionListener {

	private ViewFacade vf;
	private ModelFacade mf;
	private Properties prop;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		prop = new Properties();
	}

	public void runGUI() {
		mainloop: while (true) {
			String opcion = JOptionPane.showInputDialog(null,
					"Select the language to run:\n1. Spanih COP\n2. Portuguese BRL\n3. Russian RUB\n4. Chinese CNY\n5. Hebrew ILS",
					"Select language", JOptionPane.QUESTION_MESSAGE);

			if (opcion == null) {
				break mainloop;
			}

			switch (opcion) {
			case "1": { // Español
				prop = FileHandler.cargarArchivoDePropiedades("espa.properties");
				break;
			}
			case "2": { // Portugés
				prop = FileHandler.cargarArchivoDePropiedades("ptg.properties");
				break;
			}
			case "3": { // Ruso
				prop = FileHandler.cargarArchivoDePropiedades("ruso.properties");
				break;
			}
			case "4": { // Chino
				prop = FileHandler.cargarArchivoDePropiedades("chino.properties");
				break;
			}
			case "5": { // Hebreo
				prop = FileHandler.cargarArchivoDePropiedades("hebreo.properties");
				break;
			}
			default:
				JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
				continue mainloop;
			}

			vf.getVenMenu().setProp(prop);
			vf.getVenGenero().setProp(prop);
			vf.getVenRegistroHombre().setProp(prop);
			vf.getVenRegistroMujer().setProp(prop);
			vf.getVenPrincipal().setProp(prop);
			vf.getVenCRUD().setProp(prop);
			vf.getVenRegistroAdmin().setProp(prop);
			vf.getVenMenu().setVisible(true);
			//vf.getVenCRUD().setVisible(true);
			//vf.getVenGenero().setVisible(true);
			//vf.getVenRegistroMujer().setVisible(true);
			//vf.getVenRegistroAdmin().setVisible(true);
			asignarListeners();
			break mainloop;
		}
	}

	public void asignarListeners() {
		
		//VENTANA MENU
		vf.getVenMenu().getBtnConfirmar().addActionListener(this);
		vf.getVenMenu().getBtnConfirmar().setActionCommand("INICIAR_SESION");

		vf.getVenMenu().getBtnRegistro().addActionListener(this);
		vf.getVenMenu().getBtnRegistro().setActionCommand("REGISTRATE_AQUI");

		vf.getVenMenu().getBtnSalir().addActionListener(this);
		vf.getVenMenu().getBtnSalir().setActionCommand("SALIR_MENU");
		
		//VENTANA GENERO
		vf.getVenGenero().getBtnVolver().addActionListener(this);
		vf.getVenGenero().getBtnVolver().setActionCommand("VOLVER_DESDE_GENERO");
		
		vf.getVenGenero().getBtnHombre().addActionListener(this);
		vf.getVenGenero().getBtnHombre().setActionCommand("HOMBRE");
		
		vf.getVenGenero().getBtnMujer().addActionListener(this);
		vf.getVenGenero().getBtnMujer().setActionCommand("MUJER");
		
		//VENTANA REGISTRO HOMBRE
		vf.getVenRegistroHombre().getBtnCrearCuenta().addActionListener(this);
		vf.getVenRegistroHombre().getBtnCrearCuenta().setActionCommand("CREAR_CUENTA_HOMBRE");

		vf.getVenRegistroHombre().getBtnVolver().addActionListener(this);
		vf.getVenRegistroHombre().getBtnVolver().setActionCommand("VOLVER_DESDE_REGISTRO_HOMBRE");
		
		vf.getVenRegistroHombre().getBtnSubirImagen().addActionListener(this);
		vf.getVenRegistroHombre().getBtnSubirImagen().setActionCommand("SUBIR_FOTO_HOMBRE");
		
		vf.getVenRegistroHombre().getBtnRegistro().addActionListener(this);
		vf.getVenRegistroHombre().getBtnRegistro().setActionCommand("REGISTRAR_ADMIN_DESDE_HOMBRE");
		
		//VENTANA REGISTRO MUJER
		vf.getVenRegistroMujer().getBtnCrearCuenta().addActionListener(this);
		vf.getVenRegistroMujer().getBtnCrearCuenta().setActionCommand("CREAR_CUENTA_MUJER");

		vf.getVenRegistroMujer().getBtnVolver().addActionListener(this);
		vf.getVenRegistroMujer().getBtnVolver().setActionCommand("VOLVER_DESDE_REGISTRO_MUJER");
		
		vf.getVenRegistroMujer().getBtnSubirImagen().addActionListener(this);
		vf.getVenRegistroMujer().getBtnSubirImagen().setActionCommand("SUBIR_FOTO_MUJER");
		
		vf.getVenRegistroMujer().getBtnRegistro().addActionListener(this);
		vf.getVenRegistroMujer().getBtnRegistro().setActionCommand("REGISTRAR_ADMIN_DESDE_MUJER");
		
		//VENTANA REGISTRO ADMIN 
		vf.getVenRegistroAdmin().getBtnVolver().addActionListener(this);
		vf.getVenRegistroAdmin().getBtnVolver().setActionCommand("VOLVER_DESDE_REGISTRO_ADMIN");
		
		vf.getVenRegistroAdmin().getBtnCrearCuenta().addActionListener(this);
		vf.getVenRegistroAdmin().getBtnCrearCuenta().setActionCommand("CREAR_CUENTA_ADMIN");
		
		//VENTANA CRUD
		vf.getVenCRUD().getBtnVolver().addActionListener(this);
		vf.getVenCRUD().getBtnVolver().setActionCommand("VOLVER_DESDE_CRUD");
		
		//VENTANA PRINCIPAL
		vf.getVenPrincipal().getBtnVolver().addActionListener(this);
		vf.getVenPrincipal().getBtnVolver().setActionCommand("VOLVER_DESDE_VENTANA_PRINCIPAL");
		
	}

	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		switch (e.getActionCommand()) {
		
		//VENTANA MENU
		case "INICIAR_SESION": {
			vf.getVenMenu().setVisible(false);
			vf.getVenPrincipal().setVisible(true);
			break;
		}
		case "REGISTRATE_AQUI": {
			vf.getVenMenu().setVisible(false);
			vf.getVenGenero().setVisible(true);
			break;
		}
		case "SALIR_MENU": {
			vf.getVenMenu().dispose();
			break;
		}
		//VENTANA GENERO
		case "VOLVER_DESDE_GENERO": {
			vf.getVenGenero().setVisible(false);
			vf.getVenMenu().setVisible(true);
			break;
		}
		
		case "HOMBRE": {
			vf.getVenGenero().setVisible(false);
			vf.getVenRegistroHombre().setVisible(true);
			break;
		}
		
		case "MUJER": {
			vf.getVenGenero().setVisible(false);
			vf.getVenRegistroMujer().setVisible(true);
			
			break;
		}
		//VENTANA REGISTRO HOMBRE
		case "VOLVER_DESDE_REGISTRO_HOMBRE": {
			vf.getVenGenero().setVisible(true);
			vf.getVenRegistroHombre().setVisible(false);
			break;
		}
		
		case "CREAR_CUENTA":{
			try {
				String nombre = vf.getVenRegistroHombre().getTextNombre().getText();
			
				String apellido = vf.getVenRegistroHombre().getTextApellido().getText();
				String email = vf.getVenRegistroHombre().getTextCorreo().getText();
				String alias = vf.getVenRegistroHombre().getTextAlias().getText();
				String contrasena = vf.getVenRegistroHombre().getTextContrasenia().getText();
				double estatura = Double.parseDouble(vf.getVenRegistroHombre().getTextEstatura().getText());
				int promedioIngMensual = Integer.parseInt(vf.getVenRegistroHombre().getTextIngreso().getText());
				
				HombreDTO hombreDTO = new HombreDTO( nombre,  apellido,  email,  contrasena,  LocalDate.now(),  "", false,  false,  alias,  "",  false, 0,  promedioIngMensual,  estatura);
			
			} catch (Exception e1) {
				// TODO: handle exception
			}
			
			break;
		}
		
		case "REGISTRAR_ADMIN_DESDE_HOMBRE": {
			vf.getVenRegistroAdmin().setVisible(true);
			vf.getVenRegistroHombre().setVisible(false);
			break;
		}
		//VENTANA REGISTRO MUJER
		case "VOLVER_DESDE_REGISTRO_MUJER": {
			vf.getVenGenero().setVisible(true);
			vf.getVenRegistroMujer().setVisible(false);
			break;
		}
		
		case "REGISTRAR_ADMIN_DESDE_MUJER": {
			vf.getVenRegistroAdmin().setVisible(true);
			vf.getVenRegistroMujer().setVisible(false);
			break;
		}
		//VENTANA REGISTRO ADMIN
		case "VOLVER_DESDE_REGISTRO_ADMIN": {
			vf.getVenRegistroAdmin().setVisible(false);
			vf.getVenGenero().setVisible(true);
			break;
		}
		
		case "CREAR_CUENTA_ADMIN": {
			vf.getVenRegistroAdmin().setVisible(false);
			vf.getVenCRUD().setVisible(true);
			break;
		}
		
		//VENTANA CRUD
		case "VOLVER_DESDE_CRUD": {
			vf.getVenMenu().setVisible(true);
			vf.getVenCRUD().setVisible(false);
			break;
		}
		
		//VENTANA PRINCIPAL
		case "VOLVER_DESDE_VENTANA_PRINCIPAL" :{
			vf.getVenPrincipal().setVisible(false);
			vf.getVenMenu().setVisible(true);
		}
		}
	}
}
