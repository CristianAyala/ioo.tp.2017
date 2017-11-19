package uade.ioo.vista.formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uade.ioo.modelo.AdministradorPagos;

public abstract class JFormularioBase extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private AdministradorPagos modelo;
	
	public JFormularioBase(AdministradorPagos modelo){
		this.modelo = modelo;
		
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu items = new JMenu("Formularios");
		menu.add(items);
		
		JMenuItem opcAgregarCheque = new JMenuItem("Agregar Cheque Terceros");		
		items.add(opcAgregarCheque);
		opcAgregarCheque.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFormularioRecibirCheque(getModelo());
				f.setVisible(true);				
			}		
		});
		
		JMenuItem opcReporte = new JMenuItem("Reporte");
		items.add(opcReporte);
		opcReporte.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFormularioReporte(getModelo());
				f.setVisible(true);				
			}		
		});
		
		JMenuItem opcPago = new JMenuItem("Pagar...");
		items.add(opcPago);
		opcPago.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFormularioPago(getModelo());
				f.setVisible(true);				
			}
		
		});
		
		JMenuItem opcAVencer = new JMenuItem("A Vencer");
		items.add(opcAVencer);
		opcAVencer.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFormularioAVencer(getModelo());
				f.setVisible(true);				
			}
		});
		
		this.setJMenuBar(menu);
		
	}	
	
	protected AdministradorPagos getModelo() {
		return modelo;
	}

}
