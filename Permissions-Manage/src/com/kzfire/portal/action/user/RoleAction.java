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
import com.kzfire.portal.entiy.SysRole;
import com.kzfire.portal.service.RoleService;
import com.kzfire.portal.utils.VoFactory;
import com.kzfire.portal.vo.ConditionVo;
import com.kzfire.portal.vo.PerGroupVo;

@RequestMapping("/user/role")
@Controller
public class RoleAction extends BaseAction{
	@Autowired
	RoleService roleService;
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request,HttpServletResponse response) {
		ConditionVo cvo=VoFactory.getConditionVo(request);
		cvo.setTotalCount(roleService.getTableCount("sys_role"));
		model.addAttribute("vo", cvo);
		model.addAttribute("list", roleService.getList(cvo));
		return VIEW+"permission/role/list";
	}
	
	/**
	 * 权限编辑页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/editPermission")
	public String editPermission(Model model, HttpServletRequest request)
	{
		String roleId=request.getParameter("roleId");
		//获取角色权限
		List<PerGroupVo> group=roleService.getPerGroupVoByUserId(Integer.parseInt(roleId));
		model.addAttribute("group", group);
		model.addAttribute("roleId", roleId);
		return VIEW+"permission/role/editPermission";
	}
	
	@RequestMapping("/savePer")
	public ModelAndView savePer(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String[] perIds=request.getParameterValues("perId");
			roleService.savePermission(perIds,Integer.parseInt(request.getParameter("roleId")));
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError("操作失败");
		}
		
		return ajaxDoneSuccess("操作成功");
	}
	
	@RequestMapping("/add")
	public String add(Model model, HttpServletRequest request)
	{
		model.addAttribute("role", new SysRole());
		return VIEW+"permission/role/roleEdit";
	}
	
	
	
	@RequestMapping("/edit")
	public String edit(Model model, HttpServletRequest request)
	{
		String roleId=request.getParameter("roleId");
		SysRole role=roleService.getRoleById(Integer.parseInt(roleId));
		model.addAttribute("role", role);
		return VIEW+"permission/role/roleEdit";
	}
	
	
	
	@RequestMapping("/del")
	public ModelAndView del(Model model, HttpServletRequest request)
	{
		try {
			String roleId=request.getParameter("roleId");
			roleService.delRoleById(Integer.parseInt(roleId));
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError("操作失败");
		}
		return ajaxDoneSuccess("操作成功");
	}
	
	@RequestMapping("/save")
	public ModelAndView save(SysRole role,Model model, HttpServletRequest request,
			HttpServletResponse response) {
		if(role!=null)
		{
			roleService.saveShop(role);
		}
		return ajaxDoneSuccess("操作成功");
	}
	

}
