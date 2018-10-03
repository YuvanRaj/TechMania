package com.codility;

import java.util.Arrays;

public class MinimumDistance {

	public static void main(String str[]){
		int[] A = { 7,21,3,42,3,7};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		if (A.length == 1) {
			return -2;
		}

		Arrays.sort(A);

		long minDistance = Long.MAX_VALUE;

		for (int i = 1; i < A.length; i++) {
			long distance = (long) A[i] - A[i - 1];
			if (distance < minDistance) {
				minDistance = distance;
			}
		}

		return minDistance > 100000000 ? -1 : (int) minDistance;
	}
}
