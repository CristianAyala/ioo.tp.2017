package uade.ioo.vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaPago;

public class PagoController implements ActionListener {
	
	private AdministradorPagos modelo;
	private IVistaPago vista;
	
	public PagoController(AdministradorPagos modelo, IVistaPago vista){
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(this.vista.validar()){
			this.vista.setChequesParaPagar(this.modelo.obtenerChequesParaPagar(this.vista.getMonto()));
		}
	}

}
