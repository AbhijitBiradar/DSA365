package com.dsa.tree;

// Reference
// https://www.programiz.com/dsa/perfect-binary-tree
// https://www.geeksforgeeks.org/check-weather-given-binary-tree-perfect-not/
// https://www.includehelp.com/data-structure-tutorial/perfect-binary-tree.aspx
// https://www.javatpoint.com/binary-tree

class PerfectBinaryTree {

	private static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
			this.right = null;
			this.left = null;
		}
	}

	private Node root;

	// Calculate the depth
	public int depth(Node node) {
		int d = 0;
		while (node != null) {
			d++;
			node = node.left;
		}
		return d;
	}

	
	public boolean isPerfect(Node root, int depth, int level) {

		// Check if the tree is empty
		if (root == null) {
			return true;
		}

		// If for children
		if (root.left == null && root.right == null) {
			return (depth == level + 1);
		}

		if (root.left == null || root.right == null) {
			return false;
		}

		return isPerfect(root.left, depth, level + 1) && isPerfect(root.right, depth, level + 1);
	}

	// Wrapper function
	public boolean isPerfect(Node root) {
		int depth = depth(root);
		return isPerfect(root, depth, 0);
	}

	public static void main(String args[]) {
		PerfectBinaryTree pbt = new PerfectBinaryTree();

		pbt.root = new Node(1);
		pbt.root.left = new Node(2);
		pbt.root.right = new Node(3);
		pbt.root.left.left = new Node(4);
		pbt.root.left.right = new Node(5);

		if (pbt.isPerfect(pbt.root) == true) {
			System.out.println("The tree is a perfect binary tree");
		} else {
			System.out.println("The tree is not a perfect binary tree");
		}
	}
}
