package com.dsa.patterns;

/*Fast and Slow pointers is an algorithm that works by setting two pointers that move at different speeds, one faster than the other. If the faster pointer “meets” the slower pointer at any point, a cycle is detected. I came across an interesting problem recently that can be solved using the Fast and Slow pointers technique.

1. By moving at different speeds, the algorithm proves that the two pointers are
going to meet eventually. The fast pointer should catch the slow pointer once
both the pointers are in a cyclic loop.

2. The slow and fast pointers algorithm (also known as Floyd's Cycle Detection
algorithm or the Tortoise and Hare algori thm)

3. Time Complexity: O(N) where N is the number of nodes in the Linked Lists.

4. Space Complexity: O(1), algorithm runs in constant space.*/

// Refer
// https://www.geeksforgeeks.org/how-does-floyds-slow-and-fast-pointers-approach-work/
// https://www.geeksforgeeks.org/floyds-cycle-finding-algorithm/

public class FastAndSlowPointersExample {

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private ListNode head;

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

	public static void main(String[] args) {
		FastAndSlowPointersExample faspe = new FastAndSlowPointersExample();
		System.out.println("Contains a loop ? :" + faspe.containsLoop());
	}
}
