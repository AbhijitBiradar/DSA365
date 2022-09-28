package com.dsa.queue;

import java.util.*;

// Refer
// https://www.geeksforgeeks.org/priority-queue-set-1-introduction/

class PriorityQueueUsingArray {
	private class item {
		private int value;
		private int priority;
	}

	private item[] priorityQueue = new item[100000];
	private int size = -1;

	public boolean isEmpty() {
		return (size == -1);
	}

	public boolean isFull() {
		return (size == priorityQueue.length - 1);
	}

	// Refer
	// https://www.geeksforgeeks.org/priority-queue-set-1-introduction/
	public void enqueue(int value, int priority) {
		if (isFull()) {
			System.out.println("Queue is full!");
		} else {
			size++;
			priorityQueue[size] = new item();
			priorityQueue[size].value = value;
			priorityQueue[size].priority = priority;

			System.out.println("New value enqued with Value : " + value + " Priority : " + priority);
		}
	}

	// Refer
	// https://www.geeksforgeeks.org/priority-queue-set-1-introduction/

	// Function to remove the element with the highest priority
	public void dequeue() {

		if (isEmpty()) {
			System.out.println("Queue is empty!");
		} else {
			int index = peek(); // Find the position of the element with highest priority

			// Shift the element one index before from the position of the element with
			// highest priority is found
			for (int i = index; i < size; i++) {
				priorityQueue[i] = priorityQueue[i + 1];
			}

			// Decrease the size of the priority queue by one
			size--;

			System.out.println("Value Dequed!");
		}
	}

	// Function to check the top element
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			int highestPriority = Integer.MIN_VALUE;
			int index = -1;

			// Check for the element with highest priority
			for (int i = 0; i <= size; i++) {

				// If priority is same choose the element with the highest value
				if (highestPriority == priorityQueue[i].priority && index > -1
						&& priorityQueue[index].value < priorityQueue[i].value) {
					highestPriority = priorityQueue[i].priority;
					index = i;
				} else if (highestPriority < priorityQueue[i].priority) {
					highestPriority = priorityQueue[i].priority;
					index = i;
				}
			}

			// Return position of the element
			return index;
		}
	}

	// Function to return value of specific index
	public int getPriorityValue(int index) {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			return (priorityQueue[index].value);
		}
	}

	public static void main(String[] args) {

		PriorityQueueUsingArray pqa = new PriorityQueueUsingArray();
		// Function Call to insert elements as per the priority
		pqa.enqueue(10, 2);
		pqa.enqueue(14, 4);
		pqa.enqueue(16, 4);
		pqa.enqueue(12, 3);

		// Stores the top element at the moment
		int index = pqa.peek();

		System.out.println("Value at Peek with highest Priority: " + pqa.getPriorityValue(index));

		// Dequeue the top element
		pqa.dequeue();

		// Check the top element
		index = pqa.peek();
		System.out.println("Value at Peek with highest Priority: " + pqa.getPriorityValue(index));

		// Dequeue the top element
		pqa.dequeue();

		// Check the top element
		index = pqa.peek();
		System.out.println("Value at Peek with highest Priority: " + pqa.getPriorityValue(index));
	}
}
