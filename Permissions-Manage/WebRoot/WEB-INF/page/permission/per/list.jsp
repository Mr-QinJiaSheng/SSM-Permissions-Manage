<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/include.inc.jsp"%>

<script type="text/javascript">
	
</script>

<div class="pageHeader"></div>

<div class="pageContent j-resizeGrid">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a rel="addRole" target="dialog" class="add"
				href="user/per/add.do" ><span>添加</span></a></li>
			<li><a class="delete"
				href="user/per/del.do?perId={sid_per}" target="ajaxTodo" rel="delRoll" 
				title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" rel="editRole" target="dialog"
				 href="user/per/edit.do?perId={sid_per}"><span>修改</span></a></li>
		</ul>

	</div>
	<table class="table" width="100%" layoutH="90">
		<thead>
			<tr>
				<th width="100" style="text-align: center">权限代码</th>
				<th width="100" style="text-align: center">权限名称</th>
				<th width="100" style="text-align: center">路径</th>
				<th width="100" style="text-align: center">所属模块</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="o">
				<tr target="sid_per" rel="${o.id }">
					<td style="text-align: center">${o.permissionCode }</td>
					<td style="text-align: center">${o.permissionDesc }</td>
					<td style="text-align: center">${o.path}</td>
					<td style="text-align: center">${o.pid}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="panelBar" >
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
<form id="pagerForm" method="post" action="user/per/list.do">
	<input type="hidden" name="pageNum" value="${vo.pageNum}" />
     <input type="hidden" name="numPerPage" value="${vo.numPerPage}" />
</form>
