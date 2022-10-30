package com.dsa.tree;

// Refer
// https://youtu.be/AU1jR63cVp0
// https://youtu.be/bBIhFbvavLk
// https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
// https://www.programiz.com/dsa/avl-tree
// https://www.happycoders.eu/algorithms/avl-tree-java/
// https://www.scaler.com/topics/data-structures/avl-tree/

// Deletion
// https://www.geeksforgeeks.org/avl-tree-set-2-deletion/
// https://youtu.be/4zQV3j2X9mU
// https://youtu.be/vEZ3-bdPdUQ
// https://youtu.be/YWqla0UX-38

// Code not understood this

class AVLTree {
	private static class Node {
		private int data, height;
		private Node leftChild, rightChild;

		Node(int data) {
			this.data = data;
			height = 0;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	private Node node;

	public int getHeight(Node root) {
		if (root == null) {
			return -1;
		} else {
			return root.height;
		}
	}

	public int getBalanceFactor(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (getHeight(root.leftChild) - getHeight(root.rightChild));
		}
	}

	// Clockwise Rotation
	public Node LL_rotation(Node root) {
		Node child = root.leftChild;
		root.leftChild = child.rightChild;
		child.rightChild = root;
		root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
		child.height = Math.max(getHeight(child.leftChild), getHeight(child.rightChild)) + 1;
		return child;
	}

	// Anti-Clockwise Rotation
	public Node RR_rotation(Node root) {
		Node child = root.rightChild;
		root.rightChild = child.leftChild;
		child.leftChild = root;
		root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
		child.height = Math.max(getHeight(child.leftChild), getHeight(child.rightChild)) + 1;
		return child;
	}

	// Pre-order traversal of the tree
	public void pre_order(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			pre_order(root.leftChild);
			pre_order(root.rightChild);
		}
	}

	// AVL Insertion
	public Node insert(Node root, int val) {
		// BST Insertion Logic
		if (root == null)
			return (new Node(val));
		if (val < root.data)
			root.leftChild = insert(root.leftChild, val);
		else if (val > root.data)
			root.rightChild = insert(root.rightChild, val);
		else
			return node;

		// Balance Factor check
		root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
		int balanceFactor = getBalanceFactor(root);

		// Checking if the node insertion results in Left heavy or Right heavy nodes.
		if (balanceFactor > 1) {
			// LL Rotation Case
			if (getBalanceFactor(root.leftChild) == 1) {
				root = LL_rotation(root);
			}
			// LR Rotation Case
			else {
				root.leftChild = RR_rotation(root.leftChild);
				root = LL_rotation(root);
			}
		} else if (balanceFactor < -1) {
			// RR Rotation Case
			if (getBalanceFactor(root.rightChild) == -1) {
				root = RR_rotation(root);
			}
			// RL Rotation Case
			else {
				root.rightChild = LL_rotation(root.rightChild);
				root = RR_rotation(root);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.node = tree.insert(tree.node, 10);
		tree.node = tree.insert(tree.node, 20);
		tree.node = tree.insert(tree.node, 30);
		System.out.println("Pre-order Traversal of the AVL Tree is : ");
		tree.pre_order(tree.node);
	}
}
