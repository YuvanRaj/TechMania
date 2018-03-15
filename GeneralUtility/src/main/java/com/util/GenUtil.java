package com.util;

import java.util.Collections;
import java.util.List;

/**
 * Utility to do some generic common functionality like sorting,searching
 * @author Yuvaraj
 *
 */
public class GenUtil {
	
	
	/**
	 * Method will perform sorting based on the methodName and sortOrder
	 * @param methodName
	 * @param sortOrder
	 * @param listToBeSorted
	 * @throws Exception
	 */
	public static void performSort(String methodName, String sortOrder, List listToBeSorted) throws Exception {
		if (methodName != null && methodName.trim().length() != 0 && listToBeSorted != null
				&& !listToBeSorted.isEmpty()) {
			if (sortOrder == null || sortOrder.trim().length() == 0)
				sortOrder = "ASC";

			ObjectComparator comparator = new ObjectComparator(methodName, sortOrder);
			Collections.sort(listToBeSorted, comparator);
		}
	}
}
