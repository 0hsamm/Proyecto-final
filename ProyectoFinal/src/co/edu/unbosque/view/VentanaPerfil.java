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

public class VentanaPerfil extends JFrame {

	private JLabel fondoCRUD;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel lblTitulo;

	// Botones

	private JButton btnVolver;

	private JButton btnCuentaInvisible;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnCerrarSesion;
	
	private JButton btnOscuro;
	private JButton btnClaro;

	private Properties prop;

	public VentanaPerfil() {
		
	}
	
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
		
		btnCerrarSesion = new JButton(prop.getProperty("bostinder.ventanaperfil.btnCerrarSesion"));
		btnCerrarSesion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		btnCerrarSesion.setBounds(120, 560, 300, 50);
		btnCerrarSesion.setForeground(Color.BLACK);
		btnCerrarSesion.setFocusPainted(true);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setOpaque(true);
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setContentAreaFilled(false);
		this.add(btnCerrarSesion);
		
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
	
	public void cambiarFondo (String url) {
		ImageIcon cambio = new ImageIcon(url);
		Image escalar = cambio.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		
		fondoCRUD.setIcon(new ImageIcon(escalar));
		fondoCRUD.repaint();
		fondoCRUD.revalidate();
	}

	public JLabel getFondoCRUD() {
		return fondoCRUD;
	}

	public void setFondoCRUD(JLabel fondoCRUD) {
		this.fondoCRUD = fondoCRUD;
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

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
	}

	public JButton getBtnCuentaInvisible() {
		return btnCuentaInvisible;
	}

	public void setBtnCuentaInvisible(JButton btnCuentaInvisible) {
		this.btnCuentaInvisible = btnCuentaInvisible;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
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
