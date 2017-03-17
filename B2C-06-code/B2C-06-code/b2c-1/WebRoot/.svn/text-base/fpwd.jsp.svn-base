<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>

<title>找回密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link style="text/css" href="css/loginstyle.css" rel="stylesheet" />
<script type="text/javascript" src="js/user.js"></script>

</head>

<body>
	<div class="w">
		<div id="logo">
			<a href="user.servlet?action=logout"><img src="imgs/logo.png" /> </a>
		</div>
	</div>
	<div class="w">
		<div id="fpwd">
			<div class="header">
				<label class="label"> 找回密码 </label>
			</div>
			<div class="nr">
				<div class="form">
					<form action="user.servlet?action=fpwd" method="post">
						<div class="item">
							<span class="label">用户名：</span> <input type="text" id="regName"
								name="username" class="text" tabindex="1" autoComplete="off"
								onpaste="return false;" value="用户名" onblur="checkUser3()" onClick="if (this.value=='用户名'){this.value=''}"/>
						<span id="tip1" class="tip"></span>
						</div>


						<div class="item">
							<span class="label">验证码：</span> <input type="text" id="authcode"
								style="ime-mode: disabled" name="authcode" class="text text-1"
								tabindex="2" autocomplete="off" MaxLength="4"
								onblur="checkCode()" /> <label class="img"> <img
								id="rsi" src="user.servlet?code=code" /> </label> <label> 看不清？
								<a href="javascript:rli()">换一张</a> </label>
								<span class="tip" id="tip6"></span>
						</div>


						<input type="submit" class="handcursor re1" tabindex="3"
							style="background: url(imgs/login_bg.png); border-style: outset; width: 100px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 15px;"
							value="下一步" onclick="return checkFpwdForm()" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
