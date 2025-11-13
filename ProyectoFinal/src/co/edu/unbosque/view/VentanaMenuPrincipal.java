package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * Ventana que representa el menú principal de la aplicación.
 * Permite iniciar sesión, registrarse y cambiar entre temas claro y oscuro.
 */
public class VentanaMenuPrincipal extends JFrame {

	private JButton btnSalir;
	private JButton btnConfirmar;
	private JButton btnRegistro;
	private JButton btnInicioSesionAdmin;
	private JButton btnOscuro;
	private JButton btnClaro;

	private JLabel fondoMenu;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel titulo;
	private JLabel titulo2;

	private JLabel lblAlias;
	private JLabel lblContrasenia;
	private JLabel lblRegistro;

	private JTextField textAlias;
	private JPasswordField textContrasenia;

	private Properties prop;

	/*
	 * Constructor que crea la ventana del menú principal
	 * e inicializa el objeto de propiedades vacío.
	 */
	public VentanaMenuPrincipal() {
		prop = new Properties();
	}

	/*
	 * Inicializa y configura todos los componentes gráficos del menú principal.
	 * Define el fondo, los textos, los botones y los campos de entrada.
	 */
	public void inicializarComponentes() {
		this.setTitle("Menu Principal");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaMenuOscuro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoMenu = new JLabel(new ImageIcon(escalar));
		fondoMenu.setLayout(null);
		fondoMenu.setPreferredSize(new java.awt.Dimension(1200, 675));

		this.setContentPane(fondoMenu);
		this.pack();
		this.setLocationRelativeTo(null);

		titulo = new JLabel(prop.getProperty("bostinder.ventanamenu.lbltitulo"));
		titulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 60));
		titulo.setBounds(100, 80, 1200, 70);
		titulo.setForeground(Color.WHITE);
		fondoMenu.add(titulo);

		titulo2 = new JLabel(prop.getProperty("bostinder.ventanamenu.lbltitulo2"));
		titulo2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 60));
		titulo2.setBounds(100, 300, 1200, 70);
		titulo2.setForeground(Color.WHITE);
		fondoMenu.add(titulo2);
		
		btnClaro = new JButton("");
		btnClaro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnClaro.setBounds(928, 20, 110, 40);
		btnClaro.setForeground(Color.BLACK);
		btnClaro.setFocusPainted(true);
		btnClaro.setBorder(null);
		btnClaro.setOpaque(true);
		btnClaro.setBorderPainted(false);
		btnClaro.setContentAreaFilled(false);
		fondoMenu.add(btnClaro);
		
		btnOscuro = new JButton("");
		btnOscuro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnOscuro.setBounds(1071, 20, 110, 40);
		btnOscuro.setForeground(Color.BLACK);
		btnOscuro.setFocusPainted(true);
		btnOscuro.setBorder(null);
		btnOscuro.setOpaque(true);
		btnOscuro.setBorderPainted(false);
		btnOscuro.setContentAreaFilled(false);
		fondoMenu.add(btnOscuro);

		lblAlias = new JLabel(prop.getProperty("bostinder.ventanamenu.lblalias"));
		lblAlias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblAlias.setBounds(810, 243, 1200, 70);
		fondoMenu.add(lblAlias);

		textAlias = new JTextField();
		textAlias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textAlias.setBounds(813, 293, 214, 40);
		textAlias.setBorder(null);
		fondoMenu.add(textAlias);

		lblContrasenia = new JLabel(prop.getProperty("bostinder.ventanamenu.lblcontrasenia"));
		lblContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblContrasenia.setBounds(810, 320, 1200, 70);
		fondoMenu.add(lblContrasenia);

		textContrasenia = new JPasswordField();
		textContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textContrasenia.setBounds(813, 374, 214, 40);
		textContrasenia.setBorder(null);
		fondoMenu.add(textContrasenia);

		btnInicioSesionAdmin = new JButton(prop.getProperty("bostinder.ventanamenu.btniniciosesionadmin"));
		btnInicioSesionAdmin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnInicioSesionAdmin.setBounds(800, 523, 200, 25);
		btnInicioSesionAdmin.setBackground(new Color(255, 185, 185));
		btnInicioSesionAdmin.setForeground(Color.WHITE);
		btnInicioSesionAdmin.setFocusPainted(false);
		btnInicioSesionAdmin.setBorder(null);
		fondoMenu.add(btnInicioSesionAdmin);

		btnConfirmar = new JButton(prop.getProperty("bostinder.ventanamenu.btnConfirmar"));
		btnConfirmar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnConfirmar.setBounds(778, 480, 250, 30);
		btnConfirmar.setBackground(new Color(198, 48, 44));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setBorder(null);
		fondoMenu.add(btnConfirmar);

		btnSalir = new JButton(prop.getProperty("bostinder.ventanamenu.btnSalir"));
		btnSalir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnSalir.setBounds(21, 620, 177, 30);
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFocusPainted(false);
		btnSalir.setBorder(null);
		fondoMenu.add(btnSalir);

		lblRegistro = new JLabel(prop.getProperty("bostinder.ventanamenu.lblRegistro"));
		lblRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblRegistro.setBounds(845, 570, 250, 30);
		fondoMenu.add(lblRegistro);

		btnRegistro = new JButton(prop.getProperty("bostinder.ventanamenu.btnRegistro"));
		btnRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnRegistro.setBounds(846, 616, 110, 25);
		btnRegistro.setBackground(new Color(255, 184, 184));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorder(null);
		fondoMenu.add(btnRegistro);

	}
	
	/*
	 * Cambia la imagen de fondo de la ventana del menú principal.
	 * 
	 * @param url ruta de la imagen que se usará como nuevo fondo
	 */
	public void cambiarFondo (String url) {
		ImageIcon cambio = new ImageIcon(url);
		Image escalar = cambio.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		
		fondoMenu.setIcon(new ImageIcon(escalar));
		fondoMenu.repaint();
		fondoMenu.revalidate();
	}

	/*
	 * Retorna el botón para salir del menú.
	 * 
	 * @return botón de salir
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/*
	 * Asigna el botón de salir del menú.
	 * 
	 * @param btnSalir botón de salir
	 */
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	/*
	 * Retorna el botón de confirmación.
	 * 
	 * @return botón confirmar
	 */
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	/*
	 * Asigna el botón de confirmación.
	 * 
	 * @param btnConfirmar botón de confirmar
	 */
	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	/*
	 * Retorna el botón de registro.
	 * 
	 * @return botón de registro
	 */
	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	/*
	 * Asigna el botón de registro.
	 * 
	 * @param btnRegistro botón para registrar usuario
	 */
	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	/*
	 * Retorna el contenedor del fondo del menú.
	 * 
	 * @return etiqueta con la imagen de fondo
	 */
	public JLabel getFondoMenu() {
		return fondoMenu;
	}

	/*
	 * Asigna el contenedor del fondo del menú.
	 * 
	 * @param fondoMenu etiqueta con la imagen de fondo
	 */
	public void setFondoMenu(JLabel fondoMenu) {
		this.fondoMenu = fondoMenu;
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
	 * @param fondo imagen del fondo
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/*
	 * Retorna la imagen escalada del fondo.
	 * 
	 * @return imagen escalada
	 */
	public Image getEscalar() {
		return escalar;
	}

	/*
	 * Asigna la imagen escalada del fondo.
	 * 
	 * @param escalar imagen escalada
	 */
	public void setEscalar(Image escalar) {
		this.escalar = escalar;
	}

	/*
	 * Retorna el título principal del menú.
	 * 
	 * @return etiqueta del título
	 */
	public JLabel getTitulo() {
		return titulo;
	}

	/*
	 * Asigna el título principal.
	 * 
	 * @param titulo etiqueta del título
	 */
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	/*
	 * Retorna el segundo título del menú.
	 * 
	 * @return etiqueta del segundo título
	 */
	public JLabel getTitulo2() {
		return titulo2;
	}

	/*
	 * Asigna el segundo título del menú.
	 * 
	 * @param titulo2 etiqueta del segundo título
	 */
	public void setTitulo2(JLabel titulo2) {
		this.titulo2 = titulo2;
	}

	/*
	 * Retorna la etiqueta con el texto alias.
	 * 
	 * @return etiqueta alias
	 */
	public JLabel getLblalias() {
		return lblAlias;
	}

	/*
	 * Asigna la etiqueta de alias.
	 * 
	 * @param lblalias etiqueta alias
	 */
	public void setLblalias(JLabel lblalias) {
		this.lblAlias = lblalias;
	}

	/*
	 * Retorna la etiqueta de contraseña.
	 * 
	 * @return etiqueta contraseña
	 */
	public JLabel getLblcontrasenia() {
		return lblContrasenia;
	}

	/*
	 * Asigna la etiqueta de contraseña.
	 * 
	 * @param lblcontrasenia etiqueta contraseña
	 */
	public void setLblcontrasenia(JLabel lblcontrasenia) {
		this.lblContrasenia = lblcontrasenia;
	}

	/*
	 * Retorna la etiqueta de registro.
	 * 
	 * @return etiqueta registro
	 */
	public JLabel getLblRegistro() {
		return lblRegistro;
	}

	/*
	 * Asigna la etiqueta de registro.
	 * 
	 * @param lblRegistro etiqueta registro
	 */
	public void setLblRegistro(JLabel lblRegistro) {
		this.lblRegistro = lblRegistro;
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
	 * Retorna las propiedades de textos del menú.
	 * 
	 * @return propiedades
	 */
	public Properties getProp() {
		return prop;
	}

	/*
	 * Asigna el objeto de propiedades de la aplicación
	 * y crea los componentes gráficos del menú principal.
	 * 
	 * @param prop propiedades que contienen los textos de la interfaz
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
	}

	/*
	 * Retorna el botón para iniciar sesión como administrador.
	 * 
	 * @return botón inicio sesión admin
	 */
	public JButton getBtnInicioSesionAdmin() {
		return btnInicioSesionAdmin;
	}

	/*
	 * Asigna el botón para iniciar sesión como administrador.
	 * 
	 * @param btnInicioSesionAdmin botón inicio sesión admin
	 */
	public void setBtnInicioSesionAdmin(JButton btnInicioSesionAdmin) {
		this.btnInicioSesionAdmin = btnInicioSesionAdmin;
	}

	/*
	 * Retorna la etiqueta alias.
	 * 
	 * @return etiqueta alias
	 */
	public JLabel getLblAlias() {
		return lblAlias;
	}

	/*
	 * Asigna la etiqueta alias.
	 * 
	 * @param lblAlias etiqueta alias
	 */
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	/*
	 * Retorna la etiqueta contraseña.
	 * 
	 * @return etiqueta contraseña
	 */
	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	/*
	 * Asigna la etiqueta contraseña.
	 * 
	 * @param lblContrasenia etiqueta contraseña
	 */
	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
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
}
