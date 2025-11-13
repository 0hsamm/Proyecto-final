<<<<<<< HEAD
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
	private JLabel lblLike;
	private JLabel lblNombre;
	private JLabel lblIngreso;

	// Botones y cb
	private JButton btnVolver;
	private JButton btnPerfil;
	private JButton btnLike;

	
	private JButton btnClaro;
	private JButton btnOscuro;

	private JComboBox<String> cbGenero;
	private JComboBox<String> cbEdad;
	private JComboBox<String> cbLike;
	private JComboBox<String> cbNombre;
	private JComboBox<String> cbIngreso;
	
	//tabla
	private JTable tablaUsuarios;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollTabla;
	

	private Properties prop;

	public VentanaPrincipal() {

	}

	public void inicializarComponentes() {

		this.setTitle("Ventana Principal");
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
		
		btnOscuro = new JButton("");
		btnOscuro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnOscuro.setBounds(1071, 20, 110, 40); 
		btnOscuro.setForeground(Color.BLACK);
		btnOscuro.setFocusPainted(true);
		btnOscuro.setBorder(null);
		btnOscuro.setOpaque(true);
		btnOscuro.setBorderPainted(false);
		btnOscuro.setContentAreaFilled(false);
		this.add(btnOscuro);
		
		btnClaro = new JButton("");
		btnClaro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnClaro.setBounds(1071, 86, 110, 40); 
		btnClaro.setForeground(Color.BLACK);
		btnClaro.setFocusPainted(true);
		btnClaro.setBorder(null);
		btnClaro.setOpaque(true);
		btnClaro.setBorderPainted(false);
		btnClaro.setContentAreaFilled(false);
		this.add(btnClaro);

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
		lblGenero.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblGenero.setBounds(110, 555, 1200, 70);
		lblGenero.setForeground(Color.BLACK);
		this.add(lblGenero);

		cbGenero = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbGenero").split(","));
		cbGenero.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbGenero.setBounds(230, 575, 177, 30);
		cbGenero.setBackground(new Color(251, 255, 255));
		cbGenero.setForeground(Color.BLACK);
		cbGenero.setBorder(BorderFactory.createEmptyBorder());
		cbGenero.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbGenero);

		lblEdad = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblEdad"));
		lblEdad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblEdad.setBounds(110, 405, 1200, 70);
		lblEdad.setForeground(Color.BLACK);
		this.add(lblEdad);

		cbEdad = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbEdad").split(","));
		cbEdad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbEdad.setBounds(230, 425, 177, 30);
		cbEdad.setBackground(new Color(251, 255, 255));
		cbEdad.setForeground(Color.BLACK);
		cbEdad.setBorder(BorderFactory.createEmptyBorder());
		cbEdad.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbEdad);

		lblLike = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblLikes"));
		lblLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblLike.setBounds(110, 257, 1200, 70);
		lblLike.setForeground(Color.BLACK);
		this.add(lblLike);

		cbLike = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbLikes").split(","));
		cbLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbLike.setBounds(230, 278, 178, 30);
		cbLike.setBackground(new Color(251, 255, 255));
		cbLike.setForeground(Color.BLACK);
		cbLike.setBorder(BorderFactory.createEmptyBorder());
		cbLike.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbLike);

		lblNombre = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblNombre"));
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblNombre.setBounds(110, 330, 1200, 70);
		lblNombre.setForeground(Color.BLACK);
		this.add(lblNombre);

		cbNombre = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbNombre").split(","));
		cbNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbNombre.setBounds(295, 350, 140, 30);
		cbNombre.setBackground(new Color(251, 255, 255));
		cbNombre.setForeground(Color.BLACK);
		cbNombre.setBorder(BorderFactory.createEmptyBorder());
		cbNombre.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbNombre);

		lblIngreso = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblIngresos"));
		lblIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblIngreso.setBounds(110, 480, 1200, 70);
		lblIngreso.setForeground(Color.BLACK);
		this.add(lblIngreso);

		cbIngreso = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbIngresos").split(","));
		cbIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbIngreso.setBounds(230, 500, 177, 30);
		cbIngreso.setBackground(new Color(251, 255, 255));
		cbIngreso.setForeground(Color.BLACK);
		cbIngreso.setBorder(BorderFactory.createEmptyBorder());
		cbIngreso.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbIngreso);

		
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
		btnLike = new JButton(prop.getProperty("bostinder.ventanaprinicipal.btnLike"));
		btnLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnLike.setBounds(640, 640, 150, 25); 
		btnLike.setBackground(new Color(0, 153, 51));
		btnLike.setForeground(Color.WHITE);
		btnLike.setFocusPainted(false);
		btnLike.setBorder(BorderFactory.createEmptyBorder());
		btnLike.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLike.setActionCommand("DAR_LIKE");
		this.add(btnLike);

		
		
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
	
	public void cambiarFondo(String url) {
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

	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	public void setBtnPerfil(JButton btnPerfil) {
		this.btnPerfil = btnPerfil;
	}

	public JButton getBtnLike() {
		return btnLike;
	}

	public void setBtnLike(JButton btnLike) {
		this.btnLike = btnLike;
	}


	public JScrollPane getScrollTabla() {
		return scrollTabla;
	}

	public void setScrollTabla(JScrollPane scrollTabla) {
		this.scrollTabla = scrollTabla;
	}

	public void setTablaUsuarios(JTable tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JButton getBtnClaro() {
		return btnClaro;
	}

	public void setBtnClaro(JButton btnClaro) {
		this.btnClaro = btnClaro;
	}

	public JButton getBtnOscuro() {
		return btnOscuro;
	}

	public void setBtnOscuro(JButton btnOscuro) {
		this.btnOscuro = btnOscuro;
	}
	
	

}
=======
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
	private JLabel lblLike;
	private JLabel lblNombre;
	private JLabel lblIngreso;

	// Botones y cb
	private JButton btnVolver;
	private JButton btnPerfil;
	private JButton btnLike;

	
	private JButton btnClaro;
	private JButton btnOscuro;

	private JComboBox<String> cbGenero;
	private JComboBox<String> cbEdad;
	private JComboBox<String> cbLike;
	private JComboBox<String> cbNombre;
	private JComboBox<String> cbIngreso;
	
	//tabla
	private JTable tablaUsuarios;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollTabla;
	

	private Properties prop;

	public VentanaPrincipal() {

	}

	public void inicializarComponentes() {

		this.setTitle("Ventana Principal");
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
		
		btnOscuro = new JButton("");
		btnOscuro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnOscuro.setBounds(1071, 20, 110, 40); 
		btnOscuro.setForeground(Color.BLACK);
		btnOscuro.setFocusPainted(true);
		btnOscuro.setBorder(null);
		btnOscuro.setOpaque(true);
		btnOscuro.setBorderPainted(false);
		btnOscuro.setContentAreaFilled(false);
		this.add(btnOscuro);
		
		btnClaro = new JButton("");
		btnClaro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnClaro.setBounds(1071, 86, 110, 40); 
		btnClaro.setForeground(Color.BLACK);
		btnClaro.setFocusPainted(true);
		btnClaro.setBorder(null);
		btnClaro.setOpaque(true);
		btnClaro.setBorderPainted(false);
		btnClaro.setContentAreaFilled(false);
		this.add(btnClaro);

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
		lblGenero.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblGenero.setBounds(110, 555, 1200, 70);
		lblGenero.setForeground(Color.BLACK);
		this.add(lblGenero);

		cbGenero = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbGenero").split(","));
		cbGenero.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbGenero.setBounds(230, 575, 177, 30);
		cbGenero.setBackground(new Color(251, 255, 255));
		cbGenero.setForeground(Color.BLACK);
		cbGenero.setBorder(BorderFactory.createEmptyBorder());
		cbGenero.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbGenero);

		lblEdad = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblEdad"));
		lblEdad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblEdad.setBounds(110, 405, 1200, 70);
		lblEdad.setForeground(Color.BLACK);
		this.add(lblEdad);

		cbEdad = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbEdad").split(","));
		cbEdad.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbEdad.setBounds(230, 425, 177, 30);
		cbEdad.setBackground(new Color(251, 255, 255));
		cbEdad.setForeground(Color.BLACK);
		cbEdad.setBorder(BorderFactory.createEmptyBorder());
		cbEdad.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbEdad);

		lblLike = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblLikes"));
		lblLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblLike.setBounds(110, 257, 1200, 70);
		lblLike.setForeground(Color.BLACK);
		this.add(lblLike);

		cbLike = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbLikes").split(","));
		cbLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbLike.setBounds(230, 278, 178, 30);
		cbLike.setBackground(new Color(251, 255, 255));
		cbLike.setForeground(Color.BLACK);
		cbLike.setBorder(BorderFactory.createEmptyBorder());
		cbLike.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbLike);

		lblNombre = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblNombre"));
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblNombre.setBounds(110, 330, 1200, 70);
		lblNombre.setForeground(Color.BLACK);
		this.add(lblNombre);

		cbNombre = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbNombre").split(","));
		cbNombre.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		cbNombre.setBounds(295, 350, 140, 30);
		cbNombre.setBackground(new Color(251, 255, 255));
		cbNombre.setForeground(Color.BLACK);
		cbNombre.setBorder(BorderFactory.createEmptyBorder());
		cbNombre.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbNombre);

		lblIngreso = new JLabel(prop.getProperty("bostinder.ventanaprinicipal.lblIngresos"));
		lblIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblIngreso.setBounds(110, 480, 1200, 70);
		lblIngreso.setForeground(Color.BLACK);
		this.add(lblIngreso);

		cbIngreso = new JComboBox<>(prop.getProperty("bostinder.ventanaprinicipal.cbIngresos").split(","));
		cbIngreso.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		cbIngreso.setBounds(230, 500, 177, 30);
		cbIngreso.setBackground(new Color(251, 255, 255));
		cbIngreso.setForeground(Color.BLACK);
		cbIngreso.setBorder(BorderFactory.createEmptyBorder());
		cbIngreso.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
		this.add(cbIngreso);

		
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
		btnLike = new JButton(prop.getProperty("bostinder.ventanaprinicipal.btnLike"));
		btnLike.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		btnLike.setBounds(640, 640, 150, 25); 
		btnLike.setBackground(new Color(0, 153, 51));
		btnLike.setForeground(Color.WHITE);
		btnLike.setFocusPainted(false);
		btnLike.setBorder(BorderFactory.createEmptyBorder());
		btnLike.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLike.setActionCommand("DAR_LIKE");
		this.add(btnLike);

		
		
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
	
	public void cambiarFondo(String url) {
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

	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	public void setBtnPerfil(JButton btnPerfil) {
		this.btnPerfil = btnPerfil;
	}

	public JButton getBtnLike() {
		return btnLike;
	}

	public void setBtnLike(JButton btnLike) {
		this.btnLike = btnLike;
	}


	public JScrollPane getScrollTabla() {
		return scrollTabla;
	}

	public void setScrollTabla(JScrollPane scrollTabla) {
		this.scrollTabla = scrollTabla;
	}

	public void setTablaUsuarios(JTable tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JButton getBtnClaro() {
		return btnClaro;
	}

	public void setBtnClaro(JButton btnClaro) {
		this.btnClaro = btnClaro;
	}

	public JButton getBtnOscuro() {
		return btnOscuro;
	}

	public void setBtnOscuro(JButton btnOscuro) {
		this.btnOscuro = btnOscuro;
	}
	
	

}
>>>>>>> branch 'master' of https://github.com/0hsamm/Proyecto-final
