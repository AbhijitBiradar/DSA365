package com.dsa.queue;

// Reference
// https://www.youtube.com/watch?v=NkrlOf14GdM&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=92&t=172s
// https://www.youtube.com/watch?v=ipMDGKu9uNs&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=93&t=2s
// https://www.youtube.com/watch?v=27yOGyZow6U&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=94
// https://www.geeksforgeeks.org/queue-linked-list-implementation/
// https://www.youtube.com/watch?v=Bf-P7TGD6QU
// https://kkjavatutorials.com/queue-implementation-using-linkedlist-in-java/

// https://www.youtube.com/watch?v=Bf-P7TGD6QU&t=612s	
// https://www.youtube.com/watch?v=jPwBQgwyVKo
// https://www.youtube.com/watch?v=BXhEMOuPmmU
// https://www.youtube.com/watch?v=RN1wzY_tnYU
// https://www.youtube.com/watch?v=QfRoQMSJ664
// https://www.youtube.com/watch?v=LwYQo8mVPBs
// https://www.youtube.com/watch?v=Ey_CeVcZi4c

// Rules
// Rule 0 : Front will point deletion activity and Rear will point to insertion activity
// Rule 2 : While Enquing, Rear will point to latest added node
// Rule 3 : While Dequing, Front will point to next node of deleted node
// Rule 4 : While Dequing, for the last element, reset the values of Front and Rear to -1

class SimpleQueueUsingSinglyLinkedList {

	private ListNode front;
	private ListNode rear;
	private int length;

	public SimpleQueueUsingSinglyLinkedList() {
		this.front = null;
		this.rear = null;
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

	public void enQueue(int data) {
		ListNode newNode = new ListNode(data);

		// Case 1 : If queue is empty then, Front and Rear point to New node
		if (isEmpty()) {
			rear = newNode;
			front = rear;
			return;
		} else {
			// Case 2 : If queue is not empty then, Add the New node at the end of queue and
			// Rear will point to New node
			rear.next = newNode;
		}
		rear = newNode;
		length++;
	}

	public int deQueue() {
		// Case 1 : Queue is empty
		if (isEmpty()) {
			return (-1);
		}

		// Case 2 : Queue is not empty and contains only element
		int result = front.data;
		front = front.next;

		if (front == null) {
			rear = null;
		}

		// Case 3 : Queue is not empty and contains more elements
		length--;

		return result;
	}

	public int peek() {
		if (front == null) {			
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
			return (-1);
		} else {
			// Case 2 : Queue is not empty
			return (front.data);
		}
	}

	public void display() {
		if (isEmpty()) {
			// Case 1 : Queue is empty
			System.out.println("Queue is empty!");
		} else {
			// Case 2 : Queue is not empty
			System.out.println("Displaying Queue elements : ");
			ListNode tempNode = front;
			while (tempNode != rear) {
				System.out.print(tempNode.data + "==> ");
				tempNode = tempNode.next;
			}
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		SimpleQueueUsingSinglyLinkedList squll = new SimpleQueueUsingSinglyLinkedList();

		squll.enQueue(10);
		squll.enQueue(20);

		squll.deQueue();
		squll.deQueue();

		squll.enQueue(30);
		squll.enQueue(40);
		squll.enQueue(50);

		squll.deQueue();

		System.out.println("Queue Front : " + squll.front.data);
		System.out.println("Queue Rear : " + squll.rear.data);
	}
}
