package uade.ioo.vista.comportamiento;

import org.joda.time.DateTime;

public interface IVistaRecibirCheque {
	
	public Integer getNumero();
	public Double getMonto();
	public DateTime getfEmi();
	
	public Boolean validar();
	public void limpiar();
	
}
