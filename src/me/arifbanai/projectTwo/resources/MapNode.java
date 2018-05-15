package me.arifbanai.projectTwo.resources;

//Singly linked node for LinkedMap
public class MapNode<K, V> {
	
	public K key;
	public V val;
	
	public MapNode<K, V> next;
	
	public MapNode() {
		key = null;
		val = null;
		next = null;
	}
	
	public MapNode(K key, V val) {
		this.key = key;
		this.val = val;
		this.next = null;
	}
	
	public MapNode(K key, V val, MapNode<K, V> next) {
		this.key = key;
		this.val = val;
		this.next = next;
	}	
}
