/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.my.service.MyApplyService;
import com.jeesite.modules.my.service.MyStudentService;
import com.jeesite.modules.sys.utils.UserUtils;
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

import java.util.Date;

/**
 * 打卡表Controller
 * @author zyf
 * @version 2018-12-11
 */
@Controller
@RequestMapping(value = "${adminPath}/my/myDailyend")
public class MyDailyendController extends BaseController {
	@Autowired
	private MyApplyService myApplyService;
	@Autowired
	private MyDailyendService myDailyendService;
	@Autowired
	private MyStudentService myStudentService;
	
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
	@RequiresPermissions("my:myDailyend:view")
	@RequestMapping(value = {"list", ""})
	public String list(MyDailyend myDailyend, Model model) {
		model.addAttribute("myDailyend", myDailyend);
		return "modules/my/myDailyendList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("my:myDailyend:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MyDailyend> listData(MyDailyend myDailyend, HttpServletRequest request, HttpServletResponse response) {

//		//只能查询到自己的打卡记录
//		//思路如下：1.当前用户为学生，并获取到学号；2.从报名表中遍历，获取所有的报名记录的id；3.通过报名表id（即打卡表中的a_id）来显示记录
//		String user_id=UserUtils.getUser().getUserCode();//用户编码
//		String user_type=UserUtils.getUser().getUserType();//用户类型
//		if(user_type.equals("student")){
//			String student_number=myStudentService.get(user_id).getSnumber();//获取学号
//			String apply=myApplyService.get("a_id").getSnumber();//打卡表中的a_id即为报名表中的id，然后通过a_id获取学号
//
//		}

		myDailyend.setPage(new Page<>(request, response));
		Page<MyDailyend> page = myDailyendService.findPage(myDailyend); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("my:myDailyend:view")
	@RequestMapping(value = "form")
	public String form(MyDailyend myDailyend, Model model, HttpServletRequest request, HttpServletResponse response) {
		//设定默认工作id和打卡日期
		String A_id=request.getParameter("id");
		Date utilDate=new Date();
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		myDailyend.setAid(A_id);
		myDailyend.setDdate(sqlDate);
		model.addAttribute("myDailyend", myDailyend);
		return "modules/my/myDailyendForm";
	}

	/**
	 * 保存打卡表
	 */
	@RequiresPermissions("my:myDailyend:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MyDailyend myDailyend) {

		myDailyendService.save(myDailyend);
		return renderResult(Global.TRUE, text("保存打卡表成功！"));
	}
	
	/**
	 * 删除打卡表
	 */
	@RequiresPermissions("my:myDailyend:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MyDailyend myDailyend) {
		myDailyendService.delete(myDailyend);
		return renderResult(Global.TRUE, text("删除打卡表成功！"));
	}
	
}