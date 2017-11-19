package uade.ioo.vista.formulario;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.util.Util;
import uade.ioo.vista.comportamiento.IVistaRecibirCheque;
import uade.ioo.vista.controlador.RecibirChequeController;

public class JFormularioRecibirCheque extends JFormularioBase implements IVistaRecibirCheque {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtMonto = new JTextField();
	private JTextField txtNumero = new JTextField();
	private JTextField txtfEmi = new JTextField();
	private JButton btnAgregarCheque = new JButton("Agregar Cheque");
	
	public JFormularioRecibirCheque(AdministradorPagos modelo) {
		super(modelo);
		this.setTitle("Recibir Cheque de Terceros");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		this.txtfEmi.setToolTipText("dd/MM/yyyy");
		this.btnAgregarCheque.addActionListener(new RecibirChequeController(this.getModelo(), this));
		this.btnAgregarCheque.setMaximumSize(getMaximumSize());
		
		this.getContentPane().add(new JLabel("Numero :"));
		this.getContentPane().add(txtNumero);
		this.getContentPane().add(new JLabel("Monto :"));
		this.getContentPane().add(txtMonto);
		this.getContentPane().add(new JLabel("Fecha Emision (dd/MM/yyyy):"));
		this.getContentPane().add(txtfEmi);
		this.getContentPane().add(btnAgregarCheque);
	}

	public Integer getNumero() {
		return Integer.valueOf(this.txtNumero.getText());
	}

	public Double getMonto() {
		return Double.valueOf(this.txtMonto.getText());
	}

	public DateTime getfEmi() {
		return DateTime.parse(this.txtfEmi.getText(), DateTimeFormat.forPattern("dd/MM/yyyy"));
	}

	@Override
	public Boolean validar() {
		if( Util.isInteger(this.txtNumero.getText()) && Util.isDouble(this.txtMonto.getText()) && Util.isDate(this.txtfEmi.getText()) ){
			if(getfEmi().isAfterNow()){
				JOptionPane.showMessageDialog(null, "La fecha de emisión del cheque no puede ser posterior a la actual");
			} else if(getfEmi().plusDays(Cheque.VIGENCIA).isBeforeNow()){
				JOptionPane.showMessageDialog(null, "El cheque ingresado se encuentra vencido");
			} else {
				return true;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Los datos ingresados no son válidos");
		}
		return false;
	}

	@Override
	public void limpiar() {
		this.txtNumero.setText("");
		this.txtMonto.setText("");
		this.txtfEmi.setText("");
	}
	
}
