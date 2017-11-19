package uade.ioo.vista.formulario;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.util.Util;
import uade.ioo.vista.comportamiento.IVistaPago;
import uade.ioo.vista.controlador.PagarController;
import uade.ioo.vista.controlador.PagoController;
import uade.ioo.vista.modeloVista.MiModeloCheques;

public class JFormularioPago extends JFormularioBase implements IVistaPago {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtMontoPagar = new JTextField();
	private JButton btnObtenerChequesParaPagar = new JButton("Obtener Cheques a Usar");
	private JButton btnPagar = new JButton("Pagar");
	private JLabel lblChequesParaPagar = new JLabel("Cheques a usar para pago:");
	
	private MiModeloCheques chus;
	private JTable tabla;
	
	public JFormularioPago(AdministradorPagos modelo) {
		super(modelo);
		this.setTitle("Realizar Pago con Cheques");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		this.btnObtenerChequesParaPagar.addActionListener(new PagoController(this.getModelo(), this));
		this.btnPagar.addActionListener(new PagarController(this.getModelo(), this));
		this.btnPagar.setVisible(false);
		this.lblChequesParaPagar.setVisible(false);
		this.chus = new MiModeloCheques();
		this.tabla = new JTable(this.chus);
		this.tabla.setRowSelectionAllowed(false);
		
		this.getContentPane().add(new JLabel("Monto a Pagar:"));
		this.getContentPane().add(txtMontoPagar);
		this.getContentPane().add(btnObtenerChequesParaPagar);
		this.getContentPane().add(lblChequesParaPagar);
		this.getContentPane().add(tabla);
		this.getContentPane().add(btnPagar);
	}

	public Double getMonto() {
		return Double.parseDouble(this.txtMontoPagar.getText());
	}

	@Override
	public Boolean validar() {
		if(Util.isDouble(this.txtMontoPagar.getText())){
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El monto ingresado no es válido");
			return false;
		}
	}

	@Override
	public List<Cheque> getChequesParaPagar() {
		return this.chus.getCheques();
	}

	@Override
	public void setChequesParaPagar(List<Cheque> cheques) {
		this.chus.setCheques(cheques);
		this.chus.fireTableDataChanged();
		this.btnPagar.setVisible(true);
		this.lblChequesParaPagar.setVisible(true);
	}
	
	@Override
	public void limpiar() {
		this.txtMontoPagar.setText("");
		this.btnPagar.setVisible(false);
		this.lblChequesParaPagar.setVisible(false);
		this.chus.setCheques(new ArrayList<Cheque>());
		this.chus.fireTableDataChanged();
	}

}
