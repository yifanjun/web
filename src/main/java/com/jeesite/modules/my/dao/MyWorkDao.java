/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.my.entity.MyWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作表DAO接口
 * @author zyf
 * @version 2018-12-11
 */
@MyBatisDao(entity = MyWork.class)
public interface MyWorkDao extends CrudDao<MyWork> {
}