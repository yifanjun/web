/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.test.entity.TestDataCopy1;
import com.jeesite.modules.test.dao.TestDataCopy1Dao;

/**
 * 测试数据Service
 * @author 123
 * @version 2018-12-18
 */
@Service
@Transactional(readOnly=true)
public class TestDataCopy1Service extends CrudService<TestDataCopy1Dao, TestDataCopy1> {
	
	/**
	 * 获取单条数据
	 * @param testDataCopy1
	 * @return
	 */
	@Override
	public TestDataCopy1 get(TestDataCopy1 testDataCopy1) {
		return super.get(testDataCopy1);
	}
	
	/**
	 * 查询分页数据
	 * @param testDataCopy1 查询条件
	 * @param testDataCopy1.page 分页对象
	 * @return
	 */
	@Override
	public Page<TestDataCopy1> findPage(TestDataCopy1 testDataCopy1) {
		return super.findPage(testDataCopy1);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param testDataCopy1
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TestDataCopy1 testDataCopy1) {
		super.save(testDataCopy1);
	}
	
	/**
	 * 更新状态
	 * @param testDataCopy1
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TestDataCopy1 testDataCopy1) {
		super.updateStatus(testDataCopy1);
	}
	
	/**
	 * 删除数据
	 * @param testDataCopy1
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TestDataCopy1 testDataCopy1) {
		super.delete(testDataCopy1);
	}
	
}