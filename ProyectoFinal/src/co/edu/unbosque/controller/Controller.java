package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.Period;
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
			vf.getVenInicioSesionAdmin().setProp(prop);
			vf.getVenPerfil().setProp(prop);
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
		
		//VENTANA MENU
		vf.getVenMenu().getBtnConfirmar().addActionListener(this);
		vf.getVenMenu().getBtnConfirmar().setActionCommand("INICIAR_SESION");

		vf.getVenMenu().getBtnRegistro().addActionListener(this);
		vf.getVenMenu().getBtnRegistro().setActionCommand("REGISTRATE_AQUI");

		vf.getVenMenu().getBtnSalir().addActionListener(this);
		vf.getVenMenu().getBtnSalir().setActionCommand("SALIR_MENU");
		
		vf.getVenMenu().getBtnInicioSesionAdmin().addActionListener(this);
		vf.getVenMenu().getBtnInicioSesionAdmin().setActionCommand("INICIO_SESION_ADMIN");
		
		//VENTANA INICIO SESION ADMIN
		vf.getVenInicioSesionAdmin().getBtnConfirmar().addActionListener(this);
		vf.getVenInicioSesionAdmin().getBtnConfirmar().setActionCommand("INICIAR_SESION_DESDE_ADMIN");
		
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
		
		vf.getVenPrincipal().getBtnPerfil().addActionListener(this);
		vf.getVenPrincipal().getBtnPerfil().setActionCommand("ABRIR_PERFIL");
		
		//VENTANA PERFIL
		vf.getVenPerfil().getBtnCerrarSesion().addActionListener(this);
		vf.getVenPerfil().getBtnCerrarSesion().setActionCommand("CERRAR_SESION");
		
		vf.getVenPerfil().getBtnVolver().addActionListener(this);
		vf.getVenPerfil().getBtnVolver().setActionCommand("VOLVER_DESDE_PERFIL");
		
	}

	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		switch (e.getActionCommand()) {
		
		//VENTANA MENU
		case "INICIAR_SESION": {
		    try {
		        String alias = vf.getVenMenu().getTextAlias().getText().trim();
		        String contrasena = new String(vf.getVenMenu().getTextContrasenia().getPassword()).trim();

		        if (alias.isEmpty() || contrasena.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Por favor ingrese alias y contraseña.");
		            break;
		        }

		        boolean encontrado = false;

		        //LOGIN HOMBRE
		        for (Hombre h : mf.getHombreDAO().getListaHombres()) {
		            if (h == null) continue;

		            if (h.getAlias() != null && h.getContrasena() != null &&
		                h.getAlias().equalsIgnoreCase(alias) &&
		                h.getContrasena().equals(contrasena)) {

		                JOptionPane.showMessageDialog(null, "Bienvenido " + h.getNombre() + " 👋");
		                mf.setUsuarioActual(h);

		                vf.getVenMenu().setVisible(false);
		                vf.getVenPrincipal().setVisible(true);
		                vf.getVenPrincipal().setLocationRelativeTo(null);

		                // Tabla: mostrar solo mujeres
		                DefaultTableModel modelo = (DefaultTableModel) vf.getVenPrincipal().getTablaUsuarios().getModel();
		                String[] columnas = {"Foto", "Nombre", "Alias", "Correo", "Edad", "Estatura (cm)", "Divorciada", "Likes"};
		                modelo.setColumnIdentifiers(columnas);
		                modelo.setRowCount(0);

		                for (Mujer mu : mf.getMujerDAO().getListaMujeres()) {
		                    if (mu == null || mu.getAlias() == null) continue;

		                    // Evitar mostrar el propio perfil
		                    if (mu.getAlias().equalsIgnoreCase(h.getAlias())) continue;

		                    ImageIcon icon;
		                    try {
		                        Image img = new ImageIcon(mu.getURLfoto()).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		                        icon = new ImageIcon(img);
		                    } catch (Exception e1) {
		                        icon = new ImageIcon(new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB));
		                    }

		                    modelo.addRow(new Object[]{
		                        icon,
		                        mu.getNombre() + " " + mu.getApellido(),
		                        mu.getAlias(),
		                        mu.getEmail(),
		                        Period.between(mu.getFechaNacimiento(), LocalDate.now()).getYears(),
		                        mu.getEstatura(),
		                        mu.isEsDivorciada() ? "Sí" : "No",
		                        mu.getNumLikes()
		                    });
		                }

		                vf.getVenPrincipal().getTablaUsuarios().setRowHeight(60);
		                vf.getVenPrincipal().getTablaUsuarios().getColumnModel().getColumn(0)
		                    .setCellRenderer(new DefaultTableCellRenderer() {
		                        @Override
		                        public void setValue(Object value) {
		                            if (value instanceof ImageIcon) {
		                                setIcon((ImageIcon) value);
		                                setText("");
		                            } else {
		                                super.setValue(value);
		                            }
		                        }
		                    });

		                encontrado = true;
		                break;
		            }
		        }

		        //LOGIN MUJER
		        if (!encontrado) {
		            for (Mujer m : mf.getMujerDAO().getListaMujeres()) {
		                if (m == null) continue;

		                if (m.getAlias() != null && m.getContrasena() != null &&
		                    m.getAlias().equalsIgnoreCase(alias) &&
		                    m.getContrasena().equals(contrasena)) {

		                    JOptionPane.showMessageDialog(null, "Bienvenida " + m.getNombre() + " 💕");
		                    mf.setUsuarioActual(m);

		                    vf.getVenMenu().setVisible(false);
		                    vf.getVenPrincipal().setVisible(true);
		                    vf.getVenPrincipal().setLocationRelativeTo(null);

		                    // Tabla: mostrar solo hombres
		                    DefaultTableModel modelo = (DefaultTableModel) vf.getVenPrincipal().getTablaUsuarios().getModel();
		                    String[] columnas = {"Foto", "Nombre", "Alias", "Correo", "Edad", "Estatura (cm)", "Ingresos", "Likes"};
		                    modelo.setColumnIdentifiers(columnas);
		                    modelo.setRowCount(0);

		                    for (Hombre ho : mf.getHombreDAO().getListaHombres()) {
		                        if (ho == null || ho.getAlias() == null) continue;
		                        if (ho.getAlias().equalsIgnoreCase(m.getAlias())) continue;

		                        ImageIcon icon;
		                        try {
		                            Image img = new ImageIcon(ho.getURLfoto()).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		                            icon = new ImageIcon(img);
		                        } catch (Exception e1) {
		                            icon = new ImageIcon(new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB));
		                        }

		                        modelo.addRow(new Object[]{
		                            icon,
		                            ho.getNombre() + " " + ho.getApellido(),
		                            ho.getAlias(),
		                            ho.getEmail(),
		                            Period.between(ho.getFechaNacimiento(), LocalDate.now()).getYears(),
		                            ho.getEstatura(),
		                            ho.getPromedioIngMensual(),
		                            ho.getNumLikes()
		                        });
		                    }

		                    vf.getVenPrincipal().getTablaUsuarios().setRowHeight(60);
		                    vf.getVenPrincipal().getTablaUsuarios().getColumnModel().getColumn(0)
		                        .setCellRenderer(new DefaultTableCellRenderer() {
		                            @Override
		                            public void setValue(Object value) {
		                                if (value instanceof ImageIcon) {
		                                    setIcon((ImageIcon) value);
		                                    setText("");
		                                } else {
		                                    super.setValue(value);
		                                }
		                            }
		                        });

		                    encontrado = true;
		                    break;
		                }
		            }
		        }

		        if (!encontrado) {
		            JOptionPane.showMessageDialog(null, "Alias o contraseña incorrectos.");
		        }

		    } catch (Exception e1) {
		        e1.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e1.getMessage());
		    }
		    break;
		}

		case "DAR_LIKE": {
		    try {
		        Usuario usuarioActual = mf.getUsuarioActual();

		        if (usuarioActual == null) {
		            JOptionPane.showMessageDialog(null, "Debe iniciar sesión antes de dar like.");
		            break;
		        }

		        int filaSeleccionada = vf.getVenPrincipal().getTablaUsuarios().getSelectedRow();

		        if (filaSeleccionada == -1) {
		            JOptionPane.showMessageDialog(null, "Seleccione una persona de la tabla para dar like ❤️");
		            break;
		        }

		        String aliasSeleccionado = (String) vf.getVenPrincipal().getTablaUsuarios().getValueAt(filaSeleccionada, 2);
		        Usuario receptor = null;

		        //Buscar si es hombre
		        for (Hombre h : mf.getHombreDAO().getListaHombres()) {
		            if (h.getAlias().equalsIgnoreCase(aliasSeleccionado)) {
		                receptor = h;
		                break;
		            }
		        }

		        //Buscar si es mujer
		        if (receptor == null) {
		            for (Mujer m : mf.getMujerDAO().getListaMujeres()) {
		                if (m.getAlias().equalsIgnoreCase(aliasSeleccionado)) {
		                    receptor = m;
		                    break;
		                }
		            }
		        }

		        if (receptor == null) {
		            JOptionPane.showMessageDialog(null, "No se encontró el usuario seleccionado.");
		            break;
		        }

		        // Evitar likes repetidos
		        if (usuarioActual.getLikesDados().contains(receptor)) {
		            JOptionPane.showMessageDialog(null, "Ya le has dado like a " + receptor.getNombre());
		            break;
		        }

		        // Registrar like
		        usuarioActual.getLikesDados().add(receptor);
		        receptor.getLikesRecibidos().add(usuarioActual);

		        // Aumentar contador
		        receptor.setNumLikes(receptor.getNumLikes() + 1);
		        System.out.println("likes ahora: "+receptor.getNumLikes());
		        JOptionPane.showMessageDialog(null, "Le diste like a " + receptor.getNombre() + " 💘");

		        //Guardar en DAO correspondiente usando DTO
		        if (receptor instanceof Hombre) {
		            Hombre h = (Hombre) receptor;
		            int index = mf.getHombreDAO().getListaHombres().indexOf(h);
		            if (index >= 0) {
		                HombreDTO dto = DataMapper.convertirHombreAHombreDTO(h);
		                mf.getHombreDAO().update(index, dto);
		            }
		        } else if (receptor instanceof Mujer) {
		            Mujer m = (Mujer) receptor;
		            int index = mf.getMujerDAO().getListaMujeres().indexOf(m);
		            if (index >= 0) {
		                MujerDTO dto = DataMapper.convertirMujerAMujerDTO(m);
		                mf.getMujerDAO().update(index, dto);
		            }
		        }

		        //Refrescar tabla
		        DefaultTableModel modelo = (DefaultTableModel) vf.getVenPrincipal().getTablaUsuarios().getModel();
		        modelo.setValueAt(receptor.getNumLikes(), filaSeleccionada, modelo.getColumnCount() - 1);
		        modelo.fireTableDataChanged();

		    } catch (Exception e1) {
		        e1.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al dar like: " + e1.getMessage());
		    }
		    break;
		}

		case "DAR_DISLIKE": {
		    try {
		        Usuario usuarioActual = mf.getUsuarioActual();

		        if (usuarioActual == null) {
		            JOptionPane.showMessageDialog(null, "Debe iniciar sesión antes de dar dislike.");
		            break;
		        }

		        int filaSeleccionada = vf.getVenPrincipal().getTablaUsuarios().getSelectedRow();

		        if (filaSeleccionada == -1) {
		            JOptionPane.showMessageDialog(null, "Seleccione una persona de la tabla para quitar like 💔");
		            break;
		        }

		        // Obtener alias del usuario seleccionado (columna 2 = Alias)
		        String aliasSeleccionado = (String) vf.getVenPrincipal().getTablaUsuarios().getValueAt(filaSeleccionada, 2);

		        Usuario receptor = null;

		        // Buscar entre hombres
		        for (Hombre h : mf.getHombreDAO().getListaHombres()) {
		            if (h.getAlias().equalsIgnoreCase(aliasSeleccionado)) {
		                receptor = h;
		                break;
		            }
		        }

		        // Si no está en hombres, buscar entre mujeres
		        if (receptor == null) {
		            for (Mujer m : mf.getMujerDAO().getListaMujeres()) {
		                if (m.getAlias().equalsIgnoreCase(aliasSeleccionado)) {
		                    receptor = m;
		                    break;
		                }
		            }
		        }

		        if (receptor == null) {
		            JOptionPane.showMessageDialog(null, "No se encontró el usuario seleccionado 😕");
		            break;
		        }

		        // Verificar si el usuario actual ya le había dado like
		        if (!usuarioActual.getLikesDados().contains(receptor)) {
		            JOptionPane.showMessageDialog(null, "No le habías dado like a " + receptor.getNombre() + " 🙃");
		            break;
		        }

		        // Quitar el like
		        usuarioActual.getLikesDados().remove(receptor);
		        receptor.getLikesRecibidos().remove(usuarioActual);

		        // Disminuir contador de likes, evitando valores negativos
		        receptor.setNumLikes(Math.max(0, receptor.getNumLikes() - 1));

		        JOptionPane.showMessageDialog(null, "Le quitaste el like a " + receptor.getNombre() + " 💔");

		        // Refrescar valor de la columna de likes en la tabla
		        DefaultTableModel modelo = (DefaultTableModel) vf.getVenPrincipal().getTablaUsuarios().getModel();
		        modelo.setValueAt(receptor.getNumLikes(), filaSeleccionada, modelo.getColumnCount() - 1);

		    } catch (Exception e1) {
		        e1.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al quitar like: " + e1.getMessage());
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
		case "INICIAR_SESION_DESDE_ADMIN": {
			 String correo = vf.getVenInicioSesionAdmin().getTextCorreo().getText().trim();
			 String contrasena = new String(vf.getVenMenu().getTextContrasenia().getPassword()).trim();

			    if (correo.isEmpty() || contrasena.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Por favor ingrese correo y contraseña.");
			        break;
			    }

			    boolean encontrado = false;

			    // Buscar en hombres 
			    for (Hombre h : mf.getHombreDAO().getListaHombres()) {
			        if (h != null && h.getEmail() != null && h.getContrasena() != null) {
			            if (h.getEmail().equalsIgnoreCase(correo) &&
			                h.getContrasena().equals(contrasena) &&
			                h.isEsAdministrador()) {

			                JOptionPane.showMessageDialog(null, "Bienvenido Administrador " + h.getNombre() + " 👑");
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
			                if (m.getEmail().equalsIgnoreCase(correo) &&
			                    m.getContrasena().equals(contrasena) &&
			                    m.isEsAdministrador()) {

			                    JOptionPane.showMessageDialog(null, "Bienvenida Administradora " + m.getNombre() + " 👑");
			                    vf.getVenInicioSesionAdmin().setVisible(false);
			                    vf.getVenPrincipal().setVisible(true);
			                    encontrado = true;
			                    break;
			                }
			            }
			        }
			    }

			    if (!encontrado) {
			        JOptionPane.showMessageDialog(null, "Credenciales inválidas o el usuario no es administrador ❌");
			    }

			    break;
		}
		//VENTANA INICIO SESION ADMIN
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
		case "ABRIR_PERFIL": {
			vf.getVenPerfil().setVisible(true);
		    vf.getVenPrincipal().setVisible(false);
		    break;
		}
		//crear cuentas
		case "CREAR_CUENTA_HOMBRE": {
		    try {
		        
		        String nombre = vf.getVenRegistroHombre().getTextNombre().getText();
		        String apellido = vf.getVenRegistroHombre().getTextApellido().getText();
		        String alias = vf.getVenRegistroHombre().getTextAlias().getText();
		        String correo = vf.getVenRegistroHombre().getTextCorreo().getText();
		        String contrasena = new String(vf.getVenMenu().getTextContrasenia().getPassword()).trim();
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
		        String contrasena = new String(vf.getVenRegistroMujer().getTextContrasenia().getPassword()).trim();
		        LocalDate fechaNacimiento = vf.getVenRegistroMujer().getFechaSeleccionada();
		        String genero = "Mujer";
		        boolean esAdministrador = false;
		        boolean estaDisponible = true;
		        String urlFoto = vf.getVenRegistroMujer().getRutaFotoPerfil();
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
		        String contrasena = new String(vf.getVenMenu().getTextContrasenia().getPassword()).trim();
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
		
		//VENTANA PERFIL 
		case "CERRAR_SESION": {
			vf.getVenPerfil().setVisible(false);
		    vf.getVenMenu().setVisible(true);
		    break;
		}
		
		case "VOLVER_DESDE_PERFIL": {
			vf.getVenPerfil().setVisible(false);
		    vf.getVenPrincipal().setVisible(true);
		    break;
		}

		}
	}
}
