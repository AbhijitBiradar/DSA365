package com.dsa.sorting;

import java.util.Arrays;

// Refer
// https://www.programiz.com/dsa/shell-sort
// https://www.youtube.com/watch?v=9crZRd8GPWM
// https://www.youtube.com/watch?v=xtydR3vKw3g
// https://www.youtube.com/watch?v=4fO6PnW1WSs
// https://www.youtube.com/watch?v=ZtjCHnHTK5Q

// https://www.geeksforgeeks.org/shellsort/
// https://www.programiz.com/dsa/shell-sort
// https://www.educative.io/answers/what-is-a-shell-sort

class ShellSort {

	// Rearrange elements at each n/2, n/4, n/8, ... intervals
	void shellSort(int array[], int n) {
		for (int interval = n / 2; interval > 0; interval /= 2) {
			for (int i = interval; i < n; i += 1) {
				int temp = array[i];
				int j;
				for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
					array[j] = array[j - interval];
				}
				array[j] = temp;
			}
		}
	}

	// Driver code
	public static void main(String args[]) {
		int[] data = { 9, 8, 3, 7, 5, 6, 4, 1 };
		int size = data.length;
		ShellSort ss = new ShellSort();
		ss.shellSort(data, size);
		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(data));
	}
}
