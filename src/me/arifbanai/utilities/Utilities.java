package me.arifbanai.utilities;

import java.util.Random;

public class Utilities {
	
	private Utilities() {
		//Prevent instantiation of class by keeping 
		//default constructor private
	}
	
	private static Random generator = new Random();
	
	private static long timer = 0;
	
	public static int[] generateRandom(int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("n must be larger than 0");
		}
		
		int[] result = new int[n];
		
		for(int i = 0; i < n;i++) {
			result[i] = generator.nextInt();
		}
		
		return result;
	}
	
	public static int[] generateRandom(int n, int min, int max) {
		if(n <= 0) {
			throw new IllegalArgumentException("n must be larger than 0");
		}
		
		if(min > max) {
			throw new IllegalArgumentException("min must be less than or equal to max");
		}
		
		int[] result = new int[n];
		int range = (max - min) + 1;
		
		for(int i = 0;i < n;i++) {
			result[i] = generator.nextInt(range) + min;
		}
		
		return result;
	}
	
	public static int[][] generateRandom2D(int n, int min, int max, int minLength, int maxLength) {
		int[][] result = new int[n][];
		
		if(n <= 0) {
			throw new IllegalArgumentException("n must be greater than 0");
		}
		
		int rangeLength = (maxLength - minLength) + 1;
		
		for(int i = 0; i < n;i++) {
			int[] temp = new int[generator.nextInt(rangeLength) + minLength];
			temp = generateRandom(temp.length, min, max);
			
			result[i] = temp;
		}
		
		return result;
	}
	
	public static void startTimer() {
		timer = System.currentTimeMillis();
	}
	
	public static long elapsedTime() {
		return System.currentTimeMillis() - timer;
	}
	
	public static void main(String[] args) {
		int[][] randomArray2D = generateRandom2D(10, -10, 10, 3, 10);
		
		for(int i = 0; i < randomArray2D.length;i++) {
			for(int j = 0; j < randomArray2D[i].length;j++) {
				System.out.print(randomArray2D[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
