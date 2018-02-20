package com.codility.iterations;

public class BinaryCap {

	public static void main(String[] args) {
		int a = 74901729;
		int opt1 = solution(a);
		System.out.println(opt1);
	}

	private static int solution(int N) {
		String test = Integer.toBinaryString(N);
		boolean start = false;

		int count = 0;
		int max = 0;

		for (int i = 0; i < test.length(); i++) {

			if (test.charAt(i) == '1' && count == 0)
				start = true;

			if (start && test.charAt(i) == '0') {
				count++;
			}

			if (count > 0 && test.charAt(i) == '1') {
				if (count > max) {
					max = count;
				}
				count = 0;
			}
		}
		return max;
	}

}
