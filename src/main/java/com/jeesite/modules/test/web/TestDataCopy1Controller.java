/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.test.entity.TestDataCopy1;
import com.jeesite.modules.test.service.TestDataCopy1Service;

/**
 * 测试数据Controller
 * @author 123
 * @version 2018-12-18
 */
@Controller
@RequestMapping(value = "${adminPath}/test/testDataCopy1")
public class TestDataCopy1Controller extends BaseController {

	@Autowired
	private TestDataCopy1Service testDataCopy1Service;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TestDataCopy1 get(String id, boolean isNewRecord) {
		return testDataCopy1Service.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("test:testDataCopy1:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestDataCopy1 testDataCopy1, Model model) {
		model.addAttribute("testDataCopy1", testDataCopy1);
		return "modules/test/testDataCopy1List";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("test:testDataCopy1:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TestDataCopy1> listData(TestDataCopy1 testDataCopy1, HttpServletRequest request, HttpServletResponse response) {
		testDataCopy1.setPage(new Page<>(request, response));
		Page<TestDataCopy1> page = testDataCopy1Service.findPage(testDataCopy1); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("test:testDataCopy1:view")
	@RequestMapping(value = "form")
	public String form(TestDataCopy1 testDataCopy1, Model model) {
		model.addAttribute("testDataCopy1", testDataCopy1);
		return "modules/test/testDataCopy1Form";
	}

	/**
	 * 保存测试数据
	 */
	@RequiresPermissions("test:testDataCopy1:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TestDataCopy1 testDataCopy1) {
		testDataCopy1Service.save(testDataCopy1);
		return renderResult(Global.TRUE, text("保存测试数据成功！"));
	}
	
	/**
	 * 删除测试数据
	 */
	@RequiresPermissions("test:testDataCopy1:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TestDataCopy1 testDataCopy1) {
		testDataCopy1Service.delete(testDataCopy1);
		return renderResult(Global.TRUE, text("删除测试数据成功！"));
	}
	
}