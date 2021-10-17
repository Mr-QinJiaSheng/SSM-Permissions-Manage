<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/include.inc.jsp"%>
 <link rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>

<script type="text/javascript" src="ztree/js/jquery.ztree.core-3.5.js"></script> 

<script type="text/javascript">
	var zTree;
	var demoIframe;
	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		data: {
			key:{
				name:"deptName"
			},
			simpleData: {
				enable:true,
				idKey: "deptId",
				pIdKey: "pid",
				rootPId: "0"
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode) {
				//alert(treeNode.deptId);
				$("#deptName").html(treeNode.deptName);
				//加载数据到div
				$("#addDept").attr('href',"user/dept/add.do?selDept="+treeNode.deptId); 
				$("#editDept").attr('href',"user/dept/edit.do?selDept="+treeNode.deptId); 
				$("#delDept").attr('href',"user/dept/del.do?selDept="+treeNode.deptId); 
				$("#jbsxBox").loadUrl("user/dept/userList.do?deptId="+treeNode.deptId,"", null); 
				return true;
			}
		}
	};


	$(document).ready(function(){
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, ${data});
		demoIframe = $("#testIframe");
		demoIframe.bind("load", loadReady);
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.expandAll(true);
		$("#jbsxBox").loadUrl("user/dept/userList.do?deptId=1","", null); 
	});

	function loadReady() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
		htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = demoIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		demoIframe.height(h);
	}
	function delCallBack(json)
	{
		  DWZ.ajaxDone(json);  
     //注意返回的JSON的数据结构  
      if (json.statusCode == DWZ.statusCode.ok){  
  
                  navTab.reload();  
      } 
	}
</script>
<div class="pageContent" style="padding:5px">
	<div class="panel" defH="40">
		<h1 id="deptName" style="text-align:center;">Gcc【】</h1>
		<div>
			<ul class="leftTools">
				<li><a class="button" rel="addDept" target="dialog" href="user/dept/add.do?selDept=1" id="addDept"  mask="true"><span>创建子部门</span></a></li>
				<li><a class="button" target="dialog" href="user/dept/edit.do?selDept=1" id="editDept" mask="true"><span>编辑部门</span></a></li>
				<li><a class="button" target="ajaxTodo" 
				 title="确定要删除部门吗？删除后部门员工将无部门关系！" callback="delCallBack"
				  href="user/dept/del.do?selDept=1"  
				  id="delDept" mask="true"><span>删除部门</span></a></li>
			</ul>
		</div>
	</div>
	<div class="divider"></div>
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>部门列表</span></a></li>
				</ul>
			</div>
		</div>
		<input type="hidden" value="0" id="selDept"/>
		
		<div class="tabsContent">
			<div>
	
				<div layoutH="146" style="float:left; display:block; overflow:auto; width:240px; border:solid 1px #CCC; line-height:21px; background:#fff">
				    <TABLE border=0 height=600px align=left>
					<TR>
						<TD width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
							<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
						</TD>
						<TD width=770px align=left valign=top><IFRAME ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px SRC="core/standardData.html"></IFRAME></TD>
					</TR>
				</TABLE>
				</div>
				
				<div id="jbsxBox" class="unitBox" style="margin-left:246px;">
				</div>
	
			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
</div>


	

