package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {

	private JLabel fondoRegistro;
	private ImageIcon fondo;
	private Image escalar;

	// JLabels

	private JLabel lblTitulo;
	private JLabel lblFiltro;

	private JLabel lblGenero;
	private JLabel lblEdad;
	private JLabel lblEstatura;
	private JLabel lblLike;
	private JLabel lblNombre;
	private JLabel lblIngreso;
	private JLabel lblDivorcio;

	// Botones y cb
	private JButton btnVolver;
	private JButton btnPerfil;
	private JButton btnLike;
	private JButton btnDislike;

	private JComboBox<String> cbGenero;
	private JComboBox<String> cbEdad;
	private JComboBox<String> cbEstatura;
	private JComboBox<String> cbLike;
	private JComboBox<String> cbNombre;
	private JComboBox<String> cbIngreso;
	private JComboBox<String> cbDivorcio;
	
	//tabla
	private JTable tablaUsuarios;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollTabla;
	

	private Properties prop;

	public VentanaPrincipal() {

	}

	public void inicializarComponentes() {

		this.setTitle("Crear cuenta");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		fondo = new ImageIcon("src/co/edu/unbosque/view/VentanaPrincipalOscuro.PNG");
		escalar = fondo.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH);
		fondoRegistro = new JLabel(new ImageIcon(escalar));
		fondoRegistro.setLayout(null);
		fondoRegistro.setPreferredSize(new java.awt.Dimension(1200, 675));
		this.setContentPane(fondoRegistro);
		this.pack();
		this.setLocationRelativeTo(null);

		lblTitulo = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lbltitulo"));
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		lblTitulo.setBounds(220, 20, 1200, 70);
		lblTitulo.setForeground(Color.WHITE);
		this.add(lblTitulo);

		lblFiltro = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblFiltros"));
		lblFiltro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblFiltro.setBounds(70, 147, 1200, 70);
		lblFiltro.setForeground(Color.WHITE);
		this.add(lblFiltro);

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

		lblLike = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblLikes"));
		lblLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblLike.setBounds(110, 374, 1200, 70);
		lblLike.setForeground(Color.BLACK);
		this.add(lblLike);

		cbLike = new JComboBox<>(new String[] { "...", "0 - 10", "11 - 50", "51 - 100", "+ 100" });
		cbLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbLike.setBounds(180, 394, 178, 30);
		cbLike.setBackground(new Color(251, 255, 255));
		cbLike.setForeground(Color.BLACK);
		cbLike.setBorder(BorderFactory.createEmptyBorder());
		cbLike.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbLike);

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

		lblIngreso = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblIngresos"));
		lblIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblIngreso.setBounds(110, 491, 1200, 70);
		lblIngreso.setForeground(Color.BLACK);
		this.add(lblIngreso);

		cbIngreso = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbIngresos").split(","));
		cbIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbIngreso.setBounds(181, 508, 177, 30);
		cbIngreso.setBackground(new Color(251, 255, 255));
		cbIngreso.setForeground(Color.BLACK);
		cbIngreso.setBorder(BorderFactory.createEmptyBorder());
		cbIngreso.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbIngreso);

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
		
		//Boton Like
		btnLike = new JButton("Like");
		btnLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnLike.setBounds(640, 650, 150, 40); 
		btnLike.setBackground(new Color(0, 153, 51));
		btnLike.setForeground(Color.WHITE);
		btnLike.setFocusPainted(false);
		btnLike.setBorder(BorderFactory.createEmptyBorder());
		btnLike.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnLike);

		//Boton Dislike
		btnDislike = new JButton("Dislike");
		btnDislike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnDislike.setBounds(830, 650, 150, 40); 
		btnDislike.setBackground(new Color(204, 0, 0));
		btnDislike.setForeground(Color.WHITE);
		btnDislike.setFocusPainted(false);
		btnDislike.setBorder(BorderFactory.createEmptyBorder());
		btnDislike.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnDislike);
		
		
		//tabla de usuarios
		String[] columnas = {"Foto", "Nombre", "Alias", "Correo", "Edad", "Estatura (cm)", "Ingresos / Divorcio", "Likes"};
		modeloTabla = new DefaultTableModel(columnas, 0) {
		    @Override
		    public Class<?> getColumnClass(int columnIndex) {
		        if (columnIndex == 0) return ImageIcon.class; // Primera columna: imagen
		        return Object.class;
		    }

		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // No editable
		    }
		};

		tablaUsuarios = new JTable(modeloTabla);
		tablaUsuarios.setFillsViewportHeight(true);
		tablaUsuarios.setBackground(Color.DARK_GRAY);
		tablaUsuarios.setForeground(Color.WHITE);
		tablaUsuarios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		tablaUsuarios.setRowHeight(80); // más alto para la foto
		tablaUsuarios.getTableHeader().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		tablaUsuarios.getTableHeader().setBackground(Color.BLACK);
		tablaUsuarios.getTableHeader().setForeground(Color.WHITE);

		// Renderer personalizado para mostrar imágenes centradas
		tablaUsuarios.setDefaultRenderer(ImageIcon.class, new DefaultTableCellRenderer() {
		   
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		        JLabel lbl = new JLabel();
		        lbl.setHorizontalAlignment(JLabel.CENTER);
		        if (value instanceof ImageIcon) {
		            lbl.setIcon((ImageIcon) value);
		        }
		        return lbl;
		    }
		});

		// Scroll y bordes
		scrollTabla = new JScrollPane(tablaUsuarios);
		scrollTabla.setBounds(503, 180, 662, 455);
		scrollTabla.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		scrollTabla.getViewport().setBackground(Color.BLACK);

		this.add(scrollTabla);
		
		btnPerfil = new JButton("");
		btnPerfil.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnPerfil.setBounds(955, 20, 88, 90);
		btnPerfil.setForeground(Color.BLACK);
		btnPerfil.setFocusPainted(true);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setOpaque(false);
		this.add(btnPerfil);

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
		return lblFiltro;
	}

	public void setLblFiltros(JLabel lblFiltros) {
		this.lblFiltro = lblFiltros;
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
		return lblLike;
	}

	public void setLblLikes(JLabel lblLikes) {
		this.lblLike = lblLikes;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblIngresos() {
		return lblIngreso;
	}

	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngreso = lblIngresos;
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
		return cbLike;
	}

	public void setCbLikes(JComboBox<String> cbLikes) {
		this.cbLike = cbLikes;
	}

	public JComboBox<String> getCbNombre() {
		return cbNombre;
	}

	public void setCbNombre(JComboBox<String> cbNombre) {
		this.cbNombre = cbNombre;
	}

	public JComboBox<String> getCbIngresos() {
		return cbIngreso;
	}

	public void setCbIngresos(JComboBox<String> cbIngresos) {
		this.cbIngreso = cbIngresos;
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

	public JLabel getLblFiltro() {
		return lblFiltro;
	}

	public void setLblFiltro(JLabel lblFiltro) {
		this.lblFiltro = lblFiltro;
	}

	public JLabel getLblLike() {
		return lblLike;
	}

	public void setLblLike(JLabel lblLike) {
		this.lblLike = lblLike;
	}

	public JLabel getLblIngreso() {
		return lblIngreso;
	}

	public void setLblIngreso(JLabel lblIngreso) {
		this.lblIngreso = lblIngreso;
	}

	public JComboBox<String> getCbLike() {
		return cbLike;
	}

	public void setCbLike(JComboBox<String> cbLike) {
		this.cbLike = cbLike;
	}

	public JComboBox<String> getCbIngreso() {
		return cbIngreso;
	}

	public void setCbIngreso(JComboBox<String> cbIngreso) {
		this.cbIngreso = cbIngreso;
	}

	public DefaultTableModel getModeloTabla() {
	    return modeloTabla;
	}

	public JTable getTablaUsuarios() {
	    return tablaUsuarios;
	}

}
