package com.codility.countingelements;

public class FrogRiverOne {

	public static void main(String[] args) {
		int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
		int X = 5;
		int test = solution(X, A);
		System.out.println(test);
	}

	private static int solution(int X, int[] A) {
		boolean isNoLeaf = false;
		int count = 0;
		for (int i = 0; i <= X; i++) {
			if (A[i] == 0) {
				isNoLeaf = true;
				break;
			}
			count++;
		}
		int estimatedTime = isNoLeaf ? -1 : count;
		return estimatedTime;
	}

}
