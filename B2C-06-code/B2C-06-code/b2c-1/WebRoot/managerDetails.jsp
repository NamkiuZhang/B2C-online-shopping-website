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


		<title>My JSP 'managerDetails..jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
<style>
.content1 {
	padding: 0;
	width: 700px;
	height: 700px;
	float: left;
	border: 1px solid #cccccc;
}

</style>

	</head>
	<body>

		<jsp:include page="top.jsp"></jsp:include>
		<div class="w">
			<jsp:include page="leftadm.jsp"></jsp:include>
			<div id="addManager" class="content1">
				<h1
					style="color: #1FD1B7; font-family: '微软雅黑'; font-size: 30px; margin-left: 50px">
					管理员详细信息
				</h1>
				<br>
				<div class="item">
					<span >管理员ID: ${requestScope.uservo.u_id}</span>
				</div>
				<div class="item">
					<span >管理员名称: ${requestScope.uservo.u_name}</span>
				</div>
				<div class="item">
					<span > 密码：${requestScope.uservo.log_pwd}</span>
				</div>
				<div class="item">
					<span>找回密码提示问题：${requestScope.uservo.question}</span>
				</div>
				<div class="item">
					<span class="label">回答：${requestScope.uservo.answer}</span>
				</div>
				<form action="user.servlet?action=listManager" method="post">
					<input type="submit" value="返回管理员列表">
				</form>

			</div>
		</div>
		</div>


	</body>
</html>
