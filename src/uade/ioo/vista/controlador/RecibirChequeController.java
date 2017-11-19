package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.ChequeDeTerceros;
import uade.ioo.vista.comportamiento.IVistaRecibirCheque;

public class RecibirChequeController implements ActionListener {

	private AdministradorPagos modelo;
	private IVistaRecibirCheque vista;
	
	public RecibirChequeController(AdministradorPagos modelo, IVistaRecibirCheque vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(this.vista.validar()){
			ChequeDeTerceros cheque = new ChequeDeTerceros(vista.getNumero(), vista.getMonto(), vista.getfEmi());
			this.modelo.registrarChequeTerceros(cheque);
			this.vista.limpiar();
		}
	}

}
