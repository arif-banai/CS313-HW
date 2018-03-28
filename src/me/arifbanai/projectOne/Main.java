package me.arifbanai.projectOne;

import java.util.Random;

import me.arifbanai.projectOne.resources.PriorityQueue;
import me.arifbanai.projectOne.resources.Task;

public class Main {
	
	public static long timer = 0;
	
	public static void main(String[] args) {
		ArrayPriorityQueue<Task> arrayPQ = new ArrayPriorityQueue<>();
		HeapPriorityQueue<Task> heapPQ = new HeapPriorityQueue<>();
		LinkedListPriorityQueue<Task> listPQ = new LinkedListPriorityQueue<>();
		
		int n = 1000000;
		
		double avgTime = 0;
		long[] times = new long[10];
		
		for(int i = 0; i < 10; i++) {
			times[i] = benchmarkEnqueue(arrayPQ, n);
			avgTime += times[i];
		}
		
		System.out.println("Average time:\t" + (avgTime/10.0d));
	}
	
	public static long benchmarkEnqueue(PriorityQueue<Task> pq, int n) {
		Task[] testData = generateRandomTasks(n);
		
		startTimer();
		
		
		for(Task x : testData) {
			pq.enqueue(x);
		}

		
		return elapsedTime();
	}
	
	public static long benchmarkDequeue(PriorityQueue<Task> pq, int n) {
		Task[] testData = generateRandomTasks(n);
		
		for(Task x : testData) {
			pq.enqueue(x);
		}
		
		startTimer();
		
		for(int i = 0; i < pq.size(); i++) {
			pq.dequeue();
		}
		
		return elapsedTime();
	}
	
	public static long benchmarkEnqueueDequeue(PriorityQueue<Task> pq, int n) {
		Task[] testData = generateRandomTasks(n);
		
		startTimer();
		
		for(Task x : testData) {
			if(coinFlip()) {
				pq.enqueue(x);
			} else {
				if(!pq.isEmpty()) {
					pq.dequeue();
				}
			}
		}
		
		return elapsedTime();
	}
	
	public static Task[] generateRandomTasks(int n) {
		Random generator = new Random();
		
		Task[] tasks = new Task[n];
		
		for(int i = 0; i < n; i++) {
			tasks[i] = new Task();
			tasks[i].id = generator.nextInt();
			tasks[i].priority = generator.nextInt();
		}
		
		return tasks;
	}
	
	public static void startTimer() {
		timer = System.currentTimeMillis();
	}
	
	public static long elapsedTime() {
		return System.currentTimeMillis() - timer;
	}
	
	public static boolean coinFlip() {
		Random r = new Random();
		
		int number = r.nextInt();
		
		return number % 2 == 0;
	}

}
