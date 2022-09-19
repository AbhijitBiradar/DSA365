package com.dsa.tree;

// Reference
// https://www.programiz.com/dsa/full-binary-tree

class FullBinaryTree {

	private static class Node {
		private int data;
		private Node leftChild;
		private Node rightChild;

		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	private Node root;

	public boolean isFullBinaryTree(Node node) {

		// Case 1: Checking tree emptiness
		if (node == null)
			return true;

		// Case 2: Checking the children for null
		if (node.leftChild == null && node.rightChild == null) {
			return true;
		}

		// Case 3:Checking the sub children
		if ((node.leftChild != null) && (node.rightChild != null)) {
			return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));
		}

		return false;
	}

	public static void main(String args[]) {
		FullBinaryTree fbTree = new FullBinaryTree();
		fbTree.root = new Node(1);
		fbTree.root.leftChild = new Node(2);
		fbTree.root.rightChild = new Node(3);
		fbTree.root.leftChild.leftChild = new Node(4);
		fbTree.root.leftChild.rightChild = new Node(5);
		fbTree.root.rightChild.leftChild = new Node(6);
		fbTree.root.rightChild.rightChild = new Node(7);

		if (fbTree.isFullBinaryTree(fbTree.root)) {
			System.out.print("The tree is a full binary tree");
		} else {
			System.out.print("The tree is not a full binary tree");
		}
	}
}
