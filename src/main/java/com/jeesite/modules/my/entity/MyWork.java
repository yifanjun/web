/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.entity;

import com.jeesite.common.entity.BaseEntity;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 工作表Entity
 * @author zyf
 * @version 2018-12-11
 */
@Table(name="my_work", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="w_name", attrName="wname", label="工作名", queryType=QueryType.LIKE),
		@Column(name="w_place", attrName="wplace", label="工作地点"),
		@Column(name="w_type", attrName="wtype", label="工作类型"),
		@Column(name="w_phone", attrName="wphone", label="电话号码"),
		@Column(name="w_poeple", attrName="wpoeple", label="人数"),
		@Column(name="w_status", attrName="wstatus", label="是否已经取消"),
		@Column(name="w_remark", attrName="wremark", label="备注"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class MyWork extends DataEntity<MyWork> {
	
	private static final long serialVersionUID = 1L;
	private String wname;		// 工作名
	private String wplace;		// 工作地点
	private String wtype;		// 工作类型
	private String wphone;		// 电话号码
	private String wpoeple;		// 人数
	private String wstatus;		// 是否已经取消
	private String wremark;		// 备注
	
	public MyWork() {
		this(null);
	}

	public MyWork(String id){
		super(id);
	}
	
	@Length(min=0, max=20, message="工作名长度不能超过 20 个字符")
	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}
	
	@Length(min=0, max=20, message="工作地点长度不能超过 20 个字符")
	public String getWplace() {
		return wplace;
	}

	public void setWplace(String wplace) {
		this.wplace = wplace;
	}
	
	@Length(min=0, max=20, message="工作类型长度不能超过 20 个字符")
	public String getWtype() {
		return wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	
	@Length(min=0, max=20, message="电话号码长度不能超过 20 个字符")
	public String getWphone() {
		return wphone;
	}

	public void setWphone(String wphone) {
		this.wphone = wphone;
	}
	
	@Length(min=0, max=5, message="人数长度不能超过 5 个字符")
	public String getWpoeple() {
		return wpoeple;
	}

	public void setWpoeple(String wpoeple) {
		this.wpoeple = wpoeple;
	}
	
	@Length(min=0, max=5, message="是否已经取消长度不能超过 5 个字符")
	public String getWstatus() {
		return wstatus;
	}

	public void setWstatus(String wstatus) {
		this.wstatus = wstatus;
	}
	
	@Length(min=0, max=255, message="备注长度不能超过 255 个字符")
	public String getWremark() {
		return wremark;
	}

	public void setWremark(String wremark) {
		this.wremark = wremark;
	}
	
}