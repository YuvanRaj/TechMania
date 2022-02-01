package com.tech.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Utility class which helps to do the date related functionality
 * 
 * @author Yuvan
 *
 */
public class DateUtil {

	
	
	public static String minusDays(Date inputDate, int days, String outputFormat) {
	    Date subtractedDate = addDays(inputDate, days);
		SimpleDateFormat formatter = new SimpleDateFormat(outputFormat);
		return formatter.format(subtractedDate);
	}
	
	 public static Date addDays(final Date date, final int amount) {
	      return add(date, Calendar.DAY_OF_MONTH, amount);
	 }
	 
	 /**
	     * Adds to a date returning a new object.
	     * The original {@code Date} is unchanged.
	     *
	     * @param date  the date, not null
	     * @param calendarField  the calendar field to add to
	     * @param amount  the amount to add, may be negative
	     * @return the new {@code Date} with the amount added
	     * @throws NullPointerException if the date is null
	     */
	    private static Date add(final Date date, final int calendarField, final int amount) {
	    	if (date == null)
	            throw new NullPointerException("Empty Date Value");
	        final Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(calendarField, amount);
	        return c.getTime();
	    }
}
