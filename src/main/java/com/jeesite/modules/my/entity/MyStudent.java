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
 * 学生表Entity
 * @author zyf
 * @version 2018-12-11
 */
@Table(name="my_student", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="s_number", attrName="snumber", label="学号"),
		@Column(name="s_name", attrName="sname", label="姓名", queryType=QueryType.LIKE),
		@Column(name="s_sex", attrName="ssex", label="性别"),
		@Column(name="s_class", attrName="sclass", label="班级"),
		@Column(name="s_phone", attrName="sphone", label="电话号"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class MyStudent extends DataEntity<MyStudent> {
	
	private static final long serialVersionUID = 1L;
	private String snumber;		// 学号
	private String sname;		// 姓名
	private String ssex;		// 性别
	private String sclass;		// 班级
	private String sphone;		// 电话号
	
	public MyStudent() {
		this(null);
	}

	public MyStudent(String id){
		super(id);
	}
	
	@Length(min=0, max=20, message="学号长度不能超过 20 个字符")
	public String getSnumber() {
		return snumber;
	}

	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	
	@Length(min=0, max=20, message="姓名长度不能超过 20 个字符")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Length(min=0, max=5, message="性别长度不能超过 5 个字符")
	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	
	@Length(min=0, max=20, message="班级长度不能超过 20 个字符")
	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	@Length(min=0, max=20, message="电话号长度不能超过 20 个字符")
	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	
}