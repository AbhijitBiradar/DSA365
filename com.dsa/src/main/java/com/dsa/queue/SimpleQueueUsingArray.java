package com.dsa.queue;

// Reference
// https://www.programiz.com/dsa/queue
// https://www.youtube.com/watch?v=T0qUiI_L7S8		
// https://www.youtube.com/watch?v=bW2URZB61sg	
// https://www.youtube.com/watch?v=UQnbuAXjNtI	
// https://www.youtube.com/watch?v=YqrFeU90Coo

// Rules
// Rule 0 : Front is used for deletion purpose and Rear is used for insertion purpose
// Rule 1 : Initially, set value of FRONT and REAR to -1
// Rule 2 : While Enquing, Increase the REAR index by 1
// Rule 3 : While Dequing, increase the FRONT index by 1
// Rule 4 : While Dequing, for the last element, reset the values of Front and Rear to -1

public class SimpleQueueUsingArray {
	private int SIZE = 10;
	private int[] queue;
	private int front, rear;

	public SimpleQueueUsingArray() {
		front = -1;
		rear = -1;
		queue = new int[SIZE];
	}

	public boolean isFull() {
		return (front == 0 && rear == SIZE - 1);
	}

	public boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	public void enQueue(int element) {
		if (isFull()) {
			// Case 1: Queue is full
			System.out.println("Queue is already full!");
		} else {
			// Case 2: Queue is empty
			if (front == -1) {
				front = 0;
			}
			// Case 3: Queue contains some element
			rear++;
			queue[rear] = element;
			System.out.println("New Element Inserted : " + element);
		}
	}

	public int deQueue() {
		int deletedElement;
		if (isEmpty()) {
			// Case 1: Queue is empty
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			// Case 2: Queue is not empty
			deletedElement = queue[front];

			if (front >= rear) {
				// Case 2A: Queue is not empty & had only one element
				front = -1;
				rear = -1;
			} else {
				// Case 2B: Queue is not empty & had more than one element
				front++;
			}
			System.out.println("Element Deleted : " + deletedElement);
			return (deletedElement);
		}
	}

	public int peek() {
		if (isEmpty()) {
			// Case 1: Queue is empty
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			// Case 2: Queue is not empty
			return (queue[front]);
		}
	}

	public void display() {
		if (isEmpty()) {
			// Case 1: Queue is empty
			System.out.println("Empty Queue");
		} else {
			// Case 2: Queue is not empty
			System.out.println("Displaying queue elements:");

			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i] + "  ");
			}

			System.out.println("\nFront index : " + front);
			System.out.println("Rear index : " + rear);
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
