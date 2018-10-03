package com.codility.PrefixSums;

public class PassingCountCar {

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 1, 1 };

		int count = solution(A);
		System.out.println(count);

	}

	private static int solution(int[] A) {
		int n = A.length;
		double oneCount = 0;
		double zeroCount = 0;
		while (n >= 1) {
			if (A[n - 1] == 1)
				oneCount++;
			else
				zeroCount = zeroCount + oneCount;
			n--;
		}
		
		if(Math.abs(zeroCount) > 1000000000)
			return -1;
		
		return (int) zeroCount;
	}

}
