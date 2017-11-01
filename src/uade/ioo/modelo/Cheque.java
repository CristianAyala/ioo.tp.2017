package uade.ioo.modelo;

public abstract class Cheque {
	protected int numero;
	protected int /*DateTime*/ fechaEmision;
	protected int monto; 

	public Cheque (int fechaEmi, int m) {
		this.fechaEmision= fechaEmi;
		this.monto= m;
	}

	public abstract void sePuedePagarCon (); 

	public abstract int getMontoDisponiblePago ();
	
	public abstract String getNombre ();

	public int getNumero () {
		return this.numero;
	}
}
