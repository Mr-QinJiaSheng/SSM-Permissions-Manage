package com.kzfire.portal.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kzfire.portal.base.BaseAction;
import com.kzfire.portal.entiy.SysPermission;
import com.kzfire.portal.service.PermissionService;
import com.kzfire.portal.utils.VoFactory;
import com.kzfire.portal.vo.ConditionVo;

@RequestMapping("/user/per")
@Controller
public class PermissionAction extends BaseAction{
	@Autowired
	PermissionService permissionService;
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request,HttpServletResponse response) {
		ConditionVo cvo=VoFactory.getConditionVo(request);
		cvo.setTotalCount(permissionService.getTableCount("sys_permission"));
		model.addAttribute("vo", cvo);
		model.addAttribute("list", permissionService.getList(cvo));
		return VIEW+"permission/per/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model, HttpServletRequest request)
	{
		model.addAttribute("per", new SysPermission());
		return VIEW+"permission/per/perEdit";
	}
	
	
	
	@RequestMapping("/edit")
	public String edit(Model model, HttpServletRequest request)
	{
		String perId=request.getParameter("perId");
		SysPermission per=permissionService.getPermissionById(Integer.parseInt(perId));
		model.addAttribute("per", per);
		return VIEW+"permission/per/perEdit";
	}
	
	@RequestMapping("/del")
	public ModelAndView del(Model model, HttpServletRequest request)
	{
		try {
			String perId=request.getParameter("perId");
			permissionService.delPermissionById(Integer.parseInt(perId));
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError("操作失败");
		}
		return ajaxDoneSuccess("操作成功");
	}
	
	@RequestMapping("/save")
	public ModelAndView save(SysPermission per,Model model, HttpServletRequest request,
			HttpServletResponse response) {
		if(per!=null)
		{
			permissionService.savePermission(per);
		}
		return ajaxDoneSuccess("操作成功");
	}
}
