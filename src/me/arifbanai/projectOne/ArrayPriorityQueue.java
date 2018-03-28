package me.arifbanai.projectOne;

import java.util.Arrays;

import me.arifbanai.projectOne.resources.PriorityQueue;
import me.arifbanai.projectOne.resources.Task;
import me.arifbanai.utilities.Utilities;

public class ArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
	
	public static void main(String[] args) {
		ArrayPriorityQueue<Task> arrayPQ = new ArrayPriorityQueue<>();
		
		int n = 23;
		
		Task[] testData = new Task[n];
		
		int[] randomID = Utilities.generateRandom(n);
		int[] randomPriority = Utilities.generateRandom(n);
		
		for(int i = 0; i < n; i++) {
			testData[i] = new Task();
			testData[i].id = randomID[i];
			testData[i].priority = randomPriority[i];
			
			arrayPQ.insert(testData[i]);
		}
		
		System.out.println("ArrayPQ");
		arrayPQ.printArray();
	}
	

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

	public void insert(T item) {
		if (size == array.length) {
			grow();
		}
		
		array[size] = item;
		++size;
		sorted = false;
	}
	
	public T getMaxPriority() {
		if(size == 0) {
			return null;
		}
		
		if(!sorted) {
			Arrays.sort(array, 0, size);
			sorted = true;
		}

		return array[size];
	}

	public T removeMaxPriority() {
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
		// TODO Auto-generated method stub
		
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
