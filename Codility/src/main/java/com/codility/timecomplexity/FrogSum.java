package com.codility.timecomplexity;

public class FrogSum {

	public static void main(String[] args) {
		int X = 10;
		int Y = 85;
		int D = 30;
		solution(X,Y,D);
	}

	private static int solution(int X, int Y, int D) {
		Y = Y - X;
		int val = (Y % D == 0) ? (Y/D) : ((Y/D)+1); 
		return val;
	}

}
