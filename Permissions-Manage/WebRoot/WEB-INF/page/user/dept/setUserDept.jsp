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
				alertMsg.confirm("确定将该员工分配到"+treeNode.deptName+"吗？", {
								 okCall: function(){
								  	$.post("user/dept/saveUserdept.do",
								  	 {userId: ${userId},deptId:treeNode.deptId}, 
								  	 function(json){
								  	   DWZ.ajaxDone(json); 
								  	   $.pdialog.closeCurrent();
								  	   //刷新div
								  	   divSearch($("#pagerForm2"), 'jbsxBox');
									  }, "json");
								  
								 },
								 cancelCall : function() {}
								});
				return true;
			}
		}
	};

	function saveUdCallBack()
	{	
	
	}

	$(document).ready(function(){
		var t = $("#tree2");
		t = $.fn.zTree.init(t, setting, ${data});
		var zTree = $.fn.zTree.getZTreeObj("tree2");
		zTree.expandAll(true);
	});

	$.pdialog.resizeDialog({
		style : {
			width : 470
		}
	}, $.pdialog.getCurrent(), "");
</script>
<div class="pageContent" style="padding:5px">
	
				<div layoutH="40" style="float:left; display:block; overflow:auto; width:440px;  line-height:21px; background:#fff">
				    <TABLE border=0 height=200px align=left>
					<TR>
						<TD width=260px align=left valign=top>
							<ul id="tree2" class="ztree" style="width:160px; overflow:auto;"></ul>
						</TD>
					</TR>
				</TABLE>
				</div>
	
</div>


	

