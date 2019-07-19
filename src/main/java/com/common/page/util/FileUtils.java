package com.common.page.util;

import java.io.File;
import java.util.UUID;

/**
 * @author loudyn
 */
public class FileUtils {

	/**
	 * @param base
	 * @param suffix
	 * @return
	 */
	public static File generate(String base, String suffix) {
		suffix = getSuffixWithoutDot(suffix);
		String uuid = UUID.randomUUID().toString().replaceAll("-|:", "");
		String filePath = PathUtils.asPlatform(String.format("%s%s%s.%s", base, File.separator, uuid, suffix));
		
		return new File(filePath);
	}

	/**
	 * @param base
	 * @param paths
	 * @return
	 */
	public static String joinPaths(String base, String... paths) {
		
		StringBuilder buf = new StringBuilder().append(base);
		
		for (String path : paths) {
			buf.append(File.separator).append(path);
		}
		
		return PathUtils.asPlatform(buf.toString());
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static String getMajorName(String fileName) {
		if (fileName.indexOf(".") != -1) {
			return fileName.substring(0, fileName.lastIndexOf("."));
		}
		return fileName;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static String getSuffixWithDot(String fileName) {
		if (fileName.indexOf(".") != -1) {
			return fileName.substring(fileName.lastIndexOf("."));
		}
		return fileName;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static String getSuffixWithoutDot(String fileName) {
		if (fileName.indexOf(".") != -1) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		}
		return fileName;
	}

	/**
	 * @param fileName
	 * @param insertString
	 * @return
	 */
	public static String insertBeforeSuffix(String fileName, String insertString) {
		String majorName = getMajorName(fileName);
		String suffix = getSuffixWithDot(fileName);
		return String.format("%s%s%s", majorName, insertString, suffix);
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static boolean exists(String fileName) {
		return new File(fileName).exists();
	}

	private FileUtils() {
	}

}
