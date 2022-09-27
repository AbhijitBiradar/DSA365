package com.dsa.sorting;

public class SelectionSort {
	
	// Reference
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/SelectionSort.java
	// https://www.youtube.com/watch?v=u8moN7j6P8w&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=138
	// https://www.youtube.com/watch?v=ezwtvaqiZH8&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=139
	
	public void printArray(int[] arr) {		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void sort(int[] arr) {		
		for (int i = 0; i < arr.length - 1; i++) { // i index will track sorted part
			int min = i;
			for (int j = i + 1; j < arr.length; j++) { // j index will track unsorted part
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 2, 9, 10 };
		SelectionSort ss = new SelectionSort();
		ss.printArray(arr);
		ss.sort(arr);
		ss.printArray(arr);
	}
}
