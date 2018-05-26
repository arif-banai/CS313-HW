package me.arifbanai.projectThree;

import java.util.StringTokenizer;

import me.arifbanai.projectThree.resources.HeapPriorityQueue;
import me.arifbanai.projectThree.resources.LinkedList;
import me.arifbanai.projectThree.resources.ListNode;

//Undirected weighted graph with adjacency list/matrix implementation
public class UndirectedGraph {

	private boolean[] pathFound;
	private int[] shortestPath;
	private int[] edgeTo;
	
	private final boolean usingAdjacencyList = false;
	
	private LinkedList<Integer>[] adjacencyList;
	private int[][] adjacencyMatrix;
	
	@SuppressWarnings("unchecked")
	public UndirectedGraph(int numVertices, int numEdges, String[] edges) {
		pathFound = new boolean[numVertices];
		shortestPath = new int[numVertices];
		edgeTo = new int[numVertices];
		
		if(usingAdjacencyList) {
			adjacencyList = new LinkedList[numVertices];
			initAdjList(edges);
		} else {
			adjacencyMatrix = new int[numVertices][numVertices ];
			initAdjMatrix(edges);
		}
		
		
	}
	
	public int[] findPaths(int sourceNode) {
		
		int[] paths = shortestPath;
		boolean[] visited = pathFound;
		int[] edgeToNode = edgeTo;
		
		HeapPriorityQueue<ListNode<Integer>> pq = new HeapPriorityQueue<>();
		
		pq.enqueue(new ListNode<Integer>(sourceNode));
		visited[sourceNode] = true;
		paths[sourceNode] = 0;
		
		while(!pq.isEmpty()) {
			
			ListNode<Integer> node = pq.dequeue();
			visited[node.getData()] = true;
			
			for(ListNode<Integer> temp : adjacencyList[node.getData()]) {
				edgeToNode[temp.getData()] = node.getData();
				pq.enqueue(temp);
				
			}
			
			
		}
	}
	
	
	private void initAdjList(String[] edges) {
		for(int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
		
		for(String x : edges) {
			StringTokenizer st = new StringTokenizer(x);
			
			int index = Integer.parseInt(st.nextToken());
			int nodeNumber = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjacencyList[index].prepend(nodeNumber, weight); 
		}
	}
	
	private void initAdjMatrix(String[] edges) {
		for(String x : edges) {
			StringTokenizer st = new StringTokenizer(x);
			
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjacencyMatrix[row][col] = weight;
		}
	}
}
