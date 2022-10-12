package com.dsa.stack;

// Refer
// https://www.programiz.com/dsa/stack
// https://www.youtube.com/watch?v=VmsTAVpz0xo
// https://www.youtube.com/watch?v=i7SgAJHcx00
// https://www.youtube.com/watch?v=D0Bi0wxXh-4
// https://www.youtube.com/watch?v=KrKoP7UKnKs

class StackUsingArray {
	private int arr[];
	private int top;
	private int capacity;

	StackUsingArray(int size) {
		this.arr = new int[size];
		this.capacity = size;
		this.top = -1;

		System.out.println("A Stack is created with size : " + size);
	}

	public Boolean isFull() {
		return (top == (capacity - 1));
	}

	public Boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return top + 1;
	}

	public void push(int data) {
		// Case 1 : Stack is full
		if (isFull()) {
			System.out.println("Stack is already full!");
			return;
		}

		// Case 2 : Stack is not full
		arr[++top] = data;
		System.out.println("Pushed " + data + " into stack.");
	}

	public int pop() {
		// Case 1 : Stack is empty
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return -1;
		}

		// Case 2 : Stack is not empty
		System.out.println("Popped " + arr[top] + " from stack.");
		return arr[top--];
	}

	public void printStack() {
		// Case 1 : Stack is empty
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}

		// Case 2 : Stack is not empty
		System.out.println("Displaying Stack elements:");

		for (int i = top; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray(5);

		System.out.println("Is Stack empty: " + stack.isEmpty());

		System.out.println("Is Stack full: " + stack.isFull());

		stack.push(1);
		stack.printStack();

		stack.push(2);
		stack.printStack();

		stack.push(3);
		stack.printStack();

		stack.push(4);
		stack.printStack();

		stack.pop();

		stack.printStack();

	}
}