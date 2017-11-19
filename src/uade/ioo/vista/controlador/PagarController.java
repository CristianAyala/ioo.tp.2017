package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaPago;

public class PagarController implements ActionListener {
	
	private AdministradorPagos modelo;
	private IVistaPago vista;
	
	public PagarController(AdministradorPagos modelo, IVistaPago vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		this.modelo.entregar(this.vista.getChequesParaPagar());
		this.vista.limpiar();
	}

}
