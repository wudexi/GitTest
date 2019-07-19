package com.common.page.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author loudyn
 * 
 */
public class AjaxUtils {
	/**
	 * 
	 * @param requestWith
	 * @return
	 */
	public static boolean isAjaxRequest(String requestWith) {
		return StringUtils.isNotBlank(requestWith) ? "XMLHttpRequest".equals(requestWith) : false;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjaxUploadRequest(HttpServletRequest request) {
		return null != request.getParameter("ajaxUpload");
	}

	private AjaxUtils() {
	}
}
