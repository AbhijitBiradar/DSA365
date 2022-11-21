package com.dsa.sorting;

// Refer
// https://www.youtube.com/watch?v=UA_Rmjfj4bw&t=505s

import java.util.Arrays;

class Quicksort {

	// Refer
	// https://www.youtube.com/watch?v=UA_Rmjfj4bw&t=505s
	public int partition(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = low, j = high;

		while (i < j) {
			// while(i<=r && arr[i]<=pivot) i++;
			// Logic: If the pivot element is the largest element at any point in the
			// recursion, i will keep on incrementing and will ultimately result in an
			// ArrayIndexOutOfBoundsException. Hence, we need to have a check before the
			// equality condition as due to the lazy operation of Logical AND, if the first
			// condition fails, 2nd won't be checked. The same thing is not required in the
			// 2nd while loop as j will never go less than i.

			// Step 1 : find left most smallest value from array
			while (i <= high && arr[i] <= pivot) {
				i++;
			}

			// Step 2 : find right most largest value from array
			while (arr[j] > pivot) {
				j--;
			}

			// Step 3 : Perform swap if i is less than j
			if (i < j) {
				swap(arr, i, j);
			}
		}

		// Step 4 : Perform swap on pivot and j the position. So that pivot will be at
		// it's right position
		swap(arr, j, low);

		return j;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Refer
	// https://www.youtube.com/watch?v=UA_Rmjfj4bw&t=505s
	public void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	public static void main(String args[]) {

		int[] arr = { 11, 13, 7, 12, 16, 9, 24, 5, 10, 3 };

		System.out.println("Array before sorting: ");
		System.out.println(Arrays.toString(arr));

		Quicksort q = new Quicksort();
		q.quickSort(arr, 0, arr.length - 1);

		System.out.println("Array after sorting: ");
		System.out.println(Arrays.toString(arr));
	}

}
