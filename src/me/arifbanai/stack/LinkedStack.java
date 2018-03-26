package me.arifbanai.stack;

import me.arifbanai.adt.Stack;
import me.arifbanai.linkedList.LinkedList;
import me.arifbanai.linkedList.ListNode;

public class LinkedStack<T> extends LinkedList<T> implements Stack<T> {
	
	@Override
	public void push(T data) {
		super.append(new ListNode<T>(data));
	}

	@Override
	public T pop() {
		ListNode<T> top = super.getLast();
		
		super.removeLast();
		
		return top.getData();
	}

	@Override
	public T checkTop() {
		return super.getLast().getData();
	}
	
}
