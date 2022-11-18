package com.dsa.sorting;

// Refer
// https://www.youtube.com/watch?v=QXum8HQd_l4&t=20s


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

	// Refer
	// https://www.youtube.com/watch?v=7h1s2SojIRw&t=1s
	public int partition(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = low, j = high;

		while (i < j) {
			// Step 1 : find left most smallest value from array
			while (arr[i] < pivot) {
				i++;
			}

			// Step 2 : find right most largest value from array
			while (arr[j] > pivot) {
				j--;
			}

			// Step 3 : Perform swap if i is less than j
			if (i < j) {
				swap(arr[i], arr[j]);
			}
		}

		swap(arr[low], arr[j]);
		return j;
	}

	void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}

	// Refer
	// https://www.youtube.com/watch?v=7h1s2SojIRw&t=1s
	public void quickSort(int array[], int low, int high) {
		if (low < high) {
			int pivotPos = partition(array, low, high);
			quickSort(array, low, pivotPos - 1);
			quickSort(array, pivotPos + 1, high);
		}
	}

	public static void main(String args[]) {

		int[] arr = { 11, 13, 7, 12, 16, 9, 24, 5, 10, 3 };

		System.out.println("Array before sorting: ");
		System.out.println(Arrays.toString(arr));

		Quicksort q = new Quicksort();
		q.quickSort(arr, 0, arr.length-1);

		System.out.println("Array after sorting: ");
		System.out.println(Arrays.toString(arr));
	}

}
