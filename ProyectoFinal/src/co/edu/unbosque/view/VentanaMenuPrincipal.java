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

	public VentanaMenuPrincipal() {
		prop = new Properties();
	}

	public void inicializarComponentes() {
		this.setTitle("Menu Principall");
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
	
	public void cambiarFondo (String url) {
		ImageIcon cambio = new ImageIcon(url);
		Image escalar = cambio.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		
		fondoMenu.setIcon(new ImageIcon(escalar));
		fondoMenu.repaint();
		fondoMenu.revalidate();
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	public JLabel getFondoMenu() {
		return fondoMenu;
	}

	public void setFondoMenu(JLabel fondoMenu) {
		this.fondoMenu = fondoMenu;
	}

	public ImageIcon getFondo() {
		return fondo;
	}

	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	public Image getEscalar() {
		return escalar;
	}

	public void setEscalar(Image escalar) {
		this.escalar = escalar;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getTitulo2() {
		return titulo2;
	}

	public void setTitulo2(JLabel titulo2) {
		this.titulo2 = titulo2;
	}

	public JLabel getLblalias() {
		return lblAlias;
	}

	public void setLblalias(JLabel lblalias) {
		this.lblAlias = lblalias;
	}

	public JLabel getLblcontrasenia() {
		return lblContrasenia;
	}

	public void setLblcontrasenia(JLabel lblcontrasenia) {
		this.lblContrasenia = lblcontrasenia;
	}

	public JLabel getLblRegistro() {
		return lblRegistro;
	}

	public void setLblRegistro(JLabel lblRegistro) {
		this.lblRegistro = lblRegistro;
	}

	public JTextField getTextAlias() {
		return textAlias;
	}

	public void setTextAlias(JTextField textAlias) {
		this.textAlias = textAlias;
	}

	

	public JPasswordField getTextContrasenia() {
		return textContrasenia;
	}

	public void setTextContrasenia(JPasswordField textContrasenia) {
		this.textContrasenia = textContrasenia;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
	}

	public JButton getBtnInicioSesionAdmin() {
		return btnInicioSesionAdmin;
	}

	public void setBtnInicioSesionAdmin(JButton btnInicioSesionAdmin) {
		this.btnInicioSesionAdmin = btnInicioSesionAdmin;
	}

	public JLabel getLblAlias() {
		return lblAlias;
	}

	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JButton getBtnOscuro() {
		return btnOscuro;
	}

	public void setBtnOscuro(JButton btnOscuro) {
		this.btnOscuro = btnOscuro;
	}

	public JButton getBtnClaro() {
		return btnClaro;
	}

	public void setBtnClaro(JButton btnClaro) {
		this.btnClaro = btnClaro;
	}
	
	
}