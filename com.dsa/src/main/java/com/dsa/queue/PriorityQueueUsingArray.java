package com.dsa.queue;

// Refer
// https://www.geeksforgeeks.org/priority-queue-set-1-introduction/
// https://dzone.com/articles/the-priority-queue

class PriorityQueueUsingArray {

	private item[] priorityQueue;
	private int size;

	public PriorityQueueUsingArray() {
		this.priorityQueue = new item[100];
		this.size = -1;
	}

	private class item {
		private int value;
		private int priority;

		public item() {
			this.value = 0;
			this.priority = 0;
		}
	}

	public boolean isEmpty() {
		return (size == -1);
	}

	public boolean isFull() {
		return (size == priorityQueue.length - 1);
	}

	// Function to return value of specific index
	public int getValueAtIndex(int index) {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
			return (-1);
		} else {
			// Case 2 : Queue is not empty
			return (priorityQueue[index].value);
		}
	}

	// Refer
	// https://www.geeksforgeeks.org/priority-queue-set-1-introduction/
	public void enqueue(int value, int priority) {
		if (isFull()) {
			// Case 1 : Queue is full
			System.out.println("\nQueue is full!");
		} else {
			// Case 2 : Queue is not full
			size++;
			priorityQueue[size] = new item();
			priorityQueue[size].value = value;
			priorityQueue[size].priority = priority;

			System.out.println("\nNew value enqued with Value : " + value + " Priority : " + priority);
		}
	}

	// Function to check the top element
	public int peek() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			// Case 2 : Queue is not empty
			int highestPriority = Integer.MIN_VALUE;
			int index = -1;

			// Check for the element with highest priority
			for (int i = 0; i <= size; i++) {
				// If priority is same for more than one element then choose the element with
				// the highest value
				if ((highestPriority == priorityQueue[i].priority && index > -1)
						&& (priorityQueue[index].value < priorityQueue[i].value)) {
					// Case 2A : Priority is same for two element
					highestPriority = priorityQueue[i].priority;
					index = i;
				} else if (highestPriority < priorityQueue[i].priority) {
					// Case 2B : Priority is not same for two element
					highestPriority = priorityQueue[i].priority;
					index = i;
				}
			}

			// Return position of the element
			return index;
		}
	}

	// Refer
	// https://www.geeksforgeeks.org/priority-queue-set-1-introduction/
	// Function to remove the element with the highest priority
	public void dequeue() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
		} else {
			// Case 2 : Queue is not empty
			int index = peek(); // Find the position of the element with highest priority

			// Shift the element one index before from the position of the element with
			// highest priority is found
			for (int i = index; i < size; i++) {
				priorityQueue[i] = priorityQueue[i + 1];
			}

			// Decrease the size of the priority queue by one
			size--;

			System.out.println("\nValue Dequed!");
		}
	}

	public void display() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
		} else {
			// Case 2 : Queue is not empty
			System.out.println("\nDisplaying Queue Elements: ");
			System.out.println();
			for (int i = 0; i <= size; i++) {
				System.out.println("Value : " + priorityQueue[i].value + " Priority : " + priorityQueue[i].priority);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		PriorityQueueUsingArray pqa = new PriorityQueueUsingArray();

		pqa.enqueue(10, 2);
		pqa.display();
		int index = pqa.peek();
		System.out.println("\nValue at Peek with highest Priority: " + pqa.getValueAtIndex(index));

		pqa.enqueue(14, 4);
		pqa.display();
		index = pqa.peek();
		System.out.println("\nValue at Peek with highest Priority: " + pqa.getValueAtIndex(index));

		pqa.enqueue(16, 4);
		pqa.display();
		index = pqa.peek();
		System.out.println("\nValue at Peek with highest Priority: " + pqa.getValueAtIndex(index));

		pqa.enqueue(12, 3);
		pqa.display();
		index = pqa.peek();
		System.out.println("\nValue at Peek with highest Priority: " + pqa.getValueAtIndex(index));

		pqa.dequeue(); // Dequeue Highest Priority element
		pqa.display();
		index = pqa.peek();
		System.out.println("\nValue at Peek with highest Priority: " + pqa.getValueAtIndex(index));

		pqa.dequeue(); // Dequeue Highest Priority element
		pqa.display();
		index = pqa.peek();
		System.out.println("\nValue at Peek with highest Priority: " + pqa.getValueAtIndex(index));
	}
}
