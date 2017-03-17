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
					<label class="label">
						找回密码
					</label>
				</div>
				<div class="nr">
					<div class="form">					
						<div class="item">
							<span class="label">密保问题：</span>
							<input type="text" id="pq" name="pq" class="text" tabindex="1"
								autoComplete="off" onpaste="return false;"
								value="${requestScope.question }" readonly="readonly" />
						</div>
						<div class="item">
							<span class="label">问题答案：</span>
							<input type="text" id="pAnswer" name="pAnswer" class="text"
								tabindex="2" autoComplete="off" onpaste="return false;"  onblur="checkAnswerWithQuestion()"/>
							<input value="${requestScope.answer }" id="sAnswer" type="hidden"/>
							<span class="tip" id="tip7"></span>
						</div>

						<input type="button" class="handcursor re1" tabindex="3"
							style="background: url(imgs/login_bg.png); border-style: outset; width: 100px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 15px;"
							value="下一步" onclick="checkQAForm()" />
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
