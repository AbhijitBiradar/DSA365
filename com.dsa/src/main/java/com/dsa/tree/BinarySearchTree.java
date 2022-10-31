package com.dsa.tree;

// Reference
// https://www.programiz.com/dsa/binary-search-tree

// Definition :
// A binary search tree follows some order to arrange the elements. 
// In a Binary search tree, the value of left node must be smaller than the parent node, 
// and the value of right node must be greater than the parent node. 
// This rule is applied recursively to the left and right subtrees of the root.

class BinarySearchTree {

	private TreeNode root;

	public BinarySearchTree() {
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

	private static class ListNode {
		private int val;
		private ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// Function to construct a BST from given keys
	// user below array
	// int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

	// Refer
	// https://www.techiedelight.com/insertion-in-bst/
	public TreeNode constructBST(int[] keys) {
		TreeNode root = null;
		for (int key : keys) {
			root = insertRec(root, key);
		}
		return root;
	}

	public void traversePreOrderRec() {
		traversePreOrderRec(root);
		System.out.println();
	}

	public void traversePreOrderRec(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " -> ");
			traverseInOrderRec(root.left);
			traverseInOrderRec(root.right);
		}
	}

	public void traverseInOrderRec() {
		traverseInOrderRec(root);
		System.out.println();
	}

	public void traverseInOrderRec(TreeNode root) {
		if (root != null) {
			traverseInOrderRec(root.left);
			System.out.print(root.val + " -> ");
			traverseInOrderRec(root.right);
		}
	}

	public void traversePostOrderRec() {
		traversePostOrderRec(root);
		System.out.println();
	}

	public void traversePostOrderRec(TreeNode root) {
		if (root != null) {
			traverseInOrderRec(root.left);
			traverseInOrderRec(root.right);
			System.out.print(root.val + " -> ");
		}
	}

	public void insertRec(int data) {
		this.root = insertRec(root, data);
	}

	public TreeNode insertRec(TreeNode root, int data) {
		if (root == null) {
			// Case 1 : Tree is empty. Return a new node if the tree is empty
			root = new TreeNode(data);
			return root;
		}

		if (data < root.val) {
			// Case 2A : Tree is not empty. If the given data is smaller than the root node,
			// recur for the left subtree
			root.left = insertRec(root.left, data);
		} else if (data > root.val) {
			// Case 2A : Tree is not empty. If the given key is larger than the root node,
			// recur for the right subtree
			root.right = insertRec(root.right, data);
		}

		System.out.println("Node with data " + data + " inserted in Tree!");

		return root;
	}

	public void insertIter(int data) {
		this.root = insertIter(root, data);
	}

	public TreeNode insertIter(TreeNode root, int data) {
		// start with the root node
		TreeNode curr = root;

		// pointer to store the parent of the current node
		TreeNode parent = null;

		// if the tree is empty, create a new node and set it as root
		if (root == null) {
			return new TreeNode(data);
		}

		// traverse the tree and find the parent node of the given key
		while (curr != null) {
			// update the parent to the current node
			parent = curr;

			// if the given key is less than the current node,
			// go to the left subtree; otherwise, go to the right subtree.
			if (data < curr.val) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		// construct a node and assign it to the appropriate parent pointer
		if (data < parent.val) {
			parent.left = new TreeNode(data);
		} else {
			parent.right = new TreeNode(data);
		}

		System.out.println("Node with data " + data + " inserted in Tree!");

		return root;
	}

	public void deleteRec(int data) {
		root = deleteRec(root, data);
	}

	public TreeNode deleteRec(TreeNode root, int data) {
		// Return if the tree is empty
		if (root == null)
			return root;

		// Find the node to be deleted
		if (data < root.val)
			root.left = deleteRec(root.left, data);
		else if (data > root.val)
			root.right = deleteRec(root.right, data);
		else {
			// If the node is with only one child or no child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// If the node has two children
			// Place the inorder successor in position of the node to be deleted
			root.val = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.val);
		}

		return root;
	}

	public void deleteIter(int data) {
		root = deleteIter(root, data);
	}

	public TreeNode deleteIter(TreeNode root, int data) {
		// Refer
		// https://www.geeksforgeeks.org/binary-search-tree-set-3-iterative-delete/
		// https://www.digitalocean.com/community/tutorials/binary-search-tree-bst-search-insert-remove
		// https://www.happycoders.eu/algorithms/binary-search-tree-java/
		return null;
	}

