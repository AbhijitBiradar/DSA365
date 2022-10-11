package com.dsa.linkedlist;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/list/CircularLinkedList.java
// https://www.youtube.com/watch?v=2bqbgNQi2UE
// https://www.youtube.com/watch?v=aaULI7OIeD8

public class CircularSinglyLinkedList {

	private ListNode last;
	private int length;

	private class ListNode {
		private ListNode next;
		private int data;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public CircularSinglyLinkedList() {
		last = null;
		length = 0;
	}

	public int length() {
		return length;
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public void createCircularLinkedList() {
		ListNode firstNode = new ListNode(1);
		ListNode secondNode = new ListNode(5);
		ListNode thirdNode = new ListNode(10);
		ListNode fourthNode = new ListNode(15);

		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		fourthNode.next = firstNode;

		last = fourthNode;

		System.out.println("A Circular Linked List created successfully!");
	}

	public void display() {
		// Case 1 : Linked List is empty
		if (last == null) {
			System.out.println("Circular Linked List is empty!");
			return;
		}

		// Case 2 : Linked List is not empty
		System.out.println("Displaying Circular Linked List:");

		ListNode tempNode = last.next;
		while (tempNode != last) {
			System.out.print(tempNode.data + " --> ");
			tempNode = tempNode.next;
		}
		System.out.println(tempNode.data);
	}

	public void insertAtFirst(int data) {
		ListNode newNode = new ListNode(data);
		if (last == null) {
			// Case 1 : Linked List is empty
			last = newNode;
		} else {
			// Case 2 : Linked List is not empty
			newNode.next = last.next;
		}
		last.next = newNode;
		length++;

		System.out.println("New node inserted successfully at first in Circular Linked list");
	}

	public void insertAtLast(int data) {
		ListNode newNode = new ListNode(data);
		if (last == null) {
			// Case 1 : Linked List is empty
			last = newNode;
			last.next = last;
		} else {
			// Case 2 : Linked List is not empty
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
		length++;

		System.out.println("New node inserted successfully at last in Circular Linked list");
	}

	public ListNode removeFromFirst() {
		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Circular Singly Linked List is empty!");
			return null;
		}

		ListNode tempNode = last.next;
		if (last.next == last) {
			// Case 2 : Linked List contain only one node
			last = null;
		} else {
			// Case 3: Linked List contain more than one nodes
			last.next = tempNode.next;
		}
		tempNode.next = null;
		length--;

		System.out.println("Node removed successfully from first position in Circular Linked list");

		return tempNode;
	}

	// Refer
	// https://www.youtube.com/watch?v=2bqbgNQi2UE
	public ListNode removeFromLast() {
		ListNode tempNode;

		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Circular Singly Linked List is empty!");
			return null;
		}

		// Case 2 : Linked List contain only one node
		if (last.next == last) {
			last = null;
			return last;
		}

		// Case 3: Linked List contain more than one nodes
		tempNode = last.next;
		while (tempNode.next != last) {
			tempNode = tempNode.next;
		}
		tempNode.next = last.next;
		last = tempNode;
		length--;

		System.out.println("Node removed successfully from last position in Circular Linked list");

		return tempNode;
	}

	public void sortLinkedList() {

	}

	public void insertAt(int position, int data) {

	}

	public void deleteAt(int position) {

	}

	public void deleteNode(int searchData) {

	}

	public boolean search(int searchKey) {
		return false;
	}

	public ListNode reverse(ListNode head) {
		return null;
	}

	public ListNode getMiddleNode() {
		return null;
	}

	public ListNode getNthNodeFromEnd(int n) {
		return null;
	}

	public void removeDuplicates() {

	}

	public ListNode insertInSortedList(int data) {
		return null;
	}

	public boolean containsLoop() {
		return false;
	}

	public ListNode startNodeInALoop() {
		return null;
	}

	public void removeLoop() {

	}

	public void createALoopInLinkedList() {

	}

	public static void main(String[] args) {
		CircularSinglyLinkedList csl = new CircularSinglyLinkedList();

		csl.createCircularLinkedList();
		csl.display();

		csl.insertAtFirst(20);
		csl.insertAtFirst(25);
		csl.insertAtFirst(30);

		csl.display();

		csl.insertAtLast(35);
		csl.insertAtLast(40);
		csl.insertAtLast(45);

		csl.display();

		csl.removeFromFirst();
		csl.display();

		csl.removeFromLast();
		csl.display();
	}
}
