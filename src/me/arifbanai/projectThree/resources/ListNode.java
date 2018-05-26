package me.arifbanai.projectThree.resources;

//Represents a Node in a graph, contains a weight field for use in adjacency list
public class ListNode<T extends Comparable<T>> implements Comparable<ListNode<T>>{

	protected T data;
	protected int weight = 0;
	protected ListNode<T> next;

	public ListNode() {
		data = null;
		next = null;
	}
	
	public ListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public ListNode(T data, int weight) {
		this.data = data;
		this.next = null;
		this.weight = weight;
	}

	public ListNode(T data, ListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ListNode<T> getNext() {
		return next;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ListNode<?>) {
			if (this.data.equals(o)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int compareTo(ListNode<T> o) {
		return this.data.compareTo(o.data);
	}

}
