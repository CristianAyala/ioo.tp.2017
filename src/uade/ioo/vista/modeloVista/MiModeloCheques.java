package uade.ioo.vista.modeloVista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.joda.time.format.DateTimeFormat;

import uade.ioo.modelo.Cheque;

public class MiModeloCheques extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Cheque> cheques;

	public MiModeloCheques() {
		this.cheques = new ArrayList<Cheque>();
	}

	public int getColumnCount() {
		return 1;
	}

	public int getRowCount() {
		return this.cheques.size();
	}

	public Object getValueAt(int arg0, int arg1) {
		Cheque ch = this.cheques.get(arg0);
        return String.format("%s N° %d - Monto: %.2f - Emisión: %s - Estado: %s",
        		ch.getNombre(), ch.getNumero(), ch.getMonto(), 
        		ch.getFechaEmision().toString(DateTimeFormat.forPattern("dd/MM/yyyy")),
        		ch.getEstado().name()
        	);
	}

	public List<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}

}
