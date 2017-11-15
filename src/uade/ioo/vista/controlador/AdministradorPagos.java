package uade.ioo.vista.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequePropio;
import uade.ioo.modelo.ChequeTerceros;
import uade.ioo.modelo.Chequera;
import uade.ioo.modelo.Recibido;
import uade.ioo.modelo.observer.Observado;

public class AdministradorPagos extends Observado {
	
	private List<Cheque> cheques;
	private Chequera chequera;	

	public AdministradorPagos (){
		cheques = new ArrayList <Cheque>();
		chequera = new Chequera();
	}

	public void registrarCheque(ChequeTerceros chequeTercero){
		this.cheques.add(chequeTercero);
		this.actualizarObservadores();
	}
	
	public Cheque generarChequeNuevo (Double monto) {
		ChequePropio chequePropio = this.chequera.generarCheque(monto);
		this.cheques.add(chequePropio);
		return chequePropio;
	}
	
	public double getMontoDisponiblePagos(){
		Double montoDisponible = 0d;
		for(Cheque cheque : this.cheques){
			if(cheque.getEstado() instanceof Recibido){
				montoDisponible += cheque.getMontoDisponiblePago();
			}
		}
		return montoDisponible;
	}

	public List<Cheque> obtenerChequesParaPagar(Double monto){
		Double montoRestante = monto;
		List<Cheque> chequesParaPagar = new ArrayList<Cheque>();
		
		Collections.sort(this.cheques, new Comparator<Cheque>() {
			@Override
			public int compare(Cheque o1, Cheque o2) {
				return o1.getMontoDisponiblePago().compareTo(o2.getMontoDisponiblePago());
			}
		});
		
		for(Cheque cheque : this.cheques){
			if(cheque.sePuedePagarCon() && montoRestante<=cheque.getMontoDisponiblePago()){
				chequesParaPagar.add(cheque);
				montoRestante += cheque.getMontoDisponiblePago();
			}
		}
		
		if(montoRestante>0){
			chequesParaPagar.add(this.generarChequeNuevo(montoRestante));
		}
		
		return chequesParaPagar;
	}

	public List<Cheque> getChequesAVencer() {
		List<Cheque> chequesAVencer = new ArrayList<Cheque>();
		for(Cheque cheque : this.cheques){
			if(cheque.sePuedePagarCon()){
				chequesAVencer.add(cheque);
			}
		}
		return chequesAVencer;
	}
	
}
