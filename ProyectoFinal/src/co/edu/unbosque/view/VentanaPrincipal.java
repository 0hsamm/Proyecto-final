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

public class VentanaPrincipal extends JFrame {

	private JLabel fondoRegistro;
	private ImageIcon fondo;
	private Image escalar;

	// JLabels

	private JLabel lblTitulo;
	private JLabel lblFiltros;

	private JLabel lblGenero;
	private JLabel lblEdad;
	private JLabel lblEstatura;
	private JLabel lblLikes;
	private JLabel lblNombre;
	private JLabel lblIngresos;
	private JLabel lblDivorcio;

	// Botones y cb
	private JButton btnVolver;

	private JComboBox<String> cbGenero;
	private JComboBox<String> cbEdad;
	private JComboBox<String> cbEstatura;
	private JComboBox<String> cbLikes;
	private JComboBox<String> cbNombre;
	private JComboBox<String> cbIngresos;
	private JComboBox<String> cbDivorcio;

	private Properties prop;

	public VentanaPrincipal() {

	}

	public void inicializarComponentes() {

		this.setTitle("Crear cuenta");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaPrincipal.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoRegistro = new JLabel(new ImageIcon(escalar));
		fondoRegistro.setLayout(null);
		fondoRegistro.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoRegistro);
		this.pack();
		this.setLocationRelativeTo(null);

		lblTitulo = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lbltitulo"));
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		lblTitulo.setBounds(200, 20, 1200, 70);
		lblTitulo.setForeground(Color.BLACK);
		this.add(lblTitulo);

		lblFiltros = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblFiltros"));
		lblFiltros.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblFiltros.setBounds(70, 147, 1200, 70);
		lblFiltros.setForeground(Color.WHITE);
		this.add(lblFiltros);

		lblGenero = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblGenero"));
		lblGenero.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblGenero.setBounds(110, 200, 1200, 70);
		lblGenero.setForeground(Color.BLACK);
		this.add(lblGenero);

