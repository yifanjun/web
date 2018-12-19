/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.my.dao.MyWorkDao;
import com.jeesite.modules.my.entity.MyWork;
import com.jeesite.modules.my.service.MyStudentService;
import com.jeesite.modules.my.service.MyTeacherService;
import com.jeesite.modules.my.service.MyWorkService;
import com.jeesite.modules.sys.entity.User;
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
import com.jeesite.modules.my.entity.MyApply;
import com.jeesite.modules.my.service.MyApplyService;

/**
 * 报名记录表Controller
 * @author zyf
 * @version 2018-12-14
 */
@Controller
@RequestMapping(value = "${adminPath}/my/myApply")
public class MyApplyController extends BaseController {

	@Autowired
	private MyApplyService myApplyService;
	@Autowired
	private MyWorkService myWorkService;
	@Autowired
	private MyStudentService myStudentService;
	@Autowired
	private MyTeacherService myTeacherService;
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MyApply get(String id, boolean isNewRecord) {
		return myApplyService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("my:myApply:view")
	@RequestMapping(value = {"list", ""})
	public String list(MyApply myApply, Model model,HttpServletRequest request, HttpServletResponse response) {
		String workid=request.getParameter("id");
		myApply.setWnumber(workid);
		model.addAttribute("myApply", myApply);
		return "modules/my/myApplyList";
	}
	
	/**
	 * 查询列表数据
	 * 如果是学生，则查询该学生所有报名的工作
	 * 如果是老师，则查询该老师所有发布的工作
	 */
	@RequiresPermissions("my:myApply:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MyApply> listData(MyApply myApply, HttpServletRequest request, HttpServletResponse response) {
		//获取用户编号
		String user_id=UserUtils.getUser().getUserCode();
		String user_type=UserUtils.getUser().getUserType();
		if(user_type.equals("student")){
			System.out.println("student");
			String student_number=myStudentService.get(user_id).getSnumber();
			myApply.setSnumber(student_number);
		}else if(user_type.equals("teacher")){
			System.out.println("teacher:");
			String teacher_number=myTeacherService.get(user_id).getTnumber();
			myApply.setTnumber(teacher_number);
		}else {

		}
		myApply.setPage(new Page<>(request, response));
		Page<MyApply> page = myApplyService.findPage(myApply); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("my:myApply:view")
	@RequestMapping(value = "form")
	public String form(MyApply myApply, Model model) {
		model.addAttribute("myApply", myApply);
		return "modules/my/myApplyForm";
	}

	/**
	 * 保存报名记录表
	 */
	@RequiresPermissions("my:myApply:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MyApply myApply) {
		myApplyService.save(myApply);
		return renderResult(Global.TRUE, text("保存报名记录表成功！"));
	}
	
	/**
	 * 删除报名记录表
	 */
	@RequiresPermissions("my:myApply:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MyApply myApply) {
		myApplyService.delete(myApply);
		return renderResult(Global.TRUE, text("取消成功！"));
	}


}