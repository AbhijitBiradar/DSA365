package com.dsa.sorting;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/SelectionSort.java
// https://www.youtube.com/watch?v=u8moN7j6P8w&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=138
// https://www.youtube.com/watch?v=ezwtvaqiZH8&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=139
// https://www.youtube.com/watch?v=vQ5S6rESu8w&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=139

// https://www.geeksforgeeks.org/java-program-for-selection-sort/#:~:text=The%20selection%20sort%20algorithm%20sorts,subarray%20which%20is%20already%20sorted.
// https://www.educative.io/answers/how-to-implement-selection-sort-in-java
// https://www.happycoders.eu/algorithms/selection-sort/
// https://www.programiz.com/dsa/selection-sort

// Logic : Selection sort is a sorting algorithm that selects the smallest element from an unsorted list in each iteration 
// 		   and places that element at the beginning of the unsorted list.

public class SelectionSort {

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// i index will track sorted part
			int minValueIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				// j index will track unsorted part. This loop is used to find min value in
				// unsored part
				if (arr[j] < arr[minValueIndex]) {
					minValueIndex = j;
				}
			}

			// Swap the minimum element with current element
			int temp = arr[minValueIndex]; // assign smallest value to temp
			arr[minValueIndex] = arr[i]; // swap existing i th value to existing min value
			arr[i] = temp; // assign smallest value to arr[i]
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 2, 9, 10 };

		SelectionSort ss = new SelectionSort();

		System.out.println("Array before sorting: ");
		ss.printArray(arr);

		ss.sort(arr);

		System.out.println("Array after sorting: ");
		ss.printArray(arr);
	}
}
