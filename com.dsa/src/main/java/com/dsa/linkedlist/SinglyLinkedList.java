package com.dsa.linkedlist;

// Reference
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/list/SinglyLinkedList.java

public class SinglyLinkedList {

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private ListNode head;

	public void createALinkedList() {
		ListNode firstNode = new ListNode(1);
		ListNode secondNode = new ListNode(3);
		ListNode thirdNode = new ListNode(5);
		ListNode fourthNode = new ListNode(7);
		ListNode fifthNode = new ListNode(9);
		ListNode sixthNode = new ListNode(12);

		head = firstNode;
		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		fourthNode.next = fifthNode;
		fifthNode.next = sixthNode;

		System.out.println("A Sample Linked List created successfully!");
	}

	public void display() {
		ListNode currentNode = head;

		while (currentNode != null) {
			System.out.print(currentNode.data + " --> ");
			currentNode = currentNode.next;
		}

		System.out.print("null");
		System.out.println();
	}

	public void display(ListNode node) {
		ListNode currentNode = node;

		while (currentNode != null) {
			System.out.print(currentNode.data + " --> ");
			currentNode = currentNode.next;
		}

		System.out.print("null");
		System.out.println();
	}

	public int length() {
		if (head == null) {
			return 0;
		}

		int count = 0;
		ListNode currentNode = head;

		while (currentNode != null) {
			count++;
			currentNode = currentNode.next;
		}

		return count;
	}

	public void insertFirst(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;

		System.out.println("Node inserted at First successfully!");
	}

	public void insertLast(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			// Case 1 : Linked List is empty
			head = newNode;
			System.out.println("Node inserted at Last successfully!");
			return;
		}

		// Case 2 : Linked List is not empty
		ListNode currentNode = head;
		while (null != currentNode.next) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;