	int minValue(TreeNode root) {
		// initially minval = root
		int minval = root.val;
		// find minval
		while (root.left != null) {
			minval = root.left.val;
			root = root.left;
		}
		return minval;
	}

	int maxValue(TreeNode root) {
		// initially maxValue = root
		int maxval = root.val;
		// find maxValue
		while (root.left != null) {
			maxval = root.right.val;
			root = root.right;
		}
		return maxval;
	}

	boolean searchRec(int key) {
		root = searchRec(root, key);
		if (root != null)
			return true;
		else
			return false;
	}

	// recursive insert function
	TreeNode searchRec(TreeNode root, int data) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.val == data)
			return root;
		// data is greater than root's key
		if (root.val > data)
			return searchRec(root.left, data);
		// data is less than root's key
		return searchRec(root.right, data);
	}

	public boolean searchIter(int key) {
		return searchIter(root, key);
	}

	public boolean searchIter(TreeNode root, int key) {
		// Traverse until root reaches to dead end
		while (root != null) {
			// pass right subtree as new tree
			if (key > root.val)
				root = root.right;

			// pass left subtree as new tree
			else if (key < root.val)
				root = root.left;
			else
				return true; // if the key is found return 1
		}
		return false;
	}

	// Refer
	// https://www.geeksforgeeks.org/print-all-even-nodes-of-binary-search-tree/?ref=rp
	// Function to print all even nodes
	public void evenNode(Node root) {
		if (root != null) {
			evenNode(root.left);
			// if node is even then print it
			if (root.data % 2 == 0)
				System.out.print(root.data + " ");
			evenNode(root.right);
		}
	}

	// Refer
	// https://www.geeksforgeeks.org/print-all-odd-nodes-of-binary-search-tree/?ref=rp
	// Function to print all odd nodes
	public void oddNode(Node root) {
		if (root != null) {
			oddNode(root.left);

			// if node is odd then print it
			if (root.data % 2 != 0)
				System.out.print(root.data + " ");

			oddNode(root.right);
		}
	}

	public void updateIter(int oldData, int newData) {

	}

	public void updateRec(int oldData, int newData) {

	}

	// Refer
	// https://www.youtube.com/watch?v=ACoLBU0nPAw
	public boolean isBinarySearchTree() {
		return true;
	}

	// Refer
	// https://www.youtube.com/watch?v=_Vo3cQ2xtqk
	// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/2404676/Java-Solution-oror-Recursion-oror-0ms-100-Faster-oror-Beginner-Friendly
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}

		return createBST(nums, 0, nums.length - 1);
	}

	// Refer
	// https://www.youtube.com/watch?v=_Vo3cQ2xtqk
	// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/2404676/Java-Solution-oror-Recursion-oror-0ms-100-Faster-oror-Beginner-Friendly
	private TreeNode createBST(int nums[], int left, int right) {
		if (left > right) {
			return null;
		}

		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = createBST(nums, left, mid - 1);
		root.right = createBST(nums, mid + 1, right);

		return root;
	}

	// Refer
	// https://www.youtube.com/watch?v=5IQF13nNq6A
	// https://github.com/Algorithms-Made-Easy/Tree/blob/master/Convert-Sorted-List-to-Binary-Search-Tree
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		ListNode mid = mid(head);
		TreeNode root = new TreeNode(mid.val);

		if (head == mid)
			return root;

		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}

	// Refer
	// https://www.youtube.com/watch?v=5IQF13nNq6A
	// https://github.com/Algorithms-Made-Easy/Tree/blob/master/Convert-Sorted-List-to-Binary-Search-Tree
	public ListNode mid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (prev != null)
			prev.next = null;

		return slow;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.insertRec(8);
		bst.insertRec(3);
		bst.insertRec(1);
		bst.insertRec(6);
		bst.insertRec(7);
		bst.insertRec(10);
		bst.insertRec(14);
		bst.insertRec(4);

		System.out.println("Preorder traversal: ");
		bst.traversePreOrderRec();

		System.out.println("Inorder traversal: ");
		bst.traverseInOrderRec();

		System.out.println("Postorder traversal: ");
		bst.traversePostOrderRec();

	}
}
