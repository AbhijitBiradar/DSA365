package com.dsa.queue;

// Reference
// https://www.programiz.com/dsa/circular-queue
// https://www.youtube.com/watch?v=TPsNjRJYTEQ
// https://www.youtube.com/watch?v=lPL-pmBm04Q
// https://www.youtube.com/watch?v=lPdSHEh8LiU

public class CircularQueueUsingArray {
	int SIZE = 5; // Size of Circular Queue
	int front, rear;
	int items[] = new int[SIZE];

	CircularQueueUsingArray() {
		front = -1;
		rear = -1;
	}

	// Check if the queue is full
	boolean isFull() {
		if (front == 0 && rear == SIZE - 1) {
			return true;
		}
		if (front == rear + 1) {
			return true;
		}
		return false;
	}

	// Check if the queue is empty
	boolean isEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}

	// Adding an element
	void enQueue(int element) {
		if (isFull()) {
			System.out.println("Queue is full");
		} else {
			if (front == -1) {
				front = 0;
			}
			rear = (rear + 1) % SIZE;
			items[rear] = element;
			System.out.println("Inserted " + element);
		}
	}

	// Removing an element
	int deQueue() {
		int element;
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return (-1);
		} else {
			element = items[front];

			/* Q has only one element, so we reset the queue after deleting it. */
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				front = (front + 1) % SIZE;
			}
			return (element);
		}
	}

	void display() {
		/* Function to display status of Circular Queue */
		int i;
		if (isEmpty()) {
			System.out.println("Empty Queue");
		} else {
			System.out.println("Front -> " + front);
			System.out.println("Items -> ");
			for (i = front; i != rear; i = (i + 1) % SIZE)
				System.out.print(items[i] + " ");
			System.out.println(items[i]);
			System.out.println("Rear -> " + rear);
		}
	}

	public static void main(String[] args) {

		CircularQueueUsingArray cqua = new CircularQueueUsingArray();

		// Fails because front = -1
		cqua.deQueue();

		cqua.enQueue(1);
		cqua.enQueue(2);
		cqua.enQueue(3);
		cqua.enQueue(4);
		cqua.enQueue(5);

		// Fails to enqueue because front == 0 && rear == SIZE - 1
		cqua.enQueue(6);

		cqua.display();

		int elem = cqua.deQueue();

		if (elem != -1) {
			System.out.println("Deleted Element is " + elem);
		}
		cqua.display();

		cqua.enQueue(7);

		cqua.display();

		// Fails to enqueue because front == rear + 1
		cqua.enQueue(8);
	}

}
