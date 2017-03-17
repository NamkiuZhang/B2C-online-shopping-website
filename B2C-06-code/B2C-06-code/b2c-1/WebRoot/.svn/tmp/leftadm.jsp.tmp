<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'leftadm.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">

<style>
#catagory {
	background: #1FD1B7;
	padding: 3px 3px 2px 10px;
	width:200px;
	float:left;
}

.sidebar1 {
	padding: 10px 5px 0px 20px;
	margin-top: 8px;
	border:none;
}

a {
	color: black;
	text-decoration: none;
}

ul {
	list-style-type: none;
	margin: 0px;
}

ul li {
	list-style-type: none;
	background: #1FD1B7;
}

ul li a {
	display: block;
	width: 100%;
	background: #1FD1B7;
}

ul li a:hover {
	background: #1FD1B7;
	color: #ffffff;
}

h1 {
	color: #1FD1B7;
}
</style>
</head>

<body>
	<div id="catagory">
		<span style="color:black;font:20px;">欢迎,${sessionScope.user }</span> <br> 
		<a href="manModpwd.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;
		<a href="user.servlet?action=logout"
			style="background:#1FD1B7; border-style:none;  width:120px; height:35px; background-repeat:no-repeat; font-family:'微软雅黑'; font-size:16px;">退出登录</a> <br />
		<div class="sidebar1">
			<h2 class="label">管理员管理</h2>
			<ul class="nav">
				<li><a href="addManager.jsp" target="right">添加管理员</a>
				</li>
				<li><a href="user.servlet?action=listManager"  target="right">查询管理员</a>
				</li>
			</ul>
			<br />
		</div>
	</div>
</body>
</html>
