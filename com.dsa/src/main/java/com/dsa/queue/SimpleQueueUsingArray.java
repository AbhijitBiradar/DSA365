package com.dsa.queue;

// Reference
// https://www.programiz.com/dsa/queue

// Rule 0 : Initially, set value of FRONT and REAR to -1
// Rule 1 : While Enquing, Increase the REAR index by 1
// Rule 2 : While Dequing, increase the FRONT index by 1
// Rule 3 : While Dequing, for the last element, reset the values of FRONT and REAR to -1

public class SimpleQueueUsingArray {
	private int SIZE = 10;
	private int items[] = new int[SIZE];
	private int front, rear;

	public SimpleQueueUsingArray() {
		front = -1;
		rear = -1;
	}

	public boolean isFull() {
		if (front == 0 && rear == SIZE - 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (front == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void enQueue(int element) {
		if (isFull()) {
			System.out.println("Queue is already full!");
		} else {
			if (front == -1) {
				front = 0;
			}
			rear++;
			items[rear] = element;
			System.out.println("New Element Inserted :" + element);
		}
	}

	public int deQueue() {
		int element;
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			element = items[front];

			if (front >= rear) {
				/* Q has only one element, so we reset the queue after deleting it. */
				front = -1;
				rear = -1;
			} else {
				front++;
			}
			System.out.println("Element Deleted : " + element);
			return (element);
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			return (items[front]);
		}
	}

	public void display() {
		/* Function to display elements of Queue */
		int i;
		if (isEmpty()) {
			System.out.println("Empty Queue");
		} else {
			System.out.println("Displaying queue elements:");

			for (i = front; i <= rear; i++) {
				System.out.print(items[i] + "  ");
			}

			System.out.println("\nFront index : " + front);
			System.out.println("\nRear index : " + rear);
		}
	}

	public static void main(String[] args) {
		SimpleQueueUsingArray squa = new SimpleQueueUsingArray();

		// deQueue is not possible on empty queue
		squa.deQueue();

		// enQueue 5 elements
		squa.enQueue(1);
		squa.enQueue(2);
		squa.enQueue(3);
		squa.enQueue(4);
		squa.enQueue(5);

		System.out.println("Peek : " + squa.peek());

		// 6th element can't be added to because the queue is full
		squa.enQueue(6);

		System.out.println("Peek : " + squa.peek());

		squa.display();

		// deQueue removes element entered first i.e. 1
		squa.deQueue();

		System.out.println("Peek : " + squa.peek());

		// Now we have just 4 elements
		squa.display();
	}
}
