package com.utilities;

import java.util.Properties;

public final class Utils {

	private static Properties properties = new Properties();

	public static String getProperty(String property) {
		return properties.getProperty(property);
	}
}