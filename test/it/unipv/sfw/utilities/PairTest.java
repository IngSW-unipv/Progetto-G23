/**
 * 
 */
package it.unipv.sfw.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test per la classe {@link it.unipv.sfw.utilities.Pair}
 * @author Gabriele Invernizzi
 */
class PairTest {

	/**
	 * Test method for {@link it.unipv.sfw.utilities.Pair#Pair()}.
	 */
	@Test
	void testPair() {
		Pair<Object, Object> p = new Pair<>();
		assertNull(p.getKey());
		assertNull(p.getValue());
	}

	/**
	 * Test method for {@link it.unipv.sfw.utilities.Pair#Pair(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	void testPairKV() {
		Object k = new Object();
		Object v = new Object();
		Pair<Object, Object> p = new Pair<>(k, v);
		assertEquals(p.getKey(), k);
		assertEquals(p.getValue(), v);
	}
	
	/**
	 * Test method for {@link it.unipv.sfw.utilities.Pair#equals(java.lang.Object)}.
	 */
	@Test
	void testEquals() {
		Object k = new Object();
		Object v = new Object();
		Object vWrong = new Object();
		Pair<Object, Object> p0 = new Pair<>(k, v);
		Pair<Object, Object> p1 = new Pair<>(k, v);
		Pair<Object, Object> pWrong = new Pair<>(k, vWrong);
		assertEquals(p0, p1);
		assertNotEquals(p0, pWrong);
	}
}
