package uade.ioo.modelo.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observado {
	
	private List <IObservador> observadores = new ArrayList <IObservador>();
	
	public void registrarObservador(IObservador obs){
		this.observadores.add(obs);
	}
	
	public void actualizarObservadores(){
		for (IObservador o: this.observadores){
			o.actualizar();
		}
	}
}
