package uade.ioo.vista.formulario;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.vista.comportamiento.IVistaAVencer;
import uade.ioo.vista.controlador.AVencerController;
import uade.ioo.vista.modeloVista.MiModeloCheques;

public class JFormularioAVencer extends JFormularioBaseObservador implements IVistaAVencer {

	private static final long serialVersionUID = 1L;
	
	private MiModeloCheques chus;
	private JTable tabla;
	private JButton btnDepositar = new JButton("Depositar");

	public JFormularioAVencer(AdministradorPagos admp) {
		super(admp);
		this.setTitle("Cheques de Terceros a Vencer");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		this.btnDepositar.addActionListener(new AVencerController(this.getModelo(), this));
		this.chus = new MiModeloCheques();
		this.tabla = new JTable(this.chus);
		
		this.getContentPane().add(new JLabel(
			String.format("Cheques a %s dias de su vencimiento.", Cheque.DIAS_PREVIOS_AVISO_VENCIMIENTO)
		));
		this.getContentPane().add(new JLabel("Seleccione para depositar"));
		this.getContentPane().add(tabla);
		this.getContentPane().add(btnDepositar);
		this.actualizar();
	}

	@Override
	public void actualizar() {
		this.chus.setCheques(getModelo().getChequesAVencer());
		this.chus.fireTableDataChanged();
		if(this.chus.getCheques().isEmpty()){
			btnDepositar.setVisible(false);
		} else {
			btnDepositar.setVisible(true);
		}
	}

	@Override
	public List<Cheque> getChequesADepositar() {
		List<Cheque> chequesADepositar = new ArrayList<Cheque>();
		for(Integer selectedRow : this.tabla.getSelectedRows()){
			chequesADepositar.add(this.chus.getCheques().get(selectedRow));
		}
		return chequesADepositar;
	}
	
}
