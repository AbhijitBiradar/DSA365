package com.dsa.queue;

// Refer
// https://www.tutorialcup.com/interview/queue/priority-queue-using-doubly-linked-list.htm
// https://www.prepbytes.com/blog/queues/priority-queue-using-doubly-linked-list/
// https://kalkicode.com/priority-queue-using-doubly-linked-list

// Other Refer
// https://www.youtube.com/watch?v=m5-ofLMU-JQ&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=92		
// https://www.youtube.com/watch?v=OCDMQjpAV8Y&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=93		
// https://www.youtube.com/watch?v=Z-jGa5L82CA&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=94		
// https://www.youtube.com/watch?v=F6w8DUaG9UI&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=95		
// https://www.youtube.com/watch?v=ZwRnyYRocbM&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=96

public class PriorityQueueUsingDoublyLinkedList {
	private class Node {
		private int data;
		private int priority;
		private Node next;
		private Node previous;

		public Node(int data, int priority) {
			this.data = data;
			this.priority = priority;
			this.next = null;
			this.previous = null;
		}
	}

	private Node head = null;

	public boolean isEmpty() {
		return (head == null);
	}

	// Refer
	// https://www.tutorialcup.com/interview/queue/priority-queue-using-doubly-linked-list.htm
	public void push(int data, int priority) {
		// Case 1 : Queue is empty. If head is null this is the first node to be
		// inserted mark head as new Node
		Node newNode = new Node(data, priority);
		if (head == null) {
			head = newNode;
			System.out.println("Inserted " + data + " with priority : " + priority);
			return;
		}
		// Case 2 : Queue is not empty
		// create a new node with specified data
		// find the first node having priority less than 'priority'
		Node tempNode = head, previousNode = null;
		while (tempNode != null && tempNode.priority >= priority) {
			previousNode = tempNode;
			tempNode = tempNode.next;
		}
		// Case 2A : All the nodes are having priorities less than new node's 'priority'
		if (previousNode == null) {
			// insert the new node at the beginning of linked list
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			System.out.println("Inserted " + data + " with priority : " + priority);
		}
		// Case 2B : All the nodes are having priorities greater than new node's
		// 'priority'
		else if (tempNode == null) {
			// insert the node at the end of the linked list
			previousNode.next = newNode;
			newNode.previous = previousNode;
			System.out.println("Inserted " + data + " with priority : " + priority);
		}
		// Case 2C : Some nodes have priority higher than 'priority' and
		// some have priority lower than 'priority'
		else {
			// insert the new node before the first node having priority
			// less than new node's 'priority'
			previousNode.next = newNode;
			newNode.previous = previousNode;
			newNode.next = tempNode;
			tempNode.previous = newNode;
			System.out.println("Inserted " + data + " with priority : " + priority);
		}
	}

	public int peek() {
		// if head is not null, return the element at first position
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			return head.data;
		}
	}

	// Refer
	// https://www.tutorialcup.com/interview/queue/priority-queue-using-doubly-linked-list.htm
	public int pop() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			// Case 2 : Queue is not empty
			// if head is not null, delete the element at first position and return its
			// value
			int data = head.data;
			int priority = head.priority;
			head = head.next;
			if (head != null) {
				head.previous = null;
			}
			System.out.println("Removed " + data + " with priority : " + priority);
			return data;
		}
	}

	public static void main(String[] args) {
		PriorityQueueUsingDoublyLinkedList pqudll = new PriorityQueueUsingDoublyLinkedList();
		pqudll.push(5, 2);
		pqudll.push(1, 3);
		System.out.println("Peek value with maximum priority : " + pqudll.peek());
		pqudll.push(7, 5);
		pqudll.push(9, 1);
		pqudll.pop();
		pqudll.pop();
		System.out.println("Peek value with maximum priority : " + pqudll.peek());
	}
}
