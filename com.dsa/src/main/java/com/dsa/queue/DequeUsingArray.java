package com.dsa.queue;

// Refer 
// https://www.youtube.com/watch?v=WJres9mgiAk
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

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void insertFromFront(int data) {
		if (isFull()) {
			// Case 1: Queue is full
			System.out.println("Deque is full!");
			return;
		}

		// Case 2: Queue is empty
		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (front == 0) {
			// Case 3 : Front is pointing to first element into queue
			front = size - 1;
		} else {
			// Case 4 : Front is in between of queue but not at first and last position
			front = front - 1;
		}
		arr[front] = data;
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void insertFromRear(int data) {
		if (isFull()) {
			// Case 1: Queue is full
			System.out.println(" Overflow ");
			return;
		}

		if (front == -1) {
			// Case 2: Queue is empty
			front = 0;
			rear = 0;
		} else if (rear == size - 1) {
			// Case 3 : Rear is pointing to last element into queue
			rear = 0;
		} else {
			// Case 4 : Rear is in between of queue but not at first and last position
			rear = rear + 1;
		}
		arr[rear] = data;
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void deleteFromFront() {
		if (isEmpty()) {
			// Case 1: Queue is empty
			System.out.println("Queue Underflow\n");
			return;
		}

		if (front == rear) {
			// Case 2: Queue is having only one element and both Front and Rear pointing to
			// that element
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			// Case 3 : Front is pointing to the last position in queue
			front = 0;
		} else {
			// Case 4 : Front is pointing in between the queue, not at first & last position
			front = front + 1;
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void deleteFromRear() {
		if (isEmpty()) {
			// Case 1: Queue is empty
			System.out.println(" Underflow");
			return;
		}

		if (front == rear) {
			// Case 2: Queue is having only one element and both Front and Rear pointing to
			// that element
			front = -1;
			rear = -1;
		} else if (rear == 0) {
			// Case 3 : Rear is pointing to the first (0) position in queue
			rear = size - 1;
		} else {
			// Case 4 : Rear is pointing in between the queue, not at first & last position
			rear = rear - 1;
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public int getFront() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println(" Underflow");
			return -1;
		}
		// Case 2 : Queue is not empty
		return arr[front];
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public int getRear() {
		if (isEmpty() || rear < 0) {
			// Case 1 : Queue is empty
			System.out.println(" Underflow\n");
			return -1;
		}
		// Case 2 : Queue is not empty
		return arr[rear];
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void display() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue Underflow\n");
			return;
		}

		// Case 2 : Queue is not empty
		int i = front;
		while (i != rear) {
			System.out.print(arr[i] + " ");
			i = (i + 1) % size;
		}
		System.out.print(arr[rear] + " ");
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
