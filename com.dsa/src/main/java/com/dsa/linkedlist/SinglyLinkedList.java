package com.dsa.linkedlist;

// Reference
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/list/SinglyLinkedList.java

public class SinglyLinkedList {

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private ListNode head;

	public void createALinkedList() {
		ListNode firstNode = new ListNode(1);
		ListNode secondNode = new ListNode(3);
		ListNode thirdNode = new ListNode(5);
		ListNode fourthNode = new ListNode(7);
		ListNode fifthNode = new ListNode(9);
		ListNode sixthNode = new ListNode(12);

		head = firstNode;
		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		fourthNode.next = fifthNode;
		fifthNode.next = sixthNode;

		System.out.println("A Sample Linked List created successfully!");
	}

	public void display() {
		ListNode currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " --> ");
			currentNode = currentNode.next;
		}
		System.out.print("null");
		System.out.println();
	}

	public int length() {
		if (head == null) {
			return 0;
		}
		int count = 0;
		ListNode current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;

		System.out.println("Node inserted at First successfully!");
	}

	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		while (null != current.next) {
			current = current.next;
		}
		current.next = newNode;

		System.out.println("Node inserted at Last successfully!");
	}

	public void insert(int position, int value) {
		// 1 -> 4 -> 5
		// 1 -> 6 -> 4 -> 5
		// position starts from 1
		ListNode node = new ListNode(value);

		if (position == 1) {
			node.next = head;
			head = node;
		} else {
			ListNode previous = head;
			int count = 1; // position - 1

			while (count < position - 1) {
				previous = previous.next;
				count++;
			}

			ListNode current = previous.next;
			previous.next = node;
			node.next = current;
		}

		System.out.println("Node inserted at " + position + " successfully!");
	}

	public ListNode deleteFirst() {
		if (head == null) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;

		System.out.println("Node deleted from first successfully!");

		return temp;
	}

	public ListNode deleteLast() {
		if (head == null) {
			return head;
		}

		if (head.next == null) {
			ListNode temp = head;
			head = head.next;
			return temp;
		}

		ListNode current = head;
		ListNode previous = null;

		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null; // break the chain

		System.out.println("Node deleted from last successfully!");

		return current;
	}

	public void delete(int position) {
		// position is valid and starting from 1
		// 3 -> 4 -> 7 -> 8 -> 9 -> null
		if (position == 1) {
			head = head.next;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}

			ListNode current = previous.next;
			previous.next = current.next;
		}

		System.out.println("Node deleted from " + position + " successfully!");
	}

	public boolean find(int searchKey) {
		if (head == null) {
			System.out.println("Linked List is empty!");

			return false;
		}

		ListNode current = head;
		while (current != null) {
			if (current.data == searchKey) {

				System.out.println("Given node is present in Linked List!");

				return true;
			}
			current = current.next;
		}

		System.out.println("Given node is not present in Linked List!");
		return false;
	}

	// code not working watch video
	public ListNode reverse() {
		if (head == null) {
			System.out.println("Linked List is empty!");
			return null;
		}

		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		System.out.println("Linked List reversed successfully!");

		return previous;
	}

	// watch video for this
	public ListNode getMiddleNode() {
		if (head == null) {
			return null;
		}
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	// watch video for this
	public ListNode getNthNodeFromEnd(int n) {
		if (head == null) {
			return null;
		}

		if (n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}

		ListNode mainPtr = head;
		ListNode refPtr = head;

		int count = 0;

		while (count < n) {
			if (refPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPtr = refPtr.next;
			count++;
		}

		while (refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}

	// watch video for this
	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);

		if (head == null) {
			return newNode;
		}

		ListNode current = head;
		ListNode temp = null;

		while (current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}

		newNode.next = current;
		temp.next = newNode;
		return head;
	}

	// watch video for this
	public void deleteNode(int key) {
		ListNode current = head;
		ListNode temp = null;

		if (current != null && current.data == key) {
			head = current.next;
			return;
		}

		while (current != null && current.data != key) {
			temp = current;
			current = current.next;
		}

		if (current == null) {
			return;
		}

		temp.next = current.next;
	}

	// watch video for this
	public boolean containsLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if (fastPtr == slowPtr) {
				return true;
			}
		}
		return false;
	}

	// watch video for this
	public ListNode startNodeInALoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if (fastPtr == slowPtr) {
				return getStartingNode(slowPtr);
			}
		}
		return null;
	}

	// watch video for this
	private ListNode getStartingNode(ListNode slowPtr) {
		ListNode temp = head;
		while (temp != slowPtr) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp; // starting node of the loop
	}

	// watch video for this
	public void removeLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if (fastPtr == slowPtr) {
				removeLoop(slowPtr);
				return;
			}
		}
	}

	// watch video for this
	private void removeLoop(ListNode slowPtr) {
		ListNode temp = head;
		while (temp.next != slowPtr.next) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		slowPtr.next = null;
	}

	// watch video for this
	public void createALoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();

		sll.createALinkedList();
		sll.display();

		System.out.println("Linked List Length : " + sll.length());

		sll.insertFirst(15);
		sll.display();

		sll.insertLast(17);
		sll.display();

		sll.insert(3, 999);
		sll.display();

		sll.deleteFirst();
		sll.display();

		sll.deleteLast();
		sll.display();

		sll.delete(3);
		sll.display();

		sll.find(100);
		sll.find(12);

		sll.reverse();
		sll.display();

	}
}
