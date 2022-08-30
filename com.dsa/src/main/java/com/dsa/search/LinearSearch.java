package com.dsa.search;

public class LinearSearch {
	
	// REference
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/search/LinearSearch.java
	public int search(int[] arr, int n, int x) {
		// edge case
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Invalid input");
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 1, 9, 2, 10, 15, 20 };
		LinearSearch ls = new LinearSearch();
		System.out.println(ls.search(arr, arr.length, 50));
	}
}