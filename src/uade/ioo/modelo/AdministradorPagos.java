package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uade.ioo.observer.Observado;

public class AdministradorPagos extends Observado {
	
	private List<Cheque> cheques = new ArrayList<Cheque>();
	private Chequera chequera;	
	
	private Double montoPagado = 0d;
	private Double montoDepositado = 0d;
	private Double montoEmitido = 0d;

	public AdministradorPagos (){
		cheques = new ArrayList <Cheque>();
		chequera = new Chequera();
	}
	
	public void registrarChequeTerceros(ChequeDeTerceros cheque){
		this.cheques.add(cheque);
		this.notificarObservadores();
	}
	
	public Cheque generarChequeNuevo (Double monto) {
		ChequePropio chequePropio = this.chequera.generarCheque(monto);
		this.cheques.add(chequePropio);
		this.montoEmitido += chequePropio.getMonto();
		this.notificarObservadores();
		return chequePropio;
	}

	public List<Cheque> getChequesAVencer() {
		List<Cheque> chequesAVencer = new ArrayList<Cheque>();
		for(Cheque cheque : this.cheques){
			if(cheque.estaPorVencer()){
				chequesAVencer.add(cheque);
			}
		};
		Collections.sort(chequesAVencer, new Comparator<Cheque>() {
			@Override
			public int compare(Cheque c1, Cheque c2) {
				return c1.getFechaEmision().compareTo(c2.getFechaEmision());
			}
		});
		return chequesAVencer;
	}
	
	public List<Cheque> obtenerChequesParaPagar(Double monto){
		Double montoRestante = monto;
		List<Cheque> chequesParaPagar = new ArrayList<Cheque>();
		
		Collections.sort(this.cheques, new Comparator<Cheque>() {
			@Override
			public int compare(Cheque o1, Cheque o2) {
				return o1.getMonto().compareTo(o2.getMonto());
			}
		});
		
		for(Cheque cheque : this.cheques){
			if(cheque.sePuedePagarCon() && cheque.getMonto()<=montoRestante){
				chequesParaPagar.add(cheque);
				montoRestante -= cheque.getMonto();
			}
		}
		
		if(montoRestante>0){
			chequesParaPagar.add(this.generarChequeNuevo(montoRestante));
		}
		
		return chequesParaPagar;
	}

	public void entregar(List<Cheque> chequesAEntregar){
		this.actualizarEstadoCheque(chequesAEntregar, EstadoCheque.Entregado);
		
		for(Cheque cheque : chequesAEntregar){
			this.montoPagado+=cheque.getMonto();
		}
		this.notificarObservadores();
	}
	
	public void depositar(List<Cheque> chequesADepositar){
		this.actualizarEstadoCheque(chequesADepositar, EstadoCheque.Depositado);
		
		for(Cheque cheque : chequesADepositar){
			this.montoDepositado+=cheque.getMonto();
		}
		this.notificarObservadores();
	}
	
	private void actualizarEstadoCheque(List<Cheque> chequesAActualizar, EstadoCheque nuevoEstado){
		for(Cheque chequeAActualizar : chequesAActualizar){
			this.cheques.get(this.cheques.indexOf(chequeAActualizar)).setEstado(nuevoEstado);
		}
	}
	
	public Double getMontoDisponiblePagos(){
		Double montoDisponible = 0d;
		for(Cheque cheque : this.cheques){
			if(cheque.sePuedePagarCon()){
				montoDisponible += cheque.getMonto();
			}
		}
		return montoDisponible;
	}
	
	public Double getMontoAVencer(){
		Double montoAVencer = 0d;
		for(Cheque chequeAVencer : this.getChequesAVencer()){
			montoAVencer+=chequeAVencer.getMonto();
		}
		return montoAVencer;
	}
	
	public Double getMontoPagado() {
		return montoPagado;
	}

	public Double getMontoDepositado() {
		return montoDepositado;
	}

	public Double getMontoEmitido() {
		return montoEmitido;
	}
	
}
