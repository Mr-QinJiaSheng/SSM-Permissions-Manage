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
	$.pdialog.resizeDialog({style: {width: 450}}, $.pdialog.getCurrent(), "");
	
	function checkGroup(group) {
		$("#"+group+"_"+"a").click();
	}
</script>

</head>

<body>
	<div class="pageContent">
		<form method="post"
			action="user/role/savePer.do?navTabId=roleList&callbackType=closeCurrent"
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
				<input type="hidden" name="roleId" value="${roleId}" />
			</div>
			<div
				style=" float:left; display:block; margin:10px; overflow:auto; width:400px; height:200px; overflow:auto; border:solid 1px #CCC; line-height:21px; background:#FFF;">
				<ul>
					<c:forEach items="${group}" var="o">
						<li><a style="color: blue;cursor:pointer;" onclick="checkGroup('${o.group}');">&nbsp;&nbsp;&nbsp;${o.group}</a>
							<ul class="tree treeFolder treeCheck expand" >
								<c:forEach items="${o.per}" var="vo">
									<li><a tname="perId" tvalue="${vo.id}" id="${o.group}_a"
										<c:if test="${vo.isCheck=='1'}">checked="true"</c:if>>
											${vo.desc}</a></li>
								</c:forEach>
							</ul></li>
					</c:forEach>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>
