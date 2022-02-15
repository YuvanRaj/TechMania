package com.tech.zalando;

import java.util.Arrays;

public class MinimumAllotedRoom {

	public static void main(String[] args) {
		int[] a = {7,3,1,1,4,5,4,9};
		System.out.println(solution(a));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);
		int counter = 0;

		for (int i = 0; i < A.length;) {
			if (A[i] == 1) {
				counter++;
				i++;
				continue;
			}
			
			int withoutThemself = A[i] - 1;
			counter++;

			int coveredIndex = i + withoutThemself;
			if (coveredIndex >= A.length - 1)
				break;

			i = coveredIndex + 1;

		}

		return counter;
	}

}
