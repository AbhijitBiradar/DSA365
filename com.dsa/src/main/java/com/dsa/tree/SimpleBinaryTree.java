package com.dsa.tree;

import java.util.Stack;

// Reference
// https://www.programiz.com/dsa/binary-tree
// https://kalkicode.com/inorder-traversal-of-binary-tree-with-recursion-in-java
// https://kalkicode.com/preorder-traversal-of-binary-tree-using-recursion-in-java
// https://kalkicode.com/postorder-traversal-of-binary-tree-with-recursion-in-java

// https://www.youtube.com/watch?v=mQk6Y5B_0Mk&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=97
// https://www.youtube.com/watch?v=wL7JOLxbMI4&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=98
// https://www.youtube.com/watch?v=R4V4n-waxn4&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=99
// https://www.youtube.com/watch?v=VaIaJMeNWtU&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=100
// https://www.youtube.com/watch?v=vpXcceCmSbg&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=101
// https://www.youtube.com/watch?v=uMTrIjP_0Gw&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=103&t=1545s
// https://www.youtube.com/watch?v=xDMFBKjxZNc&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=103&t=1437s
// https://www.youtube.com/watch?v=uigaktgcQWU&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=104
// https://www.youtube.com/watch?v=m4Wb3kXk_iA&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=105&t=750s

class SimpleBinaryTree {

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

	public void traversePreOrderRec(Node node) {
		if (node != null) {
			System.out.print(" " + node.data);
			traversePreOrderRec(node.left);
			traversePreOrderRec(node.right);
		}
	}

	// Refer
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/tree/BinaryTree.java
	public void traversePreOrderIter(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}

	public void traverseInOrderRec(Node node) {
		if (node != null) {
			traverseInOrderRec(node.left);
			System.out.print(" " + node.data);
			traverseInOrderRec(node.right);
		}
	}

	// Refer
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/tree/BinaryTree.java
	public void traverseInOrderIter(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		Node temp = root;

		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}

	public void traversePostOrderRec(Node node) {
		if (node != null) {
			traversePostOrderRec(node.left);
			traversePostOrderRec(node.right);
			System.out.print(" " + node.data);
		}
	}

	// Refer
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/tree/BinaryTree.java
	public void traversePostOrderIter(Node node) {
		Node current = root;
		Stack<Node> stack = new Stack<>();

		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				Node temp = stack.peek().right;
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	// Refer
	// https://www.geeksforgeeks.org/level-order-tree-traversal/
	// This function is of level order traversal
	void levelOrderTraversal(Node root, int level) {
		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			levelOrderTraversal(root.left, level - 1);
			levelOrderTraversal(root.right, level - 1);
		}
	}

	// Refer
	// https://www.enjoyalgorithms.com/blog/find-height-of-a-binary-tree
	public int treeHeight(Node node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int leftHeight = treeHeight(node.left);
			int righttHeight = treeHeight(node.right);

			/* use the larger one */
			if (leftHeight > righttHeight)
				return (leftHeight + 1);
			else
				return (righttHeight + 1);
		}
	}

	// Refer
	// https://algorithms.tutorialhorizon.com/count-the-number-of-nodes-in-a-given-binary-tree/
	public int countNode(Node root) {
		// base case
		if (root == null)
			return 0;

		// recursive call to left child and right child and
		// add the result of these with 1 ( 1 for counting the root)
		return 1 + countNode(root.left) + countNode(root.right);
	}

	// Refer
	// https://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
	public int getLeafCount(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}

	// Refer
	// https://www.geeksforgeeks.org/count-non-leaf-nodes-binary-tree/
	public int countNonleaf(Node root) {
		// Base cases.
		if (root == null || (root.left == null && root.right == null))
			return 0;

		// If root is Not NULL and its one of its
		// child is also not NULL
		return 1 + countNonleaf(root.left) + countNonleaf(root.right);
	}

	// Refer
	// https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/2424930/Very-Easy-oror-100-oror-Fully-Explained-(C%2B%2B-Java-Python-JS-C-Python3)
	public int maxDepth(Node root) {
		// Base case...
		// If the subtree is empty i.e. root is NULL, return depth as 0...
		if (root == null)
			return 0;
		// if root is not NULL, call the same function recursively for its left child
		// and right child...
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		// When the two child function return its depth...
		// Pick the maximum out of these two subtrees and return this value after adding
		// 1 to it...
		return Math.max(leftDepth, rightDepth) + 1; // Adding 1 is the current node which is the parent of the two
													// subtrees...
	}

	// Refer
	// https://www.youtube.com/watch?v=cajtJQQpbyI
	// https://github.com/Algorithms-Made-Easy/Tree/blob/master/Binary-Tree-Maximum-Path-Sum
	static int maxSum = Integer.MIN_VALUE;

	public int BinaryTreeMaximumPathSum(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = Math.max(0, BinaryTreeMaximumPathSum(node.left));
		int right = Math.max(0, BinaryTreeMaximumPathSum(node.right));
		int currSum = node.val + left + right; // sum of left, root, right

		maxSum = Math.max(currSum, maxSum);

		return Math.max(node.val + left, node.val + right);
	}

	public static void main(String[] args) {
		SimpleBinaryTree sbTree = new SimpleBinaryTree();

		sbTree.root = new Node(1);
		sbTree.root.left = new Node(2);
		sbTree.root.right = new Node(3);
		sbTree.root.left.left = new Node(4);

		System.out.println("Pre Order Traversal: ");
		sbTree.traversePreOrderRec(sbTree.root);

		System.out.println("In Order Traversal: ");
		sbTree.traverseInOrderRec(sbTree.root);

		System.out.println("Post Order Traversal: ");
		sbTree.traversePostOrderRec(sbTree.root);
	}
}
