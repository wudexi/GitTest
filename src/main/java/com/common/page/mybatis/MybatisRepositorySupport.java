package com.common.page.mybatis;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.common.page.DataAccessException;
import com.common.page.Page;
import com.common.page.util.AssertUtils;



/**
 * 
 * @author loudyn
 * 
 */
public abstract class MybatisRepositorySupport<PK, T> extends SqlSessionDaoSupport {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		AssertUtils.notNull(id, new DataAccessException("id must not be null!"));
		try {
			return (T) getSqlSession().selectOne(getNamespace() + ".get", id);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	/**
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		AssertUtils.notNull(entity, new DataAccessException("entity must not be null!"));

		try {
			getSqlSession().insert(getNamespace() + ".save", entity);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	/**
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		AssertUtils.notNull(entity, new DataAccessException("entity must not be null!"));
		try {

			getSqlSession().update(getNamespace() + ".update", entity);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	/**
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		AssertUtils.notNull(entity, new DataAccessException("entity must not be null!"));
		try {

			getSqlSession().delete(getNamespace() + ".delete", entity);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> query(Object value) {
		try {

			return getSqlSession().selectList(getNamespace() + ".query", value);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	/**
	 * 
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<T> queryPage(Page<T> page) {
		AssertUtils.notNull(page, new DataAccessException("page must not be null!"));

		try {

			List<T> result = getSqlSession().selectList(getNamespace() + ".queryPage", page);
			page.setResult(result);
			return page;
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	
	/**
	 * 
	 * @return 
	 */
	protected String getNamespace() {
		if (namespace != null) {
			return namespace;
		}
		
		initNameSpace();
		return namespace;
	}

	private String namespace;
	
	private void initNameSpace() {
		try {
			@SuppressWarnings("unchecked")
			Class<T> type = (Class<T>) ((ParameterizedType) 
							getClass().getGenericSuperclass()).getActualTypeArguments()[1];
			namespace = type.getName();
		} catch (Exception e) {
			String msg = "Could not initialize namespace. May be you should override getNamespace() to support it.";
			throw new DataAccessException(msg, e);
		}		
	}
}
