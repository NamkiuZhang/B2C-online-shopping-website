<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
   
    <title>My JSP 'deleteOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
					删除订单
				</h1>
				<form action="servlet/OrderServlet?action=findDeOrder" method="post">
					输入订单号：
					<input type="text" name="orderId" />
					<input type="hidden" name="status" value="已作废" />
				<input type="submit" value="查询" />
				</form>
				<form action="servlet/OrderServlet?action=findDeOrder" method="post">
					查询所有已作废订单
					<input type="hidden" name="orderId" value=""/>
					<input type="hidden" name="status" value="已作废" />
				
				<input type="submit" value="显示所有" />
				</form>
				
				
				<br>
			</div>
		</div>

	</body>
</html>
