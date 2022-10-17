package com.dsa.queue;

//Refer this
//https://kalkicode.com/deque-implementation-using-doubly-linked-list
//https://www.youtube.com/watch?v=2ItzVMoenxI&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=85		
//https://www.youtube.com/watch?v=G81jTgSOf7g&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=86		
//https://www.youtube.com/watch?v=VMnsIC4kams&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=87		
//https://www.youtube.com/watch?v=yIwiRpIYwrU&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=88		
//https://www.youtube.com/watch?v=M4GdPUfH18k&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=89		
//https://www.youtube.com/watch?v=LPrPHjH5CWE&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=90		
//https://www.youtube.com/watch?v=incgHtVrYAk&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=91

class DequeueUsingSinglyLinkedList {

	private class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node front;
	private Node rear;
	private int size;

	public DequeueUsingSinglyLinkedList() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int isSize() {
		return (size);
	}

	// Refer
	// https://www.youtube.com/watch?v=VMnsIC4kams&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=87
	public void insertFront(int element) {
		Node newNode = new Node(element);
		newNode.next = this.front;
		if (front == null) {
			// Case 1 : Queue is empty. When inserting a first node of queue
			front = newNode;
			rear = newNode;
		} else {
			// Case 2 : Queue is not empty. Add node at beginning position
			newNode.next = front;
			front = newNode;
		}
		size++;
		System.out.println("Node inserted from Front!");
	}

	// Refer
	// https://www.youtube.com/watch?v=yIwiRpIYwrU&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=89
	public void insertRear(int element) {
		Node newNode = new Node(element);
		if (front == null) {
			// Case 1 : Queue is empty. When inserting a first node of queue
			front = newNode;
			rear = newNode;
		} else {
			// Case 2 : Queue is not empty. Add node at the end
			rear.next = newNode;
			rear = newNode;
		}
		size++;
		System.out.println("Node inserted from Rear!");
	}

	// Refer
	// https://www.youtube.com/watch?v=yIwiRpIYwrU&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=89
	public void deleteFront() {
		if (isEmpty() == true) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return;
		}
		// Case 2 : Queue is not empty
		Node tempNode = front;
		front = tempNode.next;
		if (front == null) {
			// Case 2A : Queue was having only one element. So, after deletion update Rear
			// as null
			rear = null;
		}
		size--;
		tempNode = null;
		System.out.println("Node deleted from Front!");
	}

	// Refer
	// https://www.youtube.com/watch?v=yIwiRpIYwrU&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=89
	public void deleteRear() {
		if (isEmpty() == true) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return;
		}
		// Case 2 : Queue is not empty
		Node tempNode = front;
		while (tempNode.next != rear) {
			tempNode = tempNode.next;
		}
		rear = tempNode;
		if (rear == null) {
			// Case 2A : Queue was having only one element. So, after deletion update Front
			// as null
			front = null;
		} else {
			rear.next = null;
		}
		size--;
		tempNode = null;
		System.out.println("Node deleted from Rear!");
	}

	public void display() {
		if (isEmpty() == true) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return;
		}
		Node node = front;
		System.out.println("Displaying Deque Element :");
		// Display node of from front to rear
		while (node != null) {
			System.out.print(" " + node.data);
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DequeueUsingSinglyLinkedList q = new DequeueUsingSinglyLinkedList();
		// Add Deque element
		// Add node at beginning position
		q.insertFront(1);
		q.display();

		q.insertFront(2);
		q.display();

		// Add node at last position
		q.insertRear(3);
		q.display();

		q.insertRear(4);
		q.display();

		// Add node at beginning position
		q.insertFront(5);
		q.display();

		q.insertFront(6);
		q.display();

		System.out.println("\n Size : " + q.isSize() + "\n");

		// Remove queue element
		q.deleteFront();
		q.display();

		q.deleteRear();
		q.display();

		System.out.println("\n Size : " + q.isSize() + "\n");

	}
}
