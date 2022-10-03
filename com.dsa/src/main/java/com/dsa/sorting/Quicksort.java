package com.dsa.sorting;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/Sort012.java
// https://www.youtube.com/watch?v=O1VG37bKmFs&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=150
// https://www.youtube.com/watch?v=0ijh_0h35wc&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=151
// https://www.youtube.com/watch?v=ppZaAsb15Ug&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=152
// https://www.youtube.com/watch?v=9qVESt5bBfQ&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=153

// https://www.programiz.com/dsa/quick-sort
// https://www.geeksforgeeks.org/quick-sort/
// https://www.educative.io/answers/how-to-implement-quicksort-in-java
// https://www.happycoders.eu/algorithms/quicksort/

// https://www.youtube.com/watch?v=sNaHN4tZmRk&t=2s
// https://www.youtube.com/watch?v=7h1s2SojIRw&t=1s

import java.util.Arrays;

class Quicksort {

	// method to find the partition position
	public int partition(int arr[], int low, int high) {

		// choose the rightmost element as pivot
		int pivot = arr[high];

		// pointer for greater element
		int i = (low - 1);

		// traverse through all elements compare each element with pivot
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				// if element smaller than pivot is found swap it with the greater element
				// pointed by i
				// swapping element at i with element at j
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

		}

		// swap the pivot element with the greater element specified by i
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		// return the position from where partition is done
		return (i + 1);
	}

	public void quickSort(int array[], int low, int high) {
		if (low < high) {

			// find pivot element such that elements smaller than pivot are on the left
			// elements greater than pivot are on the right
			int pivotPos = partition(array, low, high);

			// recursive call on the left of pivot
			quickSort(array, low, pivotPos - 1);

			// recursive call on the right of pivot
			quickSort(array, pivotPos + 1, high);
		}
	}

	public static void main(String args[]) {

		int[] arr = { 8, 7, 2, 1, 0, 9, 6 };

		System.out.println("Array before sorting: ");
		System.out.println(Arrays.toString(arr));

		// call quicksort() on array data
		Quicksort q = new Quicksort();
		q.quickSort(arr, 0, arr.length - 1);

		System.out.println("Array after sorting: ");
		System.out.println(Arrays.toString(arr));
	}

}
