package com.dsa.queue;

// Refer
// https://www.youtube.com/watch?v=7LTEqqlHx8s

// Other Reference
// https://kalkicode.com/implement-circular-queue-using-linked-list
// https://www.geeksforgeeks.org/circular-queue-set-2-circular-linked-list-implementation/
// https://tutorialspoint.dev/data-structure/queue-data-structure/circular-queue-set-2-circular-linked-list-implementation
// http://www.cs.columbia.edu/~allen/S14/NOTES/CQueue.java.txt

class CircularQueueUsingSinglyLinkedList {

	private Node front;
	private Node rear;

	public CircularQueueUsingSinglyLinkedList() {
		this.front = null;
		this.rear = null;
	}

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return front == null;
	}
	
	public Node getFront() {
		return front;
	}
	
	public Node getRear() {
		return rear;
	}

	// Refer
	// https://www.youtube.com/watch?v=7LTEqqlHx8s
	public void display() {
		// Case 1 : Queue is empty
		if (front == null) {
			System.out.println("\nQueue is empty!");
		} else {
			// Case 2 : Queue is not empty
			System.out.println("\nDisplaying elements in Queue: ");
			Node tempNode = front;
			while (tempNode.next != front) {
				System.out.print(tempNode.data + " ==> ");
				tempNode = tempNode.next;
			}
			System.out.println(tempNode.data);
		}
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
		System.out.println("\n" + data + " data Inserted successfully!");
	}

	// Refer
	// https://www.youtube.com/watch?v=7LTEqqlHx8s
	public int deQueue() {
		if (front == null) {
			// Case 1 : Queue is empty
			System.out.printf("\nQueue is empty");
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
		System.out.println("\n" + value + " data deleted successfully!");
		return value;
	}

	public static void main(String args[]) {
		CircularQueueUsingSinglyLinkedList cqull = new CircularQueueUsingSinglyLinkedList();

		cqull.enQueue(1);
		cqull.display();

		cqull.enQueue(3);
		cqull.display();

		cqull.enQueue(5);
		cqull.display();

		cqull.deQueue();
		cqull.display();

		cqull.deQueue();
		cqull.display();

		cqull.deQueue();
		cqull.display();

		cqull.enQueue(7);
		cqull.display();

		cqull.enQueue(9);
		cqull.display();
	}
}
