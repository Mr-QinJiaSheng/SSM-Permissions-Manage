<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include.inc.jsp"%>
{
	"statusCode":"${statusCode}", 
	"message":"${param.callbackType ne 'forwardConfirm' ? message : ''}", 
	"confirmMsg":"${param.callbackType eq 'forwardConfirm' ? message : ''}",
	"navTabId":"${param.navTabId}", 
	"rel":"${param.rel}",
	"callbackType":"${param.callbackType}",
	"forwardUrl":"${empty forwardUrl ? param.forwardUrl : forwardUrl}"
}