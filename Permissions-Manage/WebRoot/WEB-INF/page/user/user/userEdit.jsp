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
    <form method="post" action="user/user/save.do?navTabId=userList&callbackType=closeCurrent"  class="pageForm required-validate"  onsubmit="return validateCallback(this,navTabAjaxDone)"> 
    <div class="formBar">  
             
                <div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div>
                <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div> 
             
        </div>   
    <input type="hidden"  value="${user.id}"  name="id"/>
        <div class="pageFormContent nowrap" layoutH="97">  
            <dl>  
                <dt>员工账户</dt>  
                <dd>  
                    <input type="text" name="account" class="required" size="60" maxlength="20"  value="${user.account}"/>  
                </dd>  
            </dl>  
            <dl>  
                <dt>员工姓名</dt>  
                <dd>  
                    <input type="text" name="realName" class="required" size="60" maxlength="20"  value="${user.realName}"/>  
                </dd>  
            </dl>  
            <dl>  
                <dt>密码</dt>  
                <dd>  
                    <input type="password" name="password" class="required" size="60"  maxlength="20"  value="${user.password}"/>  
                </dd>  
            </dl> 
             <dl>  
                <dt>手机号码</dt>  
                <dd>  
                    <input type="text" name="mobile" class="required"   size="60" maxlength="20"  value="${user.mobile}"/>  
                </dd>  
            </dl> 
             <dl>  
                <dt>身份证号</dt>  
                <dd>  
                    <input type="text" name="idCard" class="required"   size="60" maxlength="20"  value="${user.idCard}"/>  
                </dd>  
            </dl> 
            <dl>  
                <dt>家庭地址</dt>  
                <dd>  
                    <input type="text" name="addr"   size="60" maxlength="20"  value="${user.addr}"/>  
                </dd>  
            </dl> 
            
             <dl>  
                <dt>职称</dt>  
                <dd>  
                	<select class="select" name="jobLvl" >
					<option value="0" <c:if test="${user.jobLvl==0}"> selected="selected"</c:if>>无</option>
					<option value="1" <c:if test="${user.jobLvl==1}"> selected="selected"</c:if>>初级工程师</option>
					<option value="2" <c:if test="${user.jobLvl==2}"> selected="selected"</c:if>>中级工程师</option>
					<option value="3" <c:if test="${user.jobLvl==3}"> selected="selected"</c:if>>高级工程师</option>
					</select>
                </dd>  
            </dl> 
              <dl>  
                <dt>性别</dt>  
                <dd>  
                男<input type="radio" <c:if test="${user.sex==1}"> checked ="checked"</c:if> name="sex" value="1"  />
               女<input type="radio" <c:if test="${user.sex==0}"> checked ="checked"</c:if> name="sex" value="0"  />
                </dd>  
            </dl> 
            </dl> 
              <dl>  
                <dt>年龄</dt>  
                <dd>  
                    <input type="text" name="age" class="number"  size="60" maxlength="20"  value="${user.age}"/>  
                </dd>  
            </dl> 
              <dl>  
                <dt>生日</dt>  
                <dd>  
                <input name="mbirthday"  value="${mbirthday}" class="date textInput readonly valid" readonly="true" type="text">
                </dd>  
            </dl> 
            
             <dl>  
                <dt>入职时间</dt>  
                <dd>  
                <input name="mjoinTime"  value="${mjoinTime}" class="date textInput readonly valid" readonly="true" type="text">
                </dd>  
            </dl> 
            
             <dl>  
                <dt>是否有效</dt>  
                <dd>  
                	<select class="select" name="isUse" >
					<option  <c:if test="${user.isUse==1}"> selected="selected"</c:if> value="1">有效</option>
					<option <c:if test="${user.isUse==0}"> selected="selected"</c:if> value="0">无效</option>
					</select>
                </dd>  
            </dl> 
        </div>  
    </form>  
</div>  
  </body>
</html>
