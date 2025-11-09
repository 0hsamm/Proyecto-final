package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaInicioSesionAdmin extends JFrame {

	private JButton btnSalir;
	private JButton btnConfirmar;
	private JButton btnRegistro;

	private JLabel fondoMenu;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel titulo;
	private JLabel titulo2;

	private JLabel lblCorreo;
	private JLabel lblContrasenia;
	private JLabel lblRegistro;

	private JTextField textCorreo;
	private JTextField textContrasenia;

	private Properties prop;

	public VentanaInicioSesionAdmin() {
		prop = new Properties();
	}

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

		lblCorreo = new JLabel(prop.getProperty("bostinder.ventanamenuadmin.lblcorreo"));
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblCorreo.setBounds(810, 243, 1200, 70);
		fondoMenu.add(lblCorreo);

		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textCorreo.setBounds(813, 293, 214, 40);
		textCorreo.setBorder(null);
		fondoMenu.add(textCorreo);

		lblContrasenia = new JLabel(prop.getProperty("bostinder.ventanamenu.lblcontrasenia"));
		lblContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblContrasenia.setBounds(810, 320, 1200, 70);
		fondoMenu.add(lblContrasenia);

		textContrasenia = new JTextField();
		textContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textContrasenia.setBounds(813, 374, 214, 40);
		textContrasenia.setBorder(null);
		fondoMenu.add(textContrasenia);

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

	public JTextField getTextContrasenia() {
		return textContrasenia;
	}

	public void setTextContrasenia(JTextField textContrasenia) {
		this.textContrasenia = textContrasenia;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JTextField getTextCorreo() {
		return textCorreo;
	}

	public void setTextCorreo(JTextField textCorreo) {
		this.textCorreo = textCorreo;
	}

}