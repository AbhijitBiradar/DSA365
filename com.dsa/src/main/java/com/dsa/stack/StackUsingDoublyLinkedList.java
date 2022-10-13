package com.dsa.stack;

// Refer
// https://www.geeksforgeeks.org/implementation-of-stack-using-doubly-linked-list/
// https://www.codingninjas.com/codestudio/library/implement-stack-using-a-doubly-linked-list
// https://www.youtube.com/watch?v=JRBA6sarFV0&t=151s

public class StackUsingDoublyLinkedList {

	private Node head;
	private Node top;
	private int length;

	StackUsingDoublyLinkedList() {
		this.head = null;
		this.top = null;
		this.length = 0;
	}

	private class Node {
		private int data;
		private Node next;
		private Node previous;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public boolean isEmpty() {
		return (head == null && top == null);
	}

	public int length() {
		return length;
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			// Case 1 : Linked List is empty
			newNode.previous = null;
			newNode.next = null;

			head = newNode;
			top = newNode;
		} else {
			// Case 2 : Linked List is not empty
			newNode.next = head; // assign old head into next of newNode
			head.previous = newNode;
			newNode.previous = null;
			head = newNode;
			top = newNode;
		}
		length++;
		System.out.println("\n" + data + " Pushed into Stack successfully!");
	}

	public void pop() {
		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		// Case 2 : Linked List contain only one node
		int result = top.data;
		if (top.next == null) {
			top = null;
			head = null;

			System.out.println("\n" + result + " Popped from Stack successfully!");

			return;
		}

		// Case 3 : Linked List contain more than one nodes
		head = head.next;
		top = top.next;
		head.previous = null;
		length--;

		System.out.println("\n" + result + " Popped from Stack successfully!");
	}

	public int peek() {
		// Case 1 : Linked List is empty
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return -1;
		}

		// Case 2 : Linked List is not empty
		return top.data;
	}

	public void printstack() {
		if (isEmpty())
			// Case 1 : Linked List is empty
			System.out.println("Stack is empty");
		else {
			System.out.println("\nDisplaying Stack elements:");
			Node tempNode = top;
			while (tempNode != null) {
				System.out.print(tempNode.data + " ==> ");
				tempNode = tempNode.next;
			}
			System.out.print("null");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		StackUsingDoublyLinkedList sudll = new StackUsingDoublyLinkedList();

		sudll.push(3);
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());

		sudll.push(5);
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());

		sudll.push(7);
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());

		sudll.push(9);
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());

		sudll.pop();
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());

		sudll.pop();
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());
		
		sudll.pop();
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());
		
		sudll.pop();
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());
		
		sudll.pop();
		sudll.printstack();
		sudll.length();
		System.out.println("\nData at Peek in Stack: " + sudll.peek());

	}
}
