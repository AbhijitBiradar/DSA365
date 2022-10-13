package com.dsa.stack;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/stack/Stack.java
// https://www.youtube.com/watch?v=Hxvn3IkE5SM&list=PL6Zs6LgrJj3vWOf01wMHiTy9IFufptfG3&index=1
// https://www.youtube.com/watch?v=Us4N22SEbM0&list=PL6Zs6LgrJj3vWOf01wMHiTy9IFufptfG3&index=2

// https://www.youtube.com/watch?v=0H_wxGw0LUs
// https://www.youtube.com/watch?v=T_UXDTy23DQ
// https://www.youtube.com/watch?v=Y36eEw3zk2I
// https://www.youtube.com/watch?v=bbyQHBbSrYA

public class StackUsingSinglyLinkedList {

	private ListNode top;
	private int length;

	public StackUsingSinglyLinkedList() {
		this.top = null;
		this.length = 0;
	}

	private class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public int length() {
		return length;
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public void push(int data) {
		ListNode newNode = new ListNode(data);

		newNode.next = top;
		top = newNode;
		length++;

		System.out.println("\n" + data + " Pushed into Stack successfully!");
	}

	public int pop() {
		// Case 1 : Stack is empty
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return -1;
		}

		// Case 2 : Stack is not empty
		int result = top.data;
		top = top.next;
		length--;

		System.out.println("\n" + result + " Popped from Stack successfully!");

		return result;
	}

	public int peek() {
		// Case 1 : Stack is empty
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return -1;
		}

		// Case 2 : Stack is not empty
		return top.data;
	}

	public void printStack() {
		// Case 1 : Stack is empty
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}

		// Case 2 : Stack is not empty
		System.out.println("\nDisplaying Stack elements:");
		ListNode tempNode = top;
		while (tempNode != null) {
			System.out.print(tempNode.data + " ==> ");
			tempNode = tempNode.next;
		}
		System.out.print("null");
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingSinglyLinkedList susll = new StackUsingSinglyLinkedList();

		susll.push(10);
		System.out.println("\nData at Peek in Stack " + susll.peek());
		susll.printStack();

		susll.push(15);
		System.out.println("\nData at Peek in Stack " + susll.peek());
		susll.printStack();

		susll.push(20);
		System.out.println("\nData at Peek in Stack " + susll.peek());
		susll.printStack();

		susll.pop();
		System.out.println("\nData at Peek in Stack " + susll.peek());
		susll.printStack();

		susll.pop();
		System.out.println("\nData at Peek in Stack " + susll.peek());
		susll.printStack();
	}
}