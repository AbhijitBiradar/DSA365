package com.dsa.linkedlist;

// Refer
// https://www.sanfoundry.com/java-program-implement-circular-doubly-linked-list/
// https://www.youtube.com/playlist?list=PLBlnK6fEyqRjW4jK-CbshJuX20nc_3IaN

class CircularDoublyLinkedList {

	private ListNode head;
	private ListNode tail;
	private int length;

	private class ListNode {
		private ListNode next;
		private ListNode previous;
		private int data;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public CircularDoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int length() {
		return length;
	}

	public void insertAtFirst(int data) {
		ListNode newNode = new ListNode(data);

		if (head == null) {
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
			tail = newNode;
		} else {
			newNode.previous = tail;
			tail.next = newNode;
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		}
		length++;
		System.out.println("New node inserted at start");
	}

	public void insertAtEnd(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
			tail = head;
		} else {
			newNode.previous = tail;
			tail.next = newNode;
			head.previous = newNode;
			newNode.next = head;
			tail = newNode;
		}
		length++;
		System.out.println("New node inserted at end");
	}

	public void insertAtPos(int data, int pos) {
		ListNode newNode = new ListNode(data);
		if (pos == 1) {
			insertAtFirst(data);
			return;
		}
		ListNode ptr = head;
		for (int i = 2; i <= length; i++) {
			if (i == pos) {
				ListNode tempNode = ptr.next;
				ptr.next = newNode;
				newNode.previous = ptr;
				newNode.next = tempNode;
				tempNode.previous = newNode;
			}
			ptr = ptr.next;
		}
		length++;
		System.out.println("New node inserted at " + pos + " position");
	}

	public void deleteFromFirst() {
		if (length == 1) {
			head = null;
			tail = null;
			length = 0;
			System.out.println("Node deleted from first position : ");
			return;
		}
		head = head.next;
		head.previous = tail;
		tail.next = head;
		length--;
		System.out.println("Node deleted from first position : ");
	}

	public void deleteFromEnd() {
		tail = tail.previous;
		tail.next = head;
		head.previous = tail;
		length--;
		System.out.println("Node deleted from end position : ");
	}

	public void deleteAtPos(int pos) {
		if (pos == 1) {
			if (length == 1) {
				head = null;
				tail = null;
				length = 0;
				System.out.println("Node deleted from position : " + pos);
				return;
			}
			head = head.next;
			head.previous = tail;
			tail.next = head;
			length--;
			System.out.println("Node deleted from position : " + pos);
			return;
		}
		if (pos == length) {
			tail = tail.previous;
			tail.next = head;
			head.previous = tail;
			length--;
			System.out.println("Node deleted from position : " + pos);
			return;
		}
		ListNode tempNode = head.next;
		for (int i = 2; i <= length; i++) {
			if (i == pos) {
				ListNode previousNode = tempNode.previous;
				ListNode nextNode = tempNode.next;

				previousNode.next = nextNode;
				nextNode.previous = previousNode;
				length--;
				System.out.println("Node deleted from position : " + pos);
				return;
			}
			tempNode = tempNode.next;
		}
	}

	public boolean search(int data) {

		// case 1 : list is empty
		if (length == 0) {
			System.out.println("Linked list is empty");
			return false;
		}

		// case 2 : positve case element found
		ListNode tempNode = head;
		while (tempNode.next != tail) {
			if (tempNode.data == data) {
				System.out.println("Element found in circular linked list!");
				return true;
			}
			tempNode = tempNode.next;
		}
		System.out.println("Element not found in circular linked list!");
		return false;
	}

	public void createCircularDoublyLinkedList() {

	}

	public void display() {
		System.out.print("Displaying Circular Doubly Linked List : ");
		ListNode tempNode = head;
		if (length == 0) {
			System.out.println("Linked list is empty");
			return;
		}
		if (head.next == head) {
			System.out.print(head.data + " ==> " + tempNode.data + "\n");
			return;
		}

		System.out.print(head.data + " ==> ");
		tempNode = head.next;
		while (tempNode.next != head) {
			System.out.print(tempNode.data + " ==> ");
			tempNode = tempNode.next;
		}
		System.out.print(tempNode.data + " ==> ");
		tempNode = tempNode.next;
		System.out.print(tempNode.data + "\n");
	}

	public static void main(String[] args) {
		CircularDoublyLinkedList c = new CircularDoublyLinkedList();
		c.insertAtFirst(1);
		c.display();
		c.insertAtFirst(3);
		c.display();

		c.insertAtEnd(5);
		c.display();
		c.insertAtEnd(7);
		c.display();

		c.insertAtPos(9, 1); // first position
		c.display();
		c.insertAtPos(11, 4); // middle position
		c.display();
		c.insertAtPos(13, 6); // last position
		c.display();
		
		c.search(11);
		c.search(100);

		c.deleteFromFirst();
		c.display();

		c.deleteFromEnd();
		c.display();

		c.deleteAtPos(1); // first position
		c.display();
		c.deleteAtPos(3); // middle position
		c.display();
		c.deleteAtPos(5); // last position
		c.display();
	}

}
