package com.dsa.tree;

// Refer
// https://www.youtube.com/watch?v=OgdYyBT8iU8

// Checking if a binary tree is height balanced in Java
// https://www.programiz.com/dsa/balanced-binary-tree

// Definition : A balanced binary tree, also referred to as a height-balanced binary tree, is defined as 
// A binary tree in which the height of the left and right subtree of any node differ by not more than 1.

// https://www.youtube.com/watch?v=lUDgp2D6sf8
// https://www.youtube.com/watch?v=Yt50Jfbd8Po
// https://www.youtube.com/watch?v=Y0fmHaY8lx4

class BalancedBinaryTree {

	private TreeNode root;

	BalancedBinaryTree() {
		this.root = null;
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}

	// Refer
	// https://www.youtube.com/watch?v=OgdYyBT8iU8
	// https://leetcode.com/problems/balanced-binary-tree/
	public boolean isBalanced(TreeNode root) {
		// Case 1 : root is null
		if (root == null) {
			return true;
		}

		if (height(root) == -1) {
			return false;
		} else {
			return true;
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=OgdYyBT8iU8
	// https://leetcode.com/problems/balanced-binary-tree/
	private int height(TreeNode root) {
		// Base condition
		if (root == null) {
			return 0;
		}

		// Height of left subtree
		int leftHeight = height(root.left);

		// Height of right subtree
		int rightHeight = height(root.right);

		// In case of left subtree or right subtree unbalanced, return -1
		if (leftHeight == -1 || rightHeight == -1) {
			return -1;
		}

		// If their heights differ by more than ‘1’, return -1
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		// Otherwise, return the height of this subtree as max(leftHeight, rightHight) +
		// 1
		return (Math.max(leftHeight, rightHeight) + 1);
	}

	public static void main(String args[]) {

		BalancedBinaryTree bbt = new BalancedBinaryTree();
		bbt.root = new TreeNode(1);
		bbt.root.left = new TreeNode(2);
		bbt.root.right = new TreeNode(3);
		bbt.root.left.left = new TreeNode(4);
		bbt.root.left.right = new TreeNode(5);

		if (bbt.isBalanced(bbt.root))
			System.out.println("The tree is balanced");
		else
			System.out.println("The tree is not balanced");
	}
}