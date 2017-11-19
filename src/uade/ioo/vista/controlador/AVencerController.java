package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaAVencer;

public class AVencerController implements ActionListener {

	private AdministradorPagos modelo;
	private IVistaAVencer vista;
	
	public AVencerController(AdministradorPagos modelo, IVistaAVencer vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(!vista.getChequesADepositar().isEmpty()){
			this.modelo.depositar(vista.getChequesADepositar());
		}
	}

}
