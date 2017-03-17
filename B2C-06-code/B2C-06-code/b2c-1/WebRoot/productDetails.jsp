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

		<title>My JSP 'productDetails.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script>
function goLast() {
	history.go(-1);
}
</script>
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
			<jsp:include page="left.jsp"></jsp:include>
			<div id="addManager" class="content1">
				<h1
					style="color: #1FD1B7; font-family: '微软雅黑'; font-size: 30px; margin-left: 50px">
					商品详细信息
				</h1>
				<br>
				<div class="item">
					
					<span>商品ID: ${requestScope.productvo.id}</span>
				</div>
				<div class="item">
					<span>商品名称: ${requestScope.productvo.pname}</span>
				</div>

				<div class="item">
					<span>类型ID：${requestScope.productvo.typeId}</span>
				</div>
				<div class="item">
					<span>单价：${requestScope.productvo.pprice}</span>
				</div>
				<div class="item">
					<span>库存量：${requestScope.productvo.storage}</span>
				</div>
				<input onmouseup="goLast()" type="submit" value="返回商品列表">
			</div>
			
		</div>


	</body>
</html>

