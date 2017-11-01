package uade.ioo.modelo;

import java.util.*;

import uade.ioo.modelo.observer.Observado;

public class AdministradorPagos extends Observado {
	private List <Cheque> c;		//Collection ???
	private Chequera ch;	

	public AdministradorPagos (){
		c= new ArrayList <Cheque> ();
	}

	public void registrarCheque (ChequeTerceros chequeTercero){ // cuando en formulario creo cheque ????
		this.c.add (chequeTercero);
		//this.actualizar (); // para q cuando agregue un nuevo cheque se actualice en ventanas pagar servicio y proximos a vencer
	}

	/*public void obtenerChequesParaPagar (int monto) {	?????
		
		;
	}

	public Cheque generarChequeNuevo (monto) {
		
		return ;
	}

	public double getMontoDisponiblePagos(){
		double ;
		return ;
	}*/

	/*public int montoCheque (Cheque terceroSeleccionado){ // cheque seleccionado devuelvo monto del cheque tercero
		for (Cheque t: this.c)
			if (t.getNombre().equals(terceroSeleccionado) /*&& c. terceroSeleccionado && t.getEstado().*//*) // busco monto de cheque seleccionado y valido q se puede usar cheque
				return terceroSeleccionado.getMontoDisponiblePago ();
	}*/

	/*public void cambiarEstadoChequeTer (Cheque terceroSeleccionado) { // actualiza estado de cheques, emite cheque propio para pagar monto faltante
		; // con un for busco cheque seleccionado y actualizo su estado ??
			t.cambiarEstado (); // en clase cheque tercero cambio estado a entregado
		this.c.remove (terceroSeleccionado);
		//this.actualizar (); // para q cuando quite un nuevo cheque se actualice en ventanas pagar servicio y proximos a vencer
	}*/

	/*public Cheque getChequesTerceros () { // muestra cheques (collection) q estan x vencer y registra deposito de los mismos
		for (Cheque t: this.c){
			if (t.getNombre().equals(tercero) && t.getFechaVencimiento()< 27){ // busca los q estan x vencer
				t.cambiarEstado (); // en clase cheque tercero cambio estado a depositado				
				return t;
			}
		}
	}*/

	/*public Cheque getChequesTercerosSinVencer (){
		for (Cheque t: this.c)
			if (t.getNombre.equals(tercero) && t.getEstado().) // busco monto de cheque seleccionado y valido q se puede usar cheque
				return t;
	}*/

	// métodos q muestra cheques para 30 días anteriores y posteriores
}
