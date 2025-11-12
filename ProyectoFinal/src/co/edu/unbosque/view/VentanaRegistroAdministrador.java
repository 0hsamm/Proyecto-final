package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

public class VentanaRegistroAdministrador extends JFrame {

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

	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
		
	private JPasswordField textContrasenia;
	private JCalendar calendario;
	
	private Properties prop;

	public VentanaRegistroAdministrador() {

	}

	public void inicializarComponentes() {
		this.setTitle("Crear cuenta administrador");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaRegistroAdminOscuro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoRegistro = new JLabel(new ImageIcon(escalar));
		fondoRegistro.setLayout(null);
		fondoRegistro.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoRegistro);
		this.pack();
		this.setLocationRelativeTo(null);

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
		textNombre.setBackground(new Color(0,0,0));
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
		textCorreo.setBackground(new Color(0,0,0));
		textCorreo.setOpaque(true);
		textCorreo.setBorder(null);
		this.add(textCorreo);
		
		//Fecha nacimiento
		
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
		lblContrasenia.setBounds(480, 120, 1200, 70);
		lblContrasenia.setForeground(Color.WHITE);
		this.add(lblContrasenia);

		textContrasenia = new JPasswordField();
		textContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textContrasenia.setBounds(470, 180, 260, 40);
		textContrasenia.setForeground(Color.WHITE);
		textContrasenia.setBackground(new Color(0,0,0));
		textContrasenia.setOpaque(true);
		textContrasenia.setBorder(null);
		this.add(textContrasenia);
		
		//DERECHA
		
		lblApellido = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblApellido"));
		lblApellido.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblApellido.setBounds(90, 283, 1200, 70);
		lblApellido.setForeground(Color.WHITE);
		this.add(lblApellido);

		textApellido = new JTextField();
		textApellido.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textApellido.setBounds(76, 340, 260, 40);
		textApellido.setForeground(Color.WHITE);
		textApellido.setBackground(new Color(0,0,0));
		textApellido.setOpaque(true);
		textApellido.setBorder(null);
		this.add(textApellido);
		
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
		this.add(btnVolver);
		
	}
	
	public String subirFotoPerfil() {
		JFileChooser fileChooser = new JFileChooser();
		int resultado = fileChooser.showOpenDialog(this);
		if (resultado == fileChooser.APPROVE_OPTION) {
			System.out.println("Abrir este archivo: " +
					fileChooser.getSelectedFile().getName());
		}
		return null;
	}
	
	public Properties getProp() {
		return prop;
	}
	
	
	public void setProp(Properties prop) {
	    this.prop = prop;
	    inicializarComponentes();
	}

	public JCalendar getCalendario() {
		return calendario;
	}

	public void setCalendario(JCalendar calendario) {
		this.calendario = calendario;
	}
	
	public LocalDate getFechaSeleccionada() {
	    Date date = calendario.getDate();
	    if (date == null) {
	        return null;
	    }
	    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnCrearCuenta() {
		return btnCrearCuenta;
	}

	public void setBtnCrearCuenta(JButton btnCrearCuenta) {
		this.btnCrearCuenta = btnCrearCuenta;
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

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblNacimiento() {
		return lblNacimiento;
	}

	public void setLblNacimiento(JLabel lblNacimiento) {
		this.lblNacimiento = lblNacimiento;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JTextField getTextApellido() {
		return textApellido;
	}

	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	public JTextField getTextCorreo() {
		return textCorreo;
	}

	public void setTextCorreo(JTextField textCorreo) {
		this.textCorreo = textCorreo;
	}

	public JPasswordField getTextContrasenia() {
		return textContrasenia;
	}

	public void setTextContrasenia(JPasswordField textContrasenia) {
		this.textContrasenia = textContrasenia;
	}

	
	
}
