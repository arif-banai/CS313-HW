package me.arifbanai.dataStructure;

//Max-BinaryHeap
public class Heap<T extends Comparable<T>> {

	private static final int DEFAULT_CAPACITY = 20;
	
	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Heap() {
		array = (T[]) new Comparable[DEFAULT_CAPACITY + 1];
		size = 0;
	}
	
	public int getLeftChildIdx(int current) {
		return current * 2;
	}

	public int getRightChildIdx(int current) {
		return (current * 2) + 1;
	}

	public int getParentIdx(int current) {
		return current / 2;
	}

	public void decreaseSize() {
		size--;
	}

	public void increaseSize() {
		size++;
	}

	public int size() {
		return size;
	}

	public void insert(T item) {
		if(size == array.length - 1)
			grow();

		size++;
		array[size] = item;
		bubbleUp(size);
	}
	
	public T removeRoot() {
		if(size == 0) {
			throw new IllegalArgumentException("There is no root to remove!");
		}
		
		T target = array[1];
		
		swap(1, size);
		array[size] = null;
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
		if(idx == 1) {
			return;
		}
		
		int parentIdx = getParentIdx(idx);

		if (array[idx].compareTo(array[parentIdx]) <= -1) {
			swap(idx, parentIdx);
			bubbleUp(parentIdx);
		}
	}

	public void bubbleDown(int idx) {
		if(size <= 1 || idx == size) {
			return;
		}
		
		int leftChildIdx = getLeftChildIdx(idx);
		int rightChildIdx = getRightChildIdx(idx);
		
		int higherPriorityIdx = Integer.MIN_VALUE;
		
		if(leftChildIdx <= size && rightChildIdx <= size) {
			if(array[leftChildIdx].compareTo(array[rightChildIdx]) >= 1) {
				higherPriorityIdx = rightChildIdx;
			} else {
				higherPriorityIdx = leftChildIdx;
			}
		} else if(leftChildIdx <= size) {
			higherPriorityIdx = leftChildIdx;
		} else if(rightChildIdx <= size) {
			higherPriorityIdx = rightChildIdx;
		} else {
			return;
		}
		
		swap(idx, higherPriorityIdx);
		bubbleDown(higherPriorityIdx);
	}

	@SuppressWarnings("unchecked")
	protected void grow() {
		T[] temp = (T[]) new Object[array.length * 2];
		System.arraycopy(array, 0, temp, 0, size);
		array = temp;
	}
}
