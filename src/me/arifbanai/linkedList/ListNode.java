package me.arifbanai.linkedList;
public class ListNode<T> implements Comparable<T> {
	
	protected T data;
	protected ListNode<T> next;
	protected ListNode<T> prev;
	
	public ListNode() {
		data = null;
		next = null;
		prev = null;
	}
	
	public ListNode(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public ListNode(T data, ListNode<T> next) {
		this.data = data;
		this.next = next;
		this.prev = null;
	}
	
	public ListNode(T data, ListNode<T> next, ListNode<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public T getData() {
		return data;
	}
	
	public ListNode<T> getNext() {
		return next;
	}
	
	public ListNode<T> getPrev() {
		return prev;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ListNode<?>) { 
			if(this.data.equals(o)) {
				return true;
			}
		}
		
		return false;
	}

	
	//Returns -2 if the objects can't be compared
	@Override
	public int compareTo(Object o) {
		if(o instanceof Integer && data instanceof Integer) {
			Integer target = (Integer) o;
			
			return -1 * target.compareTo((Integer) data);
		} 
		
		if(o instanceof String && data instanceof String) {
			String target = (String) o;
			return -1 * target.compareTo((String) data);
		}
		
		if(o instanceof Character && data instanceof Character) {
			Character target = (Character) o;
			return -1 * target.compareTo((Character) data);
		}
		//TODO continue comparisons
		
		return -2;
	}
}
