package com.dsa.queue;

// Reference
// https://kalkicode.com/implement-circular-queue-using-linked-list
// https://www.geeksforgeeks.org/circular-queue-set-2-circular-linked-list-implementation/
// https://tutorialspoint.dev/data-structure/queue-data-structure/circular-queue-set-2-circular-linked-list-implementation
// http://www.cs.columbia.edu/~allen/S14/NOTES/CQueue.java.txt

class CircularQueueUsingLinkedList {

	// Structure of a Node
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

	// Function to create Circular queue
	void enQueue(int data) {
		Node tempNode = new Node(data);
		if (front == null) {
			front = tempNode;
		} else {
			rear.next = tempNode;
		}

		rear = tempNode;
		rear.next = front;
	}

	// Function to delete element from Circular Queue
	int deQueue() {
		if (front == null) {
			System.out.printf("Queue is empty");
			return Integer.MIN_VALUE;
		}

		// If this is the last node to be deleted
		int value; // Value to be dequeued
		if (front == rear) {
			value = front.data;
			front = null;
			rear = null;
		} else {
			// There are more than one nodes
			Node tempNode = front;
			value = tempNode.data;
			front = front.next;
			rear.next = front;
		}
		return value;
	}

	// Function displaying the elements of Circular Queue
	void displayQueue() {
		Node tempNode = front;
		System.out.printf("\nElements in Circular Queue are: ");
		while (tempNode.next != front) {
			System.out.printf("%d ", tempNode.data);
			tempNode = tempNode.next;
		}
		System.out.printf("%d", tempNode.data);
	}

	/* Driver of the program */
	public static void main(String args[]) {
		CircularQueueUsingLinkedList cqull = new CircularQueueUsingLinkedList();

		// Inserting elements in Circular Queue
		cqull.enQueue(14);
		cqull.enQueue(22);
		cqull.enQueue(6);

		// Display elements present in Circular Queue
		cqull.displayQueue();

		// Deleting elements from Circular Queue
		System.out.printf("\nDeleted value = %d", cqull.deQueue());
		System.out.printf("\nDeleted value = %d", cqull.deQueue());

		// Remaining elements in Circular Queue
		cqull.displayQueue();

		cqull.enQueue(9);
		cqull.enQueue(20);
		cqull.displayQueue();
	}
}
