package com.codility.PrefixSums;

public class CountDiv {
	public static void main(String str[]) {
		int A = 6;
		int B = 11;
		int K = 2;
		int divCount = solution(A, B, K);
		System.out.println(divCount);
	}

	private static int solution(int A, int B, int K) {
		int count = 0;
		for (int i = A; i <= B; i++) {
			if (i % K == 0) {
				count++;
			}
		}
		return count;
	}

}
