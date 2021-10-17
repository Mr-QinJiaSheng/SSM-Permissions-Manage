package com.kzfire.portal.action.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kzfire.portal.base.BaseAction;
import com.kzfire.portal.entiy.SysDept;
import com.kzfire.portal.service.DeptService;
import com.kzfire.portal.service.UserService;
import com.kzfire.portal.utils.JSONUtils;
import com.kzfire.portal.utils.VoFactory;
import com.kzfire.portal.vo.ConditionVo;

@RequestMapping("/user/dept")
@Controller
public class DeptAction extends BaseAction{
	@Autowired
	DeptService deptService;
	@Autowired
	UserService userService;
	
	/**
	 * 设置员工部门
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/setUserDept")
	public String setUserDept(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		String userId=request.getParameter("userId");
		model.addAttribute("userId", userId);
		//设置部门树
		List<SysDept> list=deptService.getAllDept();
		model.addAttribute("data", JSONUtils.parseList(list));
		return VIEW+"user/dept/setUserDept";
	}
	
	@RequestMapping("/saveUserdept")
	public ModelAndView saveUserdept(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Integer userId=Integer.parseInt(request.getParameter("userId"));
			Integer deptId=Integer.parseInt(request.getParameter("deptId"));
			deptService.saveUserdept(userId,deptId);
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError("操作失败:"+e.getMessage());
		}
		return ajaxDoneSuccess("操作成功");
	}
	
	@RequestMapping("/main")
	public String list(Model model,HttpServletRequest request,HttpServletResponse response) {
		//设置部门树
		List<SysDept> list=deptService.getAllDept();
		System.out.println("json格式----->"    + JSONUtils.parseList(list).toString() );
		model.addAttribute("data", JSONUtils.parseList(list));
		return VIEW+"user/dept/dept";
	}
	
	@RequestMapping("/userList")
	public String userList(Model model,HttpServletRequest request,HttpServletResponse response) {
		ConditionVo cvo=VoFactory.getConditionVo(request);
		String deptId=request.getParameter("deptId");
		if("1".equals(deptId))
		{
			cvo.setText4("1");
		}else
		{
			cvo.setText3(request.getParameter("deptId"));
		}
		request.setAttribute("deptId", deptId);
		cvo.setTotalCount(userService.getUserCount(cvo));
		model.addAttribute("vo", cvo);
		model.addAttribute("list", userService.getList(cvo));
		return VIEW+"user/dept/userList";
	}
	
	@RequestMapping("/add")
	public String add(Model model,HttpServletRequest request,HttpServletResponse response) {
		SysDept dept=new SysDept();
		dept.setPid(Integer.parseInt(request.getParameter("selDept")));
		model.addAttribute("dept", dept);
		return VIEW+"user/dept/deptEdit";
	}
	@RequestMapping("/edit")
	public String edit(Model model,HttpServletRequest request,HttpServletResponse response) {
		SysDept dept=deptService.getDeptById(Integer.parseInt(request.getParameter("selDept")));
		model.addAttribute("dept", dept);
		return VIEW+"user/dept/deptEdit";
	}
	
	@RequestMapping("/del")
	public ModelAndView del(Model model, HttpServletRequest request)
	{
		try {
			String deptId=request.getParameter("selDept");
			deptService.delDeptById(Integer.parseInt(deptId));
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError("操作失败:"+e.getMessage());
		}
		return ajaxDoneSuccess("操作成功");
	}
	
	@RequestMapping("/save")
	public ModelAndView save(SysDept dept,Model model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if(dept!=null)
			{
				deptService.saveDept(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError("操作失败:"+e.getMessage());
		}
		return ajaxDoneSuccess("操作成功");
	}
}
