package com.kzfire.portal.action.common;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kzfire.portal.service.CheckCodeService;

@Controller
@RequestMapping("/code")
public class CheckCodeController {

	@Autowired
	private CheckCodeService checkCodeService;

	/**
	 * 生成校验码图片
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getImage")
	public void getImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应是图片
		response.setContentType("image/jpeg");

		// String code = checkCodeService.generateRandomNumberCode();
		String code = checkCodeService.generateRandomMixedCode();
		// 将生成的验证码保存到Session中
		HttpSession session = request.getSession(true);
		session.setAttribute("checkCode", code);
		ImageIO.write(checkCodeService.getImage(code), "JPEG",
				response.getOutputStream());
	}


}