package com.yuvaraj.techlearning;

import java.math.BigInteger;

public class RecursiveDigitSum {

	public static void main(String[] args) {
		System.out.println(digitSumUsingMathTrick("235", 1));

	}

	static int digitSumUsingMathTrick(String n, int k) {
		BigInteger n1 = new BigInteger(n);
		n1 = n1.multiply(new BigInteger(k + ""));
		n1 = n1.remainder(new BigInteger("9"));
		return n1.intValue() == 0 ? 9 : n1.intValue();

	}
	
	// Complete the superDigit function below.
	static int superDigit(String n, int k) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < k; i++) {
			builder.append(n);
		}		
		return sumDigits(new BigInteger(builder.toString())).intValue();
	}

	public static BigInteger sumDigits(BigInteger x) {
		// Base Condition
		if (x.toString().length() == 1)
			return x;

		BigInteger sum = new BigInteger("0");
		BigInteger divideComparator = new BigInteger("10");
		BigInteger baseComparator = new BigInteger("0");
		BigInteger num = x;

		while (num.compareTo(baseComparator) != 0) {
			BigInteger remainder = num.remainder(divideComparator);
			sum = sum.add(remainder);
			num = num.divide(divideComparator);
		}
		return sumDigits(sum);
	}

}
