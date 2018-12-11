/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.web;

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
import com.jeesite.modules.my.entity.MyStudent;
import com.jeesite.modules.my.service.MyStudentService;

/**
 * 学生表Controller
 * @author zyf
 * @version 2018-12-11
 */
@Controller
@RequestMapping(value = "${adminPath}/my/myStudent")
public class MyStudentController extends BaseController {

	@Autowired
	private MyStudentService myStudentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MyStudent get(String id, boolean isNewRecord) {
		return myStudentService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("my:myStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list(MyStudent myStudent, Model model) {
		model.addAttribute("myStudent", myStudent);
		return "modules/my/myStudentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("my:myStudent:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MyStudent> listData(MyStudent myStudent, HttpServletRequest request, HttpServletResponse response) {
		myStudent.setPage(new Page<>(request, response));
		Page<MyStudent> page = myStudentService.findPage(myStudent); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("my:myStudent:view")
	@RequestMapping(value = "form")
	public String form(MyStudent myStudent, Model model) {
		model.addAttribute("myStudent", myStudent);
		return "modules/my/myStudentForm";
	}

	/**
	 * 保存学生表
	 */
	@RequiresPermissions("my:myStudent:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MyStudent myStudent) {
		myStudentService.save(myStudent);
		return renderResult(Global.TRUE, text("保存学生表成功！"));
	}
	
	/**
	 * 删除学生表
	 */
	@RequiresPermissions("my:myStudent:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MyStudent myStudent) {
		myStudentService.delete(myStudent);
		return renderResult(Global.TRUE, text("删除学生表成功！"));
	}
	
}