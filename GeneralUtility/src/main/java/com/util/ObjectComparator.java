// ObjectComparator.java

package com.util;

import java.lang.reflect.Method;

/**
 * ObjectComparator which use reflection to sort the objects.
 * @author Yuvaraj
 *
 */
public class ObjectComparator implements java.util.Comparator, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9160869227265707806L;
	private String _methodName = null;
	private String _sortingOrder = null;
	private Method _method = null;

	public ObjectComparator(String aMethodName, String aSortingOrder) {
		setMethodName(aMethodName);
		setSortingOrder(aSortingOrder);
	}

	public void setMethodName(String bMethodName) {
		_methodName = bMethodName;
	}

	public String getMethodName() {
		if (_methodName != null)
			return _methodName;
		else
			return "";
	}

	public void setSortingOrder(String bSortingOrder) {
		_sortingOrder = bSortingOrder;
	}

	public String getSortingOrder() {
		if (_sortingOrder != null)
			return _sortingOrder;
		else
			return "ASC";
	}

	public int compare(Object o1, Object o2) {
		try {
			_method = o1.getClass().getMethod(getMethodName(), null);

			Object object = _method.invoke(o1, null);
			if (object instanceof Boolean) {
				Boolean value1 = (Boolean) object;
				Boolean value2 = (Boolean) _method.invoke(o2, null);
				if (getSortingOrder().equals("DESC")) {
					if (value1 == null && value2 == null)
						return -1;
					if (value1 == null)
						return 1;
					if (value2 == null)
						return -1;
					return (value2.toString()).compareTo(value1.toString());
				} else {
					if (value1 == null && value2 == null)
						return -1;
					if (value1 == null)
						return -1;
					if (value2 == null)
						return 1;
					return (value1.toString()).compareTo(value2.toString());
				}
			} else {
				Comparable value1 = (Comparable) object;
				Comparable value2 = (Comparable) _method.invoke(o2, null);
				
				

				if (getSortingOrder().equals("DESC")) {
					if (value1 == null && value2 == null)
						return -1;
					if (value1 == null)
						return 1;
					if (value2 == null)
						return -1;
					return value2.compareTo(value1);
				} else {
					if (value1 == null && value2 == null)
						return -1;
					if (value1 == null)
						return -1;
					if (value2 == null)
						return 1;
					return value1.compareTo(value2);
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return 0;
	}
}