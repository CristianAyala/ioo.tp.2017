package uade.ioo;

import uade.ioo.vista.controlador.AdministradorPagos;
import uade.ioo.vista.formularios.JPrincipal;

public class Programa {

	public static void main(String[] args) {
		JPrincipal principal = new JPrincipal(new AdministradorPagos());
		principal.setVisible(true);
	}

}
