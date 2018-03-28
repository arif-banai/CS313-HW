package me.arifbanai.projectOne;

import me.arifbanai.projectOne.resources.PriorityQueue;

//Max-BinaryHeap
public class HeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	//I am running into a NullPointerException is
	private static final int DEFAULT_CAPACITY = 10;
	
	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public HeapPriorityQueue() {
		array = (T[]) new Comparable[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public int getLeftChildIdx(int current) {
		return current * 2;
	}

	public int getRightChildIdx(int current) {
		return (current * 2) + 1;
	}

	public int getParentIdx(int current) {
		return current/2;
	}

	public void insert(T item) {
		if(size == array.length - 1)
			grow();

		size++;
		array[size] = item;
		bubbleUp(size);
	}
	
	public T getRoot() {
		if(size == 0) {
			return null;
		}
		
		return array[1];
	}
	
	public T removeRoot() {
		if(size == 0) {
			return null;
		}
		
		T target = array[1];
		
		swap(1, size);
		size--;
		bubbleDown(1);
		
		return target;
	}

	public void swap(int indexOne, int indexTwo) {
		T temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
	}

	public void bubbleUp(int idx) {
		int parentIdx = getParentIdx(idx);
		if(parentIdx < 1)
			return;

		if (array[idx].compareTo(array[parentIdx]) == 1) {
			swap(idx, parentIdx);
			bubbleUp(parentIdx);
		}
	}

	public void bubbleDown(int idx) {
		if(size <= 1 || idx > size) {
			return;
		}
		
		int leftChildIdx = getLeftChildIdx(idx);
		int rightChildIdx = getRightChildIdx(idx);
		
		if(leftChildIdx > array.length-1 || rightChildIdx > array.length-1) {
			return;
		}
		
		T leftNode = array[leftChildIdx];
		T rightNode = array[rightChildIdx];
		
		int higherPriorityIdx = idx;
		
		if(leftNode != null && rightNode != null) {
			if(array[leftChildIdx].compareTo(array[rightChildIdx]) == 1) {
				higherPriorityIdx = leftChildIdx;
			} else {
				higherPriorityIdx = rightChildIdx;
			}
		} else if(leftNode != null) {
			higherPriorityIdx = leftChildIdx;
		} else if(rightNode != null) {
			higherPriorityIdx = rightChildIdx;
		} else {
			return;
		}
		
		swap(idx, higherPriorityIdx);
		bubbleDown(higherPriorityIdx);
	}
	
	public void printArray() {
		for(int i = 1; i <= size; i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(T item) {
		insert(item);
	}

	@Override
	public T peek() {
		return getRoot();
	}

	@Override
	public T dequeue() {
		return removeRoot();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	protected void grow() {
		T[] temp = (T[]) new Comparable[array.length * 2];
		System.arraycopy(array, 0, temp, 0, array.length);
		array = temp;
	}
}
