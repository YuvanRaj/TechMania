package com.codility;

public class CountByPair {

	public static void main(String[] args) {
		int[] A = { 2, 1, 5, -6, 9 };
		System.out.println(countEvenSumPairs(A));

	}

	public static int countEvenSumPairs(int[] A) {
		int evenNumCount = 0;
		int oddNumCount = 0;

		// Collect the even number counts
		for (int n : A) {
			if ((n & 1) == 0) {
				evenNumCount++;
			}
		}

		// Find the odd number counts
		oddNumCount = A.length - evenNumCount;
		
		// Find the odd & even number of combination using n * (n-1)/2
		long evenNumberPairSum = (evenNumCount * (evenNumCount - 1) / 2);
		long oddNumberPairSum = (oddNumCount * (oddNumCount - 1) / 2);
		long count =  evenNumberPairSum + oddNumberPairSum;

		if (count >= 1000000000) {
			return -1;
		}

		return (int) count;
	}
}
