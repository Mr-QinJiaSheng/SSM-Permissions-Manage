package com.kzfire.portal.action.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kzfire.portal.base.BaseAction;
import com.kzfire.portal.entiy.SysUser;
import com.kzfire.portal.service.UserService;
import com.kzfire.portal.utils.Contents;
import com.kzfire.portal.utils.MStringUtils;
import com.kzfire.portal.utils.VoFactory;
import com.kzfire.portal.vo.ConditionVo;
import com.kzfire.portal.vo.UserRoleVo;

@Controller
@RequestMapping("/user/user")
public class UserAction extends BaseAction{
	@Autowired
	UserService userService;
	
	@RequestMapping("/saveRole")
	public ModelAndView savePer(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String[] roleId=request.getParameterValues("roleCode");
			//System.out.println("角色ID码--->" + roleId );
			userService.saveUserRole(roleId,Integer.parseInt(request.getParameter("userId")));
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError("操作失败");
		}
		
		return ajaxDoneSuccess("操作成功");
	}
	@RequestMapping("/editRole")
	public String editRole(Model model,HttpServletRequest request,HttpServletResponse response) {
		Integer userId=Integer.parseInt(request.getParameter("userId"));
		List<UserRoleVo> vos=userService.getUserRoleVo(userId);
		model.addAttribute("vos", vos);
		model.addAttribute("userId", userId);
		return VIEW+"user/user/editRole";
	}
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request,HttpServletResponse response) {
		ConditionVo cvo=VoFactory.getConditionVo(request);
		cvo.setTotalCount(userService.getUserCount(cvo));
		model.addAttribute("vo", cvo);
		model.addAttribute("list", userService.getList(cvo));
		return VIEW+"user/user/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model, HttpServletRequest request)
	{
		model.addAttribute("user", new SysUser());
		return VIEW+"user/user/userEdit";
	}
	
	@RequestMapping("/changePsw")
	public String changePsw(HttpServletRequest request)
	{
		return VIEW+"user/user/changePsw";
	}
	
	@RequestMapping("/savePsw")
	public ModelAndView savePsw(HttpServletRequest request)
	{
		String newPsw=request.getParameter("newPsw");
		String newPsw1=request.getParameter("newPsw1");
		String oldPsw=request.getParameter("oldPsw");
		if(!newPsw.equals(newPsw1))
			return ajaxDoneError("两次密码不一样");
		if(newPsw.equals(oldPsw))
			return ajaxDoneError("新旧密码一样");
		try {
			if(!oldPsw.equals(getLoginUser(request).getPassword()))
				return ajaxDoneError("原密码错误");
		} catch (Exception e1) {
			return ajaxDoneError(e1.getMessage());
		}
		try {
			SysUser user=new SysUser();
			user.setId(getLoginUser(request).getId());
			user.setPassword(newPsw);
			userService.updateUser(user);
		} catch (Exception e) {
			return ajaxDoneError("操作失败");
		}
//		request.getSession().removeAttribute(Contents.LOGIN_USER);
//	    Subject currentUser = SecurityUtils.getSubject();
//	    currentUser.logout();//退出登录操作  
		return ajaxDoneSuccess("修改成功");
	}
	@RequestMapping("/edit")
	public String edit(Model model, HttpServletRequest request)
	{
		SysUser user=userService.getSysUserById(Integer.parseInt(request.getParameter("userId")));
		model.addAttribute("user", user);
		model.addAttribute("mbirthday", MStringUtils.TimeTostr(user.getBirthday(), null));
		model.addAttribute("mjoinTime", MStringUtils.TimeTostr(user.getJoinTime(), null));
		return VIEW+"user/user/userEdit";
	}
	
	@RequestMapping("/save")
	public ModelAndView save(SysUser user,Model model, HttpServletRequest request,
			HttpServletResponse response) {
		if(user!=null)
		{
			try {
				user.setBirthday(MStringUtils.strToTime(request.getParameter("mbirthday"),null));
				user.setJoinTime(MStringUtils.strToTime(request.getParameter("mjoinTime"),null));
				userService.saveUser(user);
			} catch (Exception e) {
				return ajaxDoneError("操作失败");
			}
		}
		return ajaxDoneSuccess("操作成功");
	}
	
	@RequestMapping("/del")
	public ModelAndView del(String userId,Model model, HttpServletRequest request,
			HttpServletResponse response) {
			try {
				//员工离职
				userService.userLeft(Integer.parseInt(userId));
			} catch (Exception e) {
				return ajaxDoneError("操作失败");
			}
		return ajaxDoneSuccess("操作成功");
	}

}
