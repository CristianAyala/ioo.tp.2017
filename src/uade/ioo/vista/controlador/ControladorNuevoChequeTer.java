
package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.modelo.observer.IChequesTercero;

/*import comportamientoConversor.IConversor;
import vistaConversor.JConversor;*/

public class ControladorNuevoChequeTer implements ActionListener{
	private IChequesTercero c;
	private AdministradorPagos admp;
	
	public ControladorNuevoChequeTer (IChequesTercero ch, AdministradorPagos ap){
		this.c= ch;
		this.admp= ap;
	}
	
	public void actionPerformed(ActionEvent arg0) {  // creo nuevo cheque tercero y en variables obtengo datos ingresados en pantalla
		int fechaEmi= Integer.parseInt(this.c.getFecha()); //this.txt.getText ()); //obtengo fecha ingresada
		int monto= Integer.parseInt(this.c.getMonto()); //this.txtc.getText ()); // obtengo monto ingresado
		this.admp.registrarCheque (new ChequeTerceros (fechaEmi, monto));  //					!!!!!!!		
	}

}
