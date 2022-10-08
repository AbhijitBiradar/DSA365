package com.dsa.linkedlist;

import java.util.NoSuchElementException;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/list/DoublyLinkedList.java

public class DoublyLinkedList {

	private ListNode head;
	private ListNode tail;
	private int length;

	private class ListNode {
		private int data;
		private ListNode next;
		private ListNode previous;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public int length() {
		return length;
	}

	public void displayForward() {
		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");
			return;
		}

		// Case 2 : Linked List is not empty
		System.out.println("Displaying nodes in Forward Direction : ");
		ListNode tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.data + " --> ");
			tempNode = tempNode.next;
		}
		System.out.println("null");
	}

	public void displayBackward() {
		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");
			return;
		}

		// Case 2 : Linked List is not empty
		System.out.println("Displaying nodes in Backward Direction : ");
		ListNode tempNode = tail;
		while (tempNode != null) {
			System.out.print(tempNode.data + " --> ");
			tempNode = tempNode.previous;
		}
		System.out.println("null");
	}

	public void insertAtStart(int data) {
		ListNode newNode = new ListNode(data);

		if (isEmpty()) {
			// Case 1 : Linked List is empty
			tail = newNode;
		} else {
			// Case 2 : Linked List is not empty
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;

		System.out.println("New Node inserted at start!");
	}

	public void insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);

		if (isEmpty()) {
			// Case 1 : Linked List is empty
			head = newNode;
		} else {
			// Case 2 : Linked List is not empty
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		length++;

		System.out.println("New Node inserted at end!");
	}

	public ListNode deleteFromFirst() {
		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Linked List is empty!");
			throw new NoSuchElementException();
		}

		ListNode tempNode = head;
		if (head == tail) {
			// Case 2 : Linked List contain only one node
			tail = null;
		} else {
			// Case 3 : Linked List contain more nodes
			head.next.previous = null;
		}
		head = head.next;
		tempNode.next = null;
		length--;

		System.out.println("Node deleted from first!");

		return tempNode;
	}

	public ListNode deleteFromLast() {
		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Linked List is empty!");
			throw new NoSuchElementException();
		}

		ListNode tempNode = tail;
		if (head == tail) {
			// Case 2 : Linked List contain only one node
			head = null;
		} else {
			// Case 3 : Linked List contain more than one nodes
			tail.previous.next = null;
		}
		tail = tail.previous;
		tempNode.previous = null;
		length--;

		System.out.println("Node deleted from end!");

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
		DoublyLinkedList dll = new DoublyLinkedList();

		System.out.println("Is Linked List is empty? : " + dll.isEmpty());

		dll.insertAtEnd(1);
		dll.insertAtEnd(2);
		dll.insertAtEnd(3);

		dll.displayForward();
		dll.displayBackward();

		dll.insertAtStart(4);
		dll.insertAtStart(5);
		dll.insertAtStart(6);

		dll.displayForward();
		dll.displayBackward();

		System.out.println("Length of Linked List : " + dll.length());

		dll.deleteFromFirst();
		dll.displayForward();

		System.out.println("Length of Linked List : " + dll.length());

		dll.deleteFromLast();
		dll.displayForward();

		System.out.println("Length of Linked List : " + dll.length());
	}
}
