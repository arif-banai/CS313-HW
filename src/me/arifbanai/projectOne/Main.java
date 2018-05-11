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
		
		int n = 100000;
		
		double avgTime = 0;
		double[] times = new double[100];
		
		for(int i = 0; i < 10; i++) {
			times[i] = benchmarkEnqueueDequeue(listPQ, n);
			System.out.println("Time for test "  + i + ":\t" + times[i]);
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
		
		for(int i = 0; i < 1500; i++) {
			pq.enqueue(testData[i]);
		}
		
		
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
