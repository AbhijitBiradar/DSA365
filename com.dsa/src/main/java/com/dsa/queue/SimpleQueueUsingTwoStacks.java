package com.dsa.queue;

// Refer
// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s

public class QueueUsingTwoStacks {
	private int stack1[];
	private int stack2[];
	private int count = 0;
	private int size = 0;
	int top1 = -1;
	int top2 = -1;

	public QueueUsingTwoStacks(int size) {
		stack1 = new int[size];
		stack2 = new int[size];
		this.size = size;
	}

	public void enqueue(int data) {
		pushToStack1(data);
		count++;
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	public void pushToStack1(int data) {
		if (top1 == size - 1) {
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
		if (top1 == -1 && top2 == -1) {
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
	public int popFromStack1() {
		return (stack1[top1--]);
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	public void pushToStack2(int data) {
		if (top2 == size - 1) {
			System.out.println("Queue is Full!");
			return;
		} else {
			top2++;
			stack1[top2] = data;
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	public int popFromStack2() {
		return (stack2[top2--]);
	}

	// Refer
	// https://www.youtube.com/watch?v=EFO7bbFcOMw&t=1s
	public void display() {
		for (int i = 0; i <= top1; i++) {
			System.out.print(stack1[i] + " ");
		}
	}

}
