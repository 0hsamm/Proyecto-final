package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
	private JLabel lblApellido;
	private JLabel lblCorreo;
	
	private JLabel lblNacimiento;

	private JLabel lblContrasenia;
	private JLabel lblAlias;

	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
		
	private JPasswordField textContrasenia;

	
	private JTextField textAlias;
	
	// Hombre
	private JLabel lblIngreso;
	private JLabel lblEstatura;

	private JTextField textIngreso;
	private JTextField textEstatura;
	
	// Admin 
	private JLabel lblRegistro;
	private JButton btnRegistro;
	
	//Otros
	private JButton btnSubirImagen;
	private JCalendar calendario;
	
	
	private Properties prop;
	private String rutaFotoPerfil;

	public VentanaRegistroHombre() {

	}

	public void inicializarComponentes() {
		this.setTitle("Crear cuenta hombre");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaRegistroHombreOscuro.PNG");
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

		textContrasenia = new JPasswordField();
		textContrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textContrasenia.setBounds(76, 420, 260, 40);
		textContrasenia.setForeground(Color.WHITE);
		textContrasenia.setBackground(new Color(0,0,0));
		textContrasenia.setOpaque(true);
		textContrasenia.setBorder(null);
		this.add(textContrasenia);
		
		//DERECHA
		
		lblApellido = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblApellido"));
		lblApellido.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblApellido.setBounds(480, 283, 1200, 70);
		lblApellido.setForeground(Color.WHITE);
		this.add(lblApellido);

		textApellido = new JTextField();
		textApellido.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textApellido.setBounds(470, 340, 260, 40);
		textApellido.setForeground(Color.WHITE);
		textApellido.setBackground(new Color(0,0,0));
		textApellido.setOpaque(true);
		textApellido.setBorder(null);
		this.add(textApellido);
		
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
		btnVolver.setActionCommand("VOLVER_MENU_HOMBRE");
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
		
		lblRegistro = new JLabel(prop.getProperty("bostinder.ventanaregistroadministrador.lblregistro"));
		lblRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblRegistro.setBounds(830, 25, 250, 30);
		this.add(lblRegistro);
		
		btnRegistro = new JButton(prop.getProperty("bostinder.ventanaregistroadministrador.btnregistro"));
		btnRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnRegistro.setBounds(840, 72, 110, 25);
		btnRegistro.setBackground(new Color(255, 184, 184));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorder(null);
		this.add(btnRegistro);
		btnSubirImagen.addActionListener(e -> subirFotoPerfil());
		
	}
	
	public void subirFotoPerfil() {
	    JFileChooser fileChooser = new JFileChooser();
	    int resultado = fileChooser.showOpenDialog(this);

	    if (resultado == JFileChooser.APPROVE_OPTION) {
	        File archivoOrigen = fileChooser.getSelectedFile();

	        try {
	            // Crear carpeta interna "perfiles" si no existe
	            File carpetaDestino = new File("src/co/edu/unbosque/resources/perfiles/");
	            if (!carpetaDestino.exists()) {
	                carpetaDestino.mkdirs();
	            }

	            // Copiar imagen al proyecto con el mismo nombre
	            File archivoDestino = new File(carpetaDestino, archivoOrigen.getName());
	            Files.copy(archivoOrigen.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);

	            rutaFotoPerfil = archivoDestino.getPath(); // Guardar la ruta
	            System.out.println("Imagen copiada en: " + rutaFotoPerfil);
	            JOptionPane.showMessageDialog(this, "Imagen subida correctamente.");

	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error al copiar la imagen.");
	        }
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

	

	public JPasswordField getTextContrasenia() {
		return textContrasenia;
	}

	public void setTextContrasenia(JPasswordField textContrasenia) {
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
	
	public LocalDate getFechaSeleccionada() {
	    Date date = calendario.getDate();
	    if (date == null) {
	        return null;
	    }
	    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public JLabel getLblRegistro() {
		return lblRegistro;
	}

	public void setLblRegistro(JLabel lblRegistro) {
		this.lblRegistro = lblRegistro;
	}

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JTextField getTextApellido() {
		return textApellido;
	}

	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	public String getRutaFotoPerfil() {
		return rutaFotoPerfil;
	}

	public void setRutaFotoPerfil(String rutaFotoPerfil) {
		this.rutaFotoPerfil = rutaFotoPerfil;
	}
	

	
	
}
