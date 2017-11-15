package uade.ioo.vista.formularios;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.observer.IObservador;
import uade.ioo.vista.controlador.AdministradorPagos;

public class JTercerosAVencer extends JPrincipal implements IObservador {

	private static final long serialVersionUID = 3817888344904972349L;
	
	private DefaultTableModel tableModel;
	private JTable table;

	public JTercerosAVencer(AdministradorPagos admp) {
		super(admp);
		this.setTitle("Terceros a Vencer");
		tableModel = new DefaultTableModel(new Object[]{"Nro","Expiracion","Monto"}, 0);
	    table = new JTable(tableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(table.getTableHeader(), BorderLayout.NORTH);
        this.popular();
	}

	@Override
	public void actualizar() {
		tableModel.setRowCount(0);
		this.popular();
	}
	
	private void popular(){
		for(Cheque cheque : getControlador().getChequesAVencer()){
			this.tableModel.addRow(new Object[]{
					cheque.getNumero().toString(), 
					cheque.getFechaEmision().toString(), 
					String.format("%.2f", cheque.getMontoDisponiblePago())
				}
			);
		}
		
	}

}
