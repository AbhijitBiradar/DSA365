package com.dsa.graph;

// REfer
// https://www.programiz.com/dsa/graph-bfs

import java.util.*;

public class BFSAlgorithm {
	private int V;
	private LinkedList<Integer> adj[];

// Create a graph
	BFSAlgorithm(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

// Add edges to the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

// BFS algorithm
	void BFS(int s) {

		boolean visited[] = new boolean[V];

		LinkedList<Integer> queue = new LinkedList();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String args[]) {
		BFSAlgorithm g = new BFSAlgorithm(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}
}
