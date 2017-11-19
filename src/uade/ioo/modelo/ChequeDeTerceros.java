package uade.ioo.modelo;

import org.joda.time.DateTime;

public class ChequeDeTerceros extends Cheque {
	
	public ChequeDeTerceros (Integer numero, Double monto, DateTime fechaEmision) {
		super(numero, fechaEmision, monto, EstadoCheque.Recibido);
	}

	@Override
	public String getNombre() {
		return "Cheque Tercero";
	}

	public DateTime getFechaVencimiento() {
		return super.fechaEmision.plusDays(Cheque.VIGENCIA);
	}
	
}
