package me.arifbanai.projectTwo.resources;

import me.arifbanai.dataStructure.linkedList.ListNode;

//Singly linked node for LinkedMap
public class MapNode<K, V> {
	
	protected K key;
	protected V val;
	
	protected MapNode<K, V> next;
	
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
	
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return val;
	}
	
	public MapNode<K, V> getNext() {
		return next;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof MapNode<K, V>) { 
			if(this.data.equals(o)) {
				return true;
			}
		}
		
		return false;
	}
	

}
