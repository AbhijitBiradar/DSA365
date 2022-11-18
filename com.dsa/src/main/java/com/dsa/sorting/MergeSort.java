package com.dsa.sorting;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/MergeSort.java
// https://www.youtube.com/watch?v=oSNFxMazbkg&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=144
// https://www.youtube.com/watch?v=fUaNL5FUG0c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=145
// https://www.youtube.com/watch?v=ThWBE8Y83bw&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=146
// https://www.youtube.com/watch?v=rsZv8VW__ko&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=146

public class MergeSort {
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void sort(int[] arr, int[] temp, int low, int high) {
		if (low < high) { // base case
			int mid = low + (high - low) / 2; // overflow condition (low + high) / 2;
			sort(arr, temp, low, mid); // left half array
			sort(arr, temp, mid + 1, high); // right half array
			merge(arr, temp, low, mid, high); // merge two sorted array
		}
	}

	private void merge(int[] arr, int[] temp, int low, int mid, int high) {
		// Step 1: Copy elements from original array into temp array
		for (int i = low; i <= high; i++) {
			temp[i] = arr[i];
		}

		int i = low; // traverse left sorted subarray
		int j = mid + 1; // traverse right sorted subarray
		int k = low; // will merge both sub arrays into original array (arr)

		// Step 2: Compare both sub array value and update original array
		while (i <= mid && j <= high) {
			if (temp[i] <= temp[j]) {
				arr[k] = temp[i]; // Update original array
				i++;
			} else {
				arr[k] = temp[j]; // Update original array
				j++;
			}
			k++;
		}

		// Step 3: update left sub array values into original array when right sub array
		// is exhausted
		while (i <= mid) {
			arr[k] = temp[i];
			i++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 9, 5, 2, 4, 3, -1 };

		MergeSort ms = new MergeSort();

		System.out.println("Array before sorting: ");
		ms.printArray(arr);

		ms.sort(arr, new int[arr.length], 0, arr.length - 1);

		System.out.println("Array after sorting: ");
		ms.printArray(arr);
	}
}
