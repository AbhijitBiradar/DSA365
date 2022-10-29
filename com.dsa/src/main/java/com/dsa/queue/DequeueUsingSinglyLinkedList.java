package com.dsa.queue;

// Refer 
// https://kalkicode.com/deque-implementation-using-doubly-linked-list
// https://www.youtube.com/watch?v=2ItzVMoenxI&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=85		
// https://www.youtube.com/watch?v=G81jTgSOf7g&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=86		
// https://www.youtube.com/watch?v=VMnsIC4kams&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=87		
// https://www.youtube.com/watch?v=yIwiRpIYwrU&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=88		
// https://www.youtube.com/watch?v=M4GdPUfH18k&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=89		
// https://www.youtube.com/watch?v=LPrPHjH5CWE&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=90		
// https://www.youtube.com/watch?v=incgHtVrYAk&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=91

class DequeueUsingSinglyLinkedList {

	private Node front;
	private Node rear;
	private int size;

	public DequeueUsingSinglyLinkedList() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	private class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return (size);
	}

	public int getFront() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
			return -1;
		} else {
			// Case 2 : Queue is not empty
			return front.data;
		}
	}

	public int getRear() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
			return -1;
		} else {
			// Case 2 : Queue is not empty
			return rear.data;
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=VMnsIC4kams&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=87
	public void insertFromFront(int element) {
		Node newNode = new Node(element);
		// newNode.next = front;
		if (front == null) {
			// Case 1 : Queue is empty. When inserting a first node of queue
			front = newNode;
			rear = newNode;
		} else {
			// Case 2 : Queue is not empty. Add node at beginning position
			newNode.next = front;
			front = newNode;
		}
		size++;
		System.out.println("\n" + element + " Pushed from Front");
	}

	// Refer
	// https://www.youtube.com/watch?v=yIwiRpIYwrU&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=89
	public void insertFromRear(int element) {
		Node newNode = new Node(element);
		if (front == null) {
			// Case 1 : Queue is empty. When inserting a first node of queue
			front = newNode;
			rear = newNode;
		} else {
			// Case 2 : Queue is not empty. Add node at the end
			rear.next = newNode;
			rear = newNode;
		}
		size++;
		System.out.println("\n" + element + " Pushed from Rear");
	}

	// Refer
	// https://www.youtube.com/watch?v=yIwiRpIYwrU&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=89
	public void deleteFromFront() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
			return;
		}
		// Case 2 : Queue is not empty
		Node tempNode = front;
		front = tempNode.next;

		if (front == null) {
			// Case 2A : Queue was having only one element. So, after deletion update Rear
			// as null
			rear = null;
		}

		size--;
		System.out.println("\n" + tempNode.data + " Poped from Front!");
		tempNode = null;
	}

	// Refer
	// https://www.youtube.com/watch?v=yIwiRpIYwrU&list=PLoxQvXKPyCeWBT_BLlE_5g0sNxqcVUwJD&index=89
	public void deleteFromRear() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return;
		}
		// Case 2 : Queue is not empty
		Node currentNode = front;
		Node previousNode = null;
		while (currentNode != rear) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		rear = previousNode;

		if (rear == null) {
			// Case 2A : Queue was having only one element. So, after deletion update Front
			// as null
			front = null;
		} else {
			// Case 2B : Queue was having more than one element
			rear.next = null;
		}

		size--;
		System.out.println("\n" + currentNode.data + " Poped from Rear!");
		currentNode = null;
	}

	public void display() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("\nQueue is empty!");
			return;
		} else {
			// Case 2 : Queue is not empty
			Node tempNode = front;
			System.out.println("\nDisplaying Deque Element : \n");
			while (tempNode != null) {
				System.out.print(tempNode.data + " "); // Display node of from front to rear
				tempNode = tempNode.next;
			}
			System.out.println();
		}
	}

	public void displayFromFront() {

	}

	public void displayFromRear() {

	}

	public static void main(String[] args) {
		DequeueUsingSinglyLinkedList dusll = new DequeueUsingSinglyLinkedList();

		dusll.insertFromFront(1);
		dusll.display();
		System.out.println("\nFront Element : " + dusll.getFront());

		dusll.insertFromFront(3);
		dusll.display();
		System.out.println("\nFront Element : " + dusll.getFront());

		dusll.insertFromFront(5);
		dusll.display();
		System.out.println("\nFront Element : " + dusll.getFront());

		dusll.deleteFromFront();
		dusll.display();
		System.out.println("\nFront Element : " + dusll.getFront());

		dusll.deleteFromFront();
		dusll.display();
		System.out.println("\nFront Element : " + dusll.getFront());

		dusll.deleteFromFront();
		dusll.display();
		System.out.println("\nFront Element : " + dusll.getFront());

		dusll.deleteFromFront();
		dusll.display();
		System.out.println("\nFront Element : " + dusll.getFront());

		System.out.println("\nQueue Size : " + dusll.size() + "\n");

		dusll.insertFromRear(7);
		dusll.display();
		System.out.println("\nRear Element : " + dusll.getRear());

		dusll.insertFromRear(9);
		dusll.display();
		System.out.println("\nRear Element : " + dusll.getRear());

		dusll.insertFromRear(11);
		dusll.display();
		System.out.println("\nRear Element : " + dusll.getRear());

		dusll.deleteFromRear();
		dusll.display();
		System.out.println("\nRear Element : " + dusll.getRear());

		dusll.deleteFromRear();
		dusll.display();
		System.out.println("\nRear Element : " + dusll.getRear());

		dusll.deleteFromRear();
		dusll.display();
		System.out.println("\nRear Element : " + dusll.getRear());

		dusll.deleteFromRear();
		dusll.display();
		System.out.println("\nRear Element : " + dusll.getRear());

		System.out.println("\nQueue Size : " + dusll.size() + "\n");
	}
}
