package me.arifbanai.projectThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		if(0 < args.length) {
			
			//String inputFileName = args[0];
			//String outputFileName = args[1];
			
			String inputFileName = "inputFile.txt";
			String outputFileName = "output.txt";
			
			File inputFile = new File(inputFileName);
			Scanner scanner = new Scanner(inputFile);
			
			int numVertices = scanner.nextInt();
			int numEdges = scanner.nextInt();
			
			String[] edges = new String[numEdges];
			for(int i = 0; scanner.hasNextLine(); i++) {
				edges[i] = scanner.nextLine();
			}
			
			UndirectedGraph graph = new UndirectedGraph(numVertices, numEdges, edges);
		}
		
		
		

	}

}
