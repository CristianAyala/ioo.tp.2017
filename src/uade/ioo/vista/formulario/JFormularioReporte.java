package uade.ioo.vista.formulario;

import javax.swing.BoxLayout;
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
		this.setTitle("Reporte de Cheques");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.getContentPane().add(new JLabel("Monto Disponible: "));
		this.getContentPane().add(lblMontoDisponible);
		this.getContentPane().add(new JLabel("Monto Pagado: "));
		this.getContentPane().add(lblMontoPagado);
		this.getContentPane().add(new JLabel("Monto Depositado: "));
		this.getContentPane().add(lblMontoDepositado);
		this.getContentPane().add(new JLabel("Monto Emitido: "));
		this.getContentPane().add(lblMontoEmitido);
		this.getContentPane().add(new JLabel("Monto a Vencer: "));
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
