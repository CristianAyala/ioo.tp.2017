package uade.ioo.modelo;

import org.joda.time.DateTime;

public abstract class Cheque {
	
	public static Integer VIGENCIA = 30;
	
	protected Integer numero;
	protected Double monto; 
	protected DateTime fechaEmision;
	protected EstadoCheque estado;

	public Cheque(Integer numero, Double monto, DateTime fechaEmision, EstadoCheque estado) {
		this.numero = numero;
		this.monto = monto;
		this.fechaEmision = fechaEmision;
		this.estado = estado;
	}

	public Integer getNumero() {
		return this.numero;
	}
	public Double getMontoDisponiblePago() {
		return this.monto;
	}
	public DateTime getFechaEmision() {
		return fechaEmision;
	}
	public EstadoCheque getEstado() {
		return estado;
	}

	public Boolean sePuedePagarCon(){
		return this.estado instanceof Recibido && this.fechaEmision.plusDays(Cheque.VIGENCIA).isAfterNow();
	}
	
	public abstract String getNombre();
	
}
