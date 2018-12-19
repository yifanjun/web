/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 报名记录表Entity
 * @author zyf
 * @version 2018-12-14
 */
@Table(name="my_apply", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="w_number", attrName="wnumber", label="工作号"),
		@Column(name="t_number", attrName="tnumber", label="教职工号"),
		@Column(name="s_number", attrName="snumber", label="学号"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class MyApply extends DataEntity<MyApply> {
	
	private static final long serialVersionUID = 1L;
	private String wnumber;		// 工作号
	private String tnumber;		// 教职工号
	private String snumber;		// 学号
	
	public MyApply() {
		this(null);
	}

	public MyApply(String id){
		super(id);
	}
	
	@Length(min=0, max=20, message="工作号长度不能超过 20 个字符")
	public String getWnumber() {
		return wnumber;
	}

	public void setWnumber(String wnumber) {
		this.wnumber = wnumber;
	}
	
	@Length(min=0, max=20, message="教职工号长度不能超过 20 个字符")
	public String getTnumber() {
		return tnumber;
	}

	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	
	@Length(min=0, max=20, message="学号长度不能超过 20 个字符")
	public String getSnumber() {
		return snumber;
	}

	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	
}