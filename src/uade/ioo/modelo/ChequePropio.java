package uade.ioo.modelo;

public class ChequePropio extends Cheque {
	

	public ChequePropio (int fechaEmision, int monto) {
		super (fechaEmision, monto);
	}

	public void sePuedePagarCon () {
		
	}

	public int getMontoDisponiblePago () {
		int val=0;
		
		return val;
	}

	@Override
	public String getNombre() {
		return "Cheque Propio";
	}

	
}
