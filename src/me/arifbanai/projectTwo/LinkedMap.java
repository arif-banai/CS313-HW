package me.arifbanai.projectTwo;

import java.util.Iterator;

import me.arifbanai.projectTwo.resources.Map;
import me.arifbanai.projectTwo.resources.MapNode;

public class LinkedMap<K, V> implements Map<K, V>, Iterable<MapNode<K,V>> {

	protected MapNode<K, V> head;
	protected int size;
	
	public LinkedMap() {
		this.head = new MapNode<>();
		size = 0;
	}
	
	@Override
	public void put(K key, V value) {
		
		MapNode<K, V> temp = new MapNode<>(key, value);
		
		//If the list is not empty, point <temp> to the first "non-dummy" node
		if(head.next != null) {
			temp.next = head.next;
		} 
		
		//Insert new node in front to make insertion run in O(1) time
		head.next = temp;
		size++;
		return;
	}

	@Override
	public V get(K key) {
		for(MapNode<K,V> temp : this) {
			if(temp.key == key) {
				return temp.val;
			}
		}
		
		return null;
	}

	@Override
	public void remove(K key) {
		MapNode<K,V> previous = head;
		MapNode<K,V> target = null;
		
		for(MapNode<K,V> temp : this) {
			if(temp.key.equals(key)) {
				target = temp;
				
				previous.next = target.next;
				size--;
				return;
			}
			
			previous = temp;
		}
		
		//Does nothing if target is never identified
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<MapNode<K, V>> iterator() {
		return new LinkedMapIterator(this);
	}
	
	private class LinkedMapIterator implements Iterator<MapNode<K,V>> {
		
		private MapNode<K, V> current;
		
		public LinkedMapIterator(LinkedMap<K, V> list) {
			//<current> should be the dummy node
			current = head;
		}
		
		@Override
		public boolean hasNext() {
			return (current.next != null);
		}

		@Override
		public MapNode<K,V> next() {
			current = current.next;
			return current;
		}
	}
}
