package com.common.page.dialect.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.common.page.dialect.Dialect;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * 
 * @author loudyn
 * 
 */
@Deprecated
public class SQLServer2005Dialect implements Dialect {

	private static final String PAGING_SQL_FORMAT = " inner join (select row_number,id from (select row_number() over(%s) as row_number,* from %s %s) as t where row_number between %s and %s) as page on page.id=%s ";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.youboy.core.orm.dialect.Dialect#getLimitString(java.lang.String, int, int)
	 */
	public String getLimitString(String sql, int offset, int offsetSize) {

		StringBuilder buf = new StringBuilder().append(sql);
		
		if(!TableMetasFinder.ONLY.support(sql)){
			throw new IllegalArgumentException("Can't create limit sql string! your sql string must like 'select somefields from table as alias [where somefield=somevalue] order by somefields'");
		}
		
		
		TableMetas metas = TableMetasFinder.ONLY.getTableMetas(sql);
		int insertIndex = StringUtils.indexOf(sql, metas.fromTableString()) + metas.fromTableString().length();
		String onCause = StringUtils.isNotBlank(metas.tableAlias()) ? metas.tableAlias().concat(".id") : "id";

		return buf.insert(
							insertIndex,
							String.format(
											PAGING_SQL_FORMAT,
											metas.orderBy(),
											metas.table(),
											offset + 1,
											offset + offsetSize,
											onCause
									)
				)
				.toString();
		
	}

	static enum TableMetasFinder {
		ONLY(".*(from\\s+([^\\s]+)\\s+as\\s+([^\\s]+)).*order\\s+by\\s+(.+)") {

			@Override
			public TableMetas getTableMetas(String sql) {
				final Matcher m = getPattern().matcher(sql);
				if (!m.matches()) {
					return TableMetas.EMPTY;
				}

				String[] orderBys = m.group(4).split(",");
				Iterator<String> transform = Iterators.transform(
																	Iterators.filter(
																						Arrays.asList(orderBys).iterator(),
																						
																						new Predicate<String>() {
														
																							
																							public boolean apply(String input) {
																								return StringUtils.trim(input).startsWith(m.group(3));
																							}
																						}
																			),
																			
																			new Function<String, String>() {
													
																				
																				public String apply(String input) {
																					return input.substring(input.indexOf(".") + 1);
																				}
																			}
															);

				String orderBy = new StringBuilder().append("order by ").append(StringUtils.join(transform, ",")).toString();
				return new TableMetas().fromTableString(m.group(1)).table(m.group(2)).tableAlias(m.group(3)).orderBy(orderBy);
			}
		};

		private final Pattern pattern;

		private TableMetasFinder(String patternString) {
			this.pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		}

		protected Pattern getPattern() {
			return pattern;
		}

		/**
		 * 
		 * @param sql
		 * @return
		 */
		public boolean support(String sql) {
			return getPattern().matcher(sql).matches();
		}

		/**
		 * 
		 * @param sql
		 * @return
		 */
		public abstract TableMetas getTableMetas(String sql);
	}

	/**
	 * 
	 * @author loudyn
	 *
	 */
	static class TableMetas {

		static final TableMetas EMPTY = new TableMetas().fromTableString(null).table(null).tableAlias(null).orderBy(null);
		private String fromTableString, table, tableAlias, orderBy;

		public TableMetas fromTableString(String fromTableString) {
			this.fromTableString = fromTableString;
			return this;
		}

		public TableMetas orderBy(String orderBy) {
			this.orderBy = orderBy;
			return this;
		}

		public TableMetas tableAlias(String tableAlias) {
			this.tableAlias = tableAlias;
			return this;
		}

		public TableMetas table(String table) {
			this.table = table;
			return this;
		}

		public String fromTableString() {
			return fromTableString;
		}

		public String table() {
			return table;
		}

		public String tableAlias() {
			return tableAlias;
		}

		public String orderBy() {
			return orderBy;
		}

	}
}
