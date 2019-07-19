package com.common.page.dialect.impl;

import com.common.page.dialect.Dialect;

/**
 * 
 * @author loudyn
 * 
 */
public class MySQLDialect implements Dialect {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.youboy.modules.orm.mybatis.dialect.Dialect#getLimitString(java.lang.String, int, int)
	 */
	
	public String getLimitString(String sql, int offset, int offsetSize) {
	
		StringBuilder builder = new StringBuilder();
		return builder.append(sql).append(" limit ").append(offset).append(",").append(offsetSize).toString();
	}

}
