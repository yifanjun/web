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
import com.jeesite.modules.my.entity.MyTeacher;
import com.jeesite.modules.my.service.MyTeacherService;

/**
 * 教职工表Controller
 * @author zyf
 * @version 2018-12-14
 */
@Controller
@RequestMapping(value = "${adminPath}/my/myTeacher")
public class MyTeacherController extends BaseController {

	@Autowired
	private MyTeacherService myTeacherService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MyTeacher get(String id, boolean isNewRecord) {
		return myTeacherService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("my:myTeacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(MyTeacher myTeacher, Model model) {
		model.addAttribute("myTeacher", myTeacher);
		return "modules/my/myTeacherList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("my:myTeacher:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MyTeacher> listData(MyTeacher myTeacher, HttpServletRequest request, HttpServletResponse response) {
		myTeacher.setPage(new Page<>(request, response));
		Page<MyTeacher> page = myTeacherService.findPage(myTeacher); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("my:myTeacher:view")
	@RequestMapping(value = "form")
	public String form(MyTeacher myTeacher, Model model) {
		model.addAttribute("myTeacher", myTeacher);
		return "modules/my/myTeacherForm";
	}

	/**
	 * 保存教职工表
	 */
	@RequiresPermissions("my:myTeacher:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MyTeacher myTeacher) {
		myTeacherService.save(myTeacher);
		return renderResult(Global.TRUE, text("保存教职工表成功！"));
	}
	
	/**
	 * 删除教职工表
	 */
	@RequiresPermissions("my:myTeacher:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MyTeacher myTeacher) {
		myTeacherService.delete(myTeacher);
		return renderResult(Global.TRUE, text("删除教职工表成功！"));
	}
	
}