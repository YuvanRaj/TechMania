package com.yuvaraj.techlearning;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number= scan.nextInt();
		scan.close();
		
		System.out.println("Entered Number "+number);
		
		int reverse=0;
		
		while (number > 0) {
			int remainder = number % 10;
			reverse = reverse*10+remainder;
			number = number / 10;
		}		
		System.out.println("reversed number "+reverse);

	}

}
