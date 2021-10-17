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
	</script>

  </head>

  <body>
<div class="pageContent">  
    <form method="post" action="user/role/save.do?navTabId=roleList&callbackType=closeCurrent"  class="pageForm required-validate"  onsubmit="return validateCallback(this,dialogAjaxDone)"> 
    <div class="formBar">  
             
                <div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div>
                <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div> 
             
        </div>   
    <input type="hidden" value="${role.roleId}" name="roleId"/>
        <div class="pageFormContent nowrap" layoutH="97">  
            <dl>  
                <dt>角色代码</dt>  
                <dd>  
                    <input type="text" name="roleCode" class="required" size="60" maxlength="10"  value="${role.roleCode}"/>  
                </dd>  
            </dl>  
            <dl>  
                <dt>角色名称</dt>  
                <dd>  
                    <input type="text" name="roleDesc" class="required" size="60" maxlength="10"  value="${role.roleDesc}"/>  
                </dd>  
            </dl>  
        </div>  
    </form>  
</div>  
  </body>
</html>
