package com.tech.util;

/**
 * Utility class is used to perform maths related opearations
 * @author yuviram91@gmail.com
 *
 */
public class MathUtil {
	
	public static int digitCount(Integer input) {
		return (int) (Math.log10(input)+1);
	}
}
