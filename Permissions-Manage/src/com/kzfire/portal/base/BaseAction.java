package com.kzfire.portal.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.kzfire.portal.entiy.SysUser;
import com.kzfire.portal.utils.Contents;
import com.kzfire.portal.utils.ResultVo;
import com.kzfire.portal.utils.VoFactory;

/**
 * @author ysf 基础action 2014-8-21 上午9:15:21
 */
public class BaseAction {
	protected ResultVo re = VoFactory.getResultVo();
	protected final static String VIEW = "WEB-INF/page/";
	protected static Logger log = Logger.getLogger(BaseAction.class);

	/**
	 * 是否存在空的对象 存在返回Null 检测参数是否齐全
	 * 
	 * @param strs
	 * @return
	 */
	protected boolean existEmpty(Object objs[]) {
		boolean re = false;
		Object as[];
		int j = (as = objs).length;
		for (int i = 0; i < j; i++) {
			Object obj = as[i];
			if (obj == null) {
				re = true;
				break;
			}
			if (obj instanceof String) {
				String new_name = (String) obj;
				if (StringUtils.isEmpty(new_name)) {
					re = true;
					break;
				}
			}
		}
		return re;
	}

	protected SysUser getLoginUser(HttpServletRequest request) throws Exception {
		SysUser user = (SysUser) request.getSession().getAttribute(
				Contents.LOGIN_USER);
		if(user==null)
		{
			throw new Exception("登录超时");
		}
		return user;

	}

	protected ModelAndView ajaxDoneSuccess(String message) {
		return ajaxDone(200, message, "");
	}

	protected ModelAndView ajaxDoneError(String message) {
		if (message == null) {
			message = "空指针异常";
		}
		return ajaxDone(300, message, "");
	}

	protected ModelAndView ajaxDone(int statusCode, String message,
			String forwardUrl) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("forwardUrl", forwardUrl);
		return mav;
	}

	/**
	 * 获取真实的登录ip
	 * @param request
	 * @return
	 */
	protected String getRequestIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 获取最新的验证码
	 * @param request
	 * @return
	 */
	protected boolean getCurCode(HttpServletRequest request,String checkcode) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return false;
		}
		String code = (String) session.getAttribute("checkCode");
		session.removeAttribute("checkCode");
		if (checkcode != null && checkcode.equalsIgnoreCase(code)) {
			return true;
		} else {
			return false;
		}
	}

}
