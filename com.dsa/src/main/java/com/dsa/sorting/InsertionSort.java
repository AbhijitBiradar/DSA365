package com.dsa.sorting;

// Reference
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/InsertionSort.java
// https://www.youtube.com/watch?v=W3TklBfIK9U&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=134
// https://www.youtube.com/watch?v=TKIAVBsCLqk&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=135
// https://www.youtube.com/watch?v=GDNUL4lv8Nc&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=136

// https://www.programiz.com/dsa/insertion-sort
// https://www.geeksforgeeks.org/insertion-sort/
// https://www.educative.io/answers/what-is-insertion-sort-in-java

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

			//Below is the logic to compare in sorted part
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
