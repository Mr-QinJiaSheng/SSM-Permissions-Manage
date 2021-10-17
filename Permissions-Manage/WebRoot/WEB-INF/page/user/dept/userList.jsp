<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/include.inc.jsp"%>
<script type="text/javascript">
	
</script>


<div class="pageHeader" style="border:1px #B8D0D6 solid">
	<form id="pagerForm2" onsubmit="return divSearch(this, 'jbsxBox');" action="user/dept/userList.do" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					员工姓名：<input type="text" name="text1" value="${vo.text1}" />
					<input type="hidden" name="text0" value="1"/>
					<input type="hidden" name="deptId" value="${deptId}"/>
				</td>
				<td><div class="buttonActive"><div class="buttonContent"><button  id="jiansuo" type="submit">检索</button></div></div></td>
			</tr>
		</table>
	</div>
	</form>
</div>




<div class="pageContent j-resizeGrid" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
	<div class="grid">
		<div class="gridHeader"><div class="gridThead"><table style="width:765px;"><thead>
			<tr>
				<th style="text-align: center; width: 112px;"><div class="gridCol" title="员工姓名">员工姓名</div></th>
				<th class="" style="text-align: center; width: 112px; cursor: col-resize;"><div class="gridCol" title="员工账号">员工账号</div></th>
				<th style="text-align: center; width: 112px;"><div class="gridCol" title="部门">部门</div></th>
				<th style="text-align: center; width: 112px;"><div class="gridCol" title="手机号">手机号</div></th>
				<th style="text-align: center; width: 112px;"><div class="gridCol" title="入职时间">入职时间</div></th>
				<th style="text-align: center; width: 112px;"><div class="gridCol" title="操作">操作</div></th>
			</tr>
		</thead></table></div></div>
		<div class="gridScroller" layouth="230" style="width: 793px; height: 565px; overflow: auto;"><div class="gridTbody"><table style="width:765px;"><tbody>
			<c:forEach items="${list}" var="o">
				<tr target="sid_user" rel="${o.id }">
					<td style="text-align: center">${o.realName }</td>
					<td style="text-align: center">${o.account }</td>
					<td style="text-align: center">${o.deptName==null?"--":o.deptName}</td>
					<td style="text-align: center">${o.mobile}</td>
					<td style="text-align: center"><fmt:formatDate  type="date" value="${o.joinTime}"/></td>
					<td style="text-align: center"><a
					href="user/dept/setUserDept.do?userId=${o.id }"  name="jiaoseguanli" target="dialog" rel="setUserDept"
					 style="color: blue;cursor:pointer;">部门分配</a></td>
				</tr>
			</c:forEach>
		</tbody></table></div></div>
	<div class="resizeMarker" style="height:300px; left:57px;display:none;"></div><div class="resizeProxy" style="height:300px; left:377px;display:none;"></div></div>

	<div class="panelBar">
			<div class="pages">
				<span>显示</span>
				<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox')">
					<option value="20">20</option>
				</select>
				<span>条，共${vo.totalCount}条</span>
			</div>
			<div class="pagination" rel="jbsxBox" totalCount="${vo.totalCount}" numPerPage="${vo.numPerPage}" pageNumShown="5" currentPage="${vo.pageNum}"></div>
		</div>
	</div>
	<form id="pagerForm" method="post" action="user/dept/userList.do">
		<input type="hidden" name="pageNum" value="${vo.pageNum}" />
	     <input type="hidden" name="numPerPage" value="${vo.numPerPage}" />
	     <input type="hidden" name="text1" value="${vo.text1}" />
		<input type="hidden" name="text0" value="1"/>
		<input type="hidden" name="deptId" value="${deptId}"/>
	</form>
