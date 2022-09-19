package com.dsa.queue;

// Refer 
// https://www.programiz.com/dsa/deque

class DequeUsingArray {
	private int MAX = 100;
	private int arr[];
	private int front;
	private int rear;
	private int size;

	public DequeUsingArray(int size) {
		arr = new int[MAX];
		front = -1;
		rear = 0;
		this.size = size;
	}

	boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	boolean isEmpty() {
		return (front == -1);
	}

	// Not understood this code
	void insertFromFront(int key) {
		if (isFull()) {
			System.out.println("Deque is full!");
			return;
		}

		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (front == 0) {
			front = size - 1;
		} else {
			front = front - 1;
		}
		arr[front] = key;
	}

	// Not understood this code
	void insertFromRear(int key) {
		if (isFull()) {
			System.out.println(" Overflow ");
			return;
		}

		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (rear == size - 1) {
			rear = 0;
		} else {
			rear = rear + 1;
		}
		arr[rear] = key;
	}

	// Not understood this code
	void deleteFromFront() {
		if (isEmpty()) {
			System.out.println("Queue Underflow\n");
			return;
		}

		// Deque has only one element
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else {
			front = front + 1;
		}
	}

	// Not understood this code
	void deleteFromRear() {
		if (isEmpty()) {
			System.out.println(" Underflow");
			return;
		}

		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (rear == 0) {
			rear = size - 1;
		} else {
			rear = rear - 1;
		}
	}

	int getFront() {
		if (isEmpty()) {
			System.out.println(" Underflow");
			return -1;
		}
		return arr[front];
	}

	int getRear() {
		if (isEmpty() || rear < 0) {
			System.out.println(" Underflow\n");
			return -1;
		}
		return arr[rear];
	}

	public static void main(String[] args) {

		DequeUsingArray dq = new DequeUsingArray(4);

		System.out.println("Insert element at rear end : 12 ");
		dq.insertFromRear(12);

		System.out.println("insert element at rear end : 14 ");
		dq.insertFromRear(14);

		System.out.println("get rear element : " + dq.getRear());

		dq.deleteFromRear();
		System.out.println("After delete rear element new rear become : " + dq.getRear());

		System.out.println("inserting element at front end");
		dq.insertFromFront(13);

		System.out.println("get front element: " + dq.getFront());

		dq.deleteFromFront();

		System.out.println("After delete front element new front become : " + +dq.getFront());

	}
}
