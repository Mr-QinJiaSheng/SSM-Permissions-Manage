<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/include.inc.jsp"%>

<script type="text/javascript">
	
</script>

<div class="pageHeader"></div>

<div class="pageContent j-resizeGrid">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a rel="addRole" target="dialog" class="add"
				href="user/role/add.do" ><span>添加</span></a></li>
			<li><a class="delete"
				href="user/role/del.do?roleId={sid_role}" target="ajaxTodo" rel="delRoll" 
				title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" rel="editRole" target="dialog"
				 href="user/role/edit.do?roleId={sid_role}"><span>修改</span></a></li>
		</ul>

	</div>
	<table class="table" width="100%" layoutH="90">
		<thead>
			<tr>
				<th width="100" style="text-align: center">角色代码</th>
				<th width="100" style="text-align: center">角色名称</th>
				<th width="100" style="text-align: center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="o">
				<tr target="sid_role" rel="${o.roleId }">
					<td style="text-align: center">${o.roleCode }</td>
					<td style="text-align: center">${o.roleDesc }</td>
					<td style="text-align: center"><a
					href="user/role/editPermission.do?roleId=${o.roleId}" target="dialog" rel="editPermission"
					 style="color: blue;cursor:pointer;">编辑权限</a></td>
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
<form id="pagerForm" method="post" action="user/role/list.do">
	<input type="hidden" name="pageNum" value="${vo.pageNum}" />
     <input type="hidden" name="numPerPage" value="${vo.numPerPage}" />
</form>
