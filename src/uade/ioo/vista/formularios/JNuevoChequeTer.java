package uade.ioo.vista.formularios;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.observer.IChequesTercero;
/*import comportamientoConversor.IConversor;
import controladorConversor.ControladorKM;
import controladorConversor.ControladorMK;*/
import uade.ioo.vista.controlador.ControladorNuevoChequeTer;

public class JNuevoChequeTer extends JPrincipal implements IChequesTercero{ //registrar cheques de terceros recibidos (creo ChequeTercero).
	//private ChequeTercero ct;
	private static final long serialVersionUID = 1L;
	private JTextField txt;
	private JButton btnMK;
	private JTextField txtc;
	
	public JNuevoChequeTer(AdministradorPagos ap) {		// consultar en donde agrego actionlistener !!!!!!!!!!!!!!!!!!!!!!!!
		super(ap);
		this.txt = new JTextField(); // q se ingrese fechaEmision 
		this.txtc = new JTextField(); // q se ingrese monto de nuevo cheque tercero

		this.getContentPane().setLayout(new FlowLayout()); //X q hay 1 solo control

		this.txt.setColumns(12);
		this.txtc.setColumns(20);

		this.setSize(320, 200);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.getContentPane().add(txt);
		this.getContentPane().add(txtc); 
		
		this.txtc.addActionListener(new ControladorNuevoChequeTer(this, this.getModelo()));
		//this.txtc.actionPerformed();

		/*this.btnMK = new JButton();
		this.btnMK.setText("Convertir Millas a Kilometros");
		this.btnMK.addActionListener(new ControladorMK (this));
		
		this.getContentPane().add(btnMK);
		this.getContentPane().add(txtc);*/
	}

	@Override
	public String getFecha() {
		return this.txt.getText ();
	}

	@Override
	public String getMonto() {
		return this.txtc.getText ();
	}
	
	/*private void registrarNuevoChequeTer (){
	}
	
	public (){ // actualizo modelo

	}*/	

}
