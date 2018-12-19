/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.my.entity.MyTeacher;
import com.jeesite.modules.my.dao.MyTeacherDao;

/**
 * 教职工表Service
 * @author zyf
 * @version 2018-12-14
 */
@Service
@Transactional(readOnly=true)
public class MyTeacherService extends CrudService<MyTeacherDao, MyTeacher> {
	
	/**
	 * 获取单条数据
	 * @param myTeacher
	 * @return
	 */
	@Override
	public MyTeacher get(MyTeacher myTeacher) {
		return super.get(myTeacher);
	}
	
	/**
	 * 查询分页数据
	 * @param myTeacher 查询条件
	 * @param myTeacher.page 分页对象
	 * @return
	 */
	@Override
	public Page<MyTeacher> findPage(MyTeacher myTeacher) {
		return super.findPage(myTeacher);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param myTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MyTeacher myTeacher) {
		super.save(myTeacher);
	}
	
	/**
	 * 更新状态
	 * @param myTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MyTeacher myTeacher) {
		super.updateStatus(myTeacher);
	}
	
	/**
	 * 删除数据
	 * @param myTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MyTeacher myTeacher) {
		super.delete(myTeacher);
	}
	
}