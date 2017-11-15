package uade.ioo.modelo;

import org.joda.time.DateTime;

public class ChequeTerceros extends Cheque {
	
	public ChequeTerceros (Integer numero, DateTime fechaEmision, Double monto) {
		super (numero, monto, fechaEmision, new Recibido());
	}

	@Override
	public String getNombre() {
		return "Cheque tercero";
	}

	public DateTime getFechaVencimiento() {
		return super.fechaEmision.plusDays(Cheque.VIGENCIA);
	}
	
}
