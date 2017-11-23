package uade.ioo.vista.formulario;

import java.awt.Font;

import javax.swing.JLabel;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioReporte extends JFormularioBaseObservador {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblMontoDisponible = new JLabel("0");
	private JLabel lblMontoPagado = new JLabel("0");
	private JLabel lblMontoDepositado = new JLabel("0");
	private JLabel lblMontoEmitido = new JLabel("0");
	private JLabel lblMontoAVencer = new JLabel("0");

	public JFormularioReporte(AdministradorPagos modelo) {
		super(modelo);
		getContentPane().setLayout(null);
		this.setTitle("Reporte de Cheques");

		JLabel label = new JLabel("Monto Disponible: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(152, 66, 188, 14);
		this.getContentPane().add(label);
		
		lblMontoDisponible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMontoDisponible.setBounds(350, 66, 62, 14);
		this.getContentPane().add(lblMontoDisponible);
		
		JLabel label_1 = new JLabel("Monto Pagado: ");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(152, 116, 188, 14);
		this.getContentPane().add(label_1);
		
		lblMontoPagado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMontoPagado.setBounds(350, 91, 62, 14);
		this.getContentPane().add(lblMontoPagado);
		
		JLabel label_2 = new JLabel("Monto Depositado: ");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(152, 91, 188, 14);
		this.getContentPane().add(label_2);
		
		lblMontoDepositado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMontoDepositado.setBounds(350, 116, 62, 14);
		this.getContentPane().add(lblMontoDepositado);
		
		JLabel label_3 = new JLabel("Monto Emitido: ");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(152, 141, 188, 14);
		this.getContentPane().add(label_3);
		
		lblMontoEmitido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMontoEmitido.setBounds(350, 141, 62, 14);
		this.getContentPane().add(lblMontoEmitido);
		
		JLabel label_4 = new JLabel("Monto a Vencer: ");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(152, 166, 188, 14);
		this.getContentPane().add(label_4);
		
		lblMontoAVencer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMontoAVencer.setBounds(350, 166, 62, 14);
		this.getContentPane().add(lblMontoAVencer);
		
		this.actualizar();
	}

	@Override
	public void actualizar() {
		this.lblMontoDisponible.setText(String.format("%.2f", getModelo().getMontoDisponiblePagos()));
		
		this.lblMontoPagado.setText(String.format("%.2f", getModelo().getMontoPagado()));
		this.lblMontoDepositado.setText(String.format("%.2f", getModelo().getMontoDepositado()));
		this.lblMontoEmitido.setText(String.format("%.2f", getModelo().getMontoEmitido()));
		
		this.lblMontoAVencer.setText(String.format("%.2f", getModelo().getMontoAVencer()));
	}

}
