<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.inc.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	$.pdialog.resizeDialog({style: {height: 250}}, $.pdialog.getCurrent(), "");
	</script>

  </head>

  <body>
<div class="pageContent">  
    <form method="post" action="user/dept/save.do?navTabId=deptMian&callbackType=closeCurrent"  class="pageForm required-validate"  onsubmit="return validateCallback(this,dialogAjaxDone)"> 
    <div class="formBar">  
             
                <div class="buttonActive"><div   class="buttonContent"><button type="submit">保存</button></div></div>
                <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div> 
             
        </div>   
    <input type="hidden" value="${dept.deptId}" name="deptId"/>
     <input type="hidden" value="${dept.pid}" name="pid"/>
        <div class="pageFormContent nowrap" layoutH="97">  
            <dl>  
                <dt>部门名称</dt>  
                <dd>  
                    <input type="text" name="deptName" class="required" size="60" maxlength="10"  value="${dept.deptName}"/>  
                </dd>  
            </dl>  
        </div>  
    </form>  
</div>  
  </body>
</html>
