<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>ipay.html</title>

		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" type="text/css" href="css/style.css">
		<style>
.lefttable {
	float: center;
	background: #d3d7d4;
	margin-top: 30px;
	margin-left: 20px;
}
.left {
	float: left;
}

.right {
	float: right;
}
.rightb{
margin-top:20px
}

.main {
	width: 800px;
	padding-top: 60px;
	padding-left: 70px;
}

fieldset {
	border-width: 2px;
	border-color: #0C9;
	width: 300px;
	height: 200px;
	margin:30px;
}
table{
   padding-top:20px
}


</style>
	</head>


	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div id="middle" style="min-height: 600px;">
			<div class="main">
				<form action="servlet/PayServlet" method="post">
					<div class="left">
						<fieldset style="width: 230px; height: 160px;">
							<legend>
								支付信息
							</legend>
							<table class="lefttable">
								<tr style="height:50px">
									<td>
										对方账号：
									</td>
									<td>
										123212332321
									</td>
								</tr>
								<tr>
									<td>
										应付金额：
									</td>
									<td style="font-size:40px;font-color:red;">
										<strong>${sumvalue }</strong>
									</td>
								</tr>
							</table>
						</fieldset>
					</div>
					<div class="right">
						<div class="rightt">
							<fieldset>
								<legend>
									网上转账
								</legend>
								<table style="margin-left:20px;margin-top:20px;">
									<tr>
										<td>
											请输入卡号：
										</td>
										<td>
											<input type="text" />
										</td>
									</tr>
									<tr>
										<td>
											密码：
										</td>
										<td>
											<input type="password" />
										</td>
									</tr>
									<tr>
										<td>
											金额:
										</td>
										<td>
											<input type="text" />
										</td>
									</tr>
									<tr>
										<td></td>
										<td>
											<input type="submit" value="确认支付" name="web" style="background:#1FD1B7"/>
										</td>
									</tr>

								</table>
							</fieldset>
						</div>
						<div class="rightb">

							<fieldset style="height:80px">
								<legend >
									货到付款
								</legend>
								<div style="margin-left:125px;margin-top:10px">
									<input type="submit" value="货到付款" name="ship" style="background:#1FD1B7"/>
								</div>
							</fieldset>

						</div>
					</div>
					</form>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>
