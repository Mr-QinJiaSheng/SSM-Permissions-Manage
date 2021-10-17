<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	$.pdialog.resizeDialog({
		style : {
			width : 450
		}
	}, $.pdialog.getCurrent(), "");
</script>

</head>

<body>
	<div class="pageContent">
		<form method="post"
			action="user/user/saveRole.do?navTabId=userList&callbackType=closeCurrent"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,dialogAjaxDone)">
			<div class="formBar">

				<div class="buttonActive">
					<div class="buttonContent">
						<button type="submit">保存</button>
					</div>
				</div>
				<div class="button">
					<div class="buttonContent">
						<button type="button" class="close">取消</button>
					</div>
				</div>
				<input type="hidden" name="userId" value="${userId}" />
			</div>
			<div
				style=" float:left; display:block; margin:10px; overflow:auto; width:400px; height:200px; overflow:auto; border:solid 1px #CCC; line-height:21px; background:#FFF;">
				<c:forEach items="${vos}" var="vo">
					&nbsp;&nbsp;<input name="roleCode" type="checkbox"
						<c:if test="${vo.isSel=='1'}">checked="true"</c:if>
						value="${vo.roleId}" /> ${vo.roleName} </br>
				</c:forEach>
			</div>
			<!--  
			<div
				style=" float:left; display:block; margin:10px; overflow:auto; width:400px; height:200px; overflow:auto; border:solid 1px #CCC; line-height:21px; background:#FFF;">
				<ul class="tree treeFolder treeCheck expand" oncheck="kkk">
						<li><a>全部角色</a>
							<ul>
								<c:forEach items="${vos}" var="vo">
									<li><a tname="roleCode" tvalue="${vo.roleId}"  <c:if test="${vo.isSel=='1'}">checked="true"</c:if> >${vo.roleName}</a></li>
								</c:forEach>
							</ul>
						</li>
				</ul>
			</div>
			-->
		</form>
	</div>
</body>
</html>
