package com.dsa.tree;

//Checking if a binary tree is height balanced in Java

class BalancedBinaryTree {

	private static class Node {

		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private static class Height {
		private int height = 0;
	}

	private Node root;

	// Check height balance
	boolean checkHeightBalance(Node root, Height height) {

		// Check for emptiness
		if (root == null) {
			height.height = 0;
			return true;
		}

		Height leftHeighteight = new Height(), rightHeighteight = new Height();
		boolean l = checkHeightBalance(root.left, leftHeighteight);
		boolean r = checkHeightBalance(root.right, rightHeighteight);
		int leftHeight = leftHeighteight.height, rightHeight = rightHeighteight.height;

		height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

		if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2)) {
			return false;
		} else {
			return l && r;
		}
	}

	public static void main(String args[]) {
		Height height = new Height();

		BalancedBinaryTree tree = new BalancedBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		if (tree.checkHeightBalance(tree.root, height)) {
			System.out.println("The tree is balanced");
		} else {
			System.out.println("The tree is not balanced");
		}
	}
}