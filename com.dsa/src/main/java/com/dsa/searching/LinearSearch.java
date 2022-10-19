package com.dsa.searching;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/search/LinearSearch.java

public class LinearSearch {

	public int search(int[] arr, int searchData) {

		// Case 1 : Array is null or empty
		if (arr == null || arr.length == 0) {
			System.out.println("Array is null or empty!");
			return -1;
		}

		// Case 2 : Search data present in array
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == searchData) {
				return i;
			}
		}

		// Case 3 : Search data not present in array
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 9, 2, 10, 15, 20 };

		LinearSearch ls = new LinearSearch();
		int position = ls.search(arr, 9);

		if (position < 0) {
			System.out.println("Element is not present in the array!");
		} else {
			System.out.println("Element is present in the array! Position : " + position);
		}
	}
}
