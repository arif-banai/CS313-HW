package me.arifbanai.projectTwo;

import me.arifbanai.dataStructure.linkedList.ListNode;
import me.arifbanai.projectTwo.resources.Map;
import me.arifbanai.projectTwo.resources.MapNode;

public class LinkedMap<K extends Comparable<K>, V> implements Map<K, V> {

	protected MapNode<K, V> head;
	protected int size;
	
	public LinkedMap() {
		this.head = new MapNode();
		size = 0;
	}
	
	
	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
