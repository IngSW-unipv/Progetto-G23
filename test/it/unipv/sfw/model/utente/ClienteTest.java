/**
 * 
 */
package it.unipv.sfw.model.utente;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import it.unipv.sfw.exceptions.EmptyFieldException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;

/**
 * Test della classe {@link it.unipv.sfw.model.utente.Cliente}
 * @author Gabriele Invernizzi
 */
class ClienteTest {

	/**
	 * Test method for {@link it.unipv.sfw.model.utente.Cliente#getType()}.
	 */
	@Test
	void testGetType() {
		Cliente a = new Cliente(null, null, null, null, null);
		assertEquals(a.getType(), Utente.Type.CLIENTE);
	}

	/**
	 * Test method for {@link it.unipv.sfw.model.utente.Utente#checkValidity()}.
	 */
	@Test
	void testCheckValidity() {
		Cliente empty = new Cliente(" ", "", "", "\t", null);
		assertThrows(EmptyFieldException.class, () -> empty.checkValidity());
		
		Cliente invalidFormat = new Cliente("a", "b", "invalid", "c", Calendar.getInstance());
		assertThrows(WrongEmailFormatException.class, () -> invalidFormat.checkValidity());
	}

}
