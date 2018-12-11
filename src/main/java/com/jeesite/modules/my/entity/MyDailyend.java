/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.entity;

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
 * 打卡表Entity
 * @author zyf
 * @version 2018-12-11
 */
@Table(name="my_dailyend", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="a_id", attrName="aid", label="工作号"),
		@Column(name="d_time", attrName="dtime", label="每日工时"),
		@Column(name="d_date", attrName="ddate", label="日期"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class MyDailyend extends DataEntity<MyDailyend> {
	
	private static final long serialVersionUID = 1L;
	private String aid;		// 工作号
	private Double dtime;		// 每日工时
	private Date ddate;		// 日期
	
	public MyDailyend() {
		this(null);
	}

	public MyDailyend(String id){
		super(id);
	}
	
	@Length(min=0, max=20, message="工作号长度不能超过 20 个字符")
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}
	
	public Double getDtime() {
		return dtime;
	}

	public void setDtime(Double dtime) {
		this.dtime = dtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDdate() {
		return ddate;
	}

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	
}