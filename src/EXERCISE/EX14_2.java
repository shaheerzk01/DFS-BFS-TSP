package EXERCISE;

import java.io.*;
import java.util.*;

public class EX14_2 {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	EX14_2(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void DFSUtil(int vertex, boolean nodes[]) {
		nodes[vertex] = true;
		System.out.println(vertex + " ");
		int a = 0;
		
		for(int i=0; i< adj[vertex].size(); i++) {
			a = adj[vertex].get(i);
			if(!nodes[a]) {
				DFSUtil(a, nodes);
			}
		}
	}
	
	void DFS(int v) {
		boolean already[] = new boolean[V];
		DFSUtil(v, already);
	}
	
	public static void main(String args[]) {
		EX14_2 graph = new EX14_2(13);
		
		long start = System.currentTimeMillis();
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 7);
		graph.addEdge(1, 8);
		graph.addEdge(2, 3);
		graph.addEdge(2, 6);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(8, 9);
		graph.addEdge(8, 12);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		
		System.out.println("The Breadth First Traversal of the graph is as follows:");
		graph.DFS(1);
		long end = System.currentTimeMillis();
		long execution = end - start;
	    System.out.println("Execution time: " + execution + " miliseconds ");
	}


}
