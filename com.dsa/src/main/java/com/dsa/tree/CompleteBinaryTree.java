package com.dsa.tree;

// Checking if a binary tree is a complete binary tree in Java
// https://www.scaler.com/topics/complete-binary-tree/
// https://www.programiz.com/dsa/complete-binary-tree#:~:text=A%20complete%20binary%20tree%20is,is%20filled%20from%20the%20left.&text=All%20the%20leaf%20elements%20must,be%20a%20full%20binary%20tree.
// https://www.geeksforgeeks.org/complete-binary-tree/
// https://www.interviewcake.com/concept/java/complete-binary-tree

// Definition : A complete binary tree is a binary tree in which all the levels are completely filled except possibly the lowest one, which is filled from the left.

// https://www.youtube.com/watch?v=_Hehd1KSq7Y
// https://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/?ref=rp

// Code not understood this

class CompleteBinaryTree {

	private static class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int item) {
			this.data = item;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	// Count the number of nodes
	int countNumNodes(Node root) {
		if (root == null) {
			return (0);
		}
		return (1 + countNumNodes(root.left) + countNumNodes(root.right));
	}

	// Check for complete binary tree
	boolean checkComplete(Node root, int index, int numberNodes) {

		// Check if the tree is empty
		if (root == null) {
			return true;
		}

		if (index >= numberNodes) {
			return false;
		}

		return (checkComplete(root.left, 2 * index + 1, numberNodes)
				&& checkComplete(root.right, 2 * index + 2, numberNodes));
	}

	public static void main(String args[]) {
		CompleteBinaryTree tree = new CompleteBinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(6);

		int nodeCount = tree.countNumNodes(tree.root);
		int index = 0;

		if (tree.checkComplete(tree.root, index, nodeCount)) {
			System.out.println("The tree is a complete binary tree");
		} else {
			System.out.println("The tree is not a complete binary tree");
		}
	}
}
