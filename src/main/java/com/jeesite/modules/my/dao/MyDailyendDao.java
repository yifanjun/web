/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.my.entity.MyDailyend;

/**
 * 打卡表DAO接口
 * @author zyf
 * @version 2018-12-11
 */
@MyBatisDao
public interface MyDailyendDao extends CrudDao<MyDailyend> {
	
}