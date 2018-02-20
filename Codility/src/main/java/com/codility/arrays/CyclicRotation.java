package com.codility.arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };

		int k = 4;
		int[] test = solution(a, k);

		for (Integer val : test) {
			System.out.print(val);
		}
	}

	private static int[] solution(int[] A, int K) {
		int length = A.length;
		if (length == 0 || K % length == 0) {
			return A;
		} else {
			K = length - (K % length);
			int[] b = new int[length];
			for (int i = 0; i < length; i++) {
				b[i] = A[i + K < length ? (i + K) : ((i + K) - length)];
			}
			return b;
		}
	}

}
