/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.my.entity.MyDailyend;
import com.jeesite.modules.my.dao.MyDailyendDao;

/**
 * 打卡表Service
 * @author zyf
 * @version 2018-12-11
 */
@Service
@Transactional(readOnly=true)
public class MyDailyendService extends CrudService<MyDailyendDao, MyDailyend> {
	
	/**
	 * 获取单条数据
	 * @param myDailyend
	 * @return
	 */
	@Override
	public MyDailyend get(MyDailyend myDailyend) {
		return super.get(myDailyend);
	}
	
	/**
	 * 查询分页数据
	 * @param myDailyend 查询条件
	 * @param myDailyend.page 分页对象
	 * @return
	 */
	@Override
	public Page<MyDailyend> findPage(MyDailyend myDailyend) {
		return super.findPage(myDailyend);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param myDailyend
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MyDailyend myDailyend) {
		super.insert(myDailyend);
	}
	
	/**
	 * 更新状态
	 * @param myDailyend
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MyDailyend myDailyend) {
		super.updateStatus(myDailyend);
	}
	
	/**
	 * 删除数据
	 * @param myDailyend
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MyDailyend myDailyend) {
		super.delete(myDailyend);
	}
	
}