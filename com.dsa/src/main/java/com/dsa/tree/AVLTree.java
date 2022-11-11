package com.dsa.tree;

// Refer

// https://www.geeksforgeeks.org/insertion-in-an-avl-tree/
// https://www.youtube.com/watch?v=bBIhFbvavLk

// https://prepinsta.com/java-program/deletion-in-avl-tree/
// https://www.ideserve.co.in/learn/avl-tree-deletion
// https://www.codesdope.com/course/data-structures-avl-trees/

// https://www.javatpoint.com/avl-tree-program-in-java
// https://www.youtube.com/playlist?list=PLPzfPcir5uPQxkHYuDIm899Z0eoCAFGMV
// https://www.javadevjournal.com/data-structure/avl-tree/
// https://www.youtube.com/playlist?list=PLPzfPcir5uPQxkHYuDIm899Z0eoCAFGMV

// Code not understood

public class AVLTree {

	private Node rootNode;

	public AVLTree() {
		this.rootNode = null;
	}

	private static class Node {
		private int val;
		private int height;
		private Node leftChild;
		private Node rightChild;

		public Node() {
			this.leftChild = null;
			this.rightChild = null;
			this.val = 0;
			this.height = 0;
		}

		public Node(int val) {
			this.leftChild = null;
			this.rightChild = null;
			this.val = val;
			this.height = 0;
		}
	}

	public void removeAll() {
		rootNode = null;
		System.out.println("\nTree Cleared successfully");
	}

	public boolean isEmpty() {
		if (rootNode == null) {
			return true;
		} else {
			return false;
		}
	}

	private int getHeight(Node node) {
		if (node == null) {
			return -1;
		} else {
			return node.height;
		}
	}

	private int getMaxHeight(int lefNodeHeight, int righNodeHeight) {
		if (lefNodeHeight > righNodeHeight) {
			return lefNodeHeight;
		} else {
			return righNodeHeight;
		}
	}

	public int getTotalNumberOfNodes() {
		return getTotalNumberOfNodes(rootNode);
	}

	private int getTotalNumberOfNodes(Node head) {
		if (head == null) {
			return 0;
		} else {
			int length = 1;
			length = length + getTotalNumberOfNodes(head.leftChild);
			length = length + getTotalNumberOfNodes(head.rightChild);
			return length;
		}
	}

	public boolean searchElement(int val) {
		return searchElement(rootNode, val);
	}

	private boolean searchElement(Node head, int searchVal) {
		boolean searchResult = false;
		while ((head != null) && !searchResult) {
			int headval = head.val;
			if (searchVal < headval)
				head = head.leftChild;
			else if (searchVal > headval)
				head = head.rightChild;
			else {
				searchResult = true;
				break;
			}
			searchResult = searchElement(head, searchVal);
		}
		return searchResult;
	}

	public void inorderTraversal() {
		inorderTraversal(rootNode);
		System.out.println();
	}

	private void inorderTraversal(Node head) {
		if (head != null) {
			inorderTraversal(head.leftChild);
			System.out.print(head.val + " ");
			inorderTraversal(head.rightChild);
		}
	}

	public void preorderTraversal() {
		preorderTraversal(rootNode);
		System.out.println();
	}

	private void preorderTraversal(Node head) {
		if (head != null) {
			System.out.print(head.val + " ");
			preorderTraversal(head.leftChild);
			preorderTraversal(head.rightChild);
		}
	}

	public void postorderTraversal() {
		postorderTraversal(rootNode);
		System.out.println();
	}

	private void postorderTraversal(Node head) {
		if (head != null) {
			postorderTraversal(head.leftChild);
			postorderTraversal(head.rightChild);
			System.out.print(head.val + " ");
		}
	}

	public boolean checkForAVLTree() {
		// verify the given tree is AVL Tree
		return false;
	}

