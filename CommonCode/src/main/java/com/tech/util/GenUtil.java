package com.tech.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

public class GenUtil {

	/**
	 * Method will check whether given list is Empty
	 * 
	 * if Empty returns true else return false
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List list) {
		if (list == null || list.isEmpty())
			return true;
		return false;
	}

	public static Serializable cloneObject(Serializable aObj) throws IOException, ClassNotFoundException {
		// serialize original object to byte stream
		ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(aObj);
		byte buf[] = baos.toByteArray();
		oos.close();

		// deserialize new route from byte stream
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Serializable newObj = (Serializable) ois.readObject();
		ois.close();

		return newObj;
	}

	public static String arrayToString(Object[] arr) {
		if (arr == null)
			return "[]";

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1)
				sb.append(", ");
		}
		sb.append("]");

		return sb.toString();
	}

	public static String arrayToString(int[] arr) {
		if (arr == null)
			return "[]";

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1)
				sb.append(", ");
		}
		sb.append("]");

		return sb.toString();
	}

	public static String arrayToString(byte[] arr) {
		if (arr == null)
			return "[]";

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1)
				sb.append(", ");
		}
		sb.append("]");

		return sb.toString();
	}
	
	public static boolean listIsEmpty(List list)
	{
		return (list == null || list.isEmpty());
	}
	
	public static boolean equals(Object obj1, Object obj2)
	{
		return (obj1 == null) ? (obj2 == null) : obj1.equals(obj2);
	}

	public static int compare(Object object1, Object object2, String methodName) throws Exception {
		try {
			Method method = object1.getClass().getDeclaredMethod(methodName, null);
			Object result1 = method.invoke(object1, null);
			Object result2 = method.invoke(object2, null);
			if (result1 instanceof Boolean)
				return (result1.toString()).compareTo(result2.toString());

			Comparable value1 = (Comparable) result1;
			return value1.compareTo(result2);
		}

		catch (Exception e) {
			throw e;
		}
	}

}
