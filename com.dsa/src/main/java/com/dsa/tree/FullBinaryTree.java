package com.dsa.tree;

// Reference
// https://www.programiz.com/dsa/full-binary-tree

// Definition : A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.

class FullBinaryTree {

	private TreeNode root;

	public FullBinaryTree() {
		this.root = null;
	}

	private static class TreeNode {
		private int val;
		private TreeNode leftChild;
		private TreeNode rightChild;

		public TreeNode(int val) {
			this.val = val;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	public boolean isFullBinaryTree(TreeNode node) {

		// Case 1: Checking tree emptiness
		if (node == null)
			return true;

		// Case 2: Checking the children for null
		if (node.leftChild == null && node.rightChild == null) {
			return true;
		}

		// Case 3:Checking the full binary for sub children
		if ((node.leftChild != null) && (node.rightChild != null)) {
			return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));
		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		FullBinaryTree fbTree = new FullBinaryTree();
		fbTree.root = new TreeNode(1);
		fbTree.root.leftChild = new TreeNode(2);
		fbTree.root.rightChild = new TreeNode(3);
		fbTree.root.leftChild.leftChild = new TreeNode(4);
		fbTree.root.leftChild.rightChild = new TreeNode(5);
		fbTree.root.rightChild.leftChild = new TreeNode(6);
		fbTree.root.rightChild.rightChild = new TreeNode(7);

		if (fbTree.isFullBinaryTree(fbTree.root)) {
			System.out.print("The tree is a full binary tree");
		} else {
			System.out.print("The tree is not a full binary tree");
		}
	}
}
