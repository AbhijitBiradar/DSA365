package com.dsa.sorting;

public class InsertionSort {
	
	// Reference
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/InsertionSort.java
	// https://www.youtube.com/watch?v=W3TklBfIK9U&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=134
	// https://www.youtube.com/watch?v=TKIAVBsCLqk&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=135
	
	public void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void sort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; i++) { // unsorted part access by i index
			int temp = arr[i];
			int j = i - 1; // sorted part access by j index

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j]; // shifting larger elements to temp by 1 pos
				j = j - 1;
			}
			arr[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 2, 9, 10 };
		InsertionSort is = new InsertionSort();
		is.printArray(arr);
		is.sort(arr);
		is.printArray(arr);
	}
}
