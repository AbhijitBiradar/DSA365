package com.dsa.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Refer
// https://www.youtube.com/watch?v=E9OccfF9mpI
// https://www.youtube.com/watch?v=rNdTWHQMvOk&t=10s
// https://github.com/nikoo28/java-solutions/blob/master/src/main/java/util/BucketSort.java
// https://www.javatpoint.com/bucket-sort-in-java

public class BucketSort {
	public void binSort(int[] array, int bucketSize) {

		// Step 1 : Create a bucket list
		List<Integer>[] buckets = new List[bucketSize];

		// Step 2 : Associate each index in bucket array with a linked list
		for (int i = 0; i < bucketSize; i++) {
			buckets[i] = new LinkedList<Integer>();
		}

		// Step 3 : Assign number from array to the proper bucket by using hash function
		for (int num : array) {
			buckets[hash(num, bucketSize)].add(num);
		}

		// Step 5 : Sort buckets
		for (List<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}

		// Step 6 : Merge buckets to get sorted array
		int index = 0;
		for (List<Integer> bucket : buckets) {
			for (int num : bucket) {
				array[index] = num;
				index++;
			}
		}
	}

	// Step 4 : This function will generate and return hash value
	private int hash(int num, int bucketSize) {
		return num / bucketSize;
	}

	public static void main(String args[]) {
		int[] array = { 22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14, 55, 0, 12, 55 };

		System.out.println("Array before sorting: ");
		System.out.println(Arrays.toString(array));

		BucketSort bs = new BucketSort();
		bs.binSort(array, 10);

		System.out.println("Array after sorting: ");
		System.out.println(Arrays.toString(array));
	}
}
