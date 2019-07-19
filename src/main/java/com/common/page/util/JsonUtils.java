package com.common.page.util;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author loudyn
 */
public class JsonUtils {
	private final static ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * @param bean
	 * @return
	 */
	public static String toJsonString(Object bean) {
		try {
			
			return MAPPER.writeValueAsString(bean);
		} catch (Exception e) {
			throw ExceptionUtils.toUnchecked(e);
		}
	}

	/**
	 * 
	 * @param <T>
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T fromJsonString(String jsonString, Class<T> clazz) {
		try {

			return MAPPER.readValue(jsonString, clazz);
		} catch (Exception e) {
			throw ExceptionUtils.toUnchecked(e);
		}
	}

}
