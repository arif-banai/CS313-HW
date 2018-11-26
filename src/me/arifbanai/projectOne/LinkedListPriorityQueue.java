package me.arifbanai.projectOne;

import me.arifbanai.projectOne.resources.ListNode;
import me.arifbanai.projectOne.resources.PriorityQueue;

public class LinkedListPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	//Dummy root node
	private ListNode<T> root;
	private int length;

	//LinkedList with dummy root node
	public LinkedListPriorityQueue() {
		root = new ListNode<T>();
		length = 0;
	}

	//Insert a node in SORTED order
	private void insert(ListNode<T> node) {
		if(length == 0) {
			root.next = node;
			length++;
			return;
		}
		
		for(ListNode<T> temp = root.getNext(); temp != null; temp = temp.getNext()) {			
			if(temp.getData().compareTo(node.getData()) == -1) {
				
				//If the previous node is not null, <temp> is not the first node in the list
				//Otherwise, <temp> is the first node in the list
				//Therefore, <node> should be the new first node (<root> is the "0th" node)
				if(temp.prev != null) {
					//Insert the node between two nodes
					node.next = temp;
					node.prev = temp.prev;
					temp.prev.next = node;
					temp.prev = node;
					
					length++;
					return;
				} else {
					//Insert the node as the first node in the list
					node.next = root.next;
					root.next.prev = node;
					root.next = node;
					
					length++;
					return;
				}
			} else {
				//The same code can be used for when compareTo returns 0, 1, and higher numbers
				
				if(temp.next != null) {
					//There are more nodes to check, so continue
					continue;
				} else {
					//If there is no next node, insert the node at the end
					temp.next = node;
					node.prev = temp;
					
					length++;
					return;
				}
			} 
		}
	}
	

	//Since <root> is a dummy, return the next node
	private ListNode<T> getRoot() {
		return root.next;
	}
	
	private ListNode<T> removeRoot() {
		if(length == 0) {
			throw new IllegalArgumentException("There is no root to remove!");
		}
		
		ListNode<T> targetNode = root.next;
		
		if(length == 1) {
			root.next = null; 
		} else {
			root.next = root.next.next;
			root.next.prev = null;
		}
		
		length--;
		return targetNode;
	}
	
	public void showList() {
		for(ListNode<T> temp = root.next; temp != null; temp = temp.next) {
			System.out.print(temp.getData() + ", ");
		}
	}
	
	@Override
	public int size() {
		return length;
	}
	
	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public void enqueue(T item) {
		ListNode<T> node = new ListNode<>(item);
		
		insert(node);
	}

	@Override
	public T peek() {
		if(!isEmpty()) {
			return getRoot().getData();
		}
		
		return null;
	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			throw new IllegalArgumentException("There is no node to dequeue!");
		}
		
		return removeRoot().getData();
	}
}
