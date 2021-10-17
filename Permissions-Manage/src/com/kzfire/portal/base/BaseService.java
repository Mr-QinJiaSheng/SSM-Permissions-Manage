package com.kzfire.portal.base;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.kzfire.portal.dao.BaseDao;

/**
 * @author ysf
 *service基础类
 * 2014-12-1 上午9:24:35  
 */
public class BaseService {
	@Autowired
	BaseDao baseDao;
	/**
	 * @param 表名
	 * @return 记录数
	 */
	public int getTableCount(String table) {
		Map map=new HashMap();
		map.put("table", table);
		return baseDao.getTableCount(map);
	}
}
