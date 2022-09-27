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
// Rule 0 : front will point deletion activity and Rear will point to inserting activity
// Rule 2 : While Enquing, rear will point to latest added node
// Rule 3 : While Dequing, front will point to next node of deleted node
// Rule 4 : While Dequing, for the last element, reset the values of FRONT and REAR to -1

class SimpleQueueUsingLinkedList {

	private class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private ListNode front;
	private ListNode rear;
	private int length;

	public SimpleQueueUsingLinkedList() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	public int length() {
		return length;
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public void enqueue(int data) {
		ListNode newNode = new ListNode(data);

		// Case 1 : If queue is empty, then new node is front and rear both
		if (isEmpty()) {
			rear = newNode;
			front = rear;
			return;
		} else {
			// Case 2 : Add the new node at the end of queue and change rear
			rear.next = newNode;
		}
		rear = newNode;
		length++;
	}

	public int dequeue() {
		// Case 1 : Queue is empty
		if (isEmpty()) {
			return (-1);
		}

		// Case 2 : Queue is not empty
		int result = front.data;
		front = front.next;

		if (front == null) {
			rear = null;
		}

		length--;

		return result;
	}

	public int peek() {
		if (front == null) {
			// Case 1 : Queue is empty
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
			System.out.println("Displaying elements from Queue: ");
			ListNode tempNode = front;
			while (tempNode != rear) {
				System.out.print(tempNode.data + "==> ");
				tempNode = tempNode.next;
			}
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		SimpleQueueUsingLinkedList squll = new SimpleQueueUsingLinkedList();

		squll.enqueue(10);
		squll.enqueue(20);

		squll.dequeue();
		squll.dequeue();

		squll.enqueue(30);
		squll.enqueue(40);
		squll.enqueue(50);

		squll.dequeue();

		System.out.println("Queue Front : " + squll.front.data);
		System.out.println("Queue Rear : " + squll.rear.data);
	}
}
