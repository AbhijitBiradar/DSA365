package com.dsa.sorting;

import java.util.Arrays;

// Refer
// https://www.youtube.com/watch?v=408TQi6MWmI&list=PLIY8eNdw5tW_zX3OCzX7NJ8bL1p6pWfgG&index=40
// https://www.youtube.com/watch?v=zXyEZQY9nKY&list=PLIY8eNdw5tW_zX3OCzX7NJ8bL1p6pWfgG&index=41
// https://simplesnippets.tech/shell-sort-algorithm-with-c-code-sorting-algorithms-data-structures-algorithms/
// https://www.youtube.com/watch?v=WEZVY6_cZvE

class ShellSort {

	void shellSort(int arr[]) {
		int size = arr.length;
		for (int gap = size / 2; gap > 0; gap = gap / 2) {

			for (int j = gap; j < size; j = j + 1) {
				int temp = arr[j];
				int i = 0;

				for (i = j; (i >= gap) && (arr[i - gap] > temp); i = i - gap) {
					arr[i] = arr[i - gap];
				}
				arr[i] = temp;
			}
		}
	}

	public static void main(String args[]) {
		int[] arr = { 9, 8, 3, 7, 5, 6, 4, 1 };

		System.out.println("Array before sorting: ");
		System.out.println(Arrays.toString(arr));

		ShellSort ss = new ShellSort();
		ss.shellSort(arr);

		System.out.println("Array after sorting: ");
		System.out.println(Arrays.toString(arr));
	}
}
