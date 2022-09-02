package com.dsa.stack;

// Reference
// https://www.programiz.com/dsa/stack

class StackUsingArray {
	private int arr[];
	private int top;
	private int capacity;

	// Creating a stack
	StackUsingArray(int size) {
		arr = new int[size];
		capacity = size;
		top = -1;
	}

	// Check if the stack is full
	public Boolean isFull() {
		return top == capacity - 1;
	}

	// Add elements into stack
	public void push(int x) {
		if (isFull()) {
			System.out.println("Stack is already full!");
			System.exit(1);
		}

		System.out.println("Inserting " + x + " into stack.");
		arr[++top] = x;
	}

	// Check if the stack is empty
	public Boolean isEmpty() {
		return top == -1;
	}

	// Remove element from stack
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			System.exit(1);
		}
		return arr[top--];
	}

	// Utility function to return the size of the stack
	public int size() {
		return top + 1;
	}

	public void printStack() {
		System.out.println("Displaying Stack elements:");
		
		for (int i = 0; i <= top; i++) {
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
		System.out.println("\nAfter popping out");

		stack.printStack();

	}
}