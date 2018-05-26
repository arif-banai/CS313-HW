package me.arifbanai.projectTwo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

	public static long timer;

	public static void main(String[] args) {
		int numNodes[] = {100, 200, 400, 800, 1600,
						  3200, 6400, 12800, 25600, 51200};
		int numTrials = 10;
		int rowsOfData = 10;
		
		long[] timeForLinkedMapInsertion = new long[numTrials];
		long[] timeForLinkedMapRemoval = new long[numTrials];
		long[] timeForHashMapInsertion = new long[numTrials];
		long[] timeForHashMapRemoval = new long[numTrials];
		long[] timeForBSTMapInsertion = new long[numTrials];
		long[] timeForBSTMapRemoval = new long[numTrials];
		
		long avgLinkedMapInsertion = 0;
		long avgLinkedMapRemoval = 0;
		long avgHashMapInsertion = 0;
		long avgHashMapRemoval = 0;
		long avgBSTMapInsertion = 0;
		long avgBSTMapRemoval = 0;
		
		long[] avgsLinkedMapInsert = new long[rowsOfData];
		long[] avgsLinkedMapRemove = new long[rowsOfData];
		long[] avgsHashMapInsert = new long[rowsOfData];
		long[] avgsHashMapRemove = new long[rowsOfData];
		long[] avgsBSTMapInsert = new long[rowsOfData];
		long[] avgsBSTMapRemove = new long[rowsOfData];
		
		for(int test = 0; test < rowsOfData; test++) {
			for(int i = 0; i < numTrials; i++) {
				timeForLinkedMapInsertion[i] =	testLinkedMapInsertion(numNodes[test]);
				
				timeForLinkedMapRemoval[i] = 	testLinkedMapRemoval(numNodes[test]);
				
				timeForHashMapInsertion[i] = 	testHashMapInsertion(numNodes[test]);
				
				timeForHashMapRemoval[i] = 		testHashMapRemoval(numNodes[test]);
				
				timeForBSTMapInsertion[i] = 	testBSTMapInsertion(numNodes[test]);
				
				timeForBSTMapRemoval[i] = 		testBSTMapRemoval(numNodes[test]);
				
			}
			
			for(int i = 0; i < numTrials; i++) {
				avgLinkedMapInsertion += 	timeForLinkedMapInsertion[i];
				avgLinkedMapRemoval += 		timeForLinkedMapRemoval[i];
				avgHashMapInsertion += 		timeForHashMapInsertion[i];
				avgHashMapRemoval += 		timeForHashMapRemoval[i];
				avgBSTMapInsertion += 		timeForBSTMapInsertion[i];
				avgBSTMapRemoval += 		timeForBSTMapRemoval[i];
			}
			
			avgLinkedMapInsertion /= numTrials;
			avgLinkedMapRemoval /= numTrials;
			avgHashMapInsertion /= numTrials;
			avgHashMapRemoval /= numTrials;
			avgBSTMapInsertion /= numTrials;
			avgBSTMapRemoval /= numTrials;
			
			avgsLinkedMapInsert[test] = avgLinkedMapInsertion;
			avgsLinkedMapRemove[test] = avgLinkedMapRemoval;
			avgsHashMapInsert[test] = avgHashMapInsertion;
			avgsHashMapRemove[test] = avgHashMapRemoval;
			avgsBSTMapInsert[test] = avgBSTMapInsertion;
			avgsBSTMapRemove[test] = avgBSTMapRemoval;
			
			avgLinkedMapInsertion = 0;
			avgLinkedMapRemoval = 0;
			avgHashMapInsertion = 0;
			avgHashMapRemoval = 0;
			avgBSTMapInsertion = 0;
			avgBSTMapRemoval = 0;
			
			System.out.println(test);
		}
		
		
		try {
			writeToCSV(numNodes, avgsLinkedMapInsert, "linkedMapInsertion");
			System.out.println("1");
			writeToCSV(numNodes, avgsLinkedMapRemove, "linkedMapRemoval");
			System.out.println("2");
			writeToCSV(numNodes, avgsHashMapInsert, "hashMapInsertion");
			System.out.println("3");
			writeToCSV(numNodes, avgsHashMapRemove, "hashMapRemoval");
			System.out.println("4");
			writeToCSV(numNodes, avgsBSTMapInsert, "BSTMapInsertion");
			System.out.println("5");
			writeToCSV(numNodes, avgsBSTMapRemove, "BSTMapRemoval");
			System.out.println("6");
		} catch (IOException e) {
			System.err.println("Could not find file!");
			e.printStackTrace();
		}
		
		
	}

	public static long testLinkedMapInsertion(int numNodes) {
		LinkedMap<String, Integer> linkedMap = new LinkedMap<>();

		Random r = new Random();

		String[] strings = new String[numNodes];
		Integer[] ints = new Integer[numNodes];

		for (int i = 0; i < numNodes; i++) {
			strings[i] = Math.abs(r.nextLong()) + "";
			ints[i] = r.nextInt();
		}

		// Insert (numNodes/2) nodes first, then time how long it takes to insert the
		// rest
		for (int i = 0; i < numNodes / 2; i++) {
			linkedMap.put(strings[i], ints[i]);
		}

		startTimer();
		for (int i = numNodes / 2; i < numNodes; i++) {
			linkedMap.put(strings[i], ints[i]);
		}

		return elapsedTime();

	}
	
	public static long testLinkedMapRemoval(int numNodes) {
		LinkedMap<String, Integer> linkedMap = new LinkedMap<>();

		Random r = new Random();

		String[] strings = new String[numNodes];
		Integer[] ints = new Integer[numNodes];

		for (int i = 0; i < numNodes; i++) {
			strings[i] = Math.abs(r.nextLong()) + "";
			ints[i] = r.nextInt();
		}

		// Insert (numNodes) nodes
		for (int i = 0; i < numNodes; i++) {
			linkedMap.put(strings[i], ints[i]);
		}
		
		// Time the removal of (numNodes/2) nodes
		startTimer();
		for(int i = 0; i < numNodes/2; i++) {
			linkedMap.remove(strings[i]);
		}

		return elapsedTime();

	}

	public static long testHashMapInsertion(int numNodes) {
		HashMap<String, Integer> hashMap = new HashMap<>();

		Random r = new Random();

		String[] strings = new String[numNodes];
		Integer[] ints = new Integer[numNodes];

		for (int i = 0; i < numNodes; i++) {
			strings[i] = Math.abs(r.nextLong()) + "";
			ints[i] = r.nextInt();
		}

		// Insert (numNodes/2) nodes first, then time how long it takes to insert the rest
		for (int i = 0; i < numNodes / 2; i++) {
			hashMap.put(strings[i], ints[i]);
		}

		startTimer();
		for (int i = numNodes / 2; i < numNodes; i++) {
			hashMap.put(strings[i], ints[i]);
		}

		return elapsedTime();
	}
	
	public static long testHashMapRemoval(int numNodes) {
		HashMap<String, Integer> hashMap = new HashMap<>();

		Random r = new Random();

		String[] strings = new String[numNodes];
		Integer[] ints = new Integer[numNodes];

		for (int i = 0; i < numNodes; i++) {
			strings[i] = Math.abs(r.nextLong()) + "";
			ints[i] = r.nextInt();
		}

		// Insert (numNodes) nodes
		for (int i = 0; i < numNodes; i++) {
			hashMap.put(strings[i], ints[i]);
		}
		
		// Time the removal of (numNodes/2) nodes
		startTimer();
		for(int i = 0; i < numNodes/2; i++) {
			hashMap.remove(strings[i]);
		}

		return elapsedTime();
	}
	
	public static long testBSTMapInsertion(int numNodes) {
		BSTMap<String, Integer> bstMap = new BSTMap<>();
		
		Random r = new Random();

		String[] strings = new String[numNodes];
		Integer[] ints = new Integer[numNodes];

		for (int i = 0; i < numNodes; i++) {
			strings[i] = Math.abs(r.nextLong()) + "";
			ints[i] = r.nextInt();
		}

		// Insert (numNodes/2) nodes first, then time how long it takes to insert the rest
		for (int i = 0; i < numNodes / 2; i++) {
			bstMap.put(strings[i], ints[i]);
		}

		startTimer();
		for (int i = numNodes / 2; i < numNodes; i++) {
			bstMap.put(strings[i], ints[i]);
		}

		return elapsedTime();
	}
	
	public static long testBSTMapRemoval(int numNodes) {
		BSTMap<String, Integer> bstMap = new BSTMap<>();

		Random r = new Random();

		String[] strings = new String[numNodes];
		Integer[] ints = new Integer[numNodes];

		for (int i = 0; i < numNodes; i++) {
			strings[i] = Math.abs(r.nextLong()) + "";
			ints[i] = r.nextInt();
		}

		// Insert (numNodes) nodes
		for (int i = 0; i < numNodes; i++) {
			bstMap.put(strings[i], ints[i]);
		}
		
		// Time the removal of (numNodes/2) nodes
		startTimer();
		for(int i = 0; i < numNodes/2; i++) {
			bstMap.remove(strings[i]);
		}

		return elapsedTime();
	}
	
	public static String[] generateStrings(int number) {
		Random r = new Random();
		
		String[] strings = new String[number];
		
		for (int i = 0; i < number; i++) {
			strings[i] = r.nextLong() + "";
		}
		
		return strings;
	}
	
	public static Integer[] generateIntegers(int number) {
		Random r = new Random();
		
		Integer[] ints = new Integer[number];
		
		for (int i = 0; i < number; i++) {
			ints[i] = r.nextInt();
		}
		
		return ints;
	}
	
	public static void writeToCSV(int[] dataSizes, long[] avgTimes, String fileName) throws IOException {
		BufferedWriter br = new BufferedWriter(
				new FileWriter("/Users/Smeef/Desktop/" + fileName + ".csv"));
		
		for(int i = 0; i < dataSizes.length; i++) {
			StringBuilder builder = new StringBuilder();
			builder.append(dataSizes[i]);
			builder.append(",");
			builder.append(avgTimes[i]);
			builder.append("\n");
			br.write(builder.toString());
			br.flush();
		}
		
		br.close();
	}

	public static void startTimer() {
		timer = System.nanoTime();
	}

	public static long elapsedTime() {
		return (System.nanoTime() - timer);
	}

}
