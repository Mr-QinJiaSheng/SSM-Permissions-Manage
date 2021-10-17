<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>用户登录</TITLE>
<LINK href="common/images/Default.css" type=text/css rel=stylesheet>
<LINK href="common/images/xtree.css" type=text/css rel=stylesheet>
<LINK href="common/images/User_Login.css" type=text/css rel=stylesheet>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
<meta http-equiv="Cache" content="no-cache">
<meta http-equiv="Pragma" content="no-cache" />   
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<script type="text/javascript">
document.getElementById("password").value = "";
	function login()
	{
		var code=document.getElementById("code").value;
		var name=document.getElementById("username").value;
		var password=document.getElementById("password").value;
	/* 	if(name==""||password==""||name.length<5||password.length<5||containSpecial(name)||containSpecial(password))
		{
			alert("请正确输入账号密码");
			return false;
		} */
		 if(code==""||code.length!=4)
		{
			alert("请输入验证码");
			return false;
		}
		return true;
	}


	function containSpecial( s )      
	{      
	    var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);   
	    return ( containSpecial.test(s) );      
	}  
       
       
</script>

</HEAD>
<BODY id=userlogin_body>
	<DIV></DIV>

	<DIV id=user_login>
		<DL>
			<DD id=user_top>
				<UL>
					<LI class=user_top_l></LI>
					<LI class=user_top_c></LI>
					<LI class=user_top_r></LI>
				</UL>
			<DD id=user_main>
			<form action="login.do" id="login" method="post" onsubmit="return  login();">
				<UL>
					<LI class=user_main_l></LI>
					<LI class=user_main_c>
						<DIV class=user_main_box>
							<UL>
								<LI class=user_main_text>用户名：</LI>
								<LI class=user_main_input><INPUT id="username" class=TxtUserNameCssClass
									id=TxtUserName maxLength=20 name="username" value="admin"></LI>
							</UL>
							<UL>
								<LI class=user_main_text>密 码：</LI>
								<LI class=user_main_input><INPUT id="password" class=TxtPasswordCssClass
									id=TxtPassword type=password name="password" value="123456"></LI>
							</UL>
							<UL>
								<LI class=user_main_text>验证码：</LI>
								<LI class=user_main_input><INPUT class=TxtValidateCodeCssClass
									id="code" type="text" name="code" size="10"    width="10" />
									<img id="imageCode" src="code/getImage.do"  style="margin-bottom: -5px;"
            title="看不清，点击换一张" style="cursor: pointer;" onclick="this.src=this.src+'?'+Math.random();" />    </LI>
									
									
							</UL>
							<UL>
								<LI style="color: red">${message_login}</LI>
							</UL>
						</DIV>
					</LI>
					<LI class=user_main_r><INPUT class=IbtnEnterCssClass
						id=IbtnEnter
						style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
						type=image src="common/images/user_botton.gif" name=IbtnEnter></LI>
				</UL>
				</form>
			<DD id=user_bottom>
				<UL>
					<LI class=user_bottom_l></LI>
					<LI class=user_bottom_c></LI>
					<LI class=user_bottom_r></LI>
				</UL>
			</DD>
		</DL>
	</DIV>
	<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
	<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
	<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
	<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>

	<DIV></DIV>

	</FORM>
</BODY>
</HTML>


