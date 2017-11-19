package uade.ioo.vista.formulario;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.observer.IObservador;

public abstract class JFormularioBaseObservador extends JFormularioBase implements IObservador {

	private static final long serialVersionUID = 1L;
	
	public JFormularioBaseObservador(AdministradorPagos modelo) {
		super(modelo);
		getModelo().agregarObservador(this);
	}

}
