package uade.ioo.modelo;

import org.joda.time.DateTime;

public class ChequePropio extends Cheque {
	
	public ChequePropio (Integer numero, Double monto) {
		super(numero, monto, new DateTime(), new Recibido());
	}

	@Override
	public String getNombre() {
		return "Cheque Propio";
	}
	
}
