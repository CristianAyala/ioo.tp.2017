package uade.ioo.modelo;

import org.joda.time.DateTime;

public class ChequePropio extends Cheque {
	
	public ChequePropio (Integer numero, Double monto) {
		super(numero, new DateTime(), monto, EstadoCheque.Emitido);
	}

	@Override
	public String getNombre() {
		return "Cheque Propio";
	}
	
}
