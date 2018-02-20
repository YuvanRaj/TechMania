package com.codility.countingelements;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		int[] A = { -1, -3 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);
		if (A[0] > 0 && A[0] > 1) {
			return 1;
		}

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > 0 && A[i + 1] > 0 && A[i + 1] - A[i] > 1) {
				return A[i] + 1;
			}
		}

		if (A[A.length - 1] == 1000000) {
			return 1;
		}

		return A[A.length - 1] + 1 > 0 ? (A[A.length - 1] + 1) : 1;
	}

}
