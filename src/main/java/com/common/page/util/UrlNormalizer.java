package com.common.page.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author loudyn
 * 
 */
public class UrlNormalizer {
	private final static Pattern URL_PATTERN = Pattern.compile("([a-zA-z]+://[^/]+)(.+)");

	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String normalize(String url) {
		Matcher m = URL_PATTERN.matcher(url);

		if (!m.matches()) {
			throw new IllegalArgumentException(String.format("", url));
		}

		final String domain = m.group(1);
		final String namespace = m.group(2);
		return domain + namespace.replaceAll("[/\\\\]+", "/");
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String normalizeIngoreDomain(String url) {
		return url.replaceAll("[/\\\\]+", "/");
	}

	private UrlNormalizer() {
	}
}
