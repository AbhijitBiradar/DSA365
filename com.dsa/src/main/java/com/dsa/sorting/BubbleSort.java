package com.dsa.sorting;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/sorting/BubbleSort.java
// https://www.youtube.com/watch?v=eFreSZFj1bI&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=132
// https://www.youtube.com/watch?v=pYyl9QAtRdk&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=133
// https://www.youtube.com/watch?v=fF1aJL-4Yzk&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=133

// https://www.programiz.com/dsa/bubble-sort
// https://www.geeksforgeeks.org/bubble-sort/
// https://www.educative.io/answers/what-is-a-bubble-sort-in-java
// https://prepinsta.com/java-program/bubble-sort/

// Logic: In each loop, compare first element with second and if it is greater then swap it. 
// 		  Do this for all element

public class BubbleSort {

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void sort(int[] arr) {
		boolean isSwapped;
		for (int i = 0; i < arr.length - 1; i++) {
			isSwapped = false;
			// Regarding (arr.length - 1 - i)
			// This for loop starts from the first element of the array till the second last
			// index, (arr.length - 1 - i).
			// Each time one index less than the last is traversed as at the end of each
			// iteration, the largest element for that iteration reaches the end.
			for (int j = 0; j < arr.length - 1 - i; j++) {

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

		System.out.println("Original Array: ");
		bs.printArray(arr);

		bs.sort(arr);

		System.out.println("Sorted Array: ");
		bs.printArray(arr);
	}
}
