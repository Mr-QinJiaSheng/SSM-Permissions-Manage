<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/include.inc.jsp"%>

<script type="text/javascript">
	
	var v=jQuery("#zaizhi").val();
	if(v==2)
	{
		$("#toolBar").hide();
		$("[name='jiaoseguanli']").hide();
	}else
	{
		$("#toolBar").show();
		$("[name='jiaoseguanli']").show();
	}
</script>

<div class="pageHeader">

<form onsubmit="return navTabSearch(this);" id="searchForm" action="user/user/list.do" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					员工姓名：<input type="text"  value="${vo.text1 }" name="text1" />
				</td>
				<td>
					员工账号：<input type="text" value="${vo.text2 }" name="text2" />
				</td>
				<td>
					<select class="combox" name="text0" id="zaizhi" >
						<option <c:if test="${vo.text0==1}"> selected="selected"</c:if> value="1">在职</option>
						<option <c:if test="${vo.text0==2}"> selected="selected"</c:if> value="2">离职</option>
					</select>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button onclick="javascript:hideBar();" type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>

<div class="pageContent j-resizeGrid">
	<div class="panelBar" >
		<ul  class="toolBar" id="toolBar">
			<li > <a  rel="addRole"  target="navTab" class="add"
				href="user/user/add.do" ><span>入职</span></a></li>
			<li><a class="delete"
				href="user/user/del.do?userId={sid_user}&navTabId=userList" target="ajaxTodo" rel="delUser" 
				title="确定要离职操作吗?此操作将不可逆转!!!"><span>离职</span></a></li>
			<li><a class="edit" rel="editUser" target="navTab"
				 href="user/user/edit.do?userId={sid_user}"><span>编辑</span></a></li>
		</ul>

	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100" style="text-align: center">员工账号</th>
				<th width="100" style="text-align: center">员工姓名</th>
				<th width="100" style="text-align: center">部门</th>
				<th width="100" style="text-align: center">手机号</th>
				<th width="100" style="text-align: center">入职时间</th>
				<th width="100" style="text-align: center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="o">
				<tr target="sid_user" rel="${o.id }">
					<td style="text-align: center">${o.account }</td>
					<td style="text-align: center">${o.realName }</td>
					<td style="text-align: center">${o.deptName==null?"--":o.deptName}</td>
					<td style="text-align: center">${o.mobile}</td>
					<td style="text-align: center"><fmt:formatDate  type="date" value="${o.joinTime}"/></td>
					<td style="text-align: center"><a
					href="user/user/editRole.do?userId=${o.id }"  name="jiaoseguanli" target="dialog" rel="editRole"
					 style="color: blue;cursor:pointer;">角色管理</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> <select class="combox" name="numPerPage">
				<option value="20">20</option>
			</select> <span>条，共${vo.totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab"
			totalCount="${vo.totalCount}" numPerPage="${vo.numPerPage}"
			pageNumShown="5" currentPage="${vo.pageNum}"></div>

	</div>
</div>
<form id="pagerForm" method="post" action="user/user/list.do">
	<input type="hidden" name="pageNum" value="${vo.pageNum}" />
    <input type="hidden" name="numPerPage" value="${vo.numPerPage}" />
    <input type="hidden" name="text0" value="${vo.text0==null?1:vo.text0}"/>
	<input type="text" name="text1"  value="${vo.text1}"/>
	<input type="text" name="text2"  value="${vo.text2}"/>
</form>
	
