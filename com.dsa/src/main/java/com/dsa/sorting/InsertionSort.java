package com.dsa.sorting;

// Reference
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/InsertionSort.java
// https://www.youtube.com/watch?v=W3TklBfIK9U&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=134
// https://www.youtube.com/watch?v=TKIAVBsCLqk&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=135
// https://www.youtube.com/watch?v=GDNUL4lv8Nc&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=136

// https://www.programiz.com/dsa/insertion-sort
// https://www.geeksforgeeks.org/insertion-sort/
// https://www.educative.io/answers/what-is-insertion-sort-in-java

// Logic : Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration.
// 		   Insertion sort works similarly as we sort cards in our hand in a card game.
// 		   We assume that the first card is already sorted then, we select an unsorted card. 
// 		   If the unsorted card is greater than the card in hand, it is placed on the right otherwise, to the left. 
// 		   In the same way, other unsorted cards are taken and put in their right place.

public class InsertionSort {

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) { // unsorted part can access by i index
			int temp = arr[i];
			int j = i - 1; // sorted part can access by j index

			// Below is the logic to compare in sorted part
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j]; // shifting larger elements to temp by 1 position
				j = j - 1;
			}
			arr[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 2, 9, 10 };

		InsertionSort is = new InsertionSort();

		System.out.println("Array before sorting: ");
		is.printArray(arr);

		is.sort(arr);

		System.out.println("Array after sorting: ");
		is.printArray(arr);
	}
}
