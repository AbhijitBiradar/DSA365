package com.dsa.sorting;

// Refer
// https://www.youtube.com/watch?v=ydj26ZKKrk8

import java.util.Arrays;

class CountingSort {
	void countSort(int arr[], int size) {

		int[] output = new int[size + 1];

		// Step 1 : Find the largest element of the array
		int max = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		// Step 2 : Initialize count array with all zeros.
		int[] count = new int[max + 1];
		for (int i = 0; i < max; ++i) {
			count[i] = 0;
		}

		// Step 3 : Check occurrence of each element in arr array and update the count
		// in countArray
		for (int i = 0; i < size; i++) {
			int index = arr[i];
			count[index]++;
		}

		// Step 4 : Store the cumulative count of each array
		for (int i = 1; i <= max; i++) {
			count[i] = count[i] + count[i - 1];
		}

		// Step 5 : Find the index of each element of the original array in count array,
		// and place the elements in output array
		for (int i = size - 1; i >= 0; i--) {
			int countArrayIndex = arr[i];
			int outputArrayIndex = --count[countArrayIndex];
			output[outputArrayIndex] = arr[i];
		}

		// Step 6 : Copy the sorted elements into original array
		for (int i = 0; i < size; i++) {
			arr[i] = output[i];
		}
	}

	public static void main(String args[]) {
		int[] arr = { 4, 2, 2, 8, 3, 3, 1 };

		System.out.println("Array before sorting: ");
		System.out.println(Arrays.toString(arr));

		CountingSort cs = new CountingSort();
		cs.countSort(arr, arr.length);

		System.out.println("Array after sorting: ");
		System.out.println(Arrays.toString(arr));
	}
}
