package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.EmailService;
import co.edu.unbosque.view.ViewFacade;

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
		    try {
		        String alias = vf.getVenMenu().getTextAlias().getText().trim();
		        String contrasena = vf.getVenMenu().getTextContrasenia().getText().trim();

		        if (alias.isEmpty() || contrasena.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Por favor ingrese alias y contraseña.");
		            break;
		        }

		        boolean encontrado = false;

		        // Buscar en Hombres
		        for (Hombre h : mf.getHombreDAO().getListaHombres()) {
		            if (h == null) continue;

		            String aliasH = h.getAlias();
		            String passH = h.getContrasena();

		            if (aliasH != null && passH != null &&
		                aliasH.equalsIgnoreCase(alias) &&
		                passH.equals(contrasena)) {

		                JOptionPane.showMessageDialog(null, "Bienvenido " + h.getNombre() + " 👋");
		                vf.getVenMenu().setVisible(false);
		                vf.getVenPrincipal().setVisible(true);
		                encontrado = true;
		                break;
		            }
		        }

		        // Buscar en Mujeres si no se encontró antes
		        if (!encontrado) {
		            for (Mujer m : mf.getMujerDAO().getListaMujeres()) {
		                if (m == null) continue;

		                String aliasM = m.getAlias();
		                String passM = m.getContrasena();

		                if (aliasM != null && passM != null &&
		                    aliasM.equalsIgnoreCase(alias) &&
		                    passM.equals(contrasena)) {

		                    JOptionPane.showMessageDialog(null, "Bienvenida " + m.getNombre() + " 💕");
		                    vf.getVenMenu().setVisible(false);
		                    vf.getVenPrincipal().setVisible(true);
		                    encontrado = true;
		                    break;
		                }
		            }
		        }

		        if (!encontrado) {
		            JOptionPane.showMessageDialog(null, "Alias o contraseña incorrectos ❌");
		        }

		    } catch (Exception e1) {
		        e1.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e1.getMessage());
		    }
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
			break;
		}
		case "CREAR_CUENTA_HOMBRE": {
		    try {
		        
		        String nombre = vf.getVenRegistroHombre().getTextNombre().getText();
		        String apellido = vf.getVenRegistroHombre().getTextApellido().getText();
		        String alias = vf.getVenRegistroHombre().getTextAlias().getText();
		        String correo = vf.getVenRegistroHombre().getTextCorreo().getText();
		        String contrasena = vf.getVenRegistroHombre().getTextContrasenia().getText();
		        LocalDate fechaNacimiento = vf.getVenRegistroHombre().getFechaSeleccionada();
		        String genero = "Hombre";
		        boolean esAdministrador = false;
		        boolean estaDisponible = true;
		        String urlFoto = vf.getVenRegistroHombre().getRutaFotoPerfil();
		        boolean esIncognito = false;
		        int numLikes = 0;
		        int ingresos = Integer.parseInt(vf.getVenRegistroHombre().getTextIngreso().getText());
		        double estatura = Double.parseDouble(vf.getVenRegistroHombre().getTextEstatura().getText());

		        //Generar y enviar el código de verificación al correo ingresado
		        String codigo = EmailService.generarCodigo();
		        EmailService.enviarCodigo(correo, codigo);
		        JOptionPane.showMessageDialog(null, "Se ha enviado un código de verificación a tu correo electrónico.");

		        // Solicitar el código 
		        String codigoIngresado = JOptionPane.showInputDialog(
		                null,
		                "Ingresa el código de verificación que se envió a tu correo:",
		                "Verificación de correo",
		                JOptionPane.QUESTION_MESSAGE
		        );

		        //Validar el código
		        if (codigoIngresado == null || !codigoIngresado.equals(codigo)) {
		            JOptionPane.showMessageDialog(null, "El código ingresado es incorrecto. No se ha creado la cuenta.");
		            break;
		        }

		        
		        HombreDTO nuevo = new HombreDTO(nombre, apellido, correo, contrasena, fechaNacimiento, genero,
		                esAdministrador, estaDisponible, alias, urlFoto, esIncognito, numLikes,ingresos, estatura);

		        mf.getHombreDAO().create(nuevo);
		        JOptionPane.showMessageDialog(null, "¡Cuenta creada exitosamente!");

		        vf.getVenRegistroHombre().setVisible(false);
		        vf.getVenMenu().setVisible(true);

		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al crear la cuenta o enviar el correo.");
		    }
		    break;
		}
		case "CREAR_CUENTA_MUJER": {
		    try {
		      
		        String nombre = vf.getVenRegistroMujer().getTextNombre().getText();
		        String apellido = vf.getVenRegistroMujer().getTextApellido().getText();
		        String alias = vf.getVenRegistroMujer().getTextAlias().getText();
		        String correo = vf.getVenRegistroMujer().getTextCorreo().getText();
		        String contrasena = vf.getVenRegistroMujer().getTextContrasenia().getText();
		        LocalDate fechaNacimiento = vf.getVenRegistroMujer().getFechaSeleccionada();
		        String genero = "Mujer";
		        boolean esAdministrador = false;
		        boolean estaDisponible = true;
		        String urlFoto = vf.getVenRegistroHombre().getRutaFotoPerfil();
		        boolean esIncognito = false;
		        int numLikes = 0;
		        double estatura = Double.parseDouble(vf.getVenRegistroMujer().getTextEstatura().getText());
		        boolean esDivorciada = vf.getVenRegistroMujer().getCbDivorcio().getSelectedItem().equals("Sí");

		        //Generar y enviar código al correo ingresado
		        String codigo = EmailService.generarCodigo();
		        EmailService.enviarCodigo(correo, codigo);
		        JOptionPane.showMessageDialog(null, "Se ha enviado un código de verificación a tu correo electrónico.");

		        //Solicitar el código
		        String codigoIngresado = JOptionPane.showInputDialog(
		                null,
		                "Ingresa el código de verificación que se envió a tu correo:",
		                "Verificación de correo",
		                JOptionPane.QUESTION_MESSAGE
		        );

		        // Validar codigo
		        if (codigoIngresado == null || !codigoIngresado.equals(codigo)) {
		            JOptionPane.showMessageDialog(null, "El código ingresado es incorrecto. No se ha creado la cuenta.");
		            break;
		        }

		       
		        MujerDTO nueva = new MujerDTO(nombre, apellido, correo, contrasena, fechaNacimiento, genero,
		                esAdministrador, estaDisponible, alias, urlFoto, esIncognito, numLikes,estatura, esDivorciada);

		        mf.getMujerDAO().create(nueva);
		        JOptionPane.showMessageDialog(null, "¡Cuenta creada exitosamente!");

		        vf.getVenRegistroMujer().setVisible(false);
		        vf.getVenMenu().setVisible(true);

		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al crear la cuenta o enviar el correo.");
		    }
		    break;
		}
		case "CREAR_CUENTA_ADMINISTRADOR": {
		    try {
		        String nombre = vf.getVenRegistroAdmin().getTextNombre().getText().trim();
		        String apellido = vf.getVenRegistroAdmin().getTextApellido().getText().trim();
		        String email = vf.getVenRegistroAdmin().getTextCorreo().getText().trim();
		        String contrasena = vf.getVenRegistroAdmin().getTextContrasenia().getText().trim();
		        LocalDate fechaNacimiento = vf.getVenRegistroAdmin().getFechaSeleccionada();

		        // Validación básica
		        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty() || fechaNacimiento == null) {
		            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos antes de continuar.");
		            break;
		        }

		        // Generar y enviar código de verificación
		        String codigo = EmailService.generarCodigo();
		        EmailService.enviarCodigo(email, codigo);

		        // Pedir código al usuario
		        String ingresado = JOptionPane.showInputDialog(null,
		                "Ingrese el código de verificación enviado a su correo:");

		        if (ingresado != null && ingresado.equals(codigo)) {
		            // Crear DTO
		            AdministradorDTO nuevo = new AdministradorDTO(
		                    nombre, apellido, email, contrasena, fechaNacimiento, "Administrador", true
		            );

		            // Guardar
		            mf.getAdminDAO().create(nuevo);

		            JOptionPane.showMessageDialog(null, "Cuenta de administrador creada correctamente.");
		            vf.getVenRegistroAdmin().setVisible(false);
		            vf.getVenMenu().setVisible(true);
		        } else {
		            JOptionPane.showMessageDialog(null, "Código de verificación incorrecto. Intenta de nuevo.");
		        }

		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al crear cuenta: " + ex.getMessage());
		    }
		    break;
		}
		case "VOLVER_MENU_HOMBRE": {
		    vf.getVenRegistroHombre().setVisible(false);
		    vf.getVenMenu().setVisible(true);
		    break;
		}

		case "VOLVER_MENU_MUJER": {
		    vf.getVenRegistroMujer().setVisible(false);
		    vf.getVenMenu().setVisible(true);
		    break;
		}

		case "VOLVER_MENU_ADMIN": {
		    vf.getVenRegistroAdmin().setVisible(false);
		    vf.getVenMenu().setVisible(true);
		    break;
		}

		}
	}
}
