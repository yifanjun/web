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
import com.jeesite.modules.my.entity.MyDailyend;
import com.jeesite.modules.my.service.MyDailyendService;

/**
 * 打卡表Controller
 * @author zyf
 * @version 2018-12-11
 */
@Controller
@RequestMapping(value = "${adminPath}/my/myDailyend")
public class MyDailyendController extends BaseController {

	@Autowired
	private MyDailyendService myDailyendService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MyDailyend get(String id, boolean isNewRecord) {
		return myDailyendService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	//@RequiresPermissions("my:myDailyend:view")
	@RequestMapping(value = {"list", ""})
	public String list(MyDailyend myDailyend, Model model) {
		model.addAttribute("myDailyend", myDailyend);
		return "modules/my/myDailyendList";
	}
	
	/**
	 * 查询列表数据
	 */
	//@RequiresPermissions("my:myDailyend:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MyDailyend> listData(MyDailyend myDailyend, HttpServletRequest request, HttpServletResponse response) {
		myDailyend.setPage(new Page<>(request, response));
		Page<MyDailyend> page = myDailyendService.findPage(myDailyend); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	//@RequiresPermissions("my:myDailyend:view")
	@RequestMapping(value = "form")
	public String form(MyDailyend myDailyend, Model model) {
		model.addAttribute("myDailyend", myDailyend);
		return "modules/my/myDailyendForm";
	}

	/**
	 * 保存打卡表
	 */
	//@RequiresPermissions("my:myDailyend:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MyDailyend myDailyend) {
		myDailyendService.save(myDailyend);
		return renderResult(Global.TRUE, text("保存打卡表成功！"));
	}
	
	/**
	 * 删除打卡表
	 */
	//@RequiresPermissions("my:myDailyend:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MyDailyend myDailyend) {
		myDailyendService.delete(myDailyend);
		return renderResult(Global.TRUE, text("删除打卡表成功！"));
	}
	
}