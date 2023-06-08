package it.unipv.sfw.model.partita;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Gabriele Invernizzi
 */
class StadioTest {
	
	private static Stadio s;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ArrayList<Posto> posti = new ArrayList<>();
		// Riempi un settore
		for (int i = 1; i < Stadio.ANELLI_PER_SETTORE + 1; i++)
			for (int j = 1; j < Stadio.BLOCCHI_PER_ANELLO + 1; j++)
				for (int k = 1; k < Stadio.POSTI_PER_BLOCCO + 1; k++)
					posti.add(new Posto(1, i, j, k, null));
		// Riempin un anello
		for (int i = 1; i < Stadio.BLOCCHI_PER_ANELLO + 1; i++)
			for (int j = 1; j < Stadio.POSTI_PER_BLOCCO + 1; j++)
				posti.add(new Posto(2, 1, i, j, null));
		// Riempi un blocco
		for (int i = 1; i < Stadio.POSTI_PER_BLOCCO + 1; i++)
			posti.add(new Posto(3, 1, 1, i, null));
		
		s = new Stadio(posti);
	}

	/**
	 * Test method for {@link it.unipv.sfw.model.partita.Stadio#isLibero(int, int, int, int)}.
	 */
	@Test
	void testIsLiberoIntIntIntInt() {
		assertFalse(s.isLibero(1, 1, 1, 1));
		
		assertTrue(s.isLibero(4, 1, 1, 1));
	}

	/**
	 * Test method for {@link it.unipv.sfw.model.partita.Stadio#isLibero(int, int, int)}.
	 */
	@Test
	void testIsLiberoIntIntInt() {
		assertFalse(s.isLibero(1, 1, 1));
		
		assertTrue(s.isLibero(4, 1, 1));
	}

	/**
	 * Test method for {@link it.unipv.sfw.model.partita.Stadio#isLibero(int, int)}.
	 */
	@Test
	void testIsLiberoIntInt() {
		for (int i = 1; i < Stadio.ANELLI_PER_SETTORE; i++)
			assertFalse(s.isLibero(1, i));
		
		for (int i = 1; i < Stadio.ANELLI_PER_SETTORE + 1; i++)
			assertTrue(s.isLibero(4, i));
	}

	/**
	 * Test method for {@link it.unipv.sfw.model.partita.Stadio#isLibero(int)}.
	 */
	@Test
	void testIsLiberoInt() {	
		for (int i = 2; i < Stadio.N_SETTORI + 1; i++)
			assertTrue(s.isLibero(i));
		
		assertFalse(s.isLibero(1));
	}

}
