package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

// Refer
// https://www.youtube.com/watch?v=-X6ji6sjxD4&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=163
// https://www.youtube.com/watch?v=grewOnmAd0k&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=164	

// https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
// https://favtutor.com/blogs/breadth-first-search-java
// https://www.programiz.com/dsa/graph-bfs

public class BFSAlgorithm {
	private LinkedList<Integer>[] adj;
	private int V; // number of vertices
	private int E; // number of edges

	public BFSAlgorithm(int nodes) {
		this.V = nodes;
		this.E = 0;
		this.adj = new LinkedList[nodes];
		for(int v = 0; v < V; v++) {
			adj[v] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
		E++;
	}

	public void bfs(int s) {
		boolean[] visited = new boolean[V];

		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);

		while (!q.isEmpty()) {
			int u = q.poll();  // poll means remove element from queue
			System.out.print(u + " ");

			for (int v : adj[u]) {
				if (!visited[v]) {
					visited[v] = true;
					q.offer(v);  // offer means add element into queue
				} 
			}
		}
	}	

	public static void main(String[] args) {
		BFSAlgorithm g = new BFSAlgorithm(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(2, 4);				
		g.bfs(0);
	}
}
