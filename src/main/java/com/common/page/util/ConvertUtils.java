package com.common.page.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author loudyn
 * 
 */
public class ConvertUtils {

	/**
	 * 
	 * @param <T>
	 * @param beans
	 * @param keyPropertyName
	 * @param valuePropertyName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, PK, PV> void convertPropertyToMap(Collection<T> beans,
														String keyPropertyName,
														String valuePropertyName,
														Map<PK, PV> target) {

		AssertUtils.notNull(beans, "beans must not null");
		AssertUtils.hasLength(keyPropertyName, "keyPropertyName must not blank");
		AssertUtils.hasLength(valuePropertyName, "valuePropertyName must not blank");
		AssertUtils.notNull(target, "target must not null");

		try {

			for (T bean : beans) {
				PK pk = (PK) BeanUtils.getProperty(bean, keyPropertyName);
				PV pv = (PV) BeanUtils.getProperty(bean, valuePropertyName);
				target.put(pk, pv);
			}

		} catch (Exception e) {
			throw ExceptionUtils.toUnchecked(e);
		}

	}

	/**
	 * 
	 * @param <T>
	 * @param beans
	 * @param propertyName
	 * @param separator
	 * @return
	 */
	public static <T> String convertPropertyToString(Collection<T> beans,
														String propertyName,
														String separator) {
		AssertUtils.notNull(beans, "beans must not null");
		AssertUtils.hasLength(propertyName, "propertyName must not blank");

		List<String> target = new ArrayList<String>();
		convertPropertyToList(beans, propertyName, target);
		return StringUtils.join(target, separator);
	}

	/**
	 * 
	 * @param <T>
	 * @param beans
	 * @param propertyName
	 * @param separator
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, PV> void convertPropertyToList(Collection<T> beans,
													String propertyName,
													List<PV> target) {

		AssertUtils.notNull(beans, "beans must not null");
		AssertUtils.hasLength(propertyName, "propertyName must not blank");
		AssertUtils.notNull(target, "target must not null");

		try {

			for (T bean : beans) {
				target.add((PV) BeanUtils.getProperty(bean, propertyName));
			}

		} catch (Exception e) {
			throw ExceptionUtils.toUnchecked(e);
		}
	}

	private ConvertUtils(){
	}
}
