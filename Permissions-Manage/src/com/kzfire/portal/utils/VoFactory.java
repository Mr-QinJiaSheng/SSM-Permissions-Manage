package com.kzfire.portal.utils;

import javax.servlet.http.HttpServletRequest;

import com.kzfire.portal.vo.ConditionVo;


public class VoFactory {
	public static ResultVo getResultVo()
	{
		return new ResultVo();
	}

	public static ConditionVo getConditionVo(HttpServletRequest request) {
		ConditionVo cvo= new ConditionVo();
		Integer pages =1;
				try {
					pages= Integer
							.valueOf(request.getParameter("pageNum") == null ? "1"
									: request.getParameter("pageNum"));
				} catch (Exception e) {
				}
		
		Integer pagesize=20;
		try {
			pagesize = Integer
					.valueOf(request.getParameter("numPerPage") == null ? "20"
							: request.getParameter("numPerPage"));
		} catch (Exception e) {
		}
		
		cvo.setNumPerPage(pagesize);
		cvo.setPageNum(pages);
		cvo.setStartRow((pages - 1) * pagesize );
		cvo.setEndRow((pages - 1) * pagesize + pagesize);
		cvo.setText0(request.getParameter("text0"));
		cvo.setText1(request.getParameter("text1"));
		cvo.setText2(request.getParameter("text2"));
		return cvo;
	}
}
