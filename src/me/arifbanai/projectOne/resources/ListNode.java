package me.arifbanai.projectOne.resources;


public class ListNode<T extends Comparable<T>> {
	
	public T data;
	public ListNode<T> next;
	public ListNode<T> prev;
	
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
	
	public ListNode(T data, ListNode<T> left) {
		this.data = data;
		this.next = left;
		this.prev = null;
	}
	
	public ListNode(T data, ListNode<T> left, ListNode<T> right) {
		this.data = data;
		this.next = left;
		this.prev = right;
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
	
	public void setNext(ListNode<T> node) {
		this.next = node;
	}
	
	public void setPrev(ListNode<T> node) {
		this.prev = node;
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
	
}
