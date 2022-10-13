package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

// Refer
// https://www.sanfoundry.com/java-program-implement-stack-using-two-queues/

// https://www.youtube.com/watch?v=SgQ0VV3eM7Q
// https://www.youtube.com/watch?v=XTouyMSE0Y8
// https://www.youtube.com/watch?v=mDcP7tLuBhc

public class StackUsingTwoQueues {

	private Queue<Integer> mainQueue;
	private Queue<Integer> tempQueue;

	public StackUsingTwoQueues() {
		mainQueue = new LinkedList<Integer>();
		tempQueue = new LinkedList<Integer>();
	}

	public void push(int data) {
		// Case 1 : if no element is present in queue q then enqueue the new element
		// into mainQueue
		if (mainQueue.size() == 0) {
			mainQueue.add(data);
		} else {
			// Case 1 : if elements are present in q then dequeue all the elements to
			// temporary queue tempQueue

			int size = mainQueue.size();
			for (int i = 0; i < size; i++) {
				tempQueue.add(mainQueue.remove());
			}

			// enqueue the new element into q
			mainQueue.add(data);

			// dequeue all the elements from temporary queue tmp to q
			for (int i = 0; i < size; i++) {
				mainQueue.add(tempQueue.remove());
			}
		}
		System.out.println("\n" + data + " Pushed into Stack successfully!");
	}

	public int pop() {
		if (mainQueue.size() == 0) {
			// Case 1 : Stack is empty
			System.out.println("Stack is empty!");
			return -1;
		} else {
			// Case 2 : Stack is not empty
			int data = mainQueue.remove();
			System.out.println("\n" + data + " Popped from Stack successfully!");
			return data;
		}
	}

	public int peek() {
		if (mainQueue.size() == 0) {
			// Case 1 : Stack is empty
			System.out.println("Stack is empty!");
			return -1;
		} else {
			// Case 2 : Stack is not empty
			return mainQueue.peek();
		}
	}

	public boolean isEmpty() {
		return mainQueue.size() == 0;
	}

	public int size() {
		return mainQueue.size();
	}

	public void display() {
		if (size() == 0) {
			// Case 1 : Stack is empty
			System.out.println("Stack is empty!");
			return;
		} else {
			// Case 2 : Stack is not empty
			System.out.println("Displaying elements from Stack: ");
			System.out.println(mainQueue);
		}
	}

	public static void main(String[] args) {
		StackUsingTwoQueues sutq = new StackUsingTwoQueues();

		sutq.push(1);
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.push(3);
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.push(5);
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.push(7);
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.push(9);
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.pop();
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.pop();
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.pop();
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.pop();
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.pop();
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

		sutq.pop();
		sutq.display();
		System.out.println("Top : " + sutq.peek());
		System.out.println("Size : " + sutq.size());

	}

}
