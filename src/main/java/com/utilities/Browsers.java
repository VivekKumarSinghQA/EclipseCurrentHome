package com.utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Browsers {
	private static Map<String, String> browsersList = new HashMap<String, String>();
	private static String browser;

	static {

		browsersList.put("firefox", "Firefox");
		browsersList.put("chrome", "Chrome");

	}

	private Browsers() {
	}

	public static String get() throws IOException {
		browser = System.getenv("browser");
		String lowerBrowser = (browser == null ? Environment.ReadExcelData("Browser", 1, 0) : browser).toLowerCase();
		return browsersList.get(lowerBrowser);
	}

	public static String get(String environment) {
		return browsersList.get(environment);
	}

	public static void set(String environment) {
		Browsers.browser = environment;
	}
}
