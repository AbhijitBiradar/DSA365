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
		this.length = 0;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int length() {
		return length;
	}

	public void insertAtFirst(int data) {
		ListNode newNode = new ListNode(data);

		if (head == null) {
			// case 1: Linked list is empty
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
			tail = newNode;
		} else {
			// case 2: Linked list is not empty
			newNode.previous = tail;
			newNode.next = head;
			tail.next = newNode;
			head.previous = newNode;
			head = newNode;
		}
		length++;
		System.out.println("New node inserted at start");
	}

	public void insertAtEnd(int data) {
		ListNode newNode = new ListNode(data);

		if (head == null) {
			// case 1: Linked list is empty
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
			tail = newNode;
		} else {
			// case 2: Linked list is not empty
			newNode.previous = tail;
			tail.next = newNode;
			head.previous = newNode;
			newNode.next = head;
			tail = newNode;
		}
		length++;
		System.out.println("New node inserted at end");
	}

	public void insertAtPos(int data, int position) {
		// case 1 : Position is 1
		if (position == 1) {
			insertAtFirst(data);
			return;
		}

		// case 2 : Position is > 1
		ListNode newNode = new ListNode(data);
		ListNode currentNode = head;
		for (int i = 2; i <= length; i++) {
			if (i == position) {
				ListNode nextNode = currentNode.next;
				newNode.next = nextNode;
				newNode.previous = currentNode;
				currentNode.next = newNode;
				nextNode.previous = newNode;
				break;
			}
			currentNode = currentNode.next;
		}
		length++;
		System.out.println("New node inserted at " + position + " position");
	}

	public void deleteFromFirst() {
		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Circular Linked list is empty!");
			return;
		}

		// Case 2 : Linked list size = 1
		if (length == 1) {
			head = null;
			tail = null;
			length = 0;
			System.out.println("Node deleted from first position : ");
			return;
		}

		// Case 3 : Linked list contain more than one nodes
		head = head.next;
		head.previous = tail;
		tail.next = head;

		length--;
		System.out.println("Node deleted from first position : ");
	}

	public void deleteFromLast() {
		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Circular Linked list is empty!");
			return;
		}

		// Case 2 : Linked list contain more than one nodes
		tail = tail.previous;
		tail.next = head;
		head.previous = tail;
		length--;
		System.out.println("Node deleted from end position : ");
	}

	public void deleteFromPos(int pos) {
		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Circular Linked list is empty!");
			return;
		}

		// Case 2 : Invalid position (position <=0)
		if (pos <= 0) {
			System.out.println("Please provide valid position!");
			return;
		}

		if (pos == 1) {
			// Case 3 : Position = 1 & linked list length = 1
			if (length == 1) {
				head = null;
				tail = null;
				length = 0;
				System.out.println("Node deleted from position : " + pos);
				return;
			}

			// Case 4 : Position = 1 but linked list contain more than one element
			head = head.next;
			head.previous = tail;
			tail.next = head;
			length--;
			System.out.println("Node deleted from position : " + pos);
			return;
		}

		// Case 5 : Position is last element
		if (pos == length) {
			tail = tail.previous;
			tail.next = head;
			head.previous = tail;
			length--;
			System.out.println("Node deleted from position : " + pos);
			return;
		}

		// case 6 : Position > 1 & less than last position
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
		// Case 1 : Linked List is empty
		if (length == 0) {
			System.out.println("Linked list is empty");
			return false;
		}

		// Case 2 : Node present in Linked List
		ListNode tempNode = head;
		while (tempNode.next != tail) {
			if (tempNode.data == data) {
				System.out.println("Element found in circular linked list!");
				return true;
			}
			tempNode = tempNode.next;
		}

		// Case 3 : Node not present in Linked List
		System.out.println("Element not found in circular linked list!");
		return false;
	}

	public void display() {
		// Case 1 : Linked List is empty
		if (length == 0) {
			System.out.println("Linked list is empty");
			return;
		}

		// Case 2 : Linked List contain only one node
		System.out.print("Displaying Circular Doubly Linked List : ");
		ListNode tempNode = head;
		if (head.next == head) {
			System.out.print(head.data + " ==> " + tempNode.data + "\n");
			return;
		}

		// Case 3 : Linked List contain more than one nodes
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

	public void createCircularDoublyLinkedList() {

	}

	public void sortLinkedList() {

	}

	public void insertAt(int position, int data) {

	}

	public void deleteAt(int position) {

	}

	public void deleteNode(int searchData) {

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

		c.deleteFromLast();
		c.display();

		c.deleteFromPos(1); // first position
		c.display();
		c.deleteFromPos(3); // middle position
		c.display();
		c.deleteFromPos(5); // last position
		c.display();
	}

}