		cbGenero = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbGenero").split(","));
		cbGenero.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbGenero.setBounds(181, 221, 177, 30);
		cbGenero.setBackground(new Color(251, 255, 255));
		cbGenero.setForeground(Color.BLACK);
		cbGenero.setBorder(BorderFactory.createEmptyBorder());
		cbGenero.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbGenero);

		lblEdad = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblEdad"));
		lblEdad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblEdad.setBounds(110, 257, 1200, 70);
		lblEdad.setForeground(Color.BLACK);
		this.add(lblEdad);

		cbEdad = new JComboBox<>(new String[] { "...", "18 - 25", "26 - 35", "36 - 45", "46 - 55", "56 - 65", "66+" });
		cbEdad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbEdad.setBounds(225, 278, 133, 30);
		cbEdad.setBackground(new Color(251, 255, 255));
		cbEdad.setForeground(Color.BLACK);
		cbEdad.setBorder(BorderFactory.createEmptyBorder());
		cbEdad.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbEdad);

		lblEstatura = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblEstatura"));
		lblEstatura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblEstatura.setBounds(110, 314, 1200, 70);
		lblEstatura.setForeground(Color.BLACK);
		this.add(lblEstatura);

		cbEstatura = new JComboBox<>(new String[] { "...", "- 150cm", "150cm - 159cm", "160cm - 169cm", "170cm - 179cm",
				"180cm - 189cm", "190cm - 199cm", "+ 200cm" });
		cbEstatura.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbEstatura.setBounds(247, 335, 111, 30);
		cbEstatura.setBackground(new Color(251, 255, 255));
		cbEstatura.setForeground(Color.BLACK);
		cbEstatura.setBorder(BorderFactory.createEmptyBorder());
		cbEstatura.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbEstatura);

		lblLikes = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblLikes"));
		lblLikes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblLikes.setBounds(110, 374, 1200, 70);
		lblLikes.setForeground(Color.BLACK);
		this.add(lblLikes);

		cbLikes = new JComboBox<>(new String[] { "...", "0 - 10", "11 - 50", "51 - 100", "+ 100" });
		cbLikes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbLikes.setBounds(180, 394, 178, 30);
		cbLikes.setBackground(new Color(251, 255, 255));
		cbLikes.setForeground(Color.BLACK);
		cbLikes.setBorder(BorderFactory.createEmptyBorder());
		cbLikes.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbLikes);

		lblNombre = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblNombre"));
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblNombre.setBounds(110, 432, 1200, 70);
		lblNombre.setForeground(Color.BLACK);
		this.add(lblNombre);

		cbNombre = new JComboBox<>(new String[] { "...", "A-Z", "Z-A" });
		cbNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbNombre.setBounds(181, 451, 178, 30);
		cbNombre.setBackground(new Color(251, 255, 255));
		cbNombre.setForeground(Color.BLACK);
		cbNombre.setBorder(BorderFactory.createEmptyBorder());
		cbNombre.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbNombre);

		lblIngresos = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblIngresos"));
		lblIngresos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblIngresos.setBounds(110, 491, 1200, 70);
		lblIngresos.setForeground(Color.BLACK);
		this.add(lblIngresos);

		cbIngresos = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbIngresos").split(","));
		cbIngresos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbIngresos.setBounds(181, 508, 177, 30);
		cbIngresos.setBackground(new Color(251, 255, 255));
		cbIngresos.setForeground(Color.BLACK);
		cbIngresos.setBorder(BorderFactory.createEmptyBorder());
		cbIngresos.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbIngresos);

		lblDivorcio = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblDivorcio"));
		lblDivorcio.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblDivorcio.setBounds(110, 547, 1200, 70);
		lblDivorcio.setForeground(Color.BLACK);
		this.add(lblDivorcio);

		cbDivorcio = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbDivorcio").split(","));
		cbDivorcio.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbDivorcio.setBounds(208, 566, 150, 30);
		cbDivorcio.setBackground(new Color(251, 255, 255));
		cbDivorcio.setForeground(Color.BLACK);
		cbDivorcio.setBorder(BorderFactory.createEmptyBorder());
		cbDivorcio.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbDivorcio);
		
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

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblFiltros() {
		return lblFiltros;
	}

	public void setLblFiltros(JLabel lblFiltros) {
		this.lblFiltros = lblFiltros;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	public JLabel getLblLikes() {
		return lblLikes;
	}

	public void setLblLikes(JLabel lblLikes) {
		this.lblLikes = lblLikes;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}

	public JLabel getLblDivorcio() {
		return lblDivorcio;
	}

	public void setLblDivorcio(JLabel lblDivorcio) {
		this.lblDivorcio = lblDivorcio;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JComboBox<String> getCbGenero() {
		return cbGenero;
	}

	public void setCbGenero(JComboBox<String> cbGenero) {
		this.cbGenero = cbGenero;
	}

	public JComboBox<String> getCbEdad() {
		return cbEdad;
	}

	public void setCbEdad(JComboBox<String> cbEdad) {
		this.cbEdad = cbEdad;
	}

	public JComboBox<String> getCbEstatura() {
		return cbEstatura;
	}

	public void setCbEstatura(JComboBox<String> cbEstatura) {
		this.cbEstatura = cbEstatura;
	}

	public JComboBox<String> getCbLikes() {
		return cbLikes;
	}

	public void setCbLikes(JComboBox<String> cbLikes) {
		this.cbLikes = cbLikes;
	}

	public JComboBox<String> getCbNombre() {
		return cbNombre;
	}

	public void setCbNombre(JComboBox<String> cbNombre) {
		this.cbNombre = cbNombre;
	}

	public JComboBox<String> getCbIngresos() {
		return cbIngresos;
	}

	public void setCbIngresos(JComboBox<String> cbIngresos) {
		this.cbIngresos = cbIngresos;
	}

	public JComboBox<String> getCbDivorcio() {
		return cbDivorcio;
	}

	public void setCbDivorcio(JComboBox<String> cbDivorcio) {
		this.cbDivorcio = cbDivorcio;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
		inicializarComponentes();
	}

	

}
