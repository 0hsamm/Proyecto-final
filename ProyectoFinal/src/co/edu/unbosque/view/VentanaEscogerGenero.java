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

public class VentanaEscogerGenero extends JFrame {
	
	private JLabel fondoRegistro;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel titulo;
	
	private JButton btnVolver;
	private JButton btnMujer;
	private JButton btnHombre;
	private JButton btnOscuro;
	private JButton btnClaro;
	
	private Properties prop;
	
	public VentanaEscogerGenero() {
		
	}
	
	public void inicializarComponentes() {
		
		this.setTitle("Escoger sexo");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaEscogerGeneroOscuro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoRegistro = new JLabel(new ImageIcon(escalar));
		fondoRegistro.setLayout(null);
		fondoRegistro.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoRegistro);
		this.pack();
		this.setLocationRelativeTo(null);
		
		titulo = new JLabel(prop.getProperty("bostinder.ventanagenero.lbltitulo"));
		titulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 45));
		titulo.setBounds(200, 20, 1200, 70);
		titulo.setForeground(Color.WHITE);
		this.add(titulo);
		
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
		
		btnMujer = new JButton(prop.getProperty("bostinder.ventanagenero.btnMujer"));
		btnMujer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		btnMujer.setBounds(158, 530, 200, 50);
		btnMujer.setForeground(Color.WHITE);
		btnMujer.setFocusPainted(true);
		btnMujer.setBorder(null);
		btnMujer.setOpaque(true);
		btnMujer.setBorderPainted(false);
		btnMujer.setContentAreaFilled(false);
		this.add(btnMujer);
		
		btnHombre = new JButton(prop.getProperty("bostinder.ventanagenero.btnHombre"));
		btnHombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		btnHombre.setBounds(793, 530, 200, 50);
		btnHombre.setForeground(Color.WHITE);
		btnHombre.setFocusPainted(true);
		btnHombre.setBorder(null);
		btnHombre.setOpaque(true);
		btnHombre.setBorderPainted(false);
		btnHombre.setContentAreaFilled(false);
		this.add(btnHombre);
		
	}
	public void cambiarFondo (String url) {
		ImageIcon cambio = new ImageIcon(url);
		Image escalar = cambio.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		
		fondoRegistro.setIcon(new ImageIcon(escalar));
		fondoRegistro.repaint();
		fondoRegistro.revalidate();
	}

	public JLabel getFondoRegistro() {
		return fondoRegistro;
	}

	public void setFondoRegistro(JLabel fondoRegistro) {
		this.fondoRegistro = fondoRegistro;
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

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnMujer() {
		return btnMujer;
	}

	public void setBtnMujer(JButton btnMujer) {
		this.btnMujer = btnMujer;
	}

	public JButton getBtnHombre() {
		return btnHombre;
	}

	public void setBtnHombre(JButton btnHombre) {
		this.btnHombre = btnHombre;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
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

public class VentanaEscogerGenero extends JFrame {
	
	private JLabel fondoRegistro;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel titulo;
	
	private JButton btnVolver;
	private JButton btnMujer;
	private JButton btnHombre;
	private JButton btnOscuro;
	private JButton btnClaro;
	
	private Properties prop;
	
	public VentanaEscogerGenero() {
		
	}
	
	public void inicializarComponentes() {
		
		this.setTitle("Escoger sexo");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaEscogerGeneroOscuro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoRegistro = new JLabel(new ImageIcon(escalar));
		fondoRegistro.setLayout(null);
		fondoRegistro.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoRegistro);
		this.pack();
		this.setLocationRelativeTo(null);
		
		titulo = new JLabel(prop.getProperty("bostinder.ventanagenero.lbltitulo"));
		titulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 45));
		titulo.setBounds(200, 20, 1200, 70);
		titulo.setForeground(Color.WHITE);
		this.add(titulo);
		
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
		
		btnMujer = new JButton(prop.getProperty("bostinder.ventanagenero.btnMujer"));
		btnMujer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		btnMujer.setBounds(158, 530, 200, 50);
		btnMujer.setForeground(Color.WHITE);
		btnMujer.setFocusPainted(true);
		btnMujer.setBorder(null);
		btnMujer.setOpaque(true);
		btnMujer.setBorderPainted(false);
		btnMujer.setContentAreaFilled(false);
		this.add(btnMujer);
		
		btnHombre = new JButton(prop.getProperty("bostinder.ventanagenero.btnHombre"));
		btnHombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		btnHombre.setBounds(793, 530, 200, 50);
		btnHombre.setForeground(Color.WHITE);
		btnHombre.setFocusPainted(true);
		btnHombre.setBorder(null);
		btnHombre.setOpaque(true);
		btnHombre.setBorderPainted(false);
		btnHombre.setContentAreaFilled(false);
		this.add(btnHombre);
		
	}
	public void cambiarFondo (String url) {
		ImageIcon cambio = new ImageIcon(url);
		Image escalar = cambio.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		
		fondoRegistro.setIcon(new ImageIcon(escalar));
		fondoRegistro.repaint();
		fondoRegistro.revalidate();
	}

	public JLabel getFondoRegistro() {
		return fondoRegistro;
	}

	public void setFondoRegistro(JLabel fondoRegistro) {
		this.fondoRegistro = fondoRegistro;
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

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnMujer() {
		return btnMujer;
	}

	public void setBtnMujer(JButton btnMujer) {
		this.btnMujer = btnMujer;
	}

	public JButton getBtnHombre() {
		return btnHombre;
	}

	public void setBtnHombre(JButton btnHombre) {
		this.btnHombre = btnHombre;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
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
>>>>>>> branch 'master' of https://github.com/0hsamm/Proyecto-final
