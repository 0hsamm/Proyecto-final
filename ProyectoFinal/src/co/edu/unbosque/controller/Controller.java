package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.EmailService;
import co.edu.unbosque.util.exception.InvalidDateException;
import co.edu.unbosque.util.exception.InvalidDoubleException;
import co.edu.unbosque.util.exception.InvalidEmailException;
import co.edu.unbosque.util.exception.InvalidHeightException;
import co.edu.unbosque.util.exception.InvalidNameException;
import co.edu.unbosque.util.exception.InvalidPasswordException;
import co.edu.unbosque.util.exception.InvalidPhotoException;
import co.edu.unbosque.util.exception.InvalidSurNameException;
import co.edu.unbosque.util.exception.LanzadorDeExcepcion;
import co.edu.unbosque.view.ViewFacade;
import jakarta.mail.MessagingException;
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
				prop = FileHandler.cargarArchivoDePropiedades("spa.properties");
				break;
			}
			case "2": { // Portugés
				prop = FileHandler.cargarArchivoDePropiedades("por.properties");
				break;
			}
			case "3": { // Ruso
				prop = FileHandler.cargarArchivoDePropiedades("rus.properties");
				break;
			}
			case "4": { // Chino
				prop = FileHandler.cargarArchivoDePropiedades("chi.properties");
				break;
			}
			case "5": { // Hebreo
				prop = FileHandler.cargarArchivoDePropiedades("heb.properties");
				break;
			}
			default:
				JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
				continue mainloop;
			}

			vf.getVenMenu().setProp(prop);
			vf.getVenGenero().setProp(prop);
			vf.getVenRegistroHombre().setProp(prop);
			vf.getVenRegistroMujer().setProp(prop);
			vf.getVenPrincipal().setProp(prop);
			vf.getVenCRUD().setProp(prop);
			vf.getVenRegistroAdmin().setProp(prop);
			vf.getVenInicioSesionAdmin().setProp(prop);
			vf.getVenPerfil().setProp(prop);
			vf.getVenMatch().setProp(prop);
			vf.getVenMenu().setVisible(true);
			//vf.getVenPrincipal().setVisible(true);
			//vf.getVenCRUD().setVisible(true);
			//vf.getVenGenero().setVisible(true);
			//vf.getVenRegistroMujer().setVisible(true);
			//vf.getVenRegistroAdmin().setVisible(true);
			//vf.getVenPerfil().setVisible(true);
			asignarListeners();
			break mainloop;
		}
	}

	public void asignarListeners() {

		// VENTANA MENU 1
		vf.getVenMenu().getBtnConfirmar().addActionListener(this);
		vf.getVenMenu().getBtnConfirmar().setActionCommand("INICIAR_SESION");

		vf.getVenMenu().getBtnRegistro().addActionListener(this);
		vf.getVenMenu().getBtnRegistro().setActionCommand("REGISTRATE_AQUI");

		vf.getVenMenu().getBtnSalir().addActionListener(this);
		vf.getVenMenu().getBtnSalir().setActionCommand("SALIR_MENU");

		vf.getVenMenu().getBtnInicioSesionAdmin().addActionListener(this);
		vf.getVenMenu().getBtnInicioSesionAdmin().setActionCommand("INICIO_SESION_ADMIN");

		vf.getVenMenu().getBtnClaro().addActionListener(this);
		vf.getVenMenu().getBtnClaro().setActionCommand("CLARO_MENU");

		vf.getVenMenu().getBtnOscuro().addActionListener(this);
		vf.getVenMenu().getBtnOscuro().setActionCommand("OSCURO_MENU");

		// VENTANA INICIO SESION ADMIN 1
		vf.getVenInicioSesionAdmin().getBtnConfirmar().addActionListener(this);
		vf.getVenInicioSesionAdmin().getBtnConfirmar().setActionCommand("INICIAR_SESION_DESDE_ADMIN");

		vf.getVenInicioSesionAdmin().getBtnClaro().addActionListener(this);
		vf.getVenInicioSesionAdmin().getBtnClaro().setActionCommand("CLARO_INICIOSESIONADMIN");

		vf.getVenInicioSesionAdmin().getBtnOscuro().addActionListener(this);
		vf.getVenInicioSesionAdmin().getBtnOscuro().setActionCommand("OSCURO_INICIOSESIONADMIN");

		// VENTANA GENERO 1
		vf.getVenGenero().getBtnVolver().addActionListener(this);
		vf.getVenGenero().getBtnVolver().setActionCommand("VOLVER_DESDE_GENERO");

		vf.getVenGenero().getBtnHombre().addActionListener(this);
		vf.getVenGenero().getBtnHombre().setActionCommand("HOMBRE");

		vf.getVenGenero().getBtnMujer().addActionListener(this);
		vf.getVenGenero().getBtnMujer().setActionCommand("MUJER");

		vf.getVenGenero().getBtnClaro().addActionListener(this);
		vf.getVenGenero().getBtnClaro().setActionCommand("CLARO_GENERO");

		vf.getVenGenero().getBtnOscuro().addActionListener(this);
		vf.getVenGenero().getBtnOscuro().setActionCommand("OSCURO_GENERO");

		// VENTANA REGISTRO HOMBRE
		vf.getVenRegistroHombre().getBtnCrearCuenta().addActionListener(this);
		vf.getVenRegistroHombre().getBtnCrearCuenta().setActionCommand("CREAR_CUENTA_HOMBRE");

		vf.getVenRegistroHombre().getBtnVolver().addActionListener(this);
		vf.getVenRegistroHombre().getBtnVolver().setActionCommand("VOLVER_DESDE_REGISTRO_HOMBRE");

		vf.getVenRegistroHombre().getBtnSubirImagen().addActionListener(this);
		vf.getVenRegistroHombre().getBtnSubirImagen().setActionCommand("SUBIR_FOTO_HOMBRE");

		vf.getVenRegistroHombre().getBtnRegistro().addActionListener(this);
		vf.getVenRegistroHombre().getBtnRegistro().setActionCommand("REGISTRAR_ADMIN_DESDE_HOMBRE");
		
		vf.getVenRegistroHombre().getBtnClaro().addActionListener(this);
		vf.getVenRegistroHombre().getBtnClaro().setActionCommand("CLARO_REGISTRO_HOMBRE");

		vf.getVenRegistroHombre().getBtnOscuro().addActionListener(this);
		vf.getVenRegistroHombre().getBtnOscuro().setActionCommand("OSCURO_REGISTRO_HOMBRE");

		// VENTANA REGISTRO MUJER
		vf.getVenRegistroMujer().getBtnCrearCuenta().addActionListener(this);
		vf.getVenRegistroMujer().getBtnCrearCuenta().setActionCommand("CREAR_CUENTA_MUJER");

		vf.getVenRegistroMujer().getBtnVolver().addActionListener(this);
		vf.getVenRegistroMujer().getBtnVolver().setActionCommand("VOLVER_DESDE_REGISTRO_MUJER");

		vf.getVenRegistroMujer().getBtnSubirImagen().addActionListener(this);
		vf.getVenRegistroMujer().getBtnSubirImagen().setActionCommand("SUBIR_FOTO_MUJER");

		vf.getVenRegistroMujer().getBtnRegistro().addActionListener(this);
		vf.getVenRegistroMujer().getBtnRegistro().setActionCommand("REGISTRAR_ADMIN_DESDE_MUJER");
		
		vf.getVenRegistroMujer().getBtnClaro().addActionListener(this);
		vf.getVenRegistroMujer().getBtnClaro().setActionCommand("CLARO_REGISTRO_MUJER");

		vf.getVenRegistroMujer().getBtnOscuro().addActionListener(this);
		vf.getVenRegistroMujer().getBtnOscuro().setActionCommand("OSCURO_REGISTRO_MUJER");

		// VENTANA REGISTRO ADMIN 1
		vf.getVenRegistroAdmin().getBtnVolver().addActionListener(this);
		vf.getVenRegistroAdmin().getBtnVolver().setActionCommand("VOLVER_DESDE_REGISTRO_ADMIN");

		vf.getVenRegistroAdmin().getBtnCrearCuenta().addActionListener(this);
		vf.getVenRegistroAdmin().getBtnCrearCuenta().setActionCommand("CREAR_CUENTA_ADMIN");

		vf.getVenRegistroAdmin().getBtnClaro().addActionListener(this);
		vf.getVenRegistroAdmin().getBtnClaro().setActionCommand("CLARO_REGISTROADMIN");

		vf.getVenRegistroAdmin().getBtnOscuro().addActionListener(this);
		vf.getVenRegistroAdmin().getBtnOscuro().setActionCommand("OSCURO_REGISTROADMIN");

		// VENTANA FUNCIONES ADMIN 1
		vf.getVenCRUD().getBtnVolver().addActionListener(this);
		vf.getVenCRUD().getBtnVolver().setActionCommand("VOLVER_DESDE_CRUD");
		
		vf.getVenCRUD().getBtnClaro().addActionListener(this);
		vf.getVenCRUD().getBtnClaro().setActionCommand("CLARO_CRUD");

		vf.getVenCRUD().getBtnOscuro().addActionListener(this);
		vf.getVenCRUD().getBtnOscuro().setActionCommand("OSCURO_CRUD");

		// VENTANA PRINCIPAL
		vf.getVenPrincipal().getBtnVolver().addActionListener(this);
		vf.getVenPrincipal().getBtnVolver().setActionCommand("VOLVER_DESDE_VENTANA_PRINCIPAL");

		vf.getVenPrincipal().getBtnPerfil().addActionListener(this);
		vf.getVenPrincipal().getBtnPerfil().setActionCommand("ABRIR_PERFIL");
		
		vf.getVenPrincipal().getBtnClaro().addActionListener(this);
		vf.getVenPrincipal().getBtnClaro().setActionCommand("CLARO_PRINCIPAL");

		vf.getVenPrincipal().getBtnOscuro().addActionListener(this);
		vf.getVenPrincipal().getBtnOscuro().setActionCommand("OSCURO_PRINCIPAL");
		
		vf.getVenPrincipal().getBtnLike().addActionListener(this);
		
		// VENTANA PERFIL 1
		vf.getVenPerfil().getBtnMatch().addActionListener(this);
		vf.getVenPerfil().getBtnMatch().setActionCommand("MATCHES");

		vf.getVenPerfil().getBtnVolver().addActionListener(this);
		vf.getVenPerfil().getBtnVolver().setActionCommand("VOLVER_DESDE_PERFIL");
		
		vf.getVenPerfil().getBtnClaro().addActionListener(this);
		vf.getVenPerfil().getBtnClaro().setActionCommand("CLARO_PERFIL");

		vf.getVenPerfil().getBtnOscuro().addActionListener(this);
		vf.getVenPerfil().getBtnOscuro().setActionCommand("OSCURO_PERFIL");
		
		// VENTANA MATCH
		vf.getVenMatch().getBtnVolver().addActionListener(this);
		vf.getVenMatch().getBtnVolver().setActionCommand("VOLVER_DESDE_MATCH");
		
		vf.getVenMatch().getBtnClaro().addActionListener(this);
		vf.getVenMatch().getBtnClaro().setActionCommand("CLARO_MATCH");

		vf.getVenMatch().getBtnOscuro().addActionListener(this);
		vf.getVenMatch().getBtnOscuro().setActionCommand("OSCURO_MATCH");

	}

	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		switch (e.getActionCommand()) {

		// VENTANA MENU

		case "CLARO_MENU": {
			vf.getVenMenu().cambiarFondo("src/co/edu/unbosque/view/VentanaMenuClaro.PNG");

			break;
		}

		case "OSCURO_MENU": {
			vf.getVenMenu().cambiarFondo("src/co/edu/unbosque/view/VentanaMenuOscuro.PNG");

			break;
		}
		case "INICIAR_SESION": {
			try {
				String alias = vf.getVenMenu().getTextAlias().getText().trim();
				String contrasena = new String(vf.getVenMenu().getTextContrasenia().getPassword()).trim();

				if (alias.isEmpty() || contrasena.isEmpty()) {
					JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.iniciar.sesion"));
					break;
				}

				boolean encontrado = false;

				// LOGIN HOMBRE
				System.out.println(prop.getProperty("bostinder.controlador.login.hombre") + mf.getHombreDAO().getListaHombres().size());
				System.out.println(prop.getProperty("bostinder.controlador.login.mujer") + mf.getMujerDAO().getListaMujeres().size());
				// LOGIN HOMBRE
				for (Hombre h : mf.getHombreDAO().getListaHombres()) {
				    if (h == null) continue;

				    String aliasDB = (h.getAlias() == null) ? null : h.getAlias().trim();
				    String passDB  = (h.getContrasena() == null) ? null : h.getContrasena().trim();

				    // DIAGNÓSTICO (temporal): ver exactamente qué comparamos
				    System.out.println("[DEBUG] Hombre-> aliasDB='" + aliasDB + "', passLen: " + (passDB==null? -1 : passDB.length()));

				    boolean aliasOK = (aliasDB != null) && aliasDB.equalsIgnoreCase(alias);
				    boolean passOK  = (passDB  != null) && passDB.equals(contrasena);

				    if (aliasOK && passOK) {
				        JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.bienvenido")+" " + h.getNombre());
				        mf.setUsuarioActual(h);

				        vf.getVenMenu().setVisible(false);
				        vf.getVenPrincipal().setVisible(true);
				        vf.getVenPrincipal().setLocationRelativeTo(null);

				        // centraliza el llenado del feed (recomendado)
				        cargarFeedPara(mf.getUsuarioActual());

				        encontrado = true;
				        break;
				    } else {
				        // MÁS DIAGNÓSTICO (temporal)
				        if (!aliasOK) System.out.println("[DEBUG] Alias no coincide (input='" + alias + "')");
				        if (!passOK)  System.out.println("[DEBUG] Contraseña no coincide (inputLen=" + contrasena.length() + ")");
				    }
				}

				// LOGIN MUJER
				if (!encontrado) {
				    for (Mujer m : mf.getMujerDAO().getListaMujeres()) {
				        if (m == null) continue;

				        String aliasDB = (m.getAlias() == null) ? null : m.getAlias().trim();
				        String passDB  = (m.getContrasena() == null) ? null : m.getContrasena().trim();

				        // DIAGNÓSTICO (temporal)
				        System.out.println("[DEBUG] Mujer-> aliasDB='" + aliasDB + "', passLen=" + (passDB==null? -1 : passDB.length()));

				        boolean aliasOK = (aliasDB != null) && aliasDB.equalsIgnoreCase(alias);
				        boolean passOK  = (passDB  != null) && passDB.equals(contrasena);

				        if (aliasOK && passOK) {
				            JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.bienvenida")+ " " + m.getNombre());
				            mf.setUsuarioActual(m);

				            vf.getVenMenu().setVisible(false);
				            vf.getVenPrincipal().setVisible(true);
				            vf.getVenPrincipal().setLocationRelativeTo(null);

				            cargarFeedPara(mf.getUsuarioActual());

				            encontrado = true;
				            break;
				        } else {
				            if (!aliasOK) System.out.println("[DEBUG] Alias no coincide (input='" + alias + "')");
				            if (!passOK)  System.out.println("[DEBUG] Contraseña no coincide (inputLen=" + contrasena.length() + ")");
				        }
				    }
				}


				if (!encontrado) {
					JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.error.datos"));
				}

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.error.inicio.sesion") + e1.getMessage());
			}
			break;
		}

		case "DAR_LIKE": {
		    try {
		        Usuario usuarioActual = mf.getUsuarioActual();
		        if (usuarioActual == null) {
		            JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.debe.iniciar.sesion"));
		            break;
		        }

		        int fila = vf.getVenPrincipal().getTablaUsuarios().getSelectedRow();
		        if (fila == -1) {
		            JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.debe.seleccionar.persona"));
		            break;
		        }

		        String aliasSeleccionado = (String) vf.getVenPrincipal().getTablaUsuarios().getValueAt(fila, 2);

		        if (usuarioActual.getAlias() != null && usuarioActual.getAlias().equalsIgnoreCase(aliasSeleccionado)) {
		            JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.no.like.mismo.usuario"));
		            break;
		        }

		        Usuario receptor = buscarUsuarioPorAlias(aliasSeleccionado);
		        if (receptor == null) {
		            JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.usuario.no.encontrado"));
		            break;
		        }

		        boolean agregado = usuarioActual.darLike(receptor);
		        if (!agregado) {
		            JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.like.ya.dado") + " " + receptor.getNombre());
		            break;
		        }

		        persistirUsuario(usuarioActual);
		        persistirUsuario(receptor);

		        JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.like.dado") + " " + receptor.getNombre());

		        DefaultTableModel modelo = (DefaultTableModel) vf.getVenPrincipal().getTablaUsuarios().getModel();
		        modelo.setValueAt(receptor.getNumLikes(), fila, modelo.getColumnCount() - 1);
		        modelo.fireTableDataChanged();

		    } catch (Exception e1) {
		        JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.error.dar.like") + e1.getMessage());
		    }
		    break;
		}




		case "REGISTRATE_AQUI": {
			vf.getVenMenu().setVisible(false);
			vf.getVenGenero().setVisible(true);
			break;
		}

		case "INICIO_SESION_ADMIN": {
			vf.getVenMenu().setVisible(false);
			vf.getVenInicioSesionAdmin().setVisible(true);
			break;
		}

		case "CLARO_INICIOSESIONADMIN": {
			vf.getVenInicioSesionAdmin().cambiarFondo("src/co/edu/unbosque/view/VentanaIniciarSesionAdminClaro.PNG");

			break;
		}

		case "OSCURO_INICIOSESIONADMIN": {
			vf.getVenInicioSesionAdmin().cambiarFondo("src/co/edu/unbosque/view/VentanaIniciarSesionAdminOscuro.PNG");

			break;
		}

		case "INICIAR_SESION_DESDE_ADMIN": {
			String correo = vf.getVenInicioSesionAdmin().getTextCorreo().getText().trim();
			String contrasena = new String(vf.getVenMenu().getTextContrasenia().getPassword()).trim();

			if (correo.isEmpty() || contrasena.isEmpty()) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.inicio.sesion.admin"));
				break;
			}

			boolean encontrado = false;

			// Buscar en hombres
			for (Hombre h : mf.getHombreDAO().getListaHombres()) {
				if (h != null && h.getEmail() != null && h.getContrasena() != null) {
					if (h.getEmail().equalsIgnoreCase(correo) && h.getContrasena().equals(contrasena)
							&& h.isEsAdministrador()) {

						JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.bienvenido.admin.hombre") + h.getNombre());
						vf.getVenInicioSesionAdmin().setVisible(false);
						vf.getVenPrincipal().setVisible(true);
						encontrado = true;
						break;
					}
				}
			}

			// Buscar en mujeres si no se encontró antes
			if (!encontrado) {
				for (Mujer m : mf.getMujerDAO().getListaMujeres()) {
					if (m != null && m.getEmail() != null && m.getContrasena() != null) {
						if (m.getEmail().equalsIgnoreCase(correo) && m.getContrasena().equals(contrasena)
								&& m.isEsAdministrador()) {

							JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.bienvenido.admin.mujer") + m.getNombre());
							vf.getVenInicioSesionAdmin().setVisible(false);
							vf.getVenPrincipal().setVisible(true);
							encontrado = true;
							break;
						}
					}
				}
			}

			if (!encontrado) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.invalido.admin"));
			}

			break;
		}
		// VENTANA INICIO SESION ADMIN
		case "SALIR_MENU": {
			vf.getVenMenu().dispose();
			break;
		}
		// VENTANA GENERO
		case "VOLVER_DESDE_GENERO": {
			vf.getVenGenero().setVisible(false);
			vf.getVenMenu().setVisible(true);
			break;
		}

		case "CLARO_GENERO": {
			vf.getVenGenero().cambiarFondo("src/co/edu/unbosque/view/VentanaEscogerGeneroClaro.PNG");

			break;
		}

		case "OSCURO_GENERO": {
			vf.getVenGenero().cambiarFondo("src/co/edu/unbosque/view/VentanaEscogerGeneroOscuro.PNG");

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
		// VENTANA REGISTRO HOMBRE
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
		
		case "CLARO_REGISTRO_HOMBRE": {
			vf.getVenRegistroHombre().cambiarFondo("src/co/edu/unbosque/view/VentanaRegistroHombreClaro.PNG");
			vf.getVenRegistroHombre().getLblAlias().setForeground(Color.BLACK);
			vf.getVenRegistroHombre().getLblApellido().setForeground(Color.BLACK);
			vf.getVenRegistroHombre().getLblContrasenia().setForeground(Color.BLACK);
			vf.getVenRegistroHombre().getLblCorreo().setForeground(Color.BLACK);
			vf.getVenRegistroHombre().getLblEstatura().setForeground(Color.BLACK);
			vf.getVenRegistroHombre().getLblIngreso().setForeground(Color.BLACK);
			vf.getVenRegistroHombre().getLblNacimiento().setForeground(Color.BLACK);
			vf.getVenRegistroHombre().getLblNombre().setForeground(Color.BLACK);
			vf.getVenRegistroHombre().getLblRegistro().setForeground(Color.BLACK);

			break;
		}

		case "OSCURO_REGISTRO_HOMBRE": {
			vf.getVenRegistroHombre().cambiarFondo("src/co/edu/unbosque/view/VentanaRegistroHombreOscuro.PNG");
			vf.getVenRegistroHombre().getLblAlias().setForeground(Color.WHITE);
			vf.getVenRegistroHombre().getLblApellido().setForeground(Color.WHITE);
			vf.getVenRegistroHombre().getLblContrasenia().setForeground(Color.WHITE);
			vf.getVenRegistroHombre().getLblCorreo().setForeground(Color.WHITE);
			vf.getVenRegistroHombre().getLblEstatura().setForeground(Color.WHITE);
			vf.getVenRegistroHombre().getLblIngreso().setForeground(Color.WHITE);
			vf.getVenRegistroHombre().getLblNacimiento().setForeground(Color.WHITE);
			vf.getVenRegistroHombre().getLblNombre().setForeground(Color.WHITE);
			vf.getVenRegistroHombre().getLblRegistro().setForeground(Color.WHITE);

			break;
		}
		// VENTANA REGISTRO MUJER
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
		
		case "CLARO_REGISTRO_MUJER": {
			vf.getVenRegistroMujer().cambiarFondo("src/co/edu/unbosque/view/VentanaRegistroMujerClaro.PNG");
			vf.getVenRegistroMujer().getLblAlias().setForeground(Color.BLACK);
			vf.getVenRegistroMujer().getLblApellido().setForeground(Color.BLACK);
			vf.getVenRegistroMujer().getLblContrasenia().setForeground(Color.BLACK);
			vf.getVenRegistroMujer().getLblCorreo().setForeground(Color.BLACK);
			vf.getVenRegistroMujer().getLblDivorcio().setForeground(Color.BLACK);
			vf.getVenRegistroMujer().getLblEstatura().setForeground(Color.BLACK);
			vf.getVenRegistroMujer().getLblNacimiento().setForeground(Color.BLACK);
			vf.getVenRegistroMujer().getLblNombre().setForeground(Color.BLACK);
			vf.getVenRegistroMujer().getLblRegistro().setForeground(Color.BLACK);

			break;
		}

		case "OSCURO_REGISTRO_MUJER": {
			vf.getVenRegistroMujer().cambiarFondo("src/co/edu/unbosque/view/VentanaRegistroMujerOscuro.PNG");
			vf.getVenRegistroMujer().getLblAlias().setForeground(Color.WHITE);
			vf.getVenRegistroMujer().getLblApellido().setForeground(Color.WHITE);
			vf.getVenRegistroMujer().getLblContrasenia().setForeground(Color.WHITE);
			vf.getVenRegistroMujer().getLblCorreo().setForeground(Color.WHITE);
			vf.getVenRegistroMujer().getLblDivorcio().setForeground(Color.WHITE);
			vf.getVenRegistroMujer().getLblEstatura().setForeground(Color.WHITE);
			vf.getVenRegistroMujer().getLblNacimiento().setForeground(Color.WHITE);
			vf.getVenRegistroMujer().getLblNombre().setForeground(Color.WHITE);
			vf.getVenRegistroMujer().getLblRegistro().setForeground(Color.WHITE);

			break;
		}
		// VENTANA REGISTRO ADMIN
		case "VOLVER_DESDE_REGISTRO_ADMIN": {
			vf.getVenRegistroAdmin().setVisible(false);
			vf.getVenGenero().setVisible(true);
			break;
		}
		
		case "CLARO_REGISTROADMIN": {
			vf.getVenRegistroAdmin().cambiarFondo("src/co/edu/unbosque/view/VentanaRegistroAdminClaro.PNG");
			vf.getVenRegistroAdmin().getLblApellido().setForeground(Color.BLACK);
			vf.getVenRegistroAdmin().getLblContrasenia().setForeground(Color.BLACK);
			vf.getVenRegistroAdmin().getLblCorreo().setForeground(Color.BLACK);
			vf.getVenRegistroAdmin().getLblNacimiento().setForeground(Color.BLACK);
			vf.getVenRegistroAdmin().getLblNombre().setForeground(Color.BLACK);

			break;
		}

		case "OSCURO_REGISTROADMIN": {
			vf.getVenRegistroAdmin().cambiarFondo("src/co/edu/unbosque/view/VentanaRegistroAdminOscuro.PNG");
			vf.getVenRegistroAdmin().getLblApellido().setForeground(Color.WHITE);
			vf.getVenRegistroAdmin().getLblContrasenia().setForeground(Color.WHITE);
			vf.getVenRegistroAdmin().getLblCorreo().setForeground(Color.WHITE);
			vf.getVenRegistroAdmin().getLblNacimiento().setForeground(Color.WHITE);
			vf.getVenRegistroAdmin().getLblNombre().setForeground(Color.WHITE);

			break;
		}

		case "CREAR_CUENTA_ADMIN": {
			vf.getVenRegistroAdmin().setVisible(false);
			vf.getVenCRUD().setVisible(true);
			break;
		}

		// VENTANA CRUD
		case "VOLVER_DESDE_CRUD": {
			vf.getVenMenu().setVisible(true);
			vf.getVenCRUD().setVisible(false);
			break;
		}
		
		case "CLARO_CRUD": {
			vf.getVenCRUD().cambiarFondo("src/co/edu/unbosque/view/VentanaFuncionesAdminClaro.PNG");

			break;
		}

		case "OSCURO_CRUD": {
			vf.getVenCRUD().cambiarFondo("src/co/edu/unbosque/view/VentanaFuncionesAdminOscuro.PNG");

			break;
		}

		// VENTANA PRINCIPAL
		case "VOLVER_DESDE_VENTANA_PRINCIPAL": {
			vf.getVenPrincipal().setVisible(false);
			vf.getVenMenu().setVisible(true);
			break;
		}
		case "ABRIR_PERFIL": {
			vf.getVenPerfil().setVisible(true);
			vf.getVenPrincipal().setVisible(false);
			break;
		}
		
		case "CLARO_PRINCIPAL": {
			vf.getVenPrincipal().cambiarFondo("src/co/edu/unbosque/view/VentanaPrincipalClaro.PNG");

			break;
		}

		case "OSCURO_PRINCIPAL": {
			vf.getVenPrincipal().cambiarFondo("src/co/edu/unbosque/view/VentanaPrincipalOscuro.PNG");

			break;
		}
		
		// crear cuentas
		case "CREAR_CUENTA_HOMBRE": {
			try {

				String nombre = vf.getVenRegistroHombre().getTextNombre().getText();
				LanzadorDeExcepcion.verificarNombre(nombre);
				String apellido = vf.getVenRegistroHombre().getTextApellido().getText();
				LanzadorDeExcepcion.verificarApellido(apellido);
				String alias = vf.getVenRegistroHombre().getTextAlias().getText();
				String correo = vf.getVenRegistroHombre().getTextCorreo().getText();
				LanzadorDeExcepcion.verificarEmail(correo);
				String contrasena = new String(vf.getVenRegistroHombre().getTextContrasenia().getPassword()).trim();
				LanzadorDeExcepcion.verificarTamanoContrasena(contrasena);
				LocalDate fechaNacimiento = vf.getVenRegistroHombre().getFechaSeleccionada();
				LanzadorDeExcepcion.verificarEdad(fechaNacimiento);
				String genero = "Hombre";
				String urlFoto = vf.getVenRegistroHombre().getRutaFotoPerfil();
				LanzadorDeExcepcion.verificarFoto(urlFoto);
				boolean esAdministrador = false;
				boolean estaDisponible = true;
				boolean esIncognito = false;
				int numLikes = 0;
				int ingresos = Integer.parseInt(vf.getVenRegistroHombre().getTextIngreso().getText());
				double estatura = Double.parseDouble(vf.getVenRegistroHombre().getTextEstatura().getText());
				LanzadorDeExcepcion.verificarAltura(estatura);
				LanzadorDeExcepcion.verificarDouble(estatura);

				// Generar y enviar el código de verificación al correo ingresado
				String codigo = EmailService.generarCodigo();
				EmailService.enviarCodigo(correo, codigo);
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.codigo.crear"));

				// Solicitar el código
				String codigoIngresado = JOptionPane.showInputDialog(null,
						prop.getProperty("bostinder.controlador.codigo.ingreso"), prop.getProperty("bostinder.controlador.ingreso.verificacion"),
						JOptionPane.QUESTION_MESSAGE);

				// Validar el código
				if (codigoIngresado == null || !codigoIngresado.equals(codigo)) {
					JOptionPane.showMessageDialog(null,
							prop.getProperty("bostinder.controlador.codigo.error"));
					break;
				}

				HombreDTO nuevo = new HombreDTO(nombre, apellido, correo, contrasena, fechaNacimiento, genero,
						esAdministrador, estaDisponible, alias, urlFoto, esIncognito, numLikes, ingresos, estatura);

				mf.getHombreDAO().create(nuevo);
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.crear.exito"));

				vf.getVenRegistroHombre().setVisible(false);
				vf.getVenMenu().setVisible(true);

			} catch (InvalidNameException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.nombre"));
			} catch (InvalidSurNameException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.apellido"));
			} catch (InvalidEmailException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.correo"));
			} catch (InvalidPasswordException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.contrasena"));
			}catch (InvalidHeightException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.altura"));
			} catch (InvalidDoubleException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.double"));
			} catch (MessagingException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.mensaje.correo"));
			} catch (InvalidDateException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.fecha"));
			}catch (InvalidPhotoException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.foto"));

			}
			break;
		}
		case "CREAR_CUENTA_MUJER": {
			try {

				String nombre = vf.getVenRegistroMujer().getTextNombre().getText();
				LanzadorDeExcepcion.verificarNombre(nombre);
				String apellido = vf.getVenRegistroMujer().getTextApellido().getText();
				LanzadorDeExcepcion.verificarApellido(apellido);
				String alias = vf.getVenRegistroMujer().getTextAlias().getText();
				String correo = vf.getVenRegistroMujer().getTextCorreo().getText();
				LanzadorDeExcepcion.verificarEmail(correo);
				String contrasena = new String(vf.getVenRegistroMujer().getTextContrasenia().getPassword()).trim();
				LanzadorDeExcepcion.verificarTamanoContrasena(contrasena);
				LocalDate fechaNacimiento = vf.getVenRegistroMujer().getFechaSeleccionada();
				LanzadorDeExcepcion.verificarEdad(fechaNacimiento);
				String genero = "Mujer";
				boolean esAdministrador = false;
				boolean estaDisponible = true;
				String urlFoto = vf.getVenRegistroMujer().getRutaFotoPerfil();
				boolean esIncognito = false;
				int numLikes = 0;
				double estatura = Double.parseDouble(vf.getVenRegistroMujer().getTextEstatura().getText());
				LanzadorDeExcepcion.verificarAltura(estatura);
				LanzadorDeExcepcion.verificarDouble(estatura);
				boolean esDivorciada = vf.getVenRegistroMujer().getCbDivorcio().getSelectedItem().equals("Sí");

				// Generar y enviar código al correo ingresado
				String codigo = EmailService.generarCodigo();
				EmailService.enviarCodigo(correo, codigo);
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.codigo.crear"));

				// Solicitar el código
				String codigoIngresado = JOptionPane.showInputDialog(null,
						prop.getProperty("bostinder.controlador.codigo.ingreso"), prop.getProperty("bostinder.controlador.ingreso.verificacion"),
						JOptionPane.QUESTION_MESSAGE);

				// Validar codigo
				if (codigoIngresado == null || !codigoIngresado.equals(codigo)) {
					JOptionPane.showMessageDialog(null,
							prop.getProperty("bostinder.controlador.codigo.error"));
					break;
				}

				MujerDTO nueva = new MujerDTO(nombre, apellido, correo, contrasena, fechaNacimiento, genero,
						esAdministrador, estaDisponible, alias, urlFoto, esIncognito, numLikes, estatura, esDivorciada);

				mf.getMujerDAO().create(nueva);
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.crear.exito"));

				vf.getVenRegistroMujer().setVisible(false);
				vf.getVenMenu().setVisible(true);

			} catch (InvalidNameException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.nombre"));
			} catch (InvalidSurNameException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.apellido"));
			} catch (InvalidEmailException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.correo"));
			} catch (InvalidPasswordException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.contrasena"));
			} catch (InvalidHeightException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.altura"));
			} catch (InvalidDoubleException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.double"));
			} catch (MessagingException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.mensaje.correo"));
			} catch (InvalidDateException ex) {
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.fecha"));
			}
			break;
		}
		case "CREAR_CUENTA_ADMINISTRADOR": {
			try {
				String nombre = vf.getVenRegistroAdmin().getTextNombre().getText().trim();
				String apellido = vf.getVenRegistroAdmin().getTextApellido().getText().trim();
				String email = vf.getVenRegistroAdmin().getTextCorreo().getText().trim();
				String contrasena = new String(vf.getVenMenu().getTextContrasenia().getPassword()).trim();
				LocalDate fechaNacimiento = vf.getVenRegistroAdmin().getFechaSeleccionada();

				// Validación básica
				if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty()
						|| fechaNacimiento == null) {
					JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.crear.administrador.vacio"));
					break;
				}

				// Generar y enviar código de verificación
				String codigo = EmailService.generarCodigo();
				EmailService.enviarCodigo(email, codigo);

				// Pedir código al usuario
				String ingresado = JOptionPane.showInputDialog(null,
						prop.getProperty("bostinder.controlador.codigo.ingreso"));

				if (ingresado != null && ingresado.equals(codigo)) {
					// Crear DTO
					AdministradorDTO nuevo = new AdministradorDTO(nombre, apellido, email, contrasena, fechaNacimiento,
							"Administrador", true);

					// Guardar
					mf.getAdminDAO().create(nuevo);

					JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.crear.administrador.exito"));
					vf.getVenRegistroAdmin().setVisible(false);
					vf.getVenMenu().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.controlador.codigo.error"));
				}

			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, prop.getProperty("bostinder.excepcion.cuenta") + ex.getMessage());
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

		// VENTANA PERFIL
		case "MATCHES": {
			vf.getVenPerfil().setVisible(false);
			vf.getVenMatch().setVisible(true);
			break;
		}

		case "VOLVER_DESDE_PERFIL": {
			vf.getVenPerfil().setVisible(false);
			vf.getVenPrincipal().setVisible(true);
			break;
		}
		
		case "CLARO_PERFIL": {
			vf.getVenPerfil().cambiarFondo("src/co/edu/unbosque/view/VentanaPerfilClaro.PNG");

			break;
		}

		case "OSCURO_PERFIL": {
			vf.getVenPerfil().cambiarFondo("src/co/edu/unbosque/view/VentanaPerfilOscuro.PNG");

			break;
		}
		
		//VENTANA MATCH
		
		case "VOLVER_DESDE_MATCH": {
			vf.getVenMatch().setVisible(false);
			vf.getVenPerfil().setVisible(true);
			break;
		}
		
		case "CLARO_MATCH": {
			vf.getVenMatch().cambiarFondo("src/co/edu/unbosque/view/VentanaMatchClaro.PNG");

			break;
		}

		case "OSCURO_MATCH": {
			vf.getVenMatch().cambiarFondo("src/co/edu/unbosque/view/VentanaMatchOscuro.PNG");

			break;
		}
		}
	}
	//metodos auxiliares
	// Busca un usuario por alias revisando primero hombres y luego mujeres
	private Usuario buscarUsuarioPorAlias(String alias) {
	    if (alias == null) return null;
	    for (Hombre h : mf.getHombreDAO().getListaHombres()) {
	        if (h != null && h.getAlias() != null && h.getAlias().equalsIgnoreCase(alias)) return h;
	    }
	    for (Mujer m : mf.getMujerDAO().getListaMujeres()) {
	        if (m != null && m.getAlias() != null && m.getAlias().equalsIgnoreCase(alias)) return m;
	    }
	    return null;
	}

	// Persiste un usuario en su DAO correspondiente (actualiza + serializa)
	private void persistirUsuario(Usuario u) {
	    if (u instanceof Hombre) {
	        Hombre h = (Hombre) u;
	        int idx = mf.getHombreDAO().getListaHombres().indexOf(h);
	        if (idx >= 0) {
	            HombreDTO dto = DataMapper.convertirHombreAHombreDTO(h);
	            mf.getHombreDAO().update(idx, dto);
	        }
	        mf.getHombreDAO().escribirEnArchivoDeTexto();
	        mf.getHombreDAO().escribirEnArchivoSerializado();
	    } else if (u instanceof Mujer) {
	        Mujer m = (Mujer) u;
	        int idx = mf.getMujerDAO().getListaMujeres().indexOf(m);
	        if (idx >= 0) {
	            MujerDTO dto = DataMapper.convertirMujerAMujerDTO(m);
	            mf.getMujerDAO().update(idx, dto);
	        }
	        mf.getMujerDAO().escribirEnArchivoDeTexto();
	        mf.getMujerDAO().escribirEnArchivoSerializado();
	    }
	}



	
	
	
	private boolean debeMostrarseEnFeed(Usuario actual, Usuario candidato) {
	    if (candidato == null) return false;
	    if (candidato.getAlias() == null) return false;

	    if (actual.getAlias() != null && candidato.getAlias().equalsIgnoreCase(actual.getAlias())) return false;
	    if (candidato.isEsIncognito()) return false;
	    if (!candidato.isEstaDisponible()) return false;

	    if (actual.getLikesDados().contains(candidato)) return false;

	    return true;
	}

	// Carga la tabla de VenPrincipal según el tipo del usuario logueado (Hombre -> lista Mujeres; Mujer -> lista Hombres)
	private void cargarFeedPara(Usuario actual) {
	    javax.swing.JTable tabla = vf.getVenPrincipal().getTablaUsuarios();
	    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();

	    String[] columnas = { "Foto", "Nombre", "Alias", "Correo", "Edad", "Género", "Estatura (cm)", "Extra", "Likes" };
	    modelo.setColumnIdentifiers(columnas);
	    modelo.setRowCount(0);

	    // Primero todos los hombres
	    for (Hombre ho : mf.getHombreDAO().getListaHombres()) {
	        if (!debeMostrarseEnFeed(actual, ho)) continue;

	        javax.swing.ImageIcon icon;
	        try {
	            java.awt.Image img = new javax.swing.ImageIcon(ho.getURLfoto())
	                    .getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
	            icon = new javax.swing.ImageIcon(img);
	        } catch (Exception e1) {
	            icon = new javax.swing.ImageIcon(
	                    new java.awt.image.BufferedImage(60, 60, java.awt.image.BufferedImage.TYPE_INT_ARGB));
	        }

	        int edad = java.time.Period.between(ho.getFechaNacimiento(), java.time.LocalDate.now()).getYears();
	        String extra = String.valueOf(ho.getPromedioIngMensual()); // para hombres: ingresos

	        modelo.addRow(new Object[] {
	                icon,
	                ho.getNombre() + " " + ho.getApellido(),
	                ho.getAlias(),
	                ho.getEmail(),
	                edad,
	                ho.getGenero(),          // "Hombre"
	                ho.getEstatura(),
	                extra,                   // Ingresos
	                ho.getNumLikes()
	        });
	    }

	    // Luego todas las mujeres
	    for (Mujer mu : mf.getMujerDAO().getListaMujeres()) {
	        if (!debeMostrarseEnFeed(actual, mu)) continue;

	        javax.swing.ImageIcon icon;
	        try {
	            java.awt.Image img = new javax.swing.ImageIcon(mu.getURLfoto())
	                    .getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
	            icon = new javax.swing.ImageIcon(img);
	        } catch (Exception e1) {
	            icon = new javax.swing.ImageIcon(
	                    new java.awt.image.BufferedImage(60, 60, java.awt.image.BufferedImage.TYPE_INT_ARGB));
	        }

	        int edad = java.time.Period.between(mu.getFechaNacimiento(), java.time.LocalDate.now()).getYears();
	        String extra = mu.isEsDivorciada() ? "Divorciada" : "No divorciada"; // para mujeres: estado civil

	        modelo.addRow(new Object[] {
	                icon,
	                mu.getNombre() + " " + mu.getApellido(),
	                mu.getAlias(),
	                mu.getEmail(),
	                edad,
	                mu.getGenero(),          // "Mujer"
	                mu.getEstatura(),
	                extra,                   // Divorciada / No
	                mu.getNumLikes()
	        });
	    }

	    tabla.setRowHeight(60);
	    tabla.getColumnModel().getColumn(0).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
	        @Override
	        public void setValue(Object value) {
	            if (value instanceof javax.swing.ImageIcon) {
	                setIcon((javax.swing.ImageIcon) value);
	                setText("");
	            } else {
	                super.setValue(value);
	            }
	        }
	    });
	}

	
}