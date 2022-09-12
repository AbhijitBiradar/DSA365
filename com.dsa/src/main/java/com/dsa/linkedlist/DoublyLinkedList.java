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
		if (head == null) {
			System.out.println("Linked List is empty!");
			return;
		}

		System.out.println("Displaying nodes in forward direction:");
		ListNode tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.data + " --> ");
			tempNode = tempNode.next;
		}
		System.out.println("null");
	}

	public void displayBackward() {
		if (head == null) {
			System.out.println("Linked List is empty!");
			return;
		}

		System.out.println("Displaying nodes in backward direction:");
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
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;

		System.out.println("New Node inserted at first!");
	}

	public void insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		length++;

		System.out.println("New Node inserted at end!");
	}

	public ListNode deleteFirst() {
		if (isEmpty()) {
			System.out.println("Linked List is empty!");
			throw new NoSuchElementException();
		}

		ListNode tempNode = head;
		if (head == tail) {
			tail = null;
		} else {
			head.next.previous = null;
		}
		head = head.next;
		tempNode.next = null;
		length--;

		System.out.println("Node deleted from first!");

		return tempNode;
	}

	public ListNode deleteLast() {
		if (isEmpty()) {
			System.out.println("Linked List is empty!");
			throw new NoSuchElementException();
		}

		ListNode tempNode = tail;
		if (head == tail) {
			head = null;
		} else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		tempNode.previous = null;
		length--;

		System.out.println("Node deleted from end!");

		return tempNode;
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

		dll.deleteFirst();
		dll.displayForward();

		System.out.println("Length of Linked List : " + dll.length());

		dll.deleteLast();
		dll.displayForward();

		System.out.println("Length of Linked List : " + dll.length());
	}
}
