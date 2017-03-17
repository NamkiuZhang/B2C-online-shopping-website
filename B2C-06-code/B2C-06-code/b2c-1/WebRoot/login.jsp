<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
	<head>

		<title>请登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link style="text/css" href="css/loginstyle.css" rel="stylesheet" />

	</head>

	<body>
		<div class="w">
			<div id="logo">
				<a href="index.jsp"><img src="imgs/logo.png"/>
				</a><span class="logo-bg">登 录</span>
			</div>
		</div>
		<div class="w1" id="entry">
			<div class="mc">
				<div id="entry-bg">
					<img src="imgs/entry-bg.png" height="354px" />
				</div>
				<div class="form ">
					<form action="user.servlet?action=login" method="post">
						<span>用户名</span>
						<br />
						<input type="text" name="username" id="ls_username" class="text" />
						<br />
						<span>密 码</span>
						<c:if test="${not empty tip }">
							<span style="color: red; padding-left: 20px;">${
								requestScope.tip }</span>
						</c:if>
						<br />
						<input type="password" name="password" id="ls_password"
							class="text" />
						<br />
						<input type="checkbox" name="cookietime" id="ls_cookietime"
							class="ls_cookietime" value="mark" />
						<label class="label">
							自动登录
						</label>
						<label class="label">
							<a href="fpwd.jsp">忘记密码?</a>
						</label>
						<input type="submit" class="handcursor" tabindex="5"
							style="background: url(imgs/login_bg.png); border-style: none; width: 200px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 16px;"
							value="登      录" />
					</form>
					<label class="label">
						<a href="register.jsp">快速注册>></a>
					</label>
				</div>
			</div>
		</div>
	</body>
</html>
