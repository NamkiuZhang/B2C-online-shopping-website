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
		<title>我的主页</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link style="text/css" href="css/loginstyle.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />

	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<div id="home">
				<jsp:include page="myhomesidebar.jsp"></jsp:include>
				<div class="content">
					<div class="table">
						<span class="label" style="color:#1FD1B7;">
							您的基本信息
						</span>
						<br />
						<div class="item">
							用户名:
							<span class="label">${sessionScope.user }</span>
						</div>
						<span class="label" style="color:#1FD1B7;">
							您的服务
						</span>
						<div class="item">
							<table style="font-size: 12px;">
								<tr>
									<td width="86">
										登录密码
									</td>
									<td width="408">
										安全性高的密码可以使账号更安全。建议您定期更换密码，且设置一个包含数字和字母，并长度超过6位以上的密码
									</td>
									<td width="80" align="center">
										<a href="mpwd.jsp">修改</a>
									</td>
								</tr>
								<tr>
									<td>
										个人信息
									</td>
									<td>
										包含您的真实姓名和性别，设置后不可更改，请真实填写
									</td>
									<td align="center">
										<a href="user.servlet?action=userinfo">设置</a>
									</td>
								</tr>
								<tr>
									<td>
										收货地址
									</td>
									<td>
										包含您的收货地址，可随时添加、更改
									</td>
									<td align="center">
										<a href="address.servlet?action=listaddress">修改</a>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
