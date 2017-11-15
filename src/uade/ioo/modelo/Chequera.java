package uade.ioo.modelo;

public class Chequera {
	
	private static int ultimoNumero = 0;

	public ChequePropio generarCheque(Double monto){
		return new ChequePropio(++ultimoNumero, monto);
	}
	
}
