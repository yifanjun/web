/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.my.entity.MyWork;
import com.jeesite.modules.my.dao.MyWorkDao;

/**
 * 工作表Service
 * @author zyf
 * @version 2018-12-11
 */
@Service
@Transactional(readOnly=true)
public class MyWorkService extends CrudService<MyWorkDao, MyWork> {
	
	/**
	 * 获取单条数据
	 * @param myWork
	 * @return
	 */
	@Override
	public MyWork get(MyWork myWork) {
		return super.get(myWork);
	}
	
	/**
	 * 查询分页数据
	 * @param myWork 查询条件
	 * @param myWork.page 分页对象
	 * @return
	 */
	@Override
	public Page<MyWork> findPage(MyWork myWork) {
		return super.findPage(myWork);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param myWork
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MyWork myWork) {
		super.save(myWork);
	}
	
	/**
	 * 更新状态
	 * @param myWork
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MyWork myWork) {
		super.updateStatus(myWork);
	}
	
	/**
	 * 删除数据
	 * @param myWork
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MyWork myWork) {
		super.delete(myWork);
	}
	
}