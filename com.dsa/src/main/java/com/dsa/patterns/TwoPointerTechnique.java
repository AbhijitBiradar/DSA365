package com.dsa.patterns;

/*Two pointer algorithm is one of the most commonly asked questions in any programming interview. 
This approach optimizes the runtime by utilizing some order (not necessarily sorting) of the data. 
It is generally applied on lists (arrays) and linked lists. This is generally used to search pairs in a sorted array. 
This approach works in constant space.

Common patterns in the two-pointer approach entail:
1. Two pointers, each starting from the beginning and the end until they both meet.
2. One pointer moving at a slow pace, while the other pointer moves at twice the speed.

Here are some problems that feature the Two Pointer pattern:
1. Squaring a sorted array (easy)
2. Triplets that sum to zero (medium)
3. Comparing strings that contain backspaces (medium)
2. The Two Pointer Technique*/

// Refer : https://www.geeksforgeeks.org/two-pointers-technique/

/*Problem:
Given a sorted array A (sorted in ascending order), having N integers, 
find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
*/
import java.io.*;

class GFG {

	public static void main(String[] args) {

		int arr[] = { 2, 3, 5, 8, 9, 10, 11 };

		int val = 17;

		System.out.println(isPairSum(arr, arr.length, val));
	}

	private static int isPairSum(int A[], int N, int X) {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (i == j) {
					continue;
				}

				if (A[i] + A[j] == X) {
					return 1;
				}

				if (A[i] + A[j] > X) {
					break;
				}
			}
		}
		return 0;
	}
}
