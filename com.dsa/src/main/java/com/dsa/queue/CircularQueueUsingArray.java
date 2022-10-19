package com.dsa.queue;

// Reference
// https://www.youtube.com/watch?v=lPdSHEh8LiU
// https://www.programiz.com/dsa/circular-queue

public class CircularQueueUsingArray {
	private int SIZE = 5;
	private int front, rear;
	private int items[] = new int[SIZE];

	public CircularQueueUsingArray() {
		front = -1;
		rear = -1;
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

	public boolean isEmpty() {
		if (front == -1) {
			return true;
		} else {
			return false;
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=lPdSHEh8LiU
	public void enQueue(int element) {
		if (isFull()) {
			// Case 1 : Queue is full
			System.out.println("Queue is full");
		} else {
			if (front == -1) {
				// Case 2A : Queue is empty & this is first element
				front = 0;
			}
			// Case 2B : Queue is not empty & have more than one element
			rear = (rear + 1) % SIZE;
			items[rear] = element;
			System.out.println("Inserted " + element);
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=lPdSHEh8LiU
	public int deQueue() {
		int element;
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty");
			return (-1);
		} else {
			element = items[front];
			if (front == rear) {
				// Case 2A : Queue is having only one element
				front = -1;
				rear = -1;
			} else {
				// Case 2B : Queue is having more than one element
				front = (front + 1) % SIZE;
			}
			return (element);
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
			for (i = front; i != rear; i = (i + 1) % SIZE) {
				System.out.print(items[i] + " ");
			}
			System.out.println(items[i]);
			System.out.println("Front : " + front);
			System.out.println("Rear : " + rear);
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

		int element = cqua.deQueue();

		if (element != -1) {
			System.out.println("Deleted Element is " + element);
		}
		cqua.display();

		cqua.enQueue(7);

		cqua.display();

		// Fails to enqueue because front == rear + 1
		cqua.enQueue(8);
	}

}
