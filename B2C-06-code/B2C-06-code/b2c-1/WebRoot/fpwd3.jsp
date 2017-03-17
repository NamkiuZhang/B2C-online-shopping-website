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
		<script type="text/javascript" src="js/user.js">
</script>

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
					<label class="label">
						找回密码
					</label>
				</div>
				<div class="nr">
					<div class="form">
						<form action="user.servlet?action=modpwd" method="post">
							<div class="item">
								<span class="label">新密码：</span>
								<input type="password" id="pwd" name="password" class="text"
									tabindex="1" autoComplete="off" onpaste="return false;"
									onblur="checkPassword1()" />
								<span class="tip" id="tip2"></span>
							</div>
							<div class="item">
								<span class="label">确认密码：</span>
								<input type="password" id="pwdRepeat" name="pwdRepeat"
									class="text" tabindex="2" autoComplete="off"
									onpaste="return false;" onblur="checkPassword2()" />
								<span class="tip" id="tip3"></span>
							</div>
							<input type="submit" class="handcursor re1" tabindex="3"
								style="background: url(imgs/login_bg.png); border-style: outset; width: 100px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 15px;"
								value="完  成" onclick="return checkModpwdForm()" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
