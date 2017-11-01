package uade.ioo.modelo;

public class ChequeTerceros extends Cheque{
	private EstadoCheque ech;
	//private String nombre= ;

	public ChequeTerceros (int fechaEmision, int monto) {
		super (fechaEmision, monto);
	}

	public void sePuedePagarCon () {
		
	}

	public int getMontoDisponiblePago () {
		return this.monto;
	}

	public String getNombre (){
		return "tercero";
	}

	public EstadoCheque getEstado () {
		return this.ech;
	}

	/*public void cambiarEstado () {
		this.ech; // cambio recibido a ado
	}*/

	public int getFechaVencimiento (){
		return this.fechaEmision + 30;
	}
}
