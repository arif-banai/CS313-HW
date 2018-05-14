package me.arifbanai.projectTwo;

import me.arifbanai.projectTwo.resources.Map;
import me.arifbanai.projectTwo.resources.MapNode;

public class LinkedMap<K, V> implements Map<K, V> {

	protected MapNode<K, V> head;
	protected int size;
	
	public LinkedMap() {
		this.head = new MapNode<>();
		size = 0;
	}
	
	@Override
	public void put(K key, V value) {
		MapNode<K, V> temp = new MapNode<>(key, value);
		
		if(head.getNext() != null) {
			temp.setNext(head.getNext());
		} 
		
		head.setNext(temp);
		size++;
		return;
	}

	@Override
	public V get(K key) {
		for(MapNode<K,V> temp = head.getNext(); temp != null; temp = temp.getNext()) {
			if(temp.getKey() == key) {
				return temp.getValue();
			}
		}
		
		return null;
	}

	@Override
	public void remove(K key) {
		MapNode<K,V> previous = null;
		MapNode<K,V> target = null;
		
		for(MapNode<K,V> temp = head.getNext(); temp != null; temp = temp.getNext()) {
			if(temp.getKey() == key) {
				target = temp;
				break;
			}
			
			previous = temp;
		}
		
		//If target is null, then we cannot find the node to delete
		//Therefore, exit the method and do not remove anything
		if(target == null) {
			return;
		}
		
		//<previous> should never be null unless the list is empty
		//Therefore, this check should be redundant
		if(previous != null) {
			previous.setNext(target.getNext());
		}
		
		size--;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
}
