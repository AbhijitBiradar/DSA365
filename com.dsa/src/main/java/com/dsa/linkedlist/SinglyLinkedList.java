package com.dsa.linkedlist;

public class SinglyLinkedList {

	// Reference :
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/list/SinglyLinkedList.java

	private static class ListNode {
		private int data; // Can be a generic type
		private ListNode next; // Reference to next ListNode in list

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
	}
}

