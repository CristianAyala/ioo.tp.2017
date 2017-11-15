package uade.ioo.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uade.ioo.vista.controlador.AdministradorPagos;

public class JPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private AdministradorPagos admp;
	
	public JPrincipal(AdministradorPagos ap) {
		this.admp= ap;		

		this.setTitle("Menú principal");
		this.setSize(350, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuItem itemRegistrarChequeTercero= new JMenuItem ("Registrar Cheque Tercero");
		itemRegistrarChequeTercero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JNuevoChequeTer registrarChequeTercero= new JNuevoChequeTer(admp);
				registrarChequeTercero.setVisible(true);				
			}
		});
		JMenuItem itemTercerosAVencer= new JMenuItem ("Cheques Terceros a Vencer");
		itemTercerosAVencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTercerosAVencer tercerosAVencer = new JTercerosAVencer(admp);
				admp.registrarObservador(tercerosAVencer);
				tercerosAVencer.setVisible(true);				
			}
		});

		JMenu opciones= new JMenu("Opciones");
		opciones.add(itemRegistrarChequeTercero);
		opciones.add(itemTercerosAVencer);

		JMenuBar barra = new JMenuBar();
		barra.add(opciones);
		this.setJMenuBar(barra);
		
	}
	
	protected AdministradorPagos getControlador(){
		return this.admp;
	}

}
