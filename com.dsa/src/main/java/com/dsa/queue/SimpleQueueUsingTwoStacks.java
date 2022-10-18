package com.dsa.queue;

// Refer
// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s

public class SimpleQueueUsingTwoStacks {

	private int[] stack1;
	private int[] stack2;

	private int count = 0;
	private int size = 0;

	int top1 = -1;
	int top2 = -1;

	public boolean isEmpty() {
		return (top1 == -1 && top2 == -1);
	}

	public boolean isFull() {
		return (top1 == size - 1 && top2 == size - 1);
	}

	public int size() {
		return count;
	}

	public int peek() {
		return top1;
	}

	public SimpleQueueUsingTwoStacks(int size) {
		stack1 = new int[size];
		stack2 = new int[size];
		this.size = size;
	}

	public void enqueue(int data) {
		pushToStack1(data);
		count++;
		System.out.println(data + " pushed into Queue successfully!");
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	private void pushToStack1(int data) {
		if (isFull()) {
			System.out.println("Queue is Full!");
			return;
		} else {
			top1++;
			stack1[top1] = data;
		}

	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
		} else {
			for (int i = 0; i < count; i++) {
				// Step 1: Pop each item from Stack1
				int data = popFromStack1();
				// Step 2: Push each item into Stack2
				pushToStack2(data);
				// Step 3 : Delete item
				int deletedData = popFromStack2();
				System.out.println("Poped data: " + deletedData);
				System.out.println(deletedData + " Poped from Queue successfully!");
			}

			count--;

			for (int i = 0; i < count; i++) {
				int data = popFromStack2();
				pushToStack1(data);
			}
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	private int popFromStack1() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return -1;
		} else {
			return (stack1[top1--]);
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	private void pushToStack2(int data) {
		if (isFull()) {
			System.out.println("Queue is Full!");
			return;
		} else {
			top2++;
			stack1[top2] = data;
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	private int popFromStack2() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return -1;
		} else {
			return (stack2[top2--]);
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	public void display() {
		for (int i = 0; i <= top1; i++) {
			System.out.print(stack1[i] + " ");
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		SimpleQueueUsingTwoStacks s = new SimpleQueueUsingTwoStacks(5);
		s.enqueue(1);
		s.display();

		s.enqueue(3);
		s.display();

		s.enqueue(5);
		s.display();

		s.enqueue(7);
		s.display();

		s.enqueue(9);
		s.display();
	}
}