	public int getBalanceFactor(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (getHeight(root.leftChild) - getHeight(root.rightChild));
		}
	}

	public Node leftRotation(Node root) {
		Node child = root.leftChild;
		root.leftChild = child.rightChild;
		child.rightChild = root;
		root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
		child.height = Math.max(getHeight(child.leftChild), getHeight(child.rightChild)) + 1;
		return child;
	}

	public Node rightRotation(Node root) {
		Node child = root.rightChild;
		root.rightChild = child.leftChild;
		child.leftChild = root;
		root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
		child.height = Math.max(getHeight(child.leftChild), getHeight(child.rightChild)) + 1;
		return child;
	}

	private Node leftRightRotation(Node node3) {
		node3.leftChild = rightRotation(node3.leftChild);
		return leftRotation(node3);
	}

	private Node rightLeftRotation(Node node1) {
		node1.rightChild = leftRotation(node1.rightChild);
		return rightRotation(node1);
	}

	public void insert(int val) {
		rootNode = insert(rootNode, val);
	}

	// Refer
	// https://prepinsta.com/java-program/deletion-in-avl-tree/
	public Node insert(Node root, int val) {

		// Step 1: Perform Node insertion into tree
		// If root is null
		if (root == null) {
			return (new Node(val));
		}

		if (val < root.val) {
			// Given value is less than root's value then insert into left part of tree
			root.leftChild = insert(root.leftChild, val);
		} else if (val > root.val) {
			// Given value is greater than root's value then insert into right part of tree
			root.rightChild = insert(root.rightChild, val);
		} else {
			// Duplicate is not allowed
			return rootNode;
		}

		// Step 2 : Update the height of root node
		root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;

		// Step 3 : Get the Balance Factor of root node to check whether root node
		// become unbalanced
		int balanceFactor = getBalanceFactor(root);

		// Step 4 : If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balanceFactor > 1 && val < root.leftChild.val)
			return rightRotation(root);

		// Right Right Case
		if (balanceFactor < -1 && val > root.rightChild.val)
			return leftRotation(root);

		// Left Right Case
		if (balanceFactor > 1 && val > root.leftChild.val) {
			root.leftChild = leftRotation(root.leftChild);
			return rightRotation(root);
		}

		// Right Left Case
		if (balanceFactor < -1 && val < root.rightChild.val) {
			root.rightChild = rightRotation(root.rightChild);
			return leftRotation(root);
		}

		// Step 5 : return the (unchanged) node pointer
		return root;
	}

	public int getMinValue(Node node) {
		// though this case should not be hit ever for the usecase this function is
		// employed for
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		// if this is the left-most node
		if (node.leftChild == null) {
			return node.val;
		}

		return getMinValue(node.leftChild);
	}

	public Node minValueNode(Node node) {
		Node temp;
		for (temp = node; temp.leftChild != null; temp = temp.leftChild) {

		}
		;
		return temp;
	}

	void updateHeight(Node node) {
		if (node == null) {
			return;
		}

		node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
	}

	public int getBalance(Node node) {
		if (node == null) {
			return 0;
		}
		int balance;

		balance = getHeight(node.leftChild) - getHeight(node.rightChild);

		return balance;
	}

	public Node delete(int val) {
		rootNode = delete(val);
		return rootNode;
	}

	Node deleteNode(Node root, int val) {
		if (root == null) {
			return root;
		}

		if (val < root.val) {
			root.leftChild = deleteNode(root.leftChild, val);
		} else if (val > root.val) {
			root.rightChild = deleteNode(root.rightChild, val);
		} else {

			if ((root.leftChild == null) || (root.rightChild == null)) {
				Node temp = null;
				if (temp == root.leftChild)
					temp = root.rightChild;
				else
					temp = root.leftChild;

				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {

				Node temp = minValueNode(root.rightChild);

				root.val = temp.val;

				root.rightChild = deleteNode(root.rightChild, temp.val);
			}
		}

		if (root == null)
			return root;

		root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.leftChild) >= 0)
			return rightRotation(root);

		if (balance > 1 && getBalance(root.leftChild) < 0) {
			root.leftChild = leftRotation(root.leftChild);
			return rightRotation(root);
		}

		if (balance < -1 && getBalance(root.rightChild) <= 0)
			return leftRotation(root);

		if (balance < -1 && getBalance(root.rightChild) > 0) {
			root.rightChild = rightRotation(root.rightChild);
			return leftRotation(root);
		}

		return root;
	}

	public static void main(String[] args) {
		AVLTree at1 = new AVLTree();
		at1.insert(1);
		at1.insert(3);
		at1.insert(5);
		at1.insert(7);
		at1.insert(9);

		System.out.println("\nDisplay AVL Tree in Post order");
		at1.postorderTraversal();

		System.out.println("\nDisplay AVL Tree in Pre order");
		at1.preorderTraversal();

		System.out.println("\nDisplay AVL Tree in In order");
		at1.inorderTraversal();

		System.out.println("\nTotal No of nodes inside AVL Tree : " + at1.getTotalNumberOfNodes());

		System.out.println("\nIs node present in AVL Tree? : " + at1.searchElement(5));

		System.out.println("\nIs node present in AVL Tree? : " + at1.searchElement(999));

		System.out.println("\nIs AVL Tree empty? : " + at1.isEmpty());

		at1.removeAll();

		System.out.println("\nIs AVL Tree empty? : " + at1.isEmpty());
	}
}
