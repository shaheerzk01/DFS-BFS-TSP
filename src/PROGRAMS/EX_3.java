package PROGRAMS;

import java.io.*;
import java.util.*;

public class EX_3 {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	EX_3(int v){
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
		EX_3 graph = new EX_3(6);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(4, 5);
		graph.addEdge(3, 5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 0);
		graph.addEdge(2, 1);
		graph.addEdge(4, 1);
		graph.addEdge(3, 1);
		graph.addEdge(5, 4);
		graph.addEdge(5, 3);
		
		System.out.println("Following is Depth First Traversal: ");
		graph.DFS(0);
	}

}
