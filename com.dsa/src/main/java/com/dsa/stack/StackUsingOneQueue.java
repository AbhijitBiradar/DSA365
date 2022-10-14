package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

// Refer
// https://www.youtube.com/watch?v=VT7yfBG1_F8
// https://www.geeksforgeeks.org/implement-a-stack-using-single-queue/
// https://www.tutorialcup.com/interview/stack/implement-a-stack-using-single-queue.htm

public class StackUsingOneQueue {

	private Queue<Integer> intQueue;

	StackUsingOneQueue() {
		this.intQueue = new LinkedList<Integer>();
	}

	public void push(int newData) {
		// get current size of queue
		int size = intQueue.size();

		// Add new element
		intQueue.add(newData);

		// Pop (or Dequeue) all old elements and add after new element
		for (int i = 0; i < size; i++) {
			int queueData = intQueue.remove();
			intQueue.add(queueData);
		}

		System.out.println("\n" + newData + " Pushed into Stack successfully!");
	}

	public int pop() {
		// Case 1 : Stack is empty
		if (intQueue.isEmpty()) {
			System.out.println("Stack is empty!");
			return -1;
		}

		// Case 2 : Stack is not empty
		int queueData = intQueue.remove();
		System.out.println("\n" + queueData + " Popped from Stack successfully!");

		return queueData;
	}

	public int top() {
		if (intQueue.isEmpty()) {
			// Case 1 : Stack is empty
			return -1;
		} else {
			// Case 2 : Stack is not empty
			return intQueue.peek();
		}
	}

	public boolean isEmpty() {
		return intQueue.isEmpty();
	}

	public int size() {
		return intQueue.size();
	}

	public void printStack() {
		if (isEmpty()) {
			// Case 1 : Stack is empty
			System.out.println("Stack is empty!");
			return;
		} else {
			// Case 2 : Stack is not empty
			System.out.println("Displaying elements from Stack: ");
			System.out.println(intQueue);
		}
	}

	public static void main(String[] args) {
		StackUsingOneQueue suoq = new StackUsingOneQueue();

		suoq.push(10);
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.push(20);
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.push(30);
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.push(40);
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.push(50);
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.pop();
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.pop();
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.pop();
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.pop();
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.pop();
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());

		suoq.pop();
		suoq.printStack();
		System.out.println("Top : " + suoq.top());
		System.out.println("Size : " + suoq.size());
	}
}
