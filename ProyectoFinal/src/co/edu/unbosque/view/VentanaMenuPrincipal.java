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

public class VentanaMenuPrincipal extends JFrame{
	
	private JButton btnSalir;
	private JButton btnConfirmar;
	
	private JLabel fondoMenu;
	private ImageIcon fondo;
	private Image escalar;
	
	private JLabel titulo;
	private JLabel titulo2;
	
	private JLabel alias;
	private JLabel contraseña;
	
	private JTextField textAlias;
	private JTextField textContraseña;
	
	public VentanaMenuPrincipal() {
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		this.setBounds(10, 10, 1280, 720);
		this.setTitle("Menu Principal");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaMenu.JPEG");
		escalar = fondo.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondoMenu = new JLabel(new ImageIcon(escalar));
		fondoMenu.setBounds(0, 0, 1280, 720);
		this.setContentPane(fondoMenu);
		fondoMenu.setLayout(null);
		
		titulo = new JLabel("Bienvenid@ a");
		titulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 60));
		titulo.setBounds(100, 80, 1200, 70);
		titulo.setForeground(Color.WHITE); 
		fondoMenu.add(titulo);
		
		titulo2 = new JLabel("BosTinder");
		titulo2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 60));
		titulo2.setBounds(100, 300, 1200, 70);
		titulo2.setForeground(Color.WHITE); 
		fondoMenu.add(titulo2);
		
		alias = new JLabel("Alias");
		alias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		alias.setBounds(820, 243, 1200, 70);
		fondoMenu.add(alias);
		
		textAlias = new JTextField();
		textAlias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textAlias.setBounds(860, 296, 231, 40);
		textAlias.setBorder(null);
		this.add(textAlias);
		
		contraseña = new JLabel("Contraseña");
		contraseña.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		contraseña.setBounds(820, 327, 1200, 70);
		fondoMenu.add(contraseña);
		
		textContraseña = new JTextField();
		textContraseña.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textContraseña.setBounds(860, 380, 231, 40);
		textContraseña.setBorder(null);
		this.add(textContraseña);
		
		btnConfirmar = new JButton("Inicar Sesión");
		btnConfirmar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnConfirmar.setBounds(818, 493, 280, 30);
		btnConfirmar.setBackground(new Color(198, 48, 44));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setBorder(null);
		this.add(btnConfirmar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnSalir.setBounds(100, 700, 280, 30);
		btnSalir.setBackground(new Color(198, 48, 44));
		btnSalir.setForeground(Color.RED);
		btnSalir.setFocusPainted(false);
		btnSalir.setBorder(null);
		this.add(btnSalir);
		
	}

	public JLabel getFondoMenu() {
		return fondoMenu;
	}

	public void setFondoMenu(JLabel fondoMenu) {
		this.fondoMenu = fondoMenu;
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

	public JLabel getAlias() {
		return alias;
	}

	public void setAlias(JLabel alias) {
		this.alias = alias;
	}

	public JLabel getContraseña() {
		return contraseña;
	}

	public void setContraseña(JLabel contraseña) {
		this.contraseña = contraseña;
	}

	public JTextField getTextAlias() {
		return textAlias;
	}

	public void setTextAlias(JTextField textAlias) {
		this.textAlias = textAlias;
	}

	public JTextField getTextContraseña() {
		return textContraseña;
	}

	public void setTextContraseña(JTextField textContraseña) {
		this.textContraseña = textContraseña;
	}
	
}
