package uade.ioo.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.vista.controlador.AdministradorPagos;

public class JNuevoChequeTer extends JPrincipal {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNumero;
	private JTextField txtFecha;
	private JTextField txtMonto;
	
	private JButton btnRegistrar;
	
	public JNuevoChequeTer(AdministradorPagos ap) {
		super(ap);
		
		this.setTitle("Registrar cheque tercero");
		getContentPane().setLayout(null);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(25, 40, 37, 14);
		this.txtNumero = new JTextField();
		this.txtNumero.setBounds(170, 37, 124, 20);
		
		JLabel lblFecha = new JLabel("Fecha emisión");
		lblFecha.setBounds(25, 71, 77, 14);
		this.txtFecha = new JTextField(); 
		this.txtFecha.setBounds(170, 68, 124, 20);
		this.txtFecha.setColumns(20);
		this.txtFecha.setColumns(8);
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setBounds(25, 100, 77, 14);
		this.txtMonto = new JTextField();
		this.txtMonto.setToolTipText("dd/MM/yyyy");
		this.txtMonto.setBounds(170, 97, 124, 20);
		this.txtMonto.setColumns(20);
		
		this.btnRegistrar= new JButton();
		this.btnRegistrar.setBounds(247, 143, 77, 23);
		this.btnRegistrar.setText("Registrar");
		this.btnRegistrar.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					getControlador().registrarCheque(
						new ChequeTerceros(
							Integer.valueOf(txtNumero.getText()), 
							DateTime.parse(txtFecha.getText(), DateTimeFormat.forPattern("dd/MM/yyyy")), 
							Double.valueOf(txtMonto.getText())
						)
					);
					txtNumero.setText("");
					txtFecha.setText("");
					txtMonto.setText("");
				}
			}
		);
		
		this.getContentPane().add(lblNumero);
		this.getContentPane().add(txtNumero);
		this.getContentPane().add(lblMonto);
		this.getContentPane().add(txtMonto); 
		this.getContentPane().add(lblFecha);
		this.getContentPane().add(txtFecha);
		this.getContentPane().add(btnRegistrar);
	}

}
