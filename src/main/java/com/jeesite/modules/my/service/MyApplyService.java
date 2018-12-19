/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.my.entity.MyApply;
import com.jeesite.modules.my.dao.MyApplyDao;

/**
 * 报名记录表Service
 * @author zyf
 * @version 2018-12-14
 */
@Service
@Transactional(readOnly=true)
public class MyApplyService extends CrudService<MyApplyDao, MyApply> {
	
	/**
	 * 获取单条数据
	 * @param myApply
	 * @return
	 */
	@Override
	public MyApply get(MyApply myApply) {
		return super.get(myApply);
	}
	
	/**
	 * 查询分页数据
	 * @param myApply 查询条件
	 * @param myApply.page 分页对象
	 * @return
	 */
	@Override
	public Page<MyApply> findPage(MyApply myApply) {
		return super.findPage(myApply);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param myApply
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MyApply myApply) {
		super.save(myApply);
	}
	
	/**
	 * 更新状态
	 * @param myApply
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MyApply myApply) {
		super.updateStatus(myApply);
	}
	
	/**
	 * 删除数据
	 * @param myApply
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MyApply myApply) {
		super.delete(myApply);
	}
	
}