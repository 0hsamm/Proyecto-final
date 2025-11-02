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

public class VentanaCRUD extends JFrame {

	private JLabel fondoCRUD;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel lblTitulo;

	// Botones

	private JButton btnVolver;

	private JButton btnCrear;
	private JButton btnMostrar;
	private JButton btnEliminar;
	private JButton btnActualizar;

	private Properties prop;

	public VentanaCRUD() {
		
	}
	
	public void inicializarComponentes() {
		
		this.setTitle("CRUD");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon(prop.getProperty("bostinder.ventanacrud.urlImagen"));
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoCRUD = new JLabel(new ImageIcon(escalar));
		fondoCRUD.setLayout(null);
		fondoCRUD.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoCRUD);
		this.pack();
		this.setLocationRelativeTo(null);
		
		lblTitulo = new JLabel(prop.getProperty("bostinder.ventanacrud.lbltitulo"));
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 60));
		lblTitulo.setBounds(220, 20, 1200, 70);
		lblTitulo.setForeground(Color.WHITE);
		this.add(lblTitulo);
		
		btnCrear = new JButton(prop.getProperty("bostinder.ventanacrud.btnCrear"));
		btnCrear.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		btnCrear.setBounds(90, 236, 300, 50);
		btnCrear.setForeground(Color.BLACK);
		btnCrear.setFocusPainted(true);
		btnCrear.setBorder(null);
		btnCrear.setContentAreaFilled(false);
		btnCrear.setBorderPainted(false);
		btnCrear.setOpaque(false);
		fondoCRUD.add(btnCrear);
		
		btnMostrar = new JButton(prop.getProperty("bostinder.ventanacrud.btnMostrar"));
		btnMostrar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		btnMostrar.setBounds(100, 340, 300, 50);
		btnMostrar.setForeground(Color.BLACK);
		btnMostrar.setFocusPainted(true);
		btnMostrar.setBorder(null);
		btnMostrar.setContentAreaFilled(false);
		btnMostrar.setBorderPainted(false);
		btnMostrar.setOpaque(false);
		fondoCRUD.add(btnMostrar);
		
		btnEliminar = new JButton(prop.getProperty("bostinder.ventanacrud.btnEliminar"));
		btnEliminar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		btnEliminar.setBounds(100, 450, 300, 50);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFocusPainted(true);
		btnEliminar.setBorder(null);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setOpaque(false);
		fondoCRUD.add(btnEliminar);
		
		btnActualizar = new JButton(prop.getProperty("bostinder.ventanacrud.btnActualizar"));
		btnActualizar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		btnActualizar.setBounds(100, 560, 300, 50);
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFocusPainted(true);
		btnActualizar.setBorder(null);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setBorderPainted(false);
		btnActualizar.setOpaque(false);
		fondoCRUD.add(btnActualizar);
		
		btnVolver = new JButton("");
		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnVolver.setBounds(26, 50, 135, 40);
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFocusPainted(true);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setOpaque(false);
		this.add(btnVolver);
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

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	public void setBtnMostrar(JButton btnMostrar) {
		this.btnMostrar = btnMostrar;
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
	
	
}
