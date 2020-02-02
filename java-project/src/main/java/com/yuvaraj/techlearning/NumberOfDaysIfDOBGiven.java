package com.yuvaraj.techlearning;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class NumberOfDaysIfDOBGiven {

	public static void main(String[] args) {
		//String dateBeforeString = "2020-01-24";
		
		Scanner scan = new Scanner(System.in);
		String dateBeforeString = scan.nextLine();
		scan.close();
		
		LocalDate dateBefore = LocalDate.parse(dateBeforeString);

		LocalDate dateAfter = LocalDate.now();

		// calculating number of days in between
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

		// displaying the number of days
		System.out.println(noOfDaysBetween);
	}

}
