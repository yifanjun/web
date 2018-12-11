/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.my.entity.MyStudent;
import com.jeesite.modules.my.dao.MyStudentDao;

/**
 * 学生表Service
 * @author zyf
 * @version 2018-12-11
 */
@Service
@Transactional(readOnly=true)
public class MyStudentService extends CrudService<MyStudentDao, MyStudent> {
	
	/**
	 * 获取单条数据
	 * @param myStudent
	 * @return
	 */
	@Override
	public MyStudent get(MyStudent myStudent) {
		return super.get(myStudent);
	}
	
	/**
	 * 查询分页数据
	 * @param myStudent 查询条件
	 * @param myStudent.page 分页对象
	 * @return
	 */
	@Override
	public Page<MyStudent> findPage(MyStudent myStudent) {
		return super.findPage(myStudent);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param myStudent
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MyStudent myStudent) {
		super.save(myStudent);
	}
	
	/**
	 * 更新状态
	 * @param myStudent
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MyStudent myStudent) {
		super.updateStatus(myStudent);
	}
	
	/**
	 * 删除数据
	 * @param myStudent
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MyStudent myStudent) {
		super.delete(myStudent);
	}
	
}