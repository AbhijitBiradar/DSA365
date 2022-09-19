package com.dsa.queue;

// Reference
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

	public void enQueue(int data) {
		Node tempNode = new Node(data);
		if (front == null) {
			front = tempNode;
		} else {
			rear.next = tempNode;
		}

		rear = tempNode;
		rear.next = front;
		System.out.println(data  +" data Inserted successfully!");
	}

	public int deQueue() {
		if (front == null) {
			System.out.printf("Queue is empty");
			return (-1);
		}

		// case 1: If this is the last node to be deleted
		int value; // Value to be dequeued
		if (front == rear) {
			value = front.data;
			front = null;
			rear = null;
		} else {
			// case 2: There are more than one nodes
			Node tempNode = front;
			value = tempNode.data;
			front = front.next;
			rear.next = front; // Not understood this line
		}
		System.out.println(value + " data deleted successfully!");
		return value;
	}

	public void display() {
		System.out.println("Displaying elements in Queue: ");
		Node tempNode = front;
		while (tempNode.next != front) {
			System.out.print(tempNode.data + "==> ");
			tempNode = tempNode.next;
		}
		System.out.println(tempNode.data);
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
