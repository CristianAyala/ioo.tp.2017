package uade.ioo.modelo;

import org.joda.time.DateTime;

public abstract class Cheque {
	
	public static Integer VIGENCIA = 30;
	public static Integer DIAS_PREVIOS_AVISO_VENCIMIENTO = 7;
	
	protected Integer numero;
	protected Double monto; 
	protected DateTime fechaEmision;
	protected EstadoCheque estado;

	public Cheque(Integer numero, DateTime fechaEmision, Double monto, EstadoCheque estado) {
		this.numero = numero;
		this.fechaEmision = fechaEmision;
		this.monto = monto;
		this.estado = estado;
	}

	public Integer getNumero() {
		return this.numero;
	}
	public Double getMonto() {
		return this.monto;
	}
	public DateTime getFechaEmision() {
		return fechaEmision;
	}
	
	public void setEstado(EstadoCheque estado) {
		this.estado = estado;
	}
	public EstadoCheque getEstado() {
		return estado;
	}

	public Boolean sePuedePagarCon(){
		return ( EstadoCheque.Recibido.equals(this.estado) || EstadoCheque.Emitido.equals(this.estado) ) 
				&& this.fechaEmision.plusDays(Cheque.VIGENCIA).isAfterNow();
	}
	
	public Boolean estaPorVencer() {
		return sePuedePagarCon() && this.fechaEmision.plusDays(Cheque.VIGENCIA-Cheque.DIAS_PREVIOS_AVISO_VENCIMIENTO).isBeforeNow();
	}
	
	public abstract String getNombre();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cheque other = (Cheque) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
}
