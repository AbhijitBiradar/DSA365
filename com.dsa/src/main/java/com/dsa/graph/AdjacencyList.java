package com.dsa.graph;

// Refer

// https://www.youtube.com/watch?v=Kd__dmFHoZo&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=160	
// https://www.youtube.com/watch?v=nt8uN6pQrnw&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=161
// https://www.youtube.com/watch?v=6rDKLqFLfh0&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=162
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/graph/AdjListGraph.java
// https://www.programiz.com/dsa/graph-adjacency-list

// Basic Reference
// Spanning Tree 
// https://www.youtube.com/watch?v=h6cUkkaKNHw

// Minimum Spanning Tree
// https://www.youtube.com/watch?v=vNhvBrc02G4
// https://www.youtube.com/watch?v=xsM8i0jVF1w
// https://www.youtube.com/watch?v=zy9Jh7cva6U

// Strongly connected components
// https://www.youtube.com/watch?v=NWl-LtrWU-o&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=168

import java.util.LinkedList;

class AdjacencyList {
	private LinkedList<Integer>[] adj;
	private int V; // number of vertices
	private int E; // number of edges

	public AdjacencyList(int nodes) {
		this.V = nodes;
		this.E = 0;
		this.adj = new LinkedList[nodes];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
		E++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			for (int w : adj[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AdjacencyList g = new AdjacencyList(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		System.out.println(g);
	}

}
