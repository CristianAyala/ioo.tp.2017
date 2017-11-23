package uade.ioo.test;

import java.text.ParseException;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import junit.framework.TestCase;
import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequeDeTerceros;

public class AdministradorPagosTest extends TestCase {

	@Test
	public void testOk() throws ParseException {

		ChequeDeTerceros ch1 = new ChequeDeTerceros(1234, 200.50d, DateTime.parse("24/10/2017", DateTimeFormat.forPattern("dd/MM/yyyy")));
		ChequeDeTerceros ch2 = new ChequeDeTerceros(1235, 199.50d, DateTime.parse("20/11/2017", DateTimeFormat.forPattern("dd/MM/yyyy")));
		ChequeDeTerceros ch3 = new ChequeDeTerceros(1236, 10000d, DateTime.parse("25/10/2017", DateTimeFormat.forPattern("dd/MM/yyyy")));
		
		AdministradorPagos adm = new AdministradorPagos();
		adm.registrarChequeTerceros(ch1);
		adm.registrarChequeTerceros(ch2);
		adm.registrarChequeTerceros(ch3);
		
		assertEquals(10400d, adm.getMontoDisponiblePagos().doubleValue());
		assertEquals(10200.50d, adm.getMontoAVencer().doubleValue());
		assertEquals(2, adm.getChequesAVencer().size());
		
		List<Cheque> chequesParaPagar = adm.obtenerChequesParaPagar(1000d);
		
		assertEquals(3, chequesParaPagar.size());
		assertEquals(600d, adm.getMontoEmitido());
		assertEquals(11000d, adm.getMontoDisponiblePagos().doubleValue());
		
	}

}