		System.out.println("Node inserted at Last successfully!");
	}

	public void insertAt(int position, int data) {
		// 1 -> 4 -> 5
		// 1 -> 6 -> 4 -> 5
		// position starts from 1

		// Case 1 : Invalid Position
		if (position < 1) {
			System.out.print("Invalid position");
			return;
		}

		ListNode newNode = new ListNode(data);

		// Case 2 : When Position = 1
		if (position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			// Case 3 : When Position > 1
			ListNode previousNode = head;
			int count = 1;

			while (count < position - 1) {
				previousNode = previousNode.next;
				count++;
			}

			ListNode currentNode = previousNode.next;
			previousNode.next = newNode;
			newNode.next = currentNode;
		}

		System.out.println("Node inserted at " + position + " successfully!");
	}

	public ListNode deleteFirst() {
		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");
			return null;
		}

		// Case 2 : Linked List is not empty
		ListNode tempNode = head;
		head = head.next;
		tempNode.next = null;

		System.out.println("Node deleted from first successfully!");

		return tempNode;
	}

	public ListNode deleteLast() {
		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");
			return head;
		}

		// Case 2 : Linked List contain only one node
		if (head.next == null) {
			ListNode tempNode = head;
			head = head.next;
			return tempNode;
		}

		// Case 3 : Linked List contains more than one node
		ListNode currentNode = head;
		ListNode previousNode = null;

		while (currentNode.next != null) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		previousNode.next = null; // break the chain

		System.out.println("Node deleted from last successfully!");

		return currentNode;
	}

	public void deleteAt(int position) {
		// Position is valid and starting from 1
		// 3 -> 4 -> 7 -> 8 -> 9 -> null

		// Case 1 : Invalid Position. Position <= 0
		if (position <= 0) {
			System.out.println("Invalid position. Please enter position between  1 to Size");
			return;
		}

		if (position == 1) {
			// Case 2 : Position == 1
			head = head.next;
		} else {
			// Case 3 : Position > 1
			ListNode previousNode = head;
			int count = 1;
			while (count < position - 1) {
				previousNode = previousNode.next;
				count++;
			}

			ListNode currentNode = previousNode.next;
			previousNode.next = currentNode.next;
		}

		System.out.println("Node deleted from " + position + " successfully!");
	}

	public boolean search(int searchKey) {
		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");

			return false;
		}

		// Case 2 : Linked List is not empty
		ListNode currentNode = head;
		while (currentNode != null) {
			if (currentNode.data == searchKey) {
				System.out.println("Given node is present in Linked List!");
				return true;
			}
			currentNode = currentNode.next;
		}

		System.out.println("Given node is not present in Linked List!");
		return false;
	}

	// Refer
	// Udemy Course Name : Mastering Data Structures & Algorithms using C and C++
	// Video No :199, 200 & 201
	// https://www.youtube.com/watch?v=jY-EUKXYT20&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=36

	public ListNode reverse(ListNode head) {

		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");
			return null;
		}

		// Case 2 : Linked List is not empty
		ListNode currentNode = head;
		ListNode previousNode = null;
		ListNode nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.next; // Step 1: capture address of next node
			currentNode.next = previousNode; // Step 2: setup next link of current node to previous node
			previousNode = currentNode; // Shifting pointer to next node
			currentNode = nextNode; // Shifting pointer to next node
		}
		System.out.println("Linked List reversed successfully!");

		return previousNode;
	}

	// Refer
	// https://www.youtube.com/watch?v=DYpEpZzNmiA&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=36
	public ListNode getMiddleNode() {

		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");
			return null;
		}

		// Case 2 : Linked List is not empty
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	// Refer
	// https://www.youtube.com/watch?v=adS-s2Stg_A&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=37
	public ListNode getNthNodeFromEnd(int n) {

		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");
			return null;
		}

		// Case 2 : Value of N is invalid. Less than or equal to zero
		if (n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}

		// Case 3 : Linked List is not empty. Value of N is valid one
		ListNode mainPtr = head;
		ListNode refPtr = head;

		int count = 0;
		while (count < n) {
			if (refPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPtr = refPtr.next;
			count++;
		}

		while (refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}

	// Refer
	// https://www.youtube.com/watch?v=0Hn18rUkZKY&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=38
	// We are assuming that linked list is sorted one
	public void removeDuplicates() {
		// Case 1 : Linked List is empty
		if (head == null) {
			System.out.println("Linked List is empty!");
			return;
		}

		// Case 2 : Linked List is not empty
		ListNode currentNode = head;
		while (currentNode != null && currentNode.next != null) {
			if (currentNode.data == currentNode.next.data) {
				currentNode.next = currentNode.next.next;
			} else {
				currentNode = currentNode.next;
			}
		}

		System.out.println("Duplicate nodes removed!");
	}

	// Refer
	// https://www.youtube.com/watch?v=u9igWutVc4o&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=39
	public ListNode insertInSortedList(int data) {
		ListNode newNode = new ListNode(data);

		// Case 1 : Linked List is empty
		if (head == null) {
			return newNode;
		}

		// Case 2 : Linked List is not empty
		ListNode currentNode = head;
		ListNode previousNode = null;

		while (currentNode != null && currentNode.data < newNode.data) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		newNode.next = currentNode;
		previousNode.next = newNode;

		System.out.println("New Node insterted successfully into Sorted Linked List");

		return head;
	}

	// Refer
	// https://www.youtube.com/watch?v=8SoncjEIW4c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=40
	public void deleteNode(int searchData) {
		ListNode currentNode = head;
		ListNode previousNode = null;

		// Case 1 : head node (First Node) is matching with search data
		if (currentNode != null && currentNode.data == searchData) {
			head = currentNode.next;
			return;
		}

		// Case 2 : Linked list is not empty and contains more than one nodes
		while (currentNode != null && currentNode.data != searchData) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		// Case 3 : Linked List doesn't contain the search data
		if (currentNode == null) {
			return;
		}

		previousNode.next = currentNode.next;
	}

	// Refer
	// https://www.youtube.com/watch?v=rOpnLs0lXy0&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=41
	public boolean containsLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if (fastPtr == slowPtr) {
				return true;
			}
		}
		return false;
	}

	// Refer
	// https://www.youtube.com/watch?v=yKNOZ8bPdRQ&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=43
	public ListNode startNodeInALoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if (fastPtr == slowPtr) {
				return getStartingNode(slowPtr);
			}
		}
		return null;
	}

	// Refer
	// https://www.youtube.com/watch?v=yKNOZ8bPdRQ&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=43
	private ListNode getStartingNode(ListNode slowPtr) {
		ListNode tempNode = head;
		while (tempNode != slowPtr) {
			tempNode = tempNode.next;
			slowPtr = slowPtr.next;
		}
		return tempNode;
	}

	// Refer
	// https://www.youtube.com/watch?v=LWDVM_kgvdE&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=46
	public void removeLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if (fastPtr == slowPtr) {
				removeLoop(slowPtr);
				System.out.println("Loop removed from Linked List");
				return;
			}
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=LWDVM_kgvdE&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=46
	private void removeLoop(ListNode slowPtr) {
		ListNode tempNode = head;
		while (tempNode.next != slowPtr.next) {
			tempNode = tempNode.next;
			slowPtr = slowPtr.next;
		}
		slowPtr.next = null;
	}

	// Refer
	// https://www.youtube.com/watch?v=rOpnLs0lXy0&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=41
	public void createALoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;

		System.out.println("A loop Linked List created successfully!");
	}

	// Refer
	// https://www.geeksforgeeks.org/how-to-sort-a-linkedlist-in-java/
	public void sortLinkedList() {
		int tempData;

		if (head == null) {
			// Case 1 : Linked List is empty
			System.out.println("Linked List is empty!");
			return;
		} else {
			// Case 2 : Linked List is not empty
			ListNode currentNode = head;
			ListNode nextNode = currentNode.next;

			while (currentNode != null && currentNode.next != null) {
				if (currentNode.data > nextNode.data) {
					tempData = currentNode.data;
					currentNode.data = nextNode.data;
					nextNode.data = tempData;
				}
				nextNode = nextNode.next;
				currentNode = currentNode.next;
			}
		}
		System.out.println("Linked List is sorted now!");
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();

		sll.createALinkedList();
		sll.display();

		System.out.println("Linked List Length : " + sll.length());

		sll.insertFirst(15);
		sll.display();

		sll.insertLast(17);
		sll.display();

		sll.insertAt(3, 99);
		sll.display();

		sll.insertAt(3, 77);
		sll.display();

		sll.deleteFirst();
		sll.display();

		sll.deleteLast();
		sll.display();

		sll.deleteAt(3);
		sll.display();

		sll.search(100);
		sll.search(12);

		sll.display();
		sll.sortLinkedList();
		sll.display();

		ListNode middleNode = sll.getMiddleNode();
		System.out.println("Middle Node : " + middleNode.data);

		ListNode nodeFromEnd = sll.getNthNodeFromEnd(3);
		System.out.println("3rd Node from end : " + nodeFromEnd.data);

		sll.insertFirst(15);
		sll.insertFirst(17);
		sll.insertLast(17);
		sll.insertLast(15);

		sll.display();
		sll.sortLinkedList();
		sll.display();

		sll.display();
		sll.insertInSortedList(30);
		sll.display();

		sll.removeDuplicates();
		sll.display();

		// Code to reverse a Linked List
		ListNode firstNode = new ListNode(1);
		ListNode secondNode = new ListNode(3);
		ListNode thirdNode = new ListNode(5);
		ListNode fourthNode = new ListNode(7);
		ListNode fifthNode = new ListNode(9);
		ListNode sixthNode = new ListNode(12);

		ListNode head1 = firstNode;
		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		fourthNode.next = fifthNode;
		fifthNode.next = sixthNode;

		sll.display(head1);

		ListNode reverseHead = sll.reverse(head1);
		sll.display(reverseHead);

		sll.createALoopInLinkedList();
		System.out.println("Contains a loop ? :" + sll.containsLoop());

		sll.removeLoop();
		sll.display();

	}
}
