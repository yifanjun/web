/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.TestDataCopy1;

/**
 * 测试数据DAO接口
 * @author 123
 * @version 2018-12-18
 */
@MyBatisDao
public interface TestDataCopy1Dao extends CrudDao<TestDataCopy1> {
	
}