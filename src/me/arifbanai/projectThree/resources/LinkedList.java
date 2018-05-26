package me.arifbanai.projectThree.resources;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<ListNode<T>> {

	protected ListNode<T> head;
	protected int length;

	//LinkedList with dummy head node
	public LinkedList() {
		head = new ListNode<T>();
		length = 0;
	}

	
	public void prepend(T data) {
		prepend(data, 0);
	}
	
	//Add the node to the front of the list
	public void prepend(T data, int weight) {
			
		ListNode<T> node = new ListNode<T>(data, weight);
			
		if(length == 0) {
			head.next = node;
		} else {
			node.next = head.next;
			head.next = node;
		}
			
		++length;
	}
	
	//Returns node with corresponding data field
	public ListNode<T> get(T data) {
		if(length == 0) {
			throw new IllegalArgumentException("The list is empty!");
		}
		
		for(ListNode<T> temp : this) {
			if(temp.data.equals(data)) {
				return temp;
			}
		}
		
		throw new IllegalArgumentException("Node not found!");
	}

	//Returns first non-dummy node
	public ListNode<T> getFirst() {
		return head.next;
	}
	
	public void removeFirst() {
		if(length == 0) {
			throw new IllegalArgumentException("Out of bounds!");
		}
		
		head.next = head.next.next;
		--length;
	}
	
	public Iterator<ListNode<T>> iterator() {
		return new LinkedListIterator(this);
	}
	
	private class LinkedListIterator implements Iterator<ListNode<T>> {
		
		private ListNode<T> current;
		
		public LinkedListIterator(LinkedList<T> list) {
			//<current> should be the dummy node
			current = list.getFirst();
		}
		
		@Override
		public boolean hasNext() {
			return (current.next != null);
		}

		@Override
		public ListNode<T> next() {
			current = current.next;
			return current;
		}
	}

	public int size() {
		return length;
	}

	
	public boolean isEmpty() {
		return length == 0;
	}

}
