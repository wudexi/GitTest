package com.common.page.util;

import static java.io.File.separator;

import static java.util.regex.Matcher.quoteReplacement;

/**
 * 
 * @author loudyn
 * 
 */
public class PathUtils {
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String asPlatform(String path) {
		return path.replaceAll("[/|\\\\]+", quoteReplacement(separator));
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String asWindow(String path) {
		return path.replaceAll("[/|\\\\]+", quoteReplacement("\\"));
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String asUnix(String path) {
		return path.replaceAll("[/|\\\\]+", "/");
	}

	private PathUtils() {
	}
}
