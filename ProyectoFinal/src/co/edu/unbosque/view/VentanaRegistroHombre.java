package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

public class VentanaRegistroHombre extends JFrame {

	private JButton btnVolver;
	private JButton btnCrearCuenta;

	private JLabel fondoRegistro;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel titulo;

	private JLabel lblNombre;
	private JLabel lblCorreo;
	
	private JLabel lblNacimiento;

	private JLabel lblContrasenia;
	private JLabel lblAlias;

	private JTextField textNombre;
	private JTextField textCorreo;
		
	private JTextField textContrasenia;

	
	private JTextField textAlias;
	
	// Hombre
	private JLabel lblIngreso;
	private JLabel lblEstatura;

	private JTextField textIngreso;
	private JTextField textEstatura;
	
	//Otros
	private JLabel lblCodigoDeVerificacion;
	private JTextField textCodigoVerificacion;
	private JButton btnEnviarCodigoDeVerificacion;
	private JButton btnSubirImagen;
	private JCalendar calendario;
	
	
	private Properties prop;

	public VentanaRegistroHombre() {

	}

	public void inicializarComponentes() {
		this.setTitle("Crear cuenta hombre");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaRegistroHombre.PNG");
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
		lblContrasenia.setBounds(90, 362, 1200, 70);
		lblContrasenia.setForeground(Color.WHITE);
		this.add(lblContrasenia);

		textContrasenia = new JTextField();
		textContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textContrasenia.setBounds(76, 420, 260, 40);
		textContrasenia.setForeground(Color.WHITE);
		textContrasenia.setBackground(new Color(0,0,0));
		textContrasenia.setOpaque(true);
		textContrasenia.setBorder(null);
		this.add(textContrasenia);
		
		//DERECHA
		
		lblAlias = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblalias"));
		lblAlias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblAlias.setBounds(90, 283, 1200, 70);
		lblAlias.setForeground(Color.WHITE);
		this.add(lblAlias);

		textAlias = new JTextField();
		textAlias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textAlias.setBounds(76, 340, 260, 40);
		textAlias.setForeground(Color.WHITE);
		textAlias.setBackground(new Color(0,0,0));
		textAlias.setOpaque(true);
		textAlias.setBorder(null);
		this.add(textAlias);
		
		//HOMBRE
		lblIngreso = new JLabel(prop.getProperty("bostinder.ventanaregistroHombre.lblingresos"));
		lblIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblIngreso.setBounds(480, 120, 1200, 70);
		lblIngreso.setForeground(Color.WHITE);
		this.add(lblIngreso);

		textIngreso = new JTextField();
		textIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textIngreso.setBounds(470, 180, 260, 40);
		textIngreso.setForeground(Color.WHITE);
		textIngreso.setBackground(new Color(0,0,0));
		textIngreso.setOpaque(true);
		textIngreso.setBorder(null);
		this.add(textIngreso);
		
		lblEstatura = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblestatura"));
		lblEstatura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblEstatura.setBounds(480, 205, 1200, 70);
		lblEstatura.setForeground(Color.WHITE);
		this.add(lblEstatura);

		textEstatura = new JTextField();
		textEstatura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textEstatura.setBounds(470, 263, 260, 40);
		textEstatura.setForeground(Color.WHITE);
		textEstatura.setBackground(new Color(0,0,0));
		textEstatura.setOpaque(true);
		textEstatura.setBorder(null);
		this.add(textEstatura);
		
		
		//Botones
		lblCodigoDeVerificacion = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblCodigo"));
		lblCodigoDeVerificacion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblCodigoDeVerificacion.setBounds(480, 362, 1200, 70);
		lblCodigoDeVerificacion.setForeground(Color.WHITE);
		this.add(lblCodigoDeVerificacion);
		
		textCodigoVerificacion = new JTextField();
		textCodigoVerificacion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textCodigoVerificacion.setBounds(470, 420, 260, 40);
		textCodigoVerificacion.setForeground(Color.WHITE);
		textCodigoVerificacion.setBackground(new Color(0,0,0));
		textCodigoVerificacion.setOpaque(true);
		textCodigoVerificacion.setBorder(null);
		this.add(textCodigoVerificacion);
		
		btnEnviarCodigoDeVerificacion = new JButton(prop.getProperty("bostinder.ventanaregistro.btnEnviarCodigoDeVerificacion"));
		btnEnviarCodigoDeVerificacion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnEnviarCodigoDeVerificacion.setBounds(480, 630, 250, 30);
		btnEnviarCodigoDeVerificacion.setBackground(new Color(198, 48, 44));
		btnEnviarCodigoDeVerificacion.setForeground(Color.WHITE);
		btnEnviarCodigoDeVerificacion.setFocusPainted(false);
		btnEnviarCodigoDeVerificacion.setBorder(null);
		this.add(btnEnviarCodigoDeVerificacion);
		
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
	
		
		btnSubirImagen = new JButton(prop.getProperty("bostinder.ventanaregistro.btnSubirImagen"));
		btnSubirImagen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 90));
		btnSubirImagen.setBounds(1092, 467, 60, 60);
		btnSubirImagen.setForeground(Color.WHITE);
		btnSubirImagen.setFocusPainted(true);
		btnSubirImagen.setBorder(null);
		btnSubirImagen.setOpaque(true);
		btnSubirImagen.setBorderPainted(false);
		btnSubirImagen.setContentAreaFilled(false);
		this.add(btnSubirImagen);
		
	}
	
	public void subirFotoPerfil() {
		JFileChooser fileChooser = new JFileChooser();
		int resultado = fileChooser.showOpenDialog(this);
		if (resultado == fileChooser.APPROVE_OPTION) {
			System.out.println("Abrir este archivo: " +
					fileChooser.getSelectedFile().getName());
		}
	}
	
	public Properties getProp() {
		return prop;
	}
	
	
	public void setProp(Properties prop) {
	    this.prop = prop;
	    inicializarComponentes();
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

	public JLabel getLblAlias() {
		return lblAlias;
	}

	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JTextField getTextCorreo() {
		return textCorreo;
	}

	public void setTextCorreo(JTextField textCorreo) {
		this.textCorreo = textCorreo;
	}

	public JTextField getTextContrasenia() {
		return textContrasenia;
	}

	public void setTextContrasenia(JTextField textContrasenia) {
		this.textContrasenia = textContrasenia;
	}

	public JTextField getTextAlias() {
		return textAlias;
	}

	public void setTextAlias(JTextField textAlias) {
		this.textAlias = textAlias;
	}

	public JLabel getLblIngreso() {
		return lblIngreso;
	}

	public void setLblIngreso(JLabel lblIngreso) {
		this.lblIngreso = lblIngreso;
	}

	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	public JTextField getTextIngreso() {
		return textIngreso;
	}

	public void setTextIngreso(JTextField textIngreso) {
		this.textIngreso = textIngreso;
	}

	public JTextField getTextEstatura() {
		return textEstatura;
	}

	public void setTextEstatura(JTextField textEstatura) {
		this.textEstatura = textEstatura;
	}

	public JLabel getLblCodigoDeVerificacion() {
		return lblCodigoDeVerificacion;
	}

	public void setLblCodigoDeVerificacion(JLabel lblCodigoDeVerificacion) {
		this.lblCodigoDeVerificacion = lblCodigoDeVerificacion;
	}

	public JTextField getTextCodigoVerificacion() {
		return textCodigoVerificacion;
	}

	public void setTextCodigoVerificacion(JTextField textCodigoVerificacion) {
		this.textCodigoVerificacion = textCodigoVerificacion;
	}

	public JButton getBtnEnviarCodigoDeVerificacion() {
		return btnEnviarCodigoDeVerificacion;
	}

	public void setBtnEnviarCodigoDeVerificacion(JButton btnEnviarCodigoDeVerificacion) {
		this.btnEnviarCodigoDeVerificacion = btnEnviarCodigoDeVerificacion;
	}

	public JButton getBtnSubirImagen() {
		return btnSubirImagen;
	}

	public void setBtnSubirImagen(JButton btnSubirImagen) {
		this.btnSubirImagen = btnSubirImagen;
	}

	public JCalendar getCalendario() {
		return calendario;
	}

	public void setCalendario(JCalendar calendario) {
		this.calendario = calendario;
	}
	
	
}
