package com.dsa.sorting;

// Reference
// https://www.programiz.com/dsa/counting-sort
// https://www.youtube.com/watch?v=mowMVn9wTnE
// https://www.youtube.com/watch?v=pEJiGC-ObQE
// https://www.youtube.com/watch?v=HkvChUv9dDg&t=1s
// https://www.youtube.com/watch?v=bbUqXF5pSD0

import java.util.Arrays;

class CountingSort {
	void countSort(int array[], int size) {
		int[] output = new int[size + 1];

		// Find the largest element of the array
		int max = array[0];
		for (int i = 1; i < size; i++) {
			if (array[i] > max)
				max = array[i];
		}
		int[] count = new int[max + 1];

		// Initialize count array with all zeros.
		for (int i = 0; i < max; ++i) {
			count[i] = 0;
		}

		// Store the count of each element
		for (int i = 0; i < size; i++) {
			count[array[i]]++;
		}

		// Store the cummulative count of each array
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}

		// Find the index of each element of the original array in count array, and
		// place the elements in output array
		for (int i = size - 1; i >= 0; i--) {
			output[count[array[i]] - 1] = array[i];
			count[array[i]]--;
		}

		// Copy the sorted elements into original array
		for (int i = 0; i < size; i++) {
			array[i] = output[i];
		}
	}

	// Driver code
	public static void main(String args[]) {
		int[] arr = { 4, 2, 2, 8, 3, 3, 1 };

		CountingSort cs = new CountingSort();
		cs.countSort(arr, arr.length);

		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(arr));
	}
}
