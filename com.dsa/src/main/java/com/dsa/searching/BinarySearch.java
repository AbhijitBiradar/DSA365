package com.dsa.searching;

// Refer
// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/search/BinarySearch.java

public class BinarySearch {

	public int binarySearch(int[] arr, int searchValue) {

		// Case 1 : Array is null or empty
		if (arr == null || arr.length == 0) {
			System.out.println("Array is null or empty");
			return -1;
		}

		// Case 2 : Array is not empty & searchValue is present in array
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = (high + low) / 2;

			if (arr[mid] == searchValue) {
				return mid;
			}
			if (searchValue < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		// Case 3 : Array is not empty & searchValue is not present in array
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 10, 20, 47, 59, 65, 75, 88, 99 };

		BinarySearch bs = new BinarySearch();
		int position = bs.binarySearch(arr, 65);

		if (position < 0) {
			System.out.println("Element is not present in the array!");
		} else {
			System.out.println("Element is present in the array! Position : " + position);
		}
	}
}
