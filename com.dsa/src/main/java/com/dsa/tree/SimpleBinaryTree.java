package com.dsa.tree;

// Reference
// https://www.programiz.com/dsa/binary-tree
// https://kalkicode.com/inorder-traversal-of-binary-tree-with-recursion-in-java
// https://kalkicode.com/preorder-traversal-of-binary-tree-using-recursion-in-java
// https://kalkicode.com/postorder-traversal-of-binary-tree-with-recursion-in-java

class SimpleBinaryTree {

	private static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	public SimpleBinaryTree(int data) {
		this.root = new Node(data);
	}

	public SimpleBinaryTree() {
		this.root = null;
	}

	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.data);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.data);
			traverseInOrder(node.right);
		}
	}

	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.data);
		}
	}

	public static void main(String[] args) {
		SimpleBinaryTree sbTree = new SimpleBinaryTree();

		sbTree.root = new Node(1);
		sbTree.root.left = new Node(2);
		sbTree.root.right = new Node(3);
		sbTree.root.left.left = new Node(4);

		System.out.println("Pre Order Traversal: ");
		sbTree.traversePreOrder(sbTree.root);

		System.out.println("In Order Traversal: ");
		sbTree.traverseInOrder(sbTree.root);

		System.out.println("Post Order Traversal: ");
		sbTree.traversePostOrder(sbTree.root);
	}
}
