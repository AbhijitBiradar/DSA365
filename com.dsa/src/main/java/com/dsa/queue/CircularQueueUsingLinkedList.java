package com.dsa.queue;

// Reference
// https://www.youtube.com/watch?v=7LTEqqlHx8s

// Other Reference
// https://kalkicode.com/implement-circular-queue-using-linked-list
// https://www.geeksforgeeks.org/circular-queue-set-2-circular-linked-list-implementation/
// https://tutorialspoint.dev/data-structure/queue-data-structure/circular-queue-set-2-circular-linked-list-implementation
// http://www.cs.columbia.edu/~allen/S14/NOTES/CQueue.java.txt

class CircularQueueUsingLinkedList {

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node front;
	private Node rear;

	public CircularQueueUsingLinkedList() {
		this.front = null;
		this.rear = null;
	}

	// Refer
	// https://www.youtube.com/watch?v=7LTEqqlHx8s
	public void enQueue(int data) {
		Node newNode = new Node(data);
		if (front == null && rear == null) {
			// Case 1 : Queue is empty
			front = newNode;
			rear = newNode;
		} else {
			// Case 2 : Queue is not empty
			rear.next = newNode;
			rear = newNode;
		}
		rear.next = front; // This code is to make it circular connection
		System.out.println(data + " data Inserted successfully!");
	}

	// Refer
	// https://www.youtube.com/watch?v=7LTEqqlHx8s
	public int deQueue() {
		if (front == null) {
			// Case 1 : Queue is empty
			System.out.printf("Queue is empty");
			return (-1);
		}

		int value; // Value to be dequeued
		if (front == rear) {
			// Case 2A : If this is the last element to be deleted
			value = front.data;
			front = null;
			rear = null;
		} else {
			// Case 2B : There are more than one elements
			Node tempNode = front;
			value = tempNode.data;
			front = front.next;
			rear.next = front; // This code is to make it circular connection
		}
		System.out.println(value + " data deleted successfully!");
		return value;
	}

	// Refer
	// https://www.youtube.com/watch?v=7LTEqqlHx8s
	public void display() {
		System.out.println("Displaying elements in Queue: ");
		// Case 1 : Queue is empty
		if (front == null) {
			System.out.println("Queue is empty!");
		} else {
			// Case 2 : Queue is not empty
			Node tempNode = front;
			while (tempNode.next != front) {
				System.out.print(tempNode.data + " ==> ");
				tempNode = tempNode.next;
			}
			System.out.println(tempNode.data);
		}
	}

	public static void main(String args[]) {
		CircularQueueUsingLinkedList cqull = new CircularQueueUsingLinkedList();

		cqull.enQueue(14);
		cqull.enQueue(22);
		cqull.enQueue(6);

		cqull.display();

		System.out.println();
		cqull.deQueue();
		System.out.println();
		cqull.deQueue();
		System.out.println();

		cqull.display();

		cqull.enQueue(9);
		cqull.enQueue(20);
		cqull.display();
	}
}
