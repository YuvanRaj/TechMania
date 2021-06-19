package com.tech.util;

import java.util.List;

public class GenUtil {

	
	/**
	 * Method will check whether given list is Empty
	 * 
	 * if Empty returns true
	 * else return false
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List list) {
		if (list == null || list.isEmpty())
			return true;
		return false;
	}
}
