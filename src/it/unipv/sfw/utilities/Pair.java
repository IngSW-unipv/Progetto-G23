package it.unipv.sfw.utilities;


/**
 * Classe utilizzata per contentere due valori contemporaneamente.
 * @author Gabriele Invernizzi
 *
 * @param <K>
 * @param <V>
 */
public class Pair<K, V> {
	
	private K key;
	private V val;
	
	/**
	 * key e value verranno inizializzati a null.
	 */
	public Pair() {
		this.key = null;
		this.val = null;
	}
	
	/**
	 * @param key
	 * @param val
	 */
	public Pair(K key, V val) {
		this.key = key;
		this.val = val;
	}

	/**
	 * @return Il valore di key.
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @return Il valore di value.
	 */
	public V getValue() {
		return val;
	}

	/**
	 * @param val
	 */
	public void setValue(V val) {
		this.val = val;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other.getClass() != this.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Pair<K, V> o = (Pair<K, V>)other;
		return o.getKey().equals(this.key) && o.getValue().equals(this.val);
	}
}
