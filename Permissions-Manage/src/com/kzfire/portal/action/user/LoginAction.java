package com.kzfire.portal.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kzfire.portal.base.BaseAction;
import com.kzfire.portal.entiy.LoginLog;
import com.kzfire.portal.entiy.SysUser;
import com.kzfire.portal.service.UserService;
import com.kzfire.portal.utils.Contents;
import com.kzfire.portal.utils.MStringUtils;

@Controller
public class LoginAction extends BaseAction {
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String list(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		if (existEmpty(new Object[] { username, password,code })) {
			request.setAttribute("message_login", "参数错误");
	           return "login";
		}
		if(!getCurCode(request,code))
		{
			 request.setAttribute("message_login", "验证码错误");
	           return "login";
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		token.setRememberMe(true);
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {  
            currentUser.login(token);  
        }catch(UnknownAccountException uae){  
            request.setAttribute("message_login", "未知账户");
            return "login";
        }catch(IncorrectCredentialsException ice){  
            request.setAttribute("message_login", "密码不正确");  
            return "login";
        }catch(LockedAccountException lae){  
            request.setAttribute("message_login", "账户已锁定");  
            return "login";
        }catch(ExcessiveAttemptsException eae){  
            request.setAttribute("message_login", "用户名或密码错误次数过多");  
            return "login";
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            request.setAttribute("message_login", "用户名或密码不正确");  
            return "login";
        }  
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){  
        	SysUser user=userService.getByUsername(username);
    		if(user.getIsUse()==0||user.getLeftTime()!=null)
    		{
    			request.setAttribute("message_login", "该用户被锁定，请联系管理员！");  
                return "login";
    		}
        	request.getSession().setAttribute(Contents.LOGIN_USER, user);
        	//写登录日志
        	LoginLog log=new LoginLog();
        	log.setUserId(user.getId());
        	log.setLoginTime(MStringUtils.getTime());
        	log.setLoginIp(getRequestIp(request));
        	userService.saveLoginLog(log);
        }else{  
            token.clear();  
            return "login";
        }  
		return VIEW + "index";
	}


	

	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request,
			HttpServletResponse response){
	    request.getSession().removeAttribute(Contents.LOGIN_USER);
	    Subject currentUser = SecurityUtils.getSubject();
	    currentUser.logout();//退出登录操作  
		return "login";
	}

	
}
