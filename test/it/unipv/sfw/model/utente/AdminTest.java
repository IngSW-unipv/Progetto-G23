/**
 * 
 */
package it.unipv.sfw.model.utente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import it.unipv.sfw.exceptions.EmptyFieldException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;


/**
 * Test della classe {@link it.unipv.sfw.model.utente.Admin}
 * @author Gabriele Invernizzi
 */
class AdminTest {

	/**
	 * Test method for {@link it.unipv.sfw.model.utente.Admin#getType()}.
	 */
	@Test
	void testGetType() {
		Admin a = new Admin(null, null, null, null,null);
		assertEquals(a.getType(), Utente.Type.ADMIN);
	}

	/**
	 * Test method for {@link it.unipv.sfw.model.utente.Utente#checkValidity()}.
	 */
	@Test
	void testCheckValidity() {
		Admin empty = new Admin(" ", "", "", "\t",null);
		assertThrows(EmptyFieldException.class, () -> empty.checkValidity());
		
		Admin invalidFormat = new Admin("a", "b", "invalid", "c",Calendar.getInstance());
		assertThrows(WrongEmailFormatException.class, () -> invalidFormat.checkValidity());
	}

}
