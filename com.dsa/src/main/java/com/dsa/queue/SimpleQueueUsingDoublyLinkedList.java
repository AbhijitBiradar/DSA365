package com.dsa.queue;

//Refer this
// https://kalkicode.com/implement-queue-using-doubly-linked-list-in-java

public class SimpleQueueUsingDoublyLinkedList {

	public QNode front;
	public QNode rear;
	public int size;

	public SimpleQueueUsingDoublyLinkedList() {
		this.front = null;
		this.rear = null;
	}

	private class QNode {
		public int data;
		public QNode next;
		public QNode prev;

		public QNode(int data, QNode prev) {
			this.data = data;
			this.next = null;
			this.prev = prev;
		}
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int isSize() {
		return this.size;
	}

	// Print elements of queue
	public void printQdata() {
		QNode node = this.front;
		System.out.println("\n Queue Element");
		while (node != null) {
			System.out.print(" " + node.data);
			node = node.next;
		}
		System.out.println();
	}

	// Get a front element of queue
	public int peek() {
		if (this.isEmpty() == true) {
			System.out.println("\n Empty Queue");
			// When stack is empty
			return -1;
		} else {
			return this.front.data;
		}
	}

	// Add a node into queue
	public void enqueue(int data) {
		// Create a new node
		QNode node = new QNode(data, this.rear);
		if (this.front == null) {
			// When adding a first node of queue
			this.front = node;
			this.size = 1;
		} else {
			this.rear.next = node;
			this.size = this.size + 1;
		}
		this.rear = node;
	}

	// Remove a front node of a queue
	public int dequeue() {
		if (this.isEmpty() == true) {
			// When queue is empty
			return -1;
		} else {
			int data = this.peek();
			QNode temp = this.front;
			if (this.front == this.rear) {
				// When queue contains only one node
				this.rear = null;
				this.front = null;
			} else {
				this.front = this.front.next;
				this.front.prev = null;
			}
			// Change queue size
			this.size--;
			// Delete node value
			return data;
		}
	}

	public static void main(String[] args) {
		SimpleQueueUsingDoublyLinkedList q = new SimpleQueueUsingDoublyLinkedList();
		// Add queue element
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.printQdata();
		System.out.print(" Size : " + q.isSize());
		// Remove queue element
		System.out.print("\n Dequeue Node : " + q.dequeue());
		System.out.print("\n Dequeue Node : " + q.dequeue());
		System.out.print("\n Dequeue Node : " + q.dequeue());
		q.printQdata();
		System.out.print(" Size : " + q.isSize());
	}
}
