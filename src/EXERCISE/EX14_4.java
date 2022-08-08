package EXERCISE;

public class EX14_4 {
	
	// Function to find the minimum weight
			// Hamiltonian Cycle
			static int tsp(int[][] graph, boolean[] v, int currentPos,
					int n, int count, int cost, int ans) {
				// If last node is reached and it has a link 
				// to the starting node i.e the source then
				// keep the minimum value out of the total cost 
				// of traversal and "ans"
				// Finally return to check for more possible values
				
				if(count == n && graph[currentPos][0] > 0) {
					ans = Math.min(ans, cost + graph[currentPos][0]);
					return ans;
				}
				// BACKTRACKING STEP
				// Loop to traverse the adjacency list
				// of currPos node and increasing the count 
				// by 1 and cost by graph[currPos,i] value
				
				for(int i=0; i<n; i++) {
					if(v[i]==false && graph[currentPos][i]>0) {
						
						// Mark as visited
						v[i] = true;
						ans = tsp(graph, v, i,n, count + 1,cost + graph[currentPos][i], ans);
						
						// Mark ith node as unvisited 
						v[i] = false;
					}
				}
				return ans;
				  
			}
			
			public static void main(String args[]) {
				// n is the number of nodes i.e. V
				
				int n = 4;
				int[][] graph = {{0, 12, 10, 21, 13, 19, 12},
						         {12, 0, 8, 12, 11, 17, 17},
						         {10, 8, 0, 11, 3, 9, 9},
						         {23, 12, 11, 0, 11, 10, 18},
						         {13, 11, 3, 11, 0, 6, 7},
						         {19, 17, 9, 10, 6, 0, 9},
						         {12, 17, 9, 19, 7, 9, 0}};
				// Boolean array to check if a node 
				// has been visited or not
				boolean[] v = new boolean[n];
				// Mark 0th node as visited
				v[0] = true;
				int ans = Integer.MAX_VALUE;
				// Find the minimum weight Hamiltonian Cycle
				ans = tsp(graph,v,0,n,1,0,ans);
				// ans is the minimum weight Hamiltonian Cycle 
				System.out.println(ans);
			}


}
