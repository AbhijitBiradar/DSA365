package com.dsa.graph;

// Refer

// https://www.youtube.com/watch?v=9qFLiiNPDEI&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=157
// https://www.youtube.com/watch?v=zqXDwFhfPtI&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=158
// https://www.youtube.com/watch?v=X1LdtRW88c0&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=159
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/graph/AdjMatrixGraph.java
// https://www.programiz.com/dsa/graph-adjacency-matrix

// Basic Reference
// Spanning Tree 
// https://www.youtube.com/watch?v=h6cUkkaKNHw

// Minimum Spanning Tree
// https://www.youtube.com/watch?v=vNhvBrc02G4
// https://www.youtube.com/watch?v=xsM8i0jVF1w
// https://www.youtube.com/watch?v=zy9Jh7cva6U

// Strongly connected components
// https://www.youtube.com/watch?v=NWl-LtrWU-o&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=168

public class AdjacencyMatrix {
	private int V; // number of vertices in Graph
	private int E; // number of edges in Graph
	private int[][] adjMatrix;

	public AdjacencyMatrix(int nodes) {
		this.V = nodes;
		this.E = 0;
		this.adjMatrix = new int[nodes][nodes];
	}

	public void addEdge(int u, int v) {
		adjMatrix[u][v] = 1;
		adjMatrix[v][u] = 1; // because it is an undirected graph
		E++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			for (int w : adjMatrix[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AdjacencyMatrix g = new AdjacencyMatrix(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		System.out.println(g);
	}
}
