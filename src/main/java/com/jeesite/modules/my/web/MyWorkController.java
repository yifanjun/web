/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.my.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.my.entity.MyApply;
import com.jeesite.modules.my.service.MyApplyService;
import com.jeesite.modules.my.service.MyStudentService;
import com.jeesite.modules.my.service.MyTeacherService;
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

import java.util.List;

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
	@Autowired
	private MyApplyService myApplyService;
	@Autowired
	private MyStudentService myStudentService;
	@Autowired
	private MyTeacherService myTeacherService;
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

	@RequiresPermissions("my:myWork:view")
	@RequestMapping(value = "getjob")
	@ResponseBody
	public String getjob(MyWork myWork, HttpServletRequest request, HttpServletResponse response) {
		MyApply myApply=new MyApply();
		//获取学生学号
		String student_id=UserUtils.getUser().getUserCode();
		String student_number=myStudentService.get(student_id).getSnumber();
		//获取教职工号
		String teacher_id=myWork.getCreateBy();
		String teacher_number=myTeacherService.get(teacher_id).getTnumber();
		//工作id为参数
		String work_id=request.getParameter("id");

		//根据学生id进行将其所有报名工作列出来，如果没有报名则报名，已经报名则无法再次报名
		myApply.setSnumber(student_number);//学生id
		List<MyApply> list=myApplyService.findList(myApply);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getTnumber());
			System.out.println(list.get(i).getWnumber());
			if(list.get(i).getTnumber().equals(teacher_number) && list.get(i).getWnumber().equals(work_id) && list.get(i).getStatus().equals("0")){
				//如果查询到有数据的status=0，且教职工号和工作号和要报名的一样，则不允许报名
				System.out.println("已经有了数据");
				return renderResult(Global.FALSE, text("您已经报过名！"));
			}
		}
		//插入数据
		myApply.setWnumber(work_id);//工作id
		myApply.setTnumber(teacher_number);//老师id
		myApplyService.save(myApply);
		return renderResult(Global.TRUE, text("报名成功！"));
	}
	
}