package me.arifbanai.projectThree.resources;

public interface PriorityQueue<T extends Comparable<T>> {
	// Insert an element into the queue.
	void enqueue(T item);

	// Return (but do not remove) the element of highest priority in the queue.
	T peek();

	// Remove and return the element of highest priority in the queue.
	T dequeue();

	// Return the number of elements in the queue.
	int size();

	// Return true if there are no elements in the queue; false otherwise.
	boolean isEmpty();

}
