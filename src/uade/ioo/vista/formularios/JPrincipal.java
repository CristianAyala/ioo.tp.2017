package uade.ioo.vista.formularios;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import uade.ioo.modelo.AdministradorPagos;
/*import comportamientoConversor.IConversor;
import controladorConversor.ControladorKM;
import controladorConversor.ControladorMK;*/

public class JPrincipal extends JFrame{
	private AdministradorPagos admp;
	private static final long serialVersionUID = 1L;
	private JTextField txt;
	private JButton btnMK;
	private JButton btnKM;
	private JTextField txtc;
	
	public JPrincipal(AdministradorPagos ap) {
		this.admp= ap;		

		this.setSize(320, 200);
		this.setLocationRelativeTo(null);
		//this.getContentPane().setLayout(new FlowLayout());
		
		JMenuBar barra= new JMenuBar ();
		JMenu formularios= new JMenu ("Formularios");
		barra.add (formularios);
		JMenuItem formTextbox= new JMenuItem ("Crear Cheque Tercero");
		
		formTextbox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				AdministradorPagos ap= new AdministradorPagos ();
				JFrame vNCT= new  JNuevoChequeTer(ap); // this.admp.registrar (ct);  !!!!!!!
				vNCT.setVisible(true);				
			}
		});

		/*JMenuItem formPagarSer= new JMenuItem ("Formulario para pagar Servicio");
		
		formPagarSer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				JFrame f2= new PagarServicio();
				f2.setVisible(true);				
			}
		});*/


		formularios.add (formTextbox);
		//formularios.add (formPagarSer);

		this.setJMenuBar(barra);

		this.setSize(320, 200);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*this.txt = new JTextField();
		this.btnMK = new JButton();
		this.btnMK.setText("Convertir Millas a Kilometros");
		this.btnMK.addActionListener(new ControladorMK (this));
		this.txtc = new JTextField();
		
		this.txt.setColumns(12);
		this.txtc.setColumns(20);
	

		
		this.getContentPane().add(txt);
		this.getContentPane().add(btnMK);
		this.getContentPane().add(txtc);*/
	}
	
	protected AdministradorPagos getModelo(){
		return this.admp;
	}

	/*public String getValor() {
		return this.txt.getText();
	}

	@Override
	public void setMensajeConversion(String valor) {
		this.txtc.setText(valor);
	}*/

	
}
