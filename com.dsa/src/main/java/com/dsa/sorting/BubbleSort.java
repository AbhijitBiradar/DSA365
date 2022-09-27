package com.dsa.sorting;

public class BubbleSort {

	// Reference
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/BubbleSort.java
	// https://www.youtube.com/watch?v=eFreSZFj1bI&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=132
	// https://www.youtube.com/watch?v=pYyl9QAtRdk&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=133

	public void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void sort(int[] arr) {
		int length = arr.length;
		boolean isSwapped;

		for (int i = 0; i < length - 1; i++) {
			isSwapped = false;
			for (int j = 0; j < length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
				}
			}
			if (isSwapped == false) {
				break;
			}

		}

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 2, 9, 10 };
		BubbleSort bs = new BubbleSort();
		bs.printArray(arr);
		bs.sort(arr);
		bs.printArray(arr);

	}
}
