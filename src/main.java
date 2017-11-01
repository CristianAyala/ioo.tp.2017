import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.formularios.JNuevoChequeTer;
import uade.ioo.vista.formularios.JPrincipal;


public class main {

	public static void main(String[] args) {
		AdministradorPagos ap= new AdministradorPagos ();
		JFrame vPpal= new  JPrincipal(ap);
		vPpal.setVisible (true);						
	}
}
