<<<<<<< HEAD
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Ventana que permite gestionar el perfil del usuario.
 * Ofrece opciones para hacer la cuenta invisible, actualizarla, eliminarla y acceder a la sección de matches.
 */
public class VentanaPerfil extends JFrame {

	private JLabel fondoCRUD;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel lblTitulo;

	private JButton btnVolver;

	private JButton btnCuentaInvisible;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnMatch;

	private JButton btnOscuro;
	private JButton btnClaro;

	private Properties prop;

	/*
	 * Constructor por defecto de la ventana de perfil del usuario.
	 */
	public VentanaPerfil() {

	}

	/*
	 * Inicializa y configura todos los componentes gráficos de la ventana de perfil.
	 * Define el fondo, el título, los botones de acciones sobre la cuenta y los botones de cambio de tema.
	 */
	public void inicializarComponentes() {

		this.setTitle("Ventana perfil usuario");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaPerfilOscuro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoCRUD = new JLabel(new ImageIcon(escalar));
		fondoCRUD.setLayout(null);
		fondoCRUD.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoCRUD);
		this.pack();
		this.setLocationRelativeTo(null);

		lblTitulo = new JLabel(prop.getProperty("bostinder.ventanaperfil.lbltitulo"));
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 60));
		lblTitulo.setBounds(220, 20, 1200, 70);
		lblTitulo.setForeground(Color.WHITE);
		this.add(lblTitulo);

		btnClaro = new JButton("");
		btnClaro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnClaro.setBounds(928, 20, 110, 40);
		btnClaro.setForeground(Color.BLACK);
		btnClaro.setFocusPainted(true);
		btnClaro.setBorder(null);
		btnClaro.setOpaque(true);
		btnClaro.setBorderPainted(false);
		btnClaro.setContentAreaFilled(false);
		this.add(btnClaro);

		btnOscuro = new JButton("");
		btnOscuro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnOscuro.setBounds(1071, 20, 110, 40);
		btnOscuro.setForeground(Color.BLACK);
		btnOscuro.setFocusPainted(true);
		btnOscuro.setBorder(null);
		btnOscuro.setOpaque(true);
		btnOscuro.setBorderPainted(false);
		btnOscuro.setContentAreaFilled(false);
		this.add(btnOscuro);

		btnCuentaInvisible = new JButton(prop.getProperty("bostinder.ventanaperfil.btnCuentaInvisible"));
		btnCuentaInvisible.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnCuentaInvisible.setBounds(120, 236, 300, 50);
		btnCuentaInvisible.setForeground(Color.BLACK);
		btnCuentaInvisible.setFocusPainted(true);
		btnCuentaInvisible.setBorder(null);
		btnCuentaInvisible.setContentAreaFilled(false);
		btnCuentaInvisible.setBorderPainted(false);
		btnCuentaInvisible.setOpaque(false);
		fondoCRUD.add(btnCuentaInvisible);

		btnActualizar = new JButton(prop.getProperty("bostinder.ventanaperfil.btnActualizar"));
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnActualizar.setBounds(120, 340, 300, 50);
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFocusPainted(true);
		btnActualizar.setBorder(null);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setBorderPainted(false);
		btnActualizar.setOpaque(false);
		fondoCRUD.add(btnActualizar);

		btnEliminar = new JButton(prop.getProperty("bostinder.ventanaperfil.btnEliminar"));
		btnEliminar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnEliminar.setBounds(120, 450, 300, 50);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFocusPainted(true);
		btnEliminar.setBorder(null);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setOpaque(false);
		fondoCRUD.add(btnEliminar);

		btnMatch = new JButton(prop.getProperty("bostinder.ventanaperfil.btnMatch"));
		btnMatch.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnMatch.setBounds(120, 560, 300, 50);
		btnMatch.setForeground(Color.BLACK);
		btnMatch.setFocusPainted(true);
		btnMatch.setBorder(null);
		btnMatch.setOpaque(true);
		btnMatch.setBorderPainted(false);
		btnMatch.setContentAreaFilled(false);
		this.add(btnMatch);

		btnVolver = new JButton("");
		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnVolver.setBounds(26, 50, 135, 40);
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFocusPainted(true);
		btnVolver.setBorder(null);
		btnVolver.setOpaque(true);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		this.add(btnVolver);
	}

	/*
	 * Cambia la imagen de fondo de la ventana de perfil.
	 * 
	 * @param url ruta de la imagen que se usará como nuevo fondo
	 */
	public void cambiarFondo(String url) {
		ImageIcon cambio = new ImageIcon(url);
		Image escalar = cambio.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);

		fondoCRUD.setIcon(new ImageIcon(escalar));
		fondoCRUD.repaint();
		fondoCRUD.revalidate();
	}

	/*
	 * Retorna la etiqueta que contiene la imagen de fondo del perfil.
	 * 
	 * @return etiqueta de fondo del CRUD
	 */
	public JLabel getFondoCRUD() {
		return fondoCRUD;
	}

	/*
	 * Asigna la etiqueta que contiene la imagen de fondo del perfil.
	 * 
	 * @param fondoCRUD etiqueta de fondo del CRUD
	 */
	public void setFondoCRUD(JLabel fondoCRUD) {
		this.fondoCRUD = fondoCRUD;
	}

	/*
	 * Retorna la imagen de fondo original de la ventana de perfil.
	 * 
	 * @return imagen de fondo
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/*
	 * Asigna la imagen de fondo original de la ventana de perfil.
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
	 * Retorna la etiqueta del título de la ventana de perfil.
	 * 
	 * @return etiqueta del título
	 */
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	/*
	 * Asigna la etiqueta del título de la ventana de perfil.
	 * 
	 * @param lblTitulo etiqueta del título
	 */
	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
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
	 * Retorna el botón para eliminar la cuenta del usuario.
	 * 
	 * @return botón eliminar cuenta
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	/*
	 * Asigna el botón para eliminar la cuenta del usuario.
	 * 
	 * @param btnEliminar botón eliminar cuenta
	 */
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	/*
	 * Retorna el botón para actualizar los datos del perfil.
	 * 
	 * @return botón actualizar perfil
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/*
	 * Asigna el botón para actualizar los datos del perfil.
	 * 
	 * @param btnActualizar botón actualizar perfil
	 */
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
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
	 * e inicializa los componentes de la ventana de perfil.
	 * 
	 * @param prop propiedades que contienen los textos de la interfaz
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
	}

	/*
	 * Retorna el botón que permite marcar la cuenta como invisible.
	 * 
	 * @return botón cuenta invisible
	 */
	public JButton getBtnCuentaInvisible() {
		return btnCuentaInvisible;
	}

	/*
	 * Asigna el botón que permite marcar la cuenta como invisible.
	 * 
	 * @param btnCuentaInvisible botón cuenta invisible
	 */
	public void setBtnCuentaInvisible(JButton btnCuentaInvisible) {
		this.btnCuentaInvisible = btnCuentaInvisible;
	}

	/*
	 * Retorna el botón que lleva a la sección de matches del usuario.
	 * 
	 * @return botón matches
	 */
	public JButton getBtnMatch() {
		return btnMatch;
	}

	/*
	 * Asigna el botón que lleva a la sección de matches del usuario.
	 * 
	 * @param btnMatch botón matches
	 */
	public void setBtnMatch(JButton btnMatch) {
		this.btnMatch = btnMatch;
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
=======
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Ventana que permite gestionar el perfil del usuario.
 * Ofrece opciones para hacer la cuenta invisible, actualizarla, eliminarla y acceder a la sección de matches.
 */
public class VentanaPerfil extends JFrame {

	private JLabel fondoCRUD;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel lblTitulo;

	private JButton btnVolver;

	private JButton btnCuentaInvisible;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnMatch;

	private JButton btnOscuro;
	private JButton btnClaro;

	private Properties prop;

	/*
	 * Constructor por defecto de la ventana de perfil del usuario.
	 */
	public VentanaPerfil() {

	}

	/*
	 * Inicializa y configura todos los componentes gráficos de la ventana de perfil.
	 * Define el fondo, el título, los botones de acciones sobre la cuenta y los botones de cambio de tema.
	 */
	public void inicializarComponentes() {

		this.setTitle("Ventana perfil usuario");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaPerfilOscuro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoCRUD = new JLabel(new ImageIcon(escalar));
		fondoCRUD.setLayout(null);
		fondoCRUD.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoCRUD);
		this.pack();
		this.setLocationRelativeTo(null);

		lblTitulo = new JLabel(prop.getProperty("bostinder.ventanaperfil.lbltitulo"));
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 60));
		lblTitulo.setBounds(220, 20, 1200, 70);
		lblTitulo.setForeground(Color.WHITE);
		this.add(lblTitulo);

		btnClaro = new JButton("");
		btnClaro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnClaro.setBounds(928, 20, 110, 40);
		btnClaro.setForeground(Color.BLACK);
		btnClaro.setFocusPainted(true);
		btnClaro.setBorder(null);
		btnClaro.setOpaque(true);
		btnClaro.setBorderPainted(false);
		btnClaro.setContentAreaFilled(false);
		this.add(btnClaro);

		btnOscuro = new JButton("");
		btnOscuro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnOscuro.setBounds(1071, 20, 110, 40);
		btnOscuro.setForeground(Color.BLACK);
		btnOscuro.setFocusPainted(true);
		btnOscuro.setBorder(null);
		btnOscuro.setOpaque(true);
		btnOscuro.setBorderPainted(false);
		btnOscuro.setContentAreaFilled(false);
		this.add(btnOscuro);

		btnCuentaInvisible = new JButton(prop.getProperty("bostinder.ventanaperfil.btnCuentaInvisible"));
		btnCuentaInvisible.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnCuentaInvisible.setBounds(120, 236, 300, 50);
		btnCuentaInvisible.setForeground(Color.BLACK);
		btnCuentaInvisible.setFocusPainted(true);
		btnCuentaInvisible.setBorder(null);
		btnCuentaInvisible.setContentAreaFilled(false);
		btnCuentaInvisible.setBorderPainted(false);
		btnCuentaInvisible.setOpaque(false);
		fondoCRUD.add(btnCuentaInvisible);

		btnActualizar = new JButton(prop.getProperty("bostinder.ventanaperfil.btnActualizar"));
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnActualizar.setBounds(120, 340, 300, 50);
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFocusPainted(true);
		btnActualizar.setBorder(null);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setBorderPainted(false);
		btnActualizar.setOpaque(false);
		fondoCRUD.add(btnActualizar);

		btnEliminar = new JButton(prop.getProperty("bostinder.ventanaperfil.btnEliminar"));
		btnEliminar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnEliminar.setBounds(120, 450, 300, 50);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFocusPainted(true);
		btnEliminar.setBorder(null);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setOpaque(false);
		fondoCRUD.add(btnEliminar);

		btnMatch = new JButton(prop.getProperty("bostinder.ventanaperfil.btnMatch"));
		btnMatch.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnMatch.setBounds(120, 560, 300, 50);
		btnMatch.setForeground(Color.BLACK);
		btnMatch.setFocusPainted(true);
		btnMatch.setBorder(null);
		btnMatch.setOpaque(true);
		btnMatch.setBorderPainted(false);
		btnMatch.setContentAreaFilled(false);
		this.add(btnMatch);

		btnVolver = new JButton("");
		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnVolver.setBounds(26, 50, 135, 40);
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFocusPainted(true);
		btnVolver.setBorder(null);
		btnVolver.setOpaque(true);
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);
		this.add(btnVolver);
	}

	/*
	 * Cambia la imagen de fondo de la ventana de perfil.
	 * 
	 * @param url ruta de la imagen que se usará como nuevo fondo
	 */
	public void cambiarFondo(String url) {
		ImageIcon cambio = new ImageIcon(url);
		Image escalar = cambio.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);

		fondoCRUD.setIcon(new ImageIcon(escalar));
		fondoCRUD.repaint();
		fondoCRUD.revalidate();
	}

	/*
	 * Retorna la etiqueta que contiene la imagen de fondo del perfil.
	 * 
	 * @return etiqueta de fondo del CRUD
	 */
	public JLabel getFondoCRUD() {
		return fondoCRUD;
	}

	/*
	 * Asigna la etiqueta que contiene la imagen de fondo del perfil.
	 * 
	 * @param fondoCRUD etiqueta de fondo del CRUD
	 */
	public void setFondoCRUD(JLabel fondoCRUD) {
		this.fondoCRUD = fondoCRUD;
	}

	/*
	 * Retorna la imagen de fondo original de la ventana de perfil.
	 * 
	 * @return imagen de fondo
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/*
	 * Asigna la imagen de fondo original de la ventana de perfil.
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
	 * Retorna la etiqueta del título de la ventana de perfil.
	 * 
	 * @return etiqueta del título
	 */
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	/*
	 * Asigna la etiqueta del título de la ventana de perfil.
	 * 
	 * @param lblTitulo etiqueta del título
	 */
	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
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
	 * Retorna el botón para eliminar la cuenta del usuario.
	 * 
	 * @return botón eliminar cuenta
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	/*
	 * Asigna el botón para eliminar la cuenta del usuario.
	 * 
	 * @param btnEliminar botón eliminar cuenta
	 */
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	/*
	 * Retorna el botón para actualizar los datos del perfil.
	 * 
	 * @return botón actualizar perfil
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/*
	 * Asigna el botón para actualizar los datos del perfil.
	 * 
	 * @param btnActualizar botón actualizar perfil
	 */
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
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
	 * e inicializa los componentes de la ventana de perfil.
	 * 
	 * @param prop propiedades que contienen los textos de la interfaz
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
	}

	/*
	 * Retorna el botón que permite marcar la cuenta como invisible.
	 * 
	 * @return botón cuenta invisible
	 */
	public JButton getBtnCuentaInvisible() {
		return btnCuentaInvisible;
	}

	/*
	 * Asigna el botón que permite marcar la cuenta como invisible.
	 * 
	 * @param btnCuentaInvisible botón cuenta invisible
	 */
	public void setBtnCuentaInvisible(JButton btnCuentaInvisible) {
		this.btnCuentaInvisible = btnCuentaInvisible;
	}

	/*
	 * Retorna el botón que lleva a la sección de matches del usuario.
	 * 
	 * @return botón matches
	 */
	public JButton getBtnMatch() {
		return btnMatch;
	}

	/*
	 * Asigna el botón que lleva a la sección de matches del usuario.
	 * 
	 * @param btnMatch botón matches
	 */
	public void setBtnMatch(JButton btnMatch) {
		this.btnMatch = btnMatch;
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
>>>>>>> branch 'master' of https://github.com/0hsamm/Proyecto-final
