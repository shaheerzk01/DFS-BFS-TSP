package EXERCISE;

import java.io.*;
import java.util.*;

import PROGRAMS.EX_1;

public class EX14_1 {
	
	private int V;
	private LinkedList<Integer> adj[];
	private Queue<Integer> queue;
	
	EX14_1(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<>();
		}
		queue = new LinkedList<Integer>();
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void BFS(int n) {
		boolean nodes[] = new boolean[V];
		int a = 0;
		
		nodes[n] = true;
		queue.add(n);
		
		while(queue.size() != 0) {
			
			n = queue.poll();
			System.out.println(n + " ");
			
			for(int i =0; i<adj[n].size(); i++) {
				a = adj[n].get(i);
				if(!nodes[a]) {
					nodes[a] = true;
					queue.add(a);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		EX14_1 graph = new EX14_1(13);
		
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
		graph.BFS(1);
		long end = System.currentTimeMillis();
		long execution = end - start;
	    System.out.println("Execution time: " + execution + " miliseconds ");
	}

}
