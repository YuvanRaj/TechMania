package com.codility.timecomplexity;

public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = {3,1,2,4,3};

		System.out.println(printMinDiff(A));

	}

	private static int printMinDiff(int[] A) {
		int totalSum = 0;
		for (int i = 0; i < A.length; i++) {
			totalSum += A[i];
		}

		int actualSum = 0;
		int previous = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			previous += A[i];
			if(previous > totalSum){
				break;
			}
			actualSum = Math.abs(previous - (totalSum - previous));
			if (actualSum <= min) {
				min = actualSum;
			}
		}

		return min;
	}

}
