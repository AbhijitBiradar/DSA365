package com.dsa.queue;

// Reference
// https://www.tutorialcup.com/interview/queue/priority-queue-using-singly-linked-list.htm
// https://www.geeksforgeeks.org/priority-queue-using-linked-list/#:~:text=Implement%20Priority%20Queue%20using%20Linked,removing%20it%20from%20the%20queue.
// https://tutorialspoint.dev/data-structure/queue-data-structure/priority-queue-using-linked-list
// https://www.codingninjas.com/codestudio/library/priority-queue-implementation-using-linked-list

class PriorityQueueUsingSinglyLinkedList {

	private class Node {
		private int data;
		private int priority;
		private Node next;

		public Node(int data, int priority) {
			this.data = data;
			this.priority = priority;
			this.next = null;
		}
	}

	private Node head;

	public PriorityQueueUsingSinglyLinkedList() {
		this.head = null;
	}

	// Reference
	// https://www.tutorialcup.com/interview/queue/priority-queue-using-singly-linked-list.htm
	public void push(int data, int priority) {
		Node newNode = new Node(data, priority);
		// Case 1 : Queue is empty
		// If head is null, this is the first node to be added so make head = newNode
		if (head == null) {
			head = newNode;
			System.out.println("Inserted data: " + data + " & priority : " + priority + " into queue!");
			return;
		}

		// Case 2 : Queue is not empty
		Node tempNode = head;
		Node previousNode = null;
		// search for first node having priority less than new node's priority
		while (tempNode != null && tempNode.priority > priority) {
			previousNode = tempNode;
			tempNode = tempNode.next;
		}
		if (tempNode == null) {
			// Case 2A : No node with priority less than this node (Case 1)
			previousNode.next = newNode;
			System.out.println("Inserted data: " + data + " & priority : " + priority + " into queue!");
		} else {
			if (previousNode == null) {
				// Case 2B-A : All the nodes have priority less than new node's priority then
				// add this new node at the starting
				newNode.next = head;
				head = newNode;
				System.out.println("Inserted data: " + data + " & priority : " + priority + " into queue!");
			} else {
				// Case 2B-B : Add this node before the node with priority less than new node's
				// priority
				newNode.next = tempNode;
				previousNode.next = newNode;
				System.out.println("Inserted data: " + data + " & priority : " + priority + " into queue!");
			}
		}
	}

	// Reference
	// https://www.tutorialcup.com/interview/queue/priority-queue-using-singly-linked-list.htm
	private int pop() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return -1;
		} else {
			// Case 2 : Queue is not empty
			// head of the linked list contains the maximum priority element
			int data = head.data;
			int priority = head.priority;
			// removing the highest priority element
			head = head.next;
			System.out.println("Removed data: " + data + " & priority : " + priority + " from queue!");
			return data;
		}
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		} else {
			// head of the linked list contains the maximum priority element
			return head.data;
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public static void main(String[] args) {
		PriorityQueueUsingSinglyLinkedList pqull = new PriorityQueueUsingSinglyLinkedList();
		pqull.push(5, 2);
		pqull.push(1, 3);
		System.out.println("Peek value with maximum priority : " + pqull.peek());
		pqull.push(7, 5);
		pqull.push(9, 1);
		pqull.pop();
		pqull.pop();
		System.out.println("Peek value with maximum priority : " + pqull.peek());
	}
}
