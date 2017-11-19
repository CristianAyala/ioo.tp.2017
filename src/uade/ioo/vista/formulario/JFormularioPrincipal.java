package uade.ioo.vista.formulario;
import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioPrincipal extends JFormularioBase {

	private static final long serialVersionUID = 1L;

	public JFormularioPrincipal(AdministradorPagos modelo) {
		super(modelo);
		this.setTitle("Administrador de Pagos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
