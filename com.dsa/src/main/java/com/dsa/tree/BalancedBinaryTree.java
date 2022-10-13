package com.dsa.tree;

// Refer
// https://www.youtube.com/watch?v=OgdYyBT8iU8

// Checking if a binary tree is height balanced in Java
// https://www.programiz.com/dsa/balanced-binary-tree

// Definition : A balanced binary tree, also referred to as a height-balanced binary tree, is defined as a binary tree in which the height of the left and right subtree of any node differ by not more than 1.

// https://www.youtube.com/watch?v=lUDgp2D6sf8
// https://www.youtube.com/watch?v=Yt50Jfbd8Po
// https://www.youtube.com/watch?v=Y0fmHaY8lx4
// https://leetcode.com/problems/balanced-binary-tree/discuss/?currentPage=1&orderBy=most_relevant&query=java

class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// Refer
	// This is Top-Down approach
	// https://www.youtube.com/watch?v=OgdYyBT8iU8
	public boolean isBalanced1(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (Math.abs(height1(root.left) - height1(root.right)) > 1) {
			return false;
		}

		return (isBalanced1(root.left) && isBalanced1(root.right));

	}

	// Refer
	// This is Top-Down approach
	// https://www.youtube.com/watch?v=OgdYyBT8iU8
	public int height1(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return (1 + Math.max(height1(node.left), height1(node.right)));
		}
	}

	// Refer
	// This is Bottom-Up approach
	// https://www.youtube.com/watch?v=OgdYyBT8iU8
	public boolean isBalanced2(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return (height2(root) != -1);
		}
	}

	// Refer
	// This is Bottom-Up approach
	// https://www.youtube.com/watch?v=OgdYyBT8iU8
	public int height2(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = height2(node.left);
		int rightHight = height2(node.right);
		int balanceFactor = Math.abs(leftHeight - rightHight);

		if (balanceFactor > 1 || leftHeight == -1 || rightHight == -1) {
			return -1;
		} else {
			return (1 + Math.max(leftHeight, rightHight));
		}
	}
}