package com.dsa.sorting;

// Refer
// https://www.youtube.com/watch?v=SkeQsjpG_fo
// https://www.youtube.com/watch?v=UVW0NfG_YWA&t=4s
// https://www.youtube.com/watch?v=kU4KBD4NFtw
// https://www.educative.io/answers/how-to-implement-heap-sort-in-java
// https://www.geeksforgeeks.org/heap-sort/

public class HeapSort {

	public void sort(int arr[]) {
		int size = arr.length;

		// building max heap using heapify
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(arr, size, i);
		}

		// We will extract elements from heap one by one and reduce size of the heap
		// (assuming part of array is sorted controlled by index)
		for (int i = size - 1; i >= 0; i--) {

			// largest resides on root in max-heap
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call heapify on root of reduced heap
			heapify(arr, i, 0);
		}
	}

	public void heapify(int arr[], int size, int index) {
		// Check if right and left child are greater than parent and the right and
		// left child index are not out of bound.
		int largest = index; // Initialize largest as root
		int leftChildIndex = 2 * index + 1; // left = 2*i + 1
		int rightChildIndex = 2 * index + 2; // right = 2*i + 2

		// If left child is larger than root
		if (leftChildIndex < size && arr[leftChildIndex] > arr[largest]) {
			largest = leftChildIndex;
		}

		// If right child is larger than largest so far
		if (rightChildIndex < size && arr[rightChildIndex] > arr[largest]) {
			largest = rightChildIndex;
		}

		// If largest is not root
		// If maximum is not equal to its initial declaration(root) then swap.
		if (largest != index) {
			int temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;

			// We will recursively heapify the affected sub-tree
			heapify(arr, size, largest);
		}
	}

	public void printArray(int arr[]) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 1, 12, 9, 5, 6, 10 };

		System.out.println("Array before sorting : ");
		HeapSort hs = new HeapSort();
		hs.printArray(arr);

		hs.sort(arr);

		System.out.println("Array after sorting : ");
		hs.printArray(arr);
	}
}
