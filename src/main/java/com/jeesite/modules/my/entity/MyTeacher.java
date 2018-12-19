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
 * 教职工表Entity
 * @author zyf
 * @version 2018-12-14
 */
@Table(name="my_teacher", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="t_number", attrName="tnumber", label="教职工号"),
		@Column(name="t_name", attrName="tname", label="姓名", queryType=QueryType.LIKE),
		@Column(name="t_sex", attrName="tsex", label="性别"),
		@Column(name="t_department", attrName="tdepartment", label="所属部门"),
		@Column(name="t_phone", attrName="tphone", label="电话号"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class MyTeacher extends DataEntity<MyTeacher> {
	
	private static final long serialVersionUID = 1L;
	private String tnumber;		// 教职工号
	private String tname;		// 姓名
	private String tsex;		// 性别
	private String tdepartment;		// 所属部门
	private String tphone;		// 电话号
	
	public MyTeacher() {
		this(null);
	}

	public MyTeacher(String id){
		super(id);
	}
	
	@Length(min=0, max=20, message="教职工号长度不能超过 20 个字符")
	public String getTnumber() {
		return tnumber;
	}

	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	
	@Length(min=0, max=20, message="姓名长度不能超过 20 个字符")
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Length(min=0, max=5, message="性别长度不能超过 5 个字符")
	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	
	@Length(min=0, max=20, message="所属部门长度不能超过 20 个字符")
	public String getTdepartment() {
		return tdepartment;
	}

	public void setTdepartment(String tdepartment) {
		this.tdepartment = tdepartment;
	}
	
	@Length(min=0, max=20, message="电话号长度不能超过 20 个字符")
	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	
}