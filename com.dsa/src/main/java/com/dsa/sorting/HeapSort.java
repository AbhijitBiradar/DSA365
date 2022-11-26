package com.dsa.sorting;

// Refer
// https://www.youtube.com/watch?v=SkeQsjpG_fo
// https://www.youtube.com/watch?v=79KoeErdQtk
// https://www.youtube.com/watch?v=UVW0NfG_YWA&t=4s
// https://www.youtube.com/watch?v=kU4KBD4NFtw
// https://www.educative.io/answers/how-to-implement-heap-sort-in-java
// https://www.geeksforgeeks.org/heap-sort/

public class HeapSort {

	public void sort(int arr[]) {
		int size = arr.length;

		// Build max heap
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(arr, size, i);
		}

		// Heap sort
		for (int i = size - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Heapify root element
			heapify(arr, i, 0);
		}
	}

	void heapify(int arr[], int size, int index) {
		// Find largest among root, leftChild child and rightChild child
		int largest = index;
		int leftChild = 2 * index + 1;
		int rightChild = 2 * index + 2;

		if (leftChild < size && arr[leftChild] > arr[largest]) {
			largest = leftChild;
		}

		if (rightChild < size && arr[rightChild] > arr[largest]) {
			largest = rightChild;
		}

		// Swap and continue heapifying if root is not largest
		if (largest != index) {
			int swap = arr[index];
			arr[index] = arr[largest];
			arr[largest] = swap;

			heapify(arr, size, largest);
		}
	}

	static void printArray(int arr[]) {
		int size = arr.length;
		for (int i = 0; i < size; ++i) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 1, 12, 9, 5, 6, 10 };

		System.out.println("Array before sorting : ");
		printArray(arr);

		HeapSort hs = new HeapSort();
		hs.sort(arr);

		System.out.println("Array after sorting : ");
		printArray(arr);
	}
}
