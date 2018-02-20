package com.codility.countingelements;

import java.util.Arrays;

public class PermCheck {

	public static void main(String str[]) {
		int[] A = { 4, 1, 3 };
		System.out.println(solution(A));

	}

	public static int solution(int[] A) {
		Arrays.sort(A);

		boolean isPermutation = true;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				isPermutation = false;
				break;
			}
		}
		if (isPermutation) {
			return 1;
		} else {
			return 0;
		}
	}

}
