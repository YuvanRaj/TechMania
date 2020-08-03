package com.yuvaraj.techlearning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.AclEntry.Builder;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

public class NumberOfDaysIfDOBGiven {

	public static final String REPLACEMENT_STRING = "!";
	public static final String REGEX_DOUBLE_QUOTE_PATTERN = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*(?![^\\\"]*\\\"))";
	
	public static void main(String[] args) {
		String csvFile = "C:\\Users\\dell\\Downloads\\Sample.csv";
        BufferedReader br = null;
        String line = "";        
        try {
            br = new BufferedReader(new FileReader(csvFile));            
			while ((line = br.readLine()) != null) {							
				String modifiedLine = replaceLineCommaByOtherChar(line,REPLACEMENT_STRING);				
				System.out.println(line);
	            System.out.println(modifiedLine);
	            System.out.println("\n");
			}			
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

		//System.out.println(builder);
	}

	/**
	 * Method will do the below functionality
	 * 
	 * 1. Check whether the line contains double quotes if Yes
	 * 2. Replace the double quoted comma separated value into double quoted replacementString separated one.
	 * 3. If the line doesn't contains double quotes return the origin string
	 * 
	 * Method will be invoked only if specific FID request happened from UI.
	 * 
	 * @param originalLine
	 * @param replacementString
	 * @return
	 */
	private static String replaceLineCommaByOtherChar(String originalLine, String replacementString) {
		if(originalLine != null && !originalLine.contains("\"")) {
			return originalLine;
		}
		StringBuilder builder = new StringBuilder();
		String[] token = originalLine.split(REGEX_DOUBLE_QUOTE_PATTERN);
		int count=0;						
		for (String val : token) {
			count++;			
			val= val.contains("\"") ? val = val.replace(",", replacementString) : val;
			builder.append(val);			
			if(count < token.length)
				builder.append(",");
		}		
		return builder.toString();
	}

}
