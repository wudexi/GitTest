package com.common.page.util.filter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.base.Optional;
import com.common.page.util.AssertUtils;
import com.common.page.util.FileUtils;
import com.common.page.util.SensitiveWordFilter;

/**
 * 
 * @author loudyn
 * 
 */
public class HttpSensitiveWordFilter extends OncePerRequestFilter {

	public static final String DEFAULT_SENSITIVE_WORD_REPLACEMENT = "*";

	private String sensitiveWordFilePath;
	private String sensitiveWordReplacement;
	private String pathMapping;
	private final String sensitiveWordFilePathParam = "path";
	private final String sensitiveWordReplacementParam = "replacement";
	private final String pathMappingParam = "mapping";

	public String getSensitiveWordFilePath() {
		return sensitiveWordFilePath;
	}

	protected void setSensitiveWordFilePath(String sensitiveWordFilePath) {
		this.sensitiveWordFilePath = sensitiveWordFilePath;
	}

	public String getSensitiveWordReplacement() {
		return sensitiveWordReplacement;
	}

	protected void setSensitiveWordReplacement(String sensitiveWordReplacement) {
		this.sensitiveWordReplacement = sensitiveWordReplacement;
	}

	public String getPathMapping() {
		return pathMapping;
	}

	protected void setPathMapping(String pathMapping) {
		this.pathMapping = pathMapping;
	}

	private SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter() {

		@Override
		protected void afterFilter(List<String> hitWords, String text, String replacement) {
			if (!hitWords.isEmpty()) {
				SensitiveWordMonitor.found();
			}
		}

	};

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private volatile long lastModifiedOfWords = 0L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		reloadWordsIfNeccessary();
		filterChain.doFilter(new SensitiveWordFilterRequestWrapper(request), response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.filter.GenericFilterBean#initFilterBean()
	 */
	@Override
	protected void initFilterBean() throws ServletException {
		super.initFilterBean();
		initSensitiveWordFilePath();
		initSensitiveWordReplacement();
		initPathMapping();
	}

	private void initSensitiveWordFilePath() {
		String sensitiveWordFilePath = getFilterConfig().getInitParameter(sensitiveWordFilePathParam);
		AssertUtils.hasText(sensitiveWordFilePath);

		String ctx = getServletContext().getRealPath("/");
		setSensitiveWordFilePath(FileUtils.joinPaths(ctx, sensitiveWordFilePath));
	}

	private void initSensitiveWordReplacement() {
		String sensitiveWordReplacement = getFilterConfig().getInitParameter(sensitiveWordReplacementParam);
		setSensitiveWordReplacement(Optional.fromNullable(sensitiveWordReplacement).or(DEFAULT_SENSITIVE_WORD_REPLACEMENT));
	}

	private void initPathMapping() {
		String pathMapping = getFilterConfig().getInitParameter(pathMappingParam);
		AssertUtils.hasText(pathMapping);
		setPathMapping(pathMapping);
	}

	private void reloadWordsIfNeccessary() throws ServletException {
		try {

			lock.readLock().lock();
			File wordFile = new File(getSensitiveWordFilePath());
			if (!wordFile.exists()) {
				throw new IllegalStateException("Can't find wordFile!");
			}

			long lastModified = wordFile.lastModified();
			if (lastModified <= lastModifiedOfWords) {
				return;
			}

			try {

				lock.readLock().unlock();
				lock.writeLock().lock();

				lastModified = wordFile.lastModified();
				if (lastModified > lastModifiedOfWords) {
					loadSensitiveWords(wordFile);
				}

				lock.readLock().lock();
			} finally {
				lock.writeLock().unlock();
			}

		} finally {
			lock.readLock().unlock();
		}
	}

	private void loadSensitiveWords(File wordFile) throws ServletException {
		LineIterator it = null;
		try {

			it = org.apache.commons.io.FileUtils.lineIterator(wordFile);
			sensitiveWordFilter.reset();

			while (it.hasNext()) {
				String word = it.nextLine();
				if (StringUtils.isNotBlank(word)) {
					sensitiveWordFilter.addFilterWord(word);
				}
			}

			lastModifiedOfWords = System.currentTimeMillis();
		} catch (Exception e) {
			LineIterator.closeQuietly(it);
			throw new ServletException("can't load sensitiveWords", e);
		}

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			return true;
		}

		String path = request.getServletPath();
		if (!path.matches(getPathMapping())) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @author loudyn
	 * 
	 */
	protected class SensitiveWordFilterRequestWrapper extends HttpServletRequestWrapper {

		public SensitiveWordFilterRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
		 */
		@Override
		public String getParameter(String name) {
			try {

				lock.readLock().lock();
				String value = super.getParameter(name);
				if (null != value) {
					value = sensitiveWordFilter.doFilter(value, getSensitiveWordReplacement());
				}
				return value;
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.servlet.ServletRequestWrapper#getParameterValues(java.lang.String)
		 */
		@Override
		public String[] getParameterValues(String name) {
			try {

				lock.readLock().lock();
				String[] values = super.getParameterValues(name);
				if (null != values) {
					for (int i = 0; i < values.length; i++) {
						values[i] = sensitiveWordFilter.doFilter(values[i], getSensitiveWordReplacement());
					}
				}

				return values;
			} finally {
				lock.readLock().unlock();
			}
		}
	}

}
