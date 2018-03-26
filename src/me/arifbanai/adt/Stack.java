package me.arifbanai.adt;

public interface Stack<T> {
	
	public void push(T item);
	public T pop();
	
	public T checkTop();
	
	public int size();
	public boolean isEmpty();
}
