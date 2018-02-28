package me.arifbanai.linkedList;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

	protected ListNode<T> first;
	protected ListNode<T> last;
	protected int length;

	//LinkedList with dummy head node
	public LinkedList() {
		first = new ListNode<T>();
		last = first;
		length = 0;
	}

	//Add a node to the end of the list
	public void append(ListNode<T> node) {
		last.next = node;
		
		if(length != 0) {
			node.prev = last;
		}
		
		last = node;
		++length;
	}

	//Add the node to the front of the list
	public void prepend(ListNode<T> node) {
		node.next = first.next;
		first.next = node;
		++length;
	}

	//Insert a node at some position in the list
	public void insert(ListNode<T> node, int index) {
		if (index < 0 || index > length - 1) {
			throw new IllegalArgumentException("Out of bounds!");
		}
		
		if(index == 0) {
			prepend(node);
		} else if(index == length - 1) {
			append(node);
		} else {
			ListNode<T> current = get(index);
			
			//Next node for <node> is <current>
			//Prev node for <node> is the prev node for <current>
			node.next = current;
			node.prev = current.prev;
			
			//The node behind <current> will point to <node>
			//<current> will point previous to <node>
			current.prev.next = node;
			current.prev = node;
			++length;
		}
	}
	
	public ListNode<T> get(int index) {
		if(index < 0 || index > length - 1) {
			throw new IllegalArgumentException("Out of bounds!");
		}
		
		if(index == 1) {
			return getFirst(); 
		}
		
		if(index == length - 1) {
			return getLast();
		}
		
		ListNode<T> node = first.next;
		
		for(int i = 0;i < index;i++) {
			node = node.next;
		}
		
		return node;
	}

	
	public ListNode<T> getFirst() {
		return first.next;
	}

	
	public ListNode<T> getLast() {
		return last;
	}
	
	
	public void remove(int index) {
		if(index < 0 || index > length -1) {
			throw new IllegalArgumentException("Out of bounds!");
		}
		
		if(index == 1) {
			removeFirst(); 
		} else if(index == length - 1) {
			removeLast();
			return;
		} else {
			ListNode<T> current = get(index);
			
			current.prev.next = current.next;
			current.next.prev = current.prev;
			--length;
		}
	}

	
	public void removeFirst() {
		if(length == 0) {
			throw new IllegalArgumentException("Out of bounds!");
		}
		
		first.next = first.next.next;
		--length;
	}

	
	public void removeLast() {
		if(length == 0) {
			throw new IllegalArgumentException("Out of bounds!");
		}
		
		last = last.prev;
		last.next = null;
		--length;
	}

	//Returns null if node with given data does not exist
	public ListNode<T> getNode(T data) {
		for(ListNode<T> temp = first.next; temp != null; temp = temp.next) {
			if(temp.data.equals(data)) {
				return temp;
			}
		}
		
		return null;
	}

	
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int size() {
		return length;
	}

	
	public boolean isEmpty() {
		if(length == 0) 
			return true;
		
		return false;
	}

}
