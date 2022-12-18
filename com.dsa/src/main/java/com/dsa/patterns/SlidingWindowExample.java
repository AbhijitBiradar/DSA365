package com.dsa.patterns;

/*The Sliding window is a problem-solving technique of data structure and algorithm for problems that apply arrays or lists. 
These problems are painless to solve using a brute force approach in O(n²) or O(n³). However, the Sliding window technique can reduce the time complexity to O(n).

Sliding Window is used when we need to nested loops into single loop. 

Below are some fundamental hints to identify this type of problem:

Below are some fundamental hints to identify this type of problem: 
1. The problem will be based on an array, list or string type of data structure. 
2. It will ask to find subrange in that array or string will have to give longest, shortest, or target values. 
3. Its concept is mainly based on ideas like the longest sequence or shortest sequence of something that satisfies a given condition perfectly.
*/

// Refer : https://www.geeksforgeeks.org/window-sliding-technique/

/*Problem:
Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.*/	

class SlidingWindowExample {
	static int maxSum(int arr[], int n, int k) {
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < n - k + 1; i++) {
			int currentSum = 0;
			for (int j = 0; j < k; j++) {
				currentSum = currentSum + arr[i + j];
			}
			maxSum = Math.max(currentSum, maxSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		int n = arr.length;
		System.out.println(maxSum(arr, n, k));
	}
}