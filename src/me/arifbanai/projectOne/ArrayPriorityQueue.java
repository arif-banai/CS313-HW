package me.arifbanai.projectOne;

import java.util.Arrays;

import me.arifbanai.projectOne.resources.PriorityQueue;

public class ArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	private T[] array;
	private int size;
	private boolean sorted;

	private static final int DEFAULT_CAPACITY = 10;

	@SuppressWarnings("unchecked")
	public ArrayPriorityQueue() {
		array =  (T[]) new Comparable[DEFAULT_CAPACITY];
		size = 0;
		sorted = true;
	}

	private void insert(T item) {
		if (size == array.length) {
			grow();
		}
		
		array[size] = item;
		++size;
		sorted = false;
	}
	
	private T getMaxPriority() {
		if(size == 0) {
			return null;
		}
		
		if(!sorted) {
			Arrays.sort(array, 0, size);
			sorted = true;
		}

		return array[size];
	}

	private T removeMaxPriority() {
		if(size == 0) {
			return null;
		}
		
		if(!sorted) {
			Arrays.sort(array);
			sorted = true;
		}
		
		T target = array[size];
		array[size] = null;
		--size;
		
		return target;
	}
	
	public void printArray() {
		Arrays.sort(array, 0, size);
		
		for(int i = 0; i < size; i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	public void printReverseArray() {
		Arrays.sort(array, 0, size);
		
		for(int i = size - 1; i >= 0; i--) {
			System.out.print(array[i] + ", ");
		}
	}

	
	@Override
	public void enqueue(T item) {
		insert(item);
	}

	@Override
	public T peek() {
		return getMaxPriority();
	}

	@Override
	public T dequeue() {
		return removeMaxPriority();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	private void grow() {
		T[] temp = (T[]) new Comparable[array.length * 2];
		System.arraycopy(array, 0, temp, 0, size);
		array = temp;
	}
}
