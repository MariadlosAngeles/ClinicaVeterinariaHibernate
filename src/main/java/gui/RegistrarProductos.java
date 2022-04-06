package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.maria.dao.ProductoDao;
import com.maria.entidades.Persona;
import com.maria.entidades.PersonasProductos;
import com.maria.entidades.Producto;

import controlador.Coordinador;



public class RegistrarProductos  extends JDialog implements ActionListener {

	private final JPanel contentPanel= new JPanel();
	private JTextField txtNombre,txtPrecio;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JLabel lblTitulo;
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField textPersona;
	private JLabel lblIdPersona;
	private JTextField textField;
	private JLabel lblId;
	
	public RegistrarProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 265);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTitulo = new JLabel("GESTIONAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 380, 154);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 66, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(86, 66, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(193, 33, 71, 21);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(251, 33, 86, 20);
		panel.add(txtPrecio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 97, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(274, 120, 89, 23);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(175, 120, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		textField = new JTextField();
		textField.setBounds(86, 11, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(30, 14, 46, 14);
		panel.add(lblId);
		
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {
			Producto miProducto=new Producto();
			
			try {
				miProducto.setIdProducto(Long.parseLong(textField.getText()));
				miProducto.setNombreProducto(txtNombre.getText());
				miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
			
					ProductoDao miProductoDao=new ProductoDao();
					String res = miProductoDao.registrarProducto(miProducto);
					
					if(res.equals("Producto Registrado!") ) {
						JOptionPane.showMessageDialog(null, "Registro Exitoso!!");
					}else {
						JOptionPane.showMessageDialog(null, res, "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Debes llenar los campos primero");
			}
		

			
		}
	}
			
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
