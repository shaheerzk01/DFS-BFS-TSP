package PROGRAMS;

import java.io.*;
import java.util.*;

public class EX_2 {
	
	private int node;
	private LinkedList<Integer> adj[];
	private Queue<Integer> queue;
	
	EX_2(int v){
		node = v;
		adj = new LinkedList[node];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<>();
		}
		queue = new LinkedList<Integer>();
	}
	
	void insertEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void BFS(int n) {
		boolean nodes[] = new boolean[node];
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
		EX_2 graph = new EX_2(6);
		
		
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 3);
		graph.insertEdge(0, 4);
		graph.insertEdge(4, 5);
		graph.insertEdge(3, 5);
		graph.insertEdge(1, 2);
		graph.insertEdge(1, 0);
		graph.insertEdge(2, 1);
		graph.insertEdge(4, 1);
		graph.insertEdge(3, 1);
		graph.insertEdge(5, 4);
		graph.insertEdge(5, 3);
		
		System.out.println("The Breadth First Traversal of the graph is as follows:");
		graph.BFS(0);
	}
	

}
