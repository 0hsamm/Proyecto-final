package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame{
	
	private JButton btnSalir;
	private JButton btnCrearCuenta;
	
	private JLabel fondoRegistro;
	private ImageIcon fondo;
	private Image escalar;
	
	private JLabel titulo;
	
	private JLabel lblnombre;
	private JLabel lblconrreo;
	private JLabel lblcontrasenia;
	
	private JTextField textnombre;
	private JTextField textcorreo;
	private JTextField textcontrasenia;
	
	public VentanaRegistro() {
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		this.setTitle("Crear cuenta");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaRegistro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoRegistro = new JLabel(new ImageIcon(escalar));
		fondoRegistro.setLayout(null);
		fondoRegistro.setPreferredSize(new java.awt.Dimension(1200, 675));

		this.setContentPane(fondoRegistro);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
