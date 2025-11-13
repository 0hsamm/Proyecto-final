package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

/*
 * Ventana que permite registrar un usuario hombre.
 * Solicita datos personales, alias, ingresos, estatura y una foto de perfil.
 */
public class VentanaRegistroHombre extends JFrame {

	private JButton btnVolver;
	private JButton btnCrearCuenta;

	private JLabel fondoRegistro;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel titulo;

	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblCorreo;

	private JLabel lblNacimiento;

	private JLabel lblContrasenia;
	private JLabel lblAlias;

	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;

	private JPasswordField textContrasenia;

	private JTextField textAlias;

	private JLabel lblIngreso;
	private JLabel lblEstatura;

	private JTextField textIngreso;
	private JTextField textEstatura;

	private JLabel lblRegistro;
	private JButton btnRegistro;

	private JButton btnSubirImagen;
	private JCalendar calendario;

	private Properties prop;
	private String rutaFotoPerfil;

	private JButton btnClaro;
	private JButton btnOscuro;

	/*
	 * Constructor por defecto de la ventana de registro de hombre.
	 */
	public VentanaRegistroHombre() {

	}

	/*
	 * Inicializa y configura todos los componentes gráficos de la ventana de
	 * registro de hombre, incluyendo campos de texto, calendario y botones.
	 */
	public void inicializarComponentes() {
		this.setTitle("Crear cuenta hombre");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaRegistroHombreOscuro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoRegistro = new JLabel(new ImageIcon(escalar));
		fondoRegistro.setLayout(null);
		fondoRegistro.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoRegistro);
		this.pack();
		this.setLocationRelativeTo(null);

		btnOscuro = new JButton("");
		btnOscuro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnOscuro.setBounds(1071, 20, 110, 40);
		btnOscuro.setForeground(Color.BLACK);
		btnOscuro.setFocusPainted(true);
		btnOscuro.setBorder(null);
		btnOscuro.setOpaque(true);
		btnOscuro.setBorderPainted(false);
		btnOscuro.setContentAreaFilled(false);
		this.add(btnOscuro);

		btnClaro = new JButton("");
		btnClaro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnClaro.setBounds(1071, 86, 110, 40);
		btnClaro.setForeground(Color.BLACK);
		btnClaro.setFocusPainted(true);
		btnClaro.setBorder(null);
		btnClaro.setOpaque(true);
		btnClaro.setBorderPainted(false);
		btnClaro.setContentAreaFilled(false);
		this.add(btnClaro);

