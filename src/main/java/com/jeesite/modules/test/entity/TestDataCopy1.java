/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 测试数据Entity
 * @author 123
 * @version 2018-12-18
 */
@Table(name="test_data_copy1", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="test_input", attrName="testInput", label="单行文本"),
		@Column(name="test_textarea", attrName="testTextarea", label="多行文本"),
		@Column(name="test_select", attrName="testSelect", label="下拉框"),
		@Column(name="test_select_multiple", attrName="testSelectMultiple", label="下拉多选"),
		@Column(name="test_radio", attrName="testRadio", label="单选框"),
		@Column(name="test_checkbox", attrName="testCheckbox", label="复选框"),
		@Column(name="test_date", attrName="testDate", label="日期选择"),
		@Column(name="test_datetime", attrName="testDatetime", label="日期时间"),
		@Column(name="test_user_code", attrName="testUserCode", label="用户选择"),
		@Column(name="test_office_code", attrName="testOfficeCode", label="机构选择"),
		@Column(name="test_area_code", attrName="testAreaCode", label="区域选择"),
		@Column(name="test_area_name", attrName="testAreaName", label="区域名称", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class TestDataCopy1 extends DataEntity<TestDataCopy1> {
	
	private static final long serialVersionUID = 1L;
	private String testInput;		// 单行文本
	private String testTextarea;		// 多行文本
	private String testSelect;		// 下拉框
	private String testSelectMultiple;		// 下拉多选
	private String testRadio;		// 单选框
	private String testCheckbox;		// 复选框
	private Date testDate;		// 日期选择
	private Date testDatetime;		// 日期时间
	private String testUserCode;		// 用户选择
	private String testOfficeCode;		// 机构选择
	private String testAreaCode;		// 区域选择
	private String testAreaName;		// 区域名称
	
	public TestDataCopy1() {
		this(null);
	}

	public TestDataCopy1(String id){
		super(id);
	}
	
	@Length(min=0, max=200, message="单行文本长度不能超过 200 个字符")
	public String getTestInput() {
		return testInput;
	}

	public void setTestInput(String testInput) {
		this.testInput = testInput;
	}
	
	@Length(min=0, max=200, message="多行文本长度不能超过 200 个字符")
	public String getTestTextarea() {
		return testTextarea;
	}

	public void setTestTextarea(String testTextarea) {
		this.testTextarea = testTextarea;
	}
	
	@Length(min=0, max=10, message="下拉框长度不能超过 10 个字符")
	public String getTestSelect() {
		return testSelect;
	}

	public void setTestSelect(String testSelect) {
		this.testSelect = testSelect;
	}
	
	@Length(min=0, max=200, message="下拉多选长度不能超过 200 个字符")
	public String getTestSelectMultiple() {
		return testSelectMultiple;
	}

	public void setTestSelectMultiple(String testSelectMultiple) {
		this.testSelectMultiple = testSelectMultiple;
	}
	
	@Length(min=0, max=10, message="单选框长度不能超过 10 个字符")
	public String getTestRadio() {
		return testRadio;
	}

	public void setTestRadio(String testRadio) {
		this.testRadio = testRadio;
	}
	
	@Length(min=0, max=200, message="复选框长度不能超过 200 个字符")
	public String getTestCheckbox() {
		return testCheckbox;
	}

	public void setTestCheckbox(String testCheckbox) {
		this.testCheckbox = testCheckbox;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTestDatetime() {
		return testDatetime;
	}

	public void setTestDatetime(Date testDatetime) {
		this.testDatetime = testDatetime;
	}
	
	@Length(min=0, max=64, message="用户选择长度不能超过 64 个字符")
	public String getTestUserCode() {
		return testUserCode;
	}

	public void setTestUserCode(String testUserCode) {
		this.testUserCode = testUserCode;
	}
	
	@Length(min=0, max=64, message="机构选择长度不能超过 64 个字符")
	public String getTestOfficeCode() {
		return testOfficeCode;
	}

	public void setTestOfficeCode(String testOfficeCode) {
		this.testOfficeCode = testOfficeCode;
	}
	
	@Length(min=0, max=64, message="区域选择长度不能超过 64 个字符")
	public String getTestAreaCode() {
		return testAreaCode;
	}

	public void setTestAreaCode(String testAreaCode) {
		this.testAreaCode = testAreaCode;
	}
	
	@Length(min=0, max=100, message="区域名称长度不能超过 100 个字符")
	public String getTestAreaName() {
		return testAreaName;
	}

	public void setTestAreaName(String testAreaName) {
		this.testAreaName = testAreaName;
	}
	
}