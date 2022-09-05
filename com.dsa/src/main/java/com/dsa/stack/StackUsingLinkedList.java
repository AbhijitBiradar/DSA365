package com.dsa.stack;

import java.util.EmptyStackException;

// Reference
// https://www.geeksforgeeks.org/implement-a-stack-using-singly-linked-list/
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/stack/Stack.java

public class StackUsingLinkedList {

	private ListNode top;
	private int length;

	private class ListNode {
		private int data; 
		private ListNode next; 

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public StackUsingLinkedList() {
		top = null;
		length = 0;
	}

	public int length() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public void push(int data) {
		ListNode temp = new ListNode(data);
		temp.next = top;
		top = temp;
		length++;
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int result = top.data;
		top = top.next;
		length--;
		return result;
	}

	public int peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public void display() {
		if (top == null) {
			System.out.printf("\nStack Underflow");
			return;
		} else {
			ListNode temp = top;
			while (temp != null) {
				System.out.print(temp.data + "==>");
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(10);
		stack.push(15);
		stack.push(20);

		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}
}