package com.dsa.queue;

import java.util.Stack;

// Refer
// https://stackoverflow.com/questions/12470626/how-can-one-implement-a-queue-with-only-a-stack-implementation

public class SimpleQueueUsingOneStack {
	Stack<Integer> stack = new Stack<Integer>();

	public void push(int element) {
		stack.push(element);
		System.out.println(element + " pushed into Queue successfully!");
	}

	public int pop() {
		int top = stack.pop();
		if (stack.isEmpty()) {
			return top;
		}

		int result = pop();
		stack.push(top);
		return result;
	}

	public int peek() {
		int top = stack.pop();
		if (stack.isEmpty()) {
			stack.push(top);
			return top;
		}

		int result = peek();
		stack.push(top);
		return result;
	}

	public boolean empty() {
		return stack.isEmpty();
	}

	public void displayStack() {
		System.out.println("Displaying Queue Elements:");
		System.out.println(stack);
	}

	public int size() {
		return stack.size();
	}

	public static void main(String[] args) {
		SimpleQueueUsingOneStack s = new SimpleQueueUsingOneStack();
		
		s.push(1);
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());

		s.push(3);
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());

		s.push(5);
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());

		s.push(7);
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());

		s.push(9);
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());

		System.out.println(s.pop() + " poped into Queue successfully!");
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());
		
		System.out.println(s.pop() + " poped into Queue successfully!");
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());
		
		System.out.println(s.pop() + " poped into Queue successfully!");
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());
		
		System.out.println(s.pop() + " poped into Queue successfully!");
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
		System.out.println("Peek : " + s.peek());
		
		System.out.println(s.pop() + " poped into Queue successfully!");
		s.displayStack();
		System.out.println("Stack Size : " + s.size());
//		System.out.println("Peek : " + s.peek());
	}
}
