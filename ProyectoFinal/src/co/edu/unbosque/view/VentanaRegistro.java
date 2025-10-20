package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {

	private JButton btnVolver;
	private JButton btnCrearCuenta;

	private JLabel fondoRegistro;
	private ImageIcon fondo;
	private Image escalar;

	private JLabel titulo;

	private JLabel lblnombre;
	private JLabel lblconrreo;
	
	private JLabel lblnacimiento;
	private JLabel lbldia;
	private JLabel lblmes;
	private JLabel lblanio;
	
	private JLabel lblcontrasenia;
	private JLabel lblSexo;
	private JLabel lblalias;

	private JTextField textnombre;
	private JTextField textcorreo;
	
	private JTextField textdia;
	private JTextField textmes;
	private JTextField textanio;
	
	private JTextField textcontrasenia;

	private JComboBox<String> cbSexo;
	
	private JTextField textalias;
	
	// Hombre
	private JLabel lblingresos;
	private JLabel lblestatura;

	private JTextField textingresos;
	private JTextField textestatura;

	// Mujer
	private JLabel lbldivorcio;

	private JComboBox<String> cbSeHaDivorciado;
	
	//Otros
	private JLabel lblcodigoDeVerificacion;
	private JButton btnEnviarCodigoDeVerificacion;
	
	private Properties prop;

	public VentanaRegistro() {

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

		titulo = new JLabel(prop.getProperty("bostinder.ventanaregistro.lbltitulo"));
		titulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 45));
		titulo.setBounds(200, 20, 1200, 70);
		titulo.setForeground(Color.WHITE);
		this.add(titulo);

		lblnombre = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblnombre"));
		lblnombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblnombre.setBounds(90, 130, 1200, 70);
		lblnombre.setForeground(Color.WHITE);
		this.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textnombre.setBounds(76, 190, 260, 40);
		textnombre.setForeground(Color.WHITE);
		textnombre.setBackground(new Color(0,0,0));
		textnombre.setOpaque(true);
		textnombre.setBorder(null);
		this.add(textnombre);

		lblconrreo = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblcorreo"));
		lblconrreo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblconrreo.setBounds(90, 230, 1200, 70);
		lblconrreo.setForeground(Color.WHITE);
		this.add(lblconrreo);

		textcorreo = new JTextField();
		textcorreo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textcorreo.setBounds(76, 290, 260, 40);
		textcorreo.setForeground(Color.WHITE);
		textcorreo.setBackground(new Color(0,0,0));
		textcorreo.setOpaque(true);
		textcorreo.setBorder(null);
		this.add(textcorreo);
		
		//Fecha nacimiento
		
		lblnacimiento = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblnacimiento"));
		lblnacimiento.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblnacimiento.setBounds(90, 325, 1200, 70);
		lblnacimiento.setForeground(Color.WHITE);
		this.add(lblnacimiento);

		lbldia = new JLabel(prop.getProperty("bostinder.ventanaregistro.lbldia")); //DIA
		lbldia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lbldia.setBounds(100, 410, 1200, 70);
		lbldia.setForeground(Color.WHITE);
		this.add(lbldia);

		textdia = new JTextField();
		textdia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textdia.setBounds(76, 388, 70, 40);
		textdia.setForeground(Color.WHITE);
		textdia.setBackground(new Color(0,0,0));
		textdia.setOpaque(true);
		textdia.setBorder(null);
		this.add(textdia);
		
		lblmes = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblmes")); //MES
		lblmes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblmes.setBounds(190, 410, 1200, 70);
		lblmes.setForeground(Color.WHITE);
		this.add(lblmes);

		textmes = new JTextField();
		textmes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textmes.setBounds(170, 388, 70, 40);
		textmes.setForeground(Color.WHITE);
		textmes.setBackground(new Color(0,0,0));
		textmes.setOpaque(true);
		textmes.setBorder(null);
		this.add(textmes);
		
		lblanio = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblanio")); //AÑO
		lblanio.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblanio.setBounds(285, 410, 1200, 70);
		lblanio.setForeground(Color.WHITE);
		this.add(lblanio);

		textanio = new JTextField();
		textanio.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textanio.setBounds(265, 388, 70, 40);
		textanio.setForeground(Color.WHITE);
		textanio.setBackground(new Color(0,0,0));
		textanio.setOpaque(true);
		textanio.setBorder(null);
		this.add(textanio);

		//
		
		lblcontrasenia = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblcontrasenia"));
		lblcontrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblcontrasenia.setBounds(90, 435, 1200, 70);
		lblcontrasenia.setForeground(Color.WHITE);
		this.add(lblcontrasenia);

		textcontrasenia = new JTextField();
		textcontrasenia.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textcontrasenia.setBounds(76, 495, 260, 40);
		textcontrasenia.setForeground(Color.WHITE);
		textcontrasenia.setBackground(new Color(0,0,0));
		textcontrasenia.setOpaque(true);
		textcontrasenia.setBorder(null);
		this.add(textcontrasenia);
		
		lblSexo = new JLabel(prop.getProperty("bostinder.ventanaregistro.lbSexo "));
		lblSexo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblSexo.setBounds(90, 528, 1200, 70);
		lblSexo.setForeground(Color.WHITE);
		this.add(lblSexo);
		
		cbSexo = new JComboBox<>(new String[] { "Seleccione...", "Mujer", "Hombre" });
		cbSexo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbSexo.setBounds(76, 585, 260, 40);
		cbSexo.setBackground(new Color(0,0,0));
		cbSexo.setForeground(Color.WHITE);
		cbSexo.setBorder(BorderFactory.createEmptyBorder());
		cbSexo.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbSexo);
		//DERECHA
		
		lblalias = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblalias"));
		lblalias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblalias.setBounds(480, 130, 1200, 70);
		lblalias.setForeground(Color.WHITE);
		this.add(lblalias);

		textalias = new JTextField();
		textalias.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textalias.setBounds(470, 190, 260, 40);
		textalias.setForeground(Color.WHITE);
		textalias.setBackground(new Color(0,0,0));
		textalias.setOpaque(true);
		textalias.setBorder(null);
		this.add(textalias);
		
		//HOMBRE
		lblingresos = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblingresos"));
		lblingresos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblingresos.setBounds(480, 260, 1200, 70);
		lblingresos.setForeground(Color.WHITE);
		this.add(lblingresos);

		textingresos = new JTextField();
		textingresos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textingresos.setBounds(470, 320, 260, 40);
		textingresos.setForeground(Color.WHITE);
		textingresos.setBackground(new Color(0,0,0));
		textingresos.setOpaque(true);
		textingresos.setBorder(null);
		this.add(textingresos);
		
		lblestatura = new JLabel(prop.getProperty("bostinder.ventanaregistro.lblestatura"));
		lblestatura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblestatura.setBounds(480, 350, 1200, 70);
		lblestatura.setForeground(Color.WHITE);
		this.add(lblestatura);

		textestatura = new JTextField();
		textestatura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		textestatura.setBounds(470, 408, 260, 40);
		textestatura.setForeground(Color.WHITE);
		textestatura.setBackground(new Color(0,0,0));
		textestatura.setOpaque(true);
		textestatura.setBorder(null);
		this.add(textestatura);
		
		//MUJER
		lbldivorcio = new JLabel(prop.getProperty("bostinder.ventanaregistro.lbldivorcio"));
		lbldivorcio.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lbldivorcio.setBounds(480, 438, 1200, 70);
		lbldivorcio.setForeground(Color.WHITE);
		this.add(lbldivorcio);

		cbSeHaDivorciado = new JComboBox<>(new String[] { "Seleccione...", "Sí", "No" });
		cbSeHaDivorciado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbSeHaDivorciado.setBounds(470, 495, 260, 40);
		cbSeHaDivorciado.setBackground(new Color(0,0,0));
		cbSeHaDivorciado.setForeground(Color.WHITE);
		cbSeHaDivorciado.setBorder(BorderFactory.createEmptyBorder());
		cbSeHaDivorciado.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbSeHaDivorciado);

		
		//Botones
		
		btnEnviarCodigoDeVerificacion = new JButton(prop.getProperty("bostinder.ventanaregistro.btnEnviarCodigoDeVerificacion11"));
		btnEnviarCodigoDeVerificacion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnEnviarCodigoDeVerificacion.setBounds(855, 500, 250, 30);
		btnEnviarCodigoDeVerificacion.setBackground(new Color(198, 48, 44));
		btnEnviarCodigoDeVerificacion.setForeground(Color.WHITE);
		btnEnviarCodigoDeVerificacion.setFocusPainted(false);
		btnEnviarCodigoDeVerificacion.setBorder(null);
		this.add(btnEnviarCodigoDeVerificacion);
		
		btnCrearCuenta = new JButton(prop.getProperty("bostinder.ventanaregistro.btnCrearCuenta"));
		btnCrearCuenta.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnCrearCuenta.setBounds(855, 593, 250, 30);
		btnCrearCuenta.setBackground(new Color(198, 48, 44));
		btnCrearCuenta.setForeground(Color.WHITE);
		btnCrearCuenta.setFocusPainted(false);
		btnCrearCuenta.setBorder(null);
		this.add(btnCrearCuenta);
		
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

	public JLabel getLblnombre() {
		return lblnombre;
	}

	public void setLblnombre(JLabel lblnombre) {
		this.lblnombre = lblnombre;
	}

	public JLabel getLblconrreo() {
		return lblconrreo;
	}

	public void setLblconrreo(JLabel lblconrreo) {
		this.lblconrreo = lblconrreo;
	}

	public JLabel getLblnacimiento() {
		return lblnacimiento;
	}

	public void setLblnacimiento(JLabel lblnacimiento) {
		this.lblnacimiento = lblnacimiento;
	}

	public JLabel getLbldia() {
		return lbldia;
	}

	public void setLbldia(JLabel lbldia) {
		this.lbldia = lbldia;
	}

	public JLabel getLblmes() {
		return lblmes;
	}

	public void setLblmes(JLabel lblmes) {
		this.lblmes = lblmes;
	}

	public JLabel getLblanio() {
		return lblanio;
	}

	public void setLblanio(JLabel lblanio) {
		this.lblanio = lblanio;
	}

	public JLabel getLblcontrasenia() {
		return lblcontrasenia;
	}

	public void setLblcontrasenia(JLabel lblcontrasenia) {
		this.lblcontrasenia = lblcontrasenia;
	}

	public JLabel getLblSexo() {
		return lblSexo;
	}

	public void setLblSexo(JLabel lblSexo) {
		this.lblSexo = lblSexo;
	}

	public JLabel getLblalias() {
		return lblalias;
	}

	public void setLblalias(JLabel lblalias) {
		this.lblalias = lblalias;
	}

	public JTextField getTextnombre() {
		return textnombre;
	}

	public void setTextnombre(JTextField textnombre) {
		this.textnombre = textnombre;
	}

	public JTextField getTextcorreo() {
		return textcorreo;
	}

	public void setTextcorreo(JTextField textcorreo) {
		this.textcorreo = textcorreo;
	}

	public JTextField getTextdia() {
		return textdia;
	}

	public void setTextdia(JTextField textdia) {
		this.textdia = textdia;
	}

	public JTextField getTextmes() {
		return textmes;
	}

	public void setTextmes(JTextField textmes) {
		this.textmes = textmes;
	}

	public JTextField getTextanio() {
		return textanio;
	}

	public void setTextanio(JTextField textanio) {
		this.textanio = textanio;
	}

	public JTextField getTextcontrasenia() {
		return textcontrasenia;
	}

	public void setTextcontrasenia(JTextField textcontrasenia) {
		this.textcontrasenia = textcontrasenia;
	}

	public JComboBox<String> getCbSexo() {
		return cbSexo;
	}

	public void setCbSexo(JComboBox<String> cbSexo) {
		this.cbSexo = cbSexo;
	}

	public JTextField getTextalias() {
		return textalias;
	}

	public void setTextalias(JTextField textalias) {
		this.textalias = textalias;
	}

	public JLabel getLblingresos() {
		return lblingresos;
	}

	public void setLblingresos(JLabel lblingresos) {
		this.lblingresos = lblingresos;
	}

	public JLabel getLblestatura() {
		return lblestatura;
	}

	public void setLblestatura(JLabel lblestatura) {
		this.lblestatura = lblestatura;
	}

	public JTextField getTextingresos() {
		return textingresos;
	}

	public void setTextingresos(JTextField textingresos) {
		this.textingresos = textingresos;
	}

	public JTextField getTextestatura() {
		return textestatura;
	}

	public void setTextestatura(JTextField textestatura) {
		this.textestatura = textestatura;
	}

	public JLabel getLbldivorcio() {
		return lbldivorcio;
	}

	public void setLbldivorcio(JLabel lbldivorcio) {
		this.lbldivorcio = lbldivorcio;
	}

	public JComboBox<String> getCbSeHaDivorciado() {
		return cbSeHaDivorciado;
	}

	public void setCbSeHaDivorciado(JComboBox<String> cbSeHaDivorciado) {
		this.cbSeHaDivorciado = cbSeHaDivorciado;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
	    this.prop = prop;
	    inicializarComponentes();
	}
	
}
