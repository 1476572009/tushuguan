package org.taru.lanqiao.util;

public class StringUtil {
	public static String valueof(Object x) {
		if(x!=null) {
			return x.toString();
		}
		return null;
	}
}
