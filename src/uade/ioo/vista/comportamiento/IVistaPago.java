package uade.ioo.vista.comportamiento;

import java.util.List;

import uade.ioo.modelo.Cheque;

public interface IVistaPago {
	
	public Double getMonto();
	
	public List<Cheque> getChequesParaPagar();
	public void setChequesParaPagar(List<Cheque> cheques);
	
	public Boolean validar();
	public void limpiar();
	
}
