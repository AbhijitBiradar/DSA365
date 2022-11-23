package com.dsa.sorting;

// Refer
// https://www.youtube.com/watch?v=9QSgBO9yjKU&t=8s
// https://www.youtube.com/watch?v=5n8KZnQvf4k
// https://www.youtube.com/watch?v=nnd0XtYG7eg
// https://www.youtube.com/watch?v=jDL5lRPX6yI			
// https://simplesnippets.tech/radix-sort-algorithm-with-c-code-sorting-algorithms-data-structures-algorithms/

import java.util.Arrays;

class RadixSort {

	void countingSort(int[] arr, int div) {
		int size = arr.length;
		int[] output = new int[size + 1];

		// Find Max value in arr array
		int max = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// Create and Initialize count array with 0
		int[] count = new int[max + 1];
		for (int i = 0; i < max; ++i) {
			count[i] = 0;
		}

		// Calculate & update count of elements into count array
		for (int i = 0; i < size; i++) {
			int countIndex = (arr[i] / div) % 10;
			count[countIndex]++;
		}

		// Calculate cumulative count
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		// Place the elements in sorted order
		for (int i = size - 1; i >= 0; i--) {
			output[count[(arr[i] / div) % 10] - 1] = arr[i];
			count[(arr[i] / div) % 10]--;
		}

		// Update output array result to original array (arr)
		for (int i = 0; i < size; i++) {
			arr[i] = output[i];
		}
	}

	int getMax(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	void radixSort(int[] arr) {
		// Get maximum element
		int max = getMax(arr);

		// Apply counting sort for every digit
		for (int div = 1; max / div > 0; div = div * 10) {
			countingSort(arr, div);
		}
	}

	public static void main(String args[]) {
		int[] arr = { 121, 432, 564, 23, 1, 45, 788 };

		System.out.println("Array Before Sorting : ");
		System.out.println(Arrays.toString(arr));

		RadixSort rs = new RadixSort();
		rs.radixSort(arr);

		System.out.println("Array After Sorting : ");
		System.out.println(Arrays.toString(arr));
	}
}