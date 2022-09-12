package com.dsa.queue;

// Reference
// https://www.geeksforgeeks.org/queue-linked-list-implementation/
// https://www.youtube.com/watch?v=Bf-P7TGD6QU
// https://kkjavatutorials.com/queue-implementation-using-linkedlist-in-java/

class SimpleQueueUsingLinkedList {

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node front;
	private Node rear;
	private int length;

	public SimpleQueueUsingLinkedList() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	public void enqueue(int data) {
		Node newNode = new Node(data);

		// If queue is empty, then new node is front and rear both
		if (isEmpty()) {
			rear = newNode;
			front = rear;
			return;
		}

		// Add the new node at the end of queue and change rear
		rear.next = newNode;
		rear = rear.next;
		length++;
	}

	public void dequeue() {
		// If queue is empty, return NULL.
		if (isEmpty()) {
			return;
		}

		// Store previous front and move front one node ahead
		Node tempNode = front;
		front = front.next;

		// If front becomes NULL, then change rear also as NULL
		if (front == null) {
			rear = null;
		}
		length--;
	}

	public int peek() {
		if (front == null) {
			return (-1);
		} else {
			return (front.data);
		}
	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return (front == null);
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Empty Queue");
		} else {
			System.out.println("Displaying elements from Queue: ");
			Node tempNode = front;
			while (tempNode != rear) {
				System.out.print(tempNode.data + "==> ");
				tempNode = tempNode.next;
			}
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		SimpleQueueUsingLinkedList squll = new SimpleQueueUsingLinkedList();

		squll.enqueue(10);
		squll.enqueue(20);

		squll.dequeue();
		squll.dequeue();

		squll.enqueue(30);
		squll.enqueue(40);
		squll.enqueue(50);

		squll.dequeue();

		System.out.println("Queue Front : " + squll.front.data);
		System.out.println("Queue Rear : " + squll.rear.data);
	}
}
