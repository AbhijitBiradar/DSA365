package com.dsa.queue;

// Refer
// https://www.youtube.com/watch?v=lPdSHEh8LiU
// https://www.programiz.com/dsa/circular-queue

public class CircularQueueUsingArray {
	private int SIZE = 5;
	private int front, rear;
	private int queue[];

	public CircularQueueUsingArray() {
		front = -1;
		rear = -1;
		queue = new int[SIZE];
	}

	public boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	public boolean isFull() {
		if (front == 0 && rear == SIZE - 1) {
			return true;
		}

		if (front == rear + 1) {
			return true;
		}

		return false;
	}

	public int getFront() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return -1;
		} else {
			// Case 2 : Queue is not empty
			return queue[front];
		}
	}

	public int getRear() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return -1;
		} else {
			// Case 2 : Queue is not empty
			return queue[rear];
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=lPdSHEh8LiU
	public void display() {
		int i;
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
		} else {
			// Case 2 : Queue is not empty
			System.out.println("\nDisplaying Queue Elements: ");
			for (i = front; i != rear; i = (i + 1) % SIZE) {
				System.out.print(queue[i] + " ==> ");
			}
			System.out.println(queue[i]);

			System.out.println("Front and Rear Position : ");
			System.out.println("Front : " + queue[front]);
			System.out.println("Rear : " + queue[rear]);

			System.out.println();
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=lPdSHEh8LiU
	public void enQueue(int element) {
		if (isFull()) {
			// Case 1 : Queue is full
			System.out.println("\nQueue is full");
		} else {
			if (front == -1) {
				// Case 2A : Queue is empty & this is first element
				front = 0;
			}
			// Case 2B : Queue is not empty & have more than one element
			rear = (rear + 1) % SIZE;
			queue[rear] = element;
			System.out.println("\nInserted " + element + " into Queue");
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=lPdSHEh8LiU
	public int deQueue() {
		int deletedElement;
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty");
			return (-1);
		} else {
			deletedElement = queue[front];
			if (front == rear) {
				// Case 2A : Queue is having only one element
				front = -1;
				rear = -1;
			} else {
				// Case 2B : Queue is having more than one element
				front = (front + 1) % SIZE;
			}
			System.out.println("Deleted " + deletedElement + "from queue ");
			return (deletedElement);
		}
	}

	public static void main(String[] args) {

		CircularQueueUsingArray cqua = new CircularQueueUsingArray();

		// Fails because front = -1
		cqua.deQueue();

		cqua.enQueue(1);
		cqua.display();

		cqua.enQueue(3);
		cqua.display();

		cqua.enQueue(5);
		cqua.display();

		cqua.enQueue(7);
		cqua.display();

		cqua.enQueue(9);
		cqua.display();

		// Fails to enqueue because front == 0 && rear == SIZE - 1
		cqua.enQueue(11);
		cqua.display();

		int element = cqua.deQueue();
		if (element != -1) {
			System.out.println("Deleted Element is " + element);
		}
		cqua.display();

		cqua.enQueue(13);
		cqua.display();

		// Fails to enqueue because front == rear + 1
		cqua.enQueue(15);
		cqua.display();
	}
}
