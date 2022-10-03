package com.dsa.graph;

// Refer

// https://www.youtube.com/watch?v=WxM-EENBY-w&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=165
// https://www.youtube.com/watch?v=Wzk6BBEBlYE&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=166
// https://www.youtube.com/watch?v=MmIeokeCdjY&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=167

// https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
// https://favtutor.com/blogs/depth-first-search-java
// https://www.programiz.com/dsa/graph-dfs

import java.util.*;

class DFSAlgorithm {
	private LinkedList<Integer>[] adj;
	private int vertex; // number of vertices
	private int edge; // number of edges

	public DFSAlgorithm(int nodes) {
		this.vertex = nodes;
		this.edge = 0;
		this.adj = new LinkedList[nodes];
		for (int v = 0; v < vertex; v++) {
			adj[v] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
		edge++;
	}

	public void dfs(int s) {
		boolean[] visited = new boolean[vertex];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(s);

		while (!stack.isEmpty()) {
			int u = stack.pop();
			if (!visited[u]) {
				visited[u] = true;
				System.out.print(u + " ");

				for (int v : adj[u]) {
					if (!visited[v]) {
						stack.push(v);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		DFSAlgorithm g = new DFSAlgorithm(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(2, 4);
		g.dfs(0);
	}
}
