package it.unipv.sfw.utilities;

public class Pair<K, V> {
	
	private K key;
	private V val;
	
	public Pair() {
		this.key = null;
		this.val = null;
	}
	
	public Pair(K key, V val) {
		this.key = key;
		this.val = val;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getVal() {
		return val;
	}

	public void setVal(V val) {
		this.val = val;
	}
	
	
}
