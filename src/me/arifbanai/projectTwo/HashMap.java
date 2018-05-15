package me.arifbanai.projectTwo;

import me.arifbanai.projectTwo.resources.Map;
import me.arifbanai.projectTwo.resources.MapNode;

public class HashMap<K, V> implements Map<K, V> {
	
	public LinkedMap<K, V>[] array;
	private int initialCapacity = 10;
	
	
	private int numNodes;
	private double loadFactor;
	private static final double MAX_LOAD_FACTOR = 4.0d;
	
	public HashMap() {
		array = new LinkedMap[initialCapacity];
		
		for(int i = 0; i < initialCapacity; i++) {
			array[i] = new LinkedMap<K, V>();
		}
		
		numNodes = 0;
		loadFactor = 0d;
	}

	@Override
	public void put(K key, V value) {
		
		if(loadFactor >= MAX_LOAD_FACTOR) {
			grow();
		}
		
		int hash = Math.abs(key.hashCode() % array.length);
		array[hash].put(key, value);
		
		numNodes++;
		loadFactor = (numNodes / array.length);
	}

	@Override
	public V get(K key) {
		int hash = Math.abs(key.hashCode() % array.length);
		return array[hash].get(key);
	}

	@Override
	public void remove(K key) {
		int hash = Math.abs(key.hashCode() % array.length);
		
		--numNodes;
		loadFactor = (--numNodes / array.length);
		
		array[hash].remove(key);
	}

	@Override
	public int size() {
		return numNodes;
	}

	@Override
	public boolean isEmpty() {
		return numNodes == 0;
	}
	
	@SuppressWarnings("unchecked")
	private void grow() {
		LinkedMap<K, V>[] newArray = new LinkedMap[array.length * 2];
		
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = new LinkedMap<K, V>();
		}
		
		for(LinkedMap<K,V> temp : array) {
			for(MapNode<K, V> node : temp) {
				K key = node.key;
				V value = node.val;
				
				int hash = Math.abs(node.key.hashCode() % newArray.length);
				newArray[hash].put(key, value);
			}
		}
		
		this.array = newArray;
	}

	

}
