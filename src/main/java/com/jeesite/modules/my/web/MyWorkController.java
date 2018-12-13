/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
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
import com.jeesite.modules.my.entity.MyWork;
import com.jeesite.modules.my.service.MyWorkService;

/**
 * 工作表Controller
 * @author zyf
 * @version 2018-12-11
 */
@Controller
@RequestMapping(value = "${adminPath}/my/myWork")
public class MyWorkController extends BaseController {

	@Autowired
	private MyWorkService myWorkService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MyWork get(String id, boolean isNewRecord) {
		return myWorkService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("my:myWork:view")
	@RequestMapping(value = {"list", ""})
	public String list(MyWork myWork, Model model) {
		Subject subject=UserUtils.getSubject();
		boolean a=subject.isPermitted("my:myWork:view");
		System.out.println(a);
		boolean b=subject.isPermitted("my:myWork:edit");
		System.out.println(b);

		model.addAttribute("myWork", myWork);
		return "modules/my/myWorkList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("my:myWork:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MyWork> listData(MyWork myWork, HttpServletRequest request, HttpServletResponse response) {
		myWork.setPage(new Page<>(request, response));
		Page<MyWork> page = myWorkService.findPage(myWork); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("my:myWork:view")
	@RequestMapping(value = "form")
	public String form(MyWork myWork, Model model) {
		model.addAttribute("myWork", myWork);
		return "modules/my/myWorkForm";
	}

	/**
	 * 保存工作表
	 */
	@RequiresPermissions("my:myWork:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MyWork myWork) {
		myWorkService.save(myWork);
		return renderResult(Global.TRUE, text("保存工作表成功！"));
	}
	
	/**
	 * 删除工作表
	 */
	@RequiresPermissions("my:myWork:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MyWork myWork) {
		myWorkService.delete(myWork);
		return renderResult(Global.TRUE, text("删除工作表成功！"));
	}
	
}