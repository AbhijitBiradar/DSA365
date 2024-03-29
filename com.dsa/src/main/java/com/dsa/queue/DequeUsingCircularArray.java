package com.dsa.queue;

// Refer 
// https://www.youtube.com/watch?v=WJres9mgiAk
// https://www.programiz.com/dsa/deque

class DequeUsingCircularArray {
	private int MAX = 100;
	private int arr[];
	private int front;
	private int rear;
	private int size;

	public DequeUsingCircularArray(int size) {
		this.arr = new int[MAX];
		this.front = -1;
		this.rear = 0;
		this.size = size;
	}

	public boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	public boolean isEmpty() {
		return (front == -1);
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void insertFromFront(int data) {
		if (isFull()) {
			// Case 1 : Queue is full
			System.out.println("\n Queue is full!");
			return;
		}

		if (front == -1) {
			// Case 2 : Queue is empty
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
		System.out.println("\n" + data + " Pushed from Front");
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void deleteFromFront() {
		if (isEmpty()) {
			// Case 1: Queue is empty
			System.out.println("\nQueue is empty!");
			return;
		}

		int deletedData = arr[front];
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
		System.out.println("\n" + deletedData + " Poped from Front");
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void insertFromRear(int data) {
		if (isFull()) {
			// Case 1: Queue is full
			System.out.println("\n Queue is full!");
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
		System.out.println("\n" + data + " Pushed from Rear");
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void deleteFromRear() {
		if (isEmpty()) {
			// Case 1: Queue is empty
			System.out.println("\nQueue is empty!");
			return;
		}

		int deletedData = arr[rear];
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
		System.out.println("\n" + deletedData + " Poped from Rear");
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public int getFront() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
			return (-1);
		} else {
			// Case 2 : Queue is not empty
			return arr[front];
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public int getRear() {
		if (isEmpty() || rear < 0) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
			return (-1);
		} else {
			// Case 2 : Queue is not empty
			return arr[rear];
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=WJres9mgiAk
	public void display() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
			return;
		} else {
			// Case 2 : Queue is not empty
			System.out.println("\nDisplaying Queue Elements:");
			System.out.println();
			int i = front;
			while (i != rear) {
				System.out.print(arr[i] + " ");
				i = (i + 1) % size;
			}
			System.out.print(arr[rear] + " ");
			System.out.println();
			System.out.println();
		}
	}

	public void displayFromFront() {

	}

	public void displayFromRear() {

	}

	public static void main(String[] args) {

		DequeUsingCircularArray dquca = new DequeUsingCircularArray(4);

		dquca.insertFromRear(1);
		dquca.display();
		System.out.println("Rear Element : " + dquca.getRear());

		dquca.insertFromRear(3);
		dquca.display();
		System.out.println("Rear Element : " + dquca.getRear());

		dquca.deleteFromRear();
		dquca.display();
		System.out.println("Rear Element : " + dquca.getRear());

		dquca.deleteFromRear();
		dquca.display();
		System.out.println("Rear Element : " + dquca.getRear());

		dquca.deleteFromRear();
		dquca.display();
		System.out.println("Rear Element : " + dquca.getRear());

		dquca.insertFromFront(5);
		dquca.display();
		System.out.println("Front Element: " + dquca.getFront());

		dquca.insertFromFront(7);
		dquca.display();
		System.out.println("Front Element: " + dquca.getFront());

		dquca.deleteFromFront();
		dquca.display();
		System.out.println("Front Element: " + dquca.getFront());

		dquca.deleteFromFront();
		dquca.display();
		System.out.println("Front Element: " + dquca.getFront());

		dquca.deleteFromFront();
		dquca.display();
		System.out.println("Front Element: " + dquca.getFront());
	}
}
