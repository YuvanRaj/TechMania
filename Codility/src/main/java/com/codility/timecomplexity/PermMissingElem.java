package com.codility.timecomplexity;

import java.util.Arrays;

public class PermMissingElem {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7 };

		int x = getMissingElement(A);
		System.out.println(x);

	}

	/**
	 * Time Complexity will be Arrays.sort(A) = O (n log n) Binary Search O (log
	 * n)
	 * 
	 * Total Time Complexity = O (n log n) + O (log n)
	 * 
	 * @param A
	 * @return
	 */
	private static int getMissingElement(int[] A) {
		Arrays.sort(A);

		int low = 0;
		int high = A.length - 1;
		int missingElement = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (A[mid] != mid + 1) {
				high = mid - 1;
				missingElement = mid + 1;
			} else {
				low = mid + 1;
			}
		}
		if (missingElement == 0) {
			return A.length + 1;
		}
		return missingElement;
	}

}
