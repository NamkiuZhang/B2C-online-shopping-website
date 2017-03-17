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

		<title>My JSP 'modifyOrderStatus.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="./CSS/styles.css">

		<style>
th {
	width: 130;
	align: center;
	background-color: #d3d7d4;
	font-family: "微软雅黑" ；
}

#firstline {
	width: 180;
	height: 50
}

td {
	text-align: center;
	height: 50px;
}

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
			<jsp:include page="left.jsp"></jsp:include>
			<div id="addManager" class="content1">
			<h1 align="center">
					修改订单状态
				</h1>
				<form action="servlet/OrderServlet?action=findMSOrder" method="post">
					输入订单号：
					<input type="text" name="orderId"  value=""/>
					<br>
					选择查询类别：
					<input type="checkbox" name="status" value="未支付" />
					新订单
					<input type="checkbox" name="status" value="已支付" />
					已支付订单
					<input type="submit" value="查询" />
				</form>
				<br>
			</div>
		</div>

	</body>
</html>