		titulo = new JLabel(prop.getProperty("bostinder.ventanaregistro.lbltitulo"));
		titulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 45));
		titulo.setBounds(200, 20, 1200, 70);
		titulo.setForeground(Color.WHITE);
		this.add(titulo);

		lblNombre = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblnombre"));
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblNombre.setBounds(90, 120, 1200, 70);
		lblNombre.setForeground(Color.WHITE);
		this.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textNombre.setBounds(76, 180, 260, 40);
		textNombre.setForeground(Color.WHITE);
		textNombre.setBackground(new Color(0, 0, 0));
		textNombre.setOpaque(true);
		textNombre.setBorder(null);
		this.add(textNombre);

		lblCorreo = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblcorreo"));
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblCorreo.setBounds(90, 205, 1200, 70);
		lblCorreo.setForeground(Color.WHITE);
		this.add(lblCorreo);

		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textCorreo.setBounds(76, 262, 260, 40);
		textCorreo.setForeground(Color.WHITE);
		textCorreo.setBackground(new Color(0, 0, 0));
		textCorreo.setOpaque(true);
		textCorreo.setBorder(null);
		this.add(textCorreo);

		lblNacimiento = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblnacimiento"));
		lblNacimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblNacimiento.setBounds(90, 443, 1200, 70);
		lblNacimiento.setForeground(Color.WHITE);
		this.add(lblNacimiento);

		calendario = new JCalendar();
		calendario.setBounds(76, 490, 295, 170);
		this.add(calendario);

		lblContrasenia = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblcontrasenia"));
		lblContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblContrasenia.setBounds(90, 362, 1200, 70);
		lblContrasenia.setForeground(Color.WHITE);
		this.add(lblContrasenia);

		textContrasenia = new JPasswordField();
		textContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textContrasenia.setBounds(76, 420, 260, 40);
		textContrasenia.setForeground(Color.WHITE);
		textContrasenia.setBackground(new Color(0, 0, 0));
		textContrasenia.setOpaque(true);
		textContrasenia.setBorder(null);
		this.add(textContrasenia);

		lblApellido = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblApellido"));
		lblApellido.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblApellido.setBounds(480, 283, 1200, 70);
		lblApellido.setForeground(Color.WHITE);
		this.add(lblApellido);

		textApellido = new JTextField();
		textApellido.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textApellido.setBounds(470, 340, 260, 40);
		textApellido.setForeground(Color.WHITE);
		textApellido.setBackground(new Color(0, 0, 0));
		textApellido.setOpaque(true);
		textApellido.setBorder(null);
		this.add(textApellido);

		lblAlias = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblalias"));
		lblAlias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblAlias.setBounds(90, 283, 1200, 70);
		lblAlias.setForeground(Color.WHITE);
		this.add(lblAlias);

		textAlias = new JTextField();
		textAlias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textAlias.setBounds(76, 340, 260, 40);
		textAlias.setForeground(Color.WHITE);
		textAlias.setBackground(new Color(0, 0, 0));
		textAlias.setOpaque(true);
		textAlias.setBorder(null);
		this.add(textAlias);

		lblIngreso = new JLabel(prop.getProperty("bostinder.ventanaregistroHombre.lblingresos"));
		lblIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblIngreso.setBounds(480, 120, 1200, 70);
		lblIngreso.setForeground(Color.WHITE);
		this.add(lblIngreso);

		textIngreso = new JTextField();
		textIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textIngreso.setBounds(470, 180, 260, 40);
		textIngreso.setForeground(Color.WHITE);
		textIngreso.setBackground(new Color(0, 0, 0));
		textIngreso.setOpaque(true);
		textIngreso.setBorder(null);
		this.add(textIngreso);

		lblEstatura = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblestatura"));
		lblEstatura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblEstatura.setBounds(480, 205, 1200, 70);
		lblEstatura.setForeground(Color.WHITE);
		this.add(lblEstatura);

		textEstatura = new JTextField();
		textEstatura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textEstatura.setBounds(470, 263, 260, 40);
		textEstatura.setForeground(Color.WHITE);
		textEstatura.setBackground(new Color(0, 0, 0));
		textEstatura.setOpaque(true);
		textEstatura.setBorder(null);
		this.add(textEstatura);

		btnCrearCuenta = new JButton(prop.getProperty("bostinder.ventanaregistro.btnCrearCuenta"));
		btnCrearCuenta.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnCrearCuenta.setBounds(920, 605, 240, 30);
		btnCrearCuenta.setForeground(Color.WHITE);
		btnCrearCuenta.setFocusPainted(true);
		btnCrearCuenta.setBorder(null);
		btnCrearCuenta.setOpaque(true);
		btnCrearCuenta.setBorderPainted(false);
		btnCrearCuenta.setContentAreaFilled(false);
		this.add(btnCrearCuenta);

		btnVolver = new JButton("");
		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnVolver.setBounds(26, 50, 135, 40);
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFocusPainted(true);
		btnVolver.setBorder(null);
		btnVolver.setOpaque(true);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setActionCommand("VOLVER_MENU_HOMBRE");
		this.add(btnVolver);

		btnSubirImagen = new JButton(prop.getProperty("bostinder.ventanaregistro.btnSubirImagen"));
		btnSubirImagen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 90));
		btnSubirImagen.setBounds(1092, 467, 60, 60);
		btnSubirImagen.setForeground(Color.WHITE);
		btnSubirImagen.setFocusPainted(true);
		btnSubirImagen.setBorder(null);
		btnSubirImagen.setOpaque(true);
		btnSubirImagen.setBorderPainted(false);
		btnSubirImagen.setContentAreaFilled(false);
		this.add(btnSubirImagen);

		lblRegistro = new JLabel(prop.getProperty("bostinder.ventanaregistroadministrador.lblregistro"));
		lblRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblRegistro.setBounds(830, 25, 250, 30);
		this.add(lblRegistro);

		btnRegistro = new JButton(prop.getProperty("bostinder.ventanaregistroadministrador.btnregistro"));
		btnRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnRegistro.setBounds(840, 72, 110, 25);
		btnRegistro.setBackground(new Color(255, 184, 184));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorder(null);
		this.add(btnRegistro);

		btnSubirImagen.addActionListener(e -> subirFotoPerfil());
	}

	/*
	 * Cambia la imagen de fondo de la ventana de registro de hombre.
	 * 
	 * @param url ruta de la imagen que se usará como nuevo fondo
	 */
	public void cambiarFondo(String url) {
		ImageIcon cambio = new ImageIcon(url);
		Image escalar = cambio.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);

		fondoRegistro.setIcon(new ImageIcon(escalar));
		fondoRegistro.repaint();
		fondoRegistro.revalidate();
	}

	/*
	 * Abre un selector de archivos para elegir una imagen de perfil,
	 * copia la imagen a la carpeta de perfiles del proyecto y guarda su ruta.
	 */
	public void subirFotoPerfil() {
		JFileChooser fileChooser = new JFileChooser();
		int resultado = fileChooser.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivoOrigen = fileChooser.getSelectedFile();

			try {
				File carpetaDestino = new File("src/co/edu/unbosque/resources/perfiles/");
				if (!carpetaDestino.exists()) {
					carpetaDestino.mkdirs();
				}

				File archivoDestino = new File(carpetaDestino, archivoOrigen.getName());
				Files.copy(archivoOrigen.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);

				rutaFotoPerfil = archivoDestino.getPath();
				System.out.println("Imagen copiada en: " + rutaFotoPerfil);
				JOptionPane.showMessageDialog(this, "Imagen subida correctamente.");

			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error al copiar la imagen.");
			}
		}
	}

	/*
	 * Retorna las propiedades de texto asociadas a la ventana.
	 * 
	 * @return propiedades de la interfaz
	 */
	public Properties getProp() {
		return prop;
	}

	/*
	 * Asigna las propiedades de texto de la interfaz
	 * e inicializa los componentes de la ventana.
	 * 
	 * @param prop propiedades que contienen los textos de la interfaz
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
	}

	/*
	 * Retorna el botón para volver a la ventana anterior.
	 * 
	 * @return botón volver
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/*
	 * Asigna el botón para volver a la ventana anterior.
	 * 
	 * @param btnVolver botón volver
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	/*
	 * Retorna el botón para crear la cuenta del usuario hombre.
	 * 
	 * @return botón crear cuenta
	 */
	public JButton getBtnCrearCuenta() {
		return btnCrearCuenta;
	}

	/*
	 * Asigna el botón para crear la cuenta del usuario hombre.
	 * 
	 * @param btnCrearCuenta botón crear cuenta
	 */
	public void setBtnCrearCuenta(JButton btnCrearCuenta) {
		this.btnCrearCuenta = btnCrearCuenta;
	}

	/*
	 * Retorna la etiqueta que contiene la imagen de fondo.
	 * 
	 * @return etiqueta fondo de registro
	 */
	public JLabel getFondoRegistro() {
		return fondoRegistro;
	}

	/*
	 * Asigna la etiqueta que contiene la imagen de fondo.
	 * 
	 * @param fondoRegistro etiqueta fondo de registro
	 */
	public void setFondoRegistro(JLabel fondoRegistro) {
		this.fondoRegistro = fondoRegistro;
	}

	/*
	 * Retorna la imagen de fondo original.
	 * 
	 * @return imagen de fondo
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/*
	 * Asigna la imagen de fondo original.
	 * 
	 * @param fondo imagen de fondo
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/*
	 * Retorna la imagen escalada usada como fondo.
	 * 
	 * @return imagen escalada
	 */
	public Image getEscalar() {
		return escalar;
	}

	/*
	 * Asigna la imagen escalada usada como fondo.
	 * 
	 * @param escalar imagen escalada
	 */
	public void setEscalar(Image escalar) {
		this.escalar = escalar;
	}

	/*
	 * Retorna la etiqueta del título principal.
	 * 
	 * @return etiqueta del título
	 */
	public JLabel getTitulo() {
		return titulo;
	}

	/*
	 * Asigna la etiqueta del título principal.
	 * 
	 * @param titulo etiqueta del título
	 */
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	/*
	 * Retorna la etiqueta del texto de nombre.
	 * 
	 * @return etiqueta nombre
	 */
	public JLabel getLblNombre() {
		return lblNombre;
	}

	/*
	 * Asigna la etiqueta del texto de nombre.
	 * 
	 * @param lblNombre etiqueta nombre
	 */
	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	/*
	 * Retorna la etiqueta del texto de correo.
	 * 
	 * @return etiqueta correo
	 */
	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	/*
	 * Asigna la etiqueta del texto de correo.
	 * 
	 * @param lblCorreo etiqueta correo
	 */
	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	/*
	 * Retorna la etiqueta del texto de fecha de nacimiento.
	 * 
	 * @return etiqueta nacimiento
	 */
	public JLabel getLblNacimiento() {
		return lblNacimiento;
	}

	/*
	 * Asigna la etiqueta del texto de fecha de nacimiento.
	 * 
	 * @param lblNacimiento etiqueta nacimiento
	 */
	public void setLblNacimiento(JLabel lblNacimiento) {
		this.lblNacimiento = lblNacimiento;
	}

	/*
	 * Retorna la etiqueta del texto de contraseña.
	 * 
	 * @return etiqueta contraseña
	 */
	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	/*
	 * Asigna la etiqueta del texto de contraseña.
	 * 
	 * @param lblContrasenia etiqueta contraseña
	 */
	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	/*
	 * Retorna la etiqueta del texto de alias.
	 * 
	 * @return etiqueta alias
	 */
	public JLabel getLblAlias() {
		return lblAlias;
	}

	/*
	 * Asigna la etiqueta del texto de alias.
	 * 
	 * @param lblAlias etiqueta alias
	 */
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	/*
	 * Retorna el campo de texto para el nombre.
	 * 
	 * @return campo nombre
	 */
	public JTextField getTextNombre() {
		return textNombre;
	}

	/*
	 * Asigna el campo de texto para el nombre.
	 * 
	 * @param textNombre campo nombre
	 */
	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	/*
	 * Retorna el campo de texto para el correo.
	 * 
	 * @return campo correo
	 */
	public JTextField getTextCorreo() {
		return textCorreo;
	}

	/*
	 * Asigna el campo de texto para el correo.
	 * 
	 * @param textCorreo campo correo
	 */
	public void setTextCorreo(JTextField textCorreo) {
		this.textCorreo = textCorreo;
	}

	/*
	 * Retorna el campo de contraseña.
	 * 
	 * @return campo contraseña
	 */
	public JPasswordField getTextContrasenia() {
		return textContrasenia;
	}

	/*
	 * Asigna el campo de contraseña.
	 * 
	 * @param textContrasenia campo contraseña
	 */
	public void setTextContrasenia(JPasswordField textContrasenia) {
		this.textContrasenia = textContrasenia;
	}

	/*
	 * Retorna el campo de texto para el alias.
	 * 
	 * @return campo alias
	 */
	public JTextField getTextAlias() {
		return textAlias;
	}

	/*
	 * Asigna el campo de texto para el alias.
	 * 
	 * @param textAlias campo alias
	 */
	public void setTextAlias(JTextField textAlias) {
		this.textAlias = textAlias;
	}

	/*
	 * Retorna la etiqueta del texto de ingresos.
	 * 
	 * @return etiqueta ingresos
	 */
	public JLabel getLblIngreso() {
		return lblIngreso;
	}

	/*
	 * Asigna la etiqueta del texto de ingresos.
	 * 
	 * @param lblIngreso etiqueta ingresos
	 */
	public void setLblIngreso(JLabel lblIngreso) {
		this.lblIngreso = lblIngreso;
	}

	/*
	 * Retorna la etiqueta del texto de estatura.
	 * 
	 * @return etiqueta estatura
	 */
	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	/*
	 * Asigna la etiqueta del texto de estatura.
	 * 
	 * @param lblEstatura etiqueta estatura
	 */
	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	/*
	 * Retorna el campo de texto para los ingresos.
	 * 
	 * @return campo ingresos
	 */
	public JTextField getTextIngreso() {
		return textIngreso;
	}

	/*
	 * Asigna el campo de texto para los ingresos.
	 * 
	 * @param textIngreso campo ingresos
	 */
	public void setTextIngreso(JTextField textIngreso) {
		this.textIngreso = textIngreso;
	}

	/*
	 * Retorna el campo de texto para la estatura.
	 * 
	 * @return campo estatura
	 */
	public JTextField getTextEstatura() {
		return textEstatura;
	}

	/*
	 * Asigna el campo de texto para la estatura.
	 * 
	 * @param textEstatura campo estatura
	 */
	public void setTextEstatura(JTextField textEstatura) {
		this.textEstatura = textEstatura;
	}

	/*
	 * Retorna el botón para subir imagen de perfil.
	 * 
	 * @return botón subir imagen
	 */
	public JButton getBtnSubirImagen() {
		return btnSubirImagen;
	}

	/*
	 * Asigna el botón para subir imagen de perfil.
	 * 
	 * @param btnSubirImagen botón subir imagen
	 */
	public void setBtnSubirImagen(JButton btnSubirImagen) {
		this.btnSubirImagen = btnSubirImagen;
	}

	/*
	 * Retorna el componente de calendario usado para seleccionar la fecha.
	 * 
	 * @return calendario de la ventana
	 */
	public JCalendar getCalendario() {
		return calendario;
	}

	/*
	 * Asigna el componente de calendario usado para seleccionar la fecha.
	 * 
	 * @param calendario componente calendario
	 */
	public void setCalendario(JCalendar calendario) {
		this.calendario = calendario;
	}

	/*
	 * Obtiene la fecha seleccionada en el calendario.
	 * 
	 * @return fecha seleccionada como LocalDate, o null si no hay fecha seleccionada
	 */
	public LocalDate getFechaSeleccionada() {
		Date date = calendario.getDate();
		if (date == null) {
			return null;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/*
	 * Retorna la etiqueta asociada al texto de registro de administrador.
	 * 
	 * @return etiqueta registro admin
	 */
	public JLabel getLblRegistro() {
		return lblRegistro;
	}

	/*
	 * Asigna la etiqueta asociada al texto de registro de administrador.
	 * 
	 * @param lblRegistro etiqueta registro admin
	 */
	public void setLblRegistro(JLabel lblRegistro) {
		this.lblRegistro = lblRegistro;
	}

	/*
	 * Retorna el botón para ir al registro de administrador.
	 * 
	 * @return botón registro admin
	 */
	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	/*
	 * Asigna el botón para ir al registro de administrador.
	 * 
	 * @param btnRegistro botón registro admin
	 */
	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	/*
	 * Retorna la etiqueta del texto de apellido.
	 * 
	 * @return etiqueta apellido
	 */
	public JLabel getLblApellido() {
		return lblApellido;
	}

	/*
	 * Asigna la etiqueta del texto de apellido.
	 * 
	 * @param lblApellido etiqueta apellido
	 */
	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	/*
	 * Retorna el campo de texto para el apellido.
	 * 
	 * @return campo apellido
	 */
	public JTextField getTextApellido() {
		return textApellido;
	}

	/*
	 * Asigna el campo de texto para el apellido.
	 * 
	 * @param textApellido campo apellido
	 */
	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	/*
	 * Retorna la ruta de la foto de perfil seleccionada.
	 * 
	 * @return ruta de la foto de perfil
	 */
	public String getRutaFotoPerfil() {
		return rutaFotoPerfil;
	}

	/*
	 * Asigna la ruta de la foto de perfil seleccionada.
	 * 
	 * @param rutaFotoPerfil ruta de la foto de perfil
	 */
	public void setRutaFotoPerfil(String rutaFotoPerfil) {
		this.rutaFotoPerfil = rutaFotoPerfil;
	}

	/*
	 * Retorna el botón para activar el tema claro.
	 * 
	 * @return botón tema claro
	 */
	public JButton getBtnClaro() {
		return btnClaro;
	}

	/*
	 * Asigna el botón para activar el tema claro.
	 * 
	 * @param btnClaro botón tema claro
	 */
	public void setBtnClaro(JButton btnClaro) {
		this.btnClaro = btnClaro;
	}

	/*
	 * Retorna el botón para activar el tema oscuro.
	 * 
	 * @return botón tema oscuro
	 */
	public JButton getBtnOscuro() {
		return btnOscuro;
	}

	/*
	 * Asigna el botón para activar el tema oscuro.
	 * 
	 * @param btnOscuro botón tema oscuro
	 */
	public void setBtnOscuro(JButton btnOscuro) {
		this.btnOscuro = btnOscuro;
	}

}
