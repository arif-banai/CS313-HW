package me.arifbanai.array;

import java.util.Iterator;

//Self-resizing array class provided by Adolfus Lapsys
public class Array<T> implements  Iterable<T> {
	private T[] data;
	private int size;

	private static final int DEFAULT_CAPACITY = 10;

	public Array() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		data = (T[]) new Object[capacity];
		size = 0;
	}

	public void insert(int index, T elem) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (size == data.length) {
			grow();
		}

		System.arraycopy(data, index, data, index + 1, size - index);
		data[index] = elem;
		++size;
	}

	public void prepend(T elem) {
		insert(0, elem);
	}

	public void append(T elem) {
		insert(size, elem);
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		return data[index];
	}

	public T getFirst() {
		return get(0);
	}

	public T getLast() {
		return get(size - 1);
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		System.arraycopy(data, index + 1, data, index, size - index);
		--size;
	}

	public void removeFirst() {
		remove(0);
	}

	public void removeLast() {
		remove(size - 1);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<T> iterator() {
		return new ArrayIterator<T>(this);
	}

	private class ArrayIterator<T> implements Iterator<T> {
		private int index;
		private Array<T> array;

		public ArrayIterator(Array<T> array) {
			this.array = array;
			index = 0;
		}

		public boolean hasNext() {
			return index < array.size();
		}

		public T next() {
			return array.get(index++);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		if (!isEmpty()) {
			sb.append(get(0).toString());
		}
		for (int i = 0; i < size; ++i) {
			sb.append(", " + get(i).toString());
		}
		return sb.append("}").toString();
	}

	@SuppressWarnings("unchecked")
	private void grow() {
		T[] temp = (T[]) new Object[data.length * 2];
		System.arraycopy(data, 0, temp, 0, size);
		data = temp;
	}
}
